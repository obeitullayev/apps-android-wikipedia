
#!/usr/bin/env bash

set -e

# ==========================================
# CONFIG
# ==========================================

# Existing AVD names
AVD_1="Pixel_7_API_33"
AVD_2="Pixel_6_API_33"

# Emulator serials
EMU_1_SERIAL="emulator-5554"
EMU_2_SERIAL="emulator-5556"

ADB="${ANDROID_HOME}/platform-tools/adb"
EMULATOR="${ANDROID_HOME}/emulator/emulator"

# ==========================================
# CLEANUP
# ==========================================

cleanup() {

  echo ""
  echo "Stopping emulators..."

  $ADB -s "${EMU_1_SERIAL}" emu kill || true
  $ADB -s "${EMU_2_SERIAL}" emu kill || true

  pkill -f "${AVD_1}" || true
  pkill -f "${AVD_2}" || true
}

trap cleanup EXIT

# ==========================================
# BUILD APKs
# ==========================================

echo ""
echo "=========================================="
echo "BUILDING APKs"
echo "=========================================="

./gradlew clean \
assembleAlphaDebug \
assembleAlphaDebugAndroidTest

# ==========================================
# VERIFY APKs
# ==========================================

APP_APK="app/build/outputs/apk/alpha/debug/app-alpha-debug.apk"

TEST_APK="app/build/outputs/apk/androidTest/alpha/debug/app-alpha-debug-androidTest.apk"

if [ ! -f "$APP_APK" ]; then
  echo "Application APK not found:"
  echo "$APP_APK"
  exit 1
fi

if [ ! -f "$TEST_APK" ]; then
  echo "Test APK not found:"
  echo "$TEST_APK"
  exit 1
fi

echo ""
echo "APKs found:"
echo "$APP_APK"
echo "$TEST_APK"

# ==========================================
# START EMULATORS
# ==========================================

echo ""
echo "=========================================="
echo "STARTING EMULATORS"
echo "=========================================="

$EMULATOR \
-avd "${AVD_1}" \
-port 5554 \
-no-window \
-no-audio \
-partition-size 1024 \
-no-snapshot \
-no-boot-anim \
-gpu swiftshader_indirect \
&

sleep 20

$EMULATOR \
-avd "${AVD_2}" \
-port 5556 \
-no-window \
-no-audio \
-partition-size 1024 \
-no-snapshot \
-no-boot-anim \
-gpu swiftshader_indirect \
&

# ==========================================
# WAIT FOR DEVICES
# ==========================================

wait_for_boot() {

  local SERIAL=$1

  echo ""
  echo "Waiting for ${SERIAL}..."

  $ADB -s "$SERIAL" wait-for-device

  boot_completed=""

  until [[ "$boot_completed" == "1" ]]; do

    sleep 10

    boot_completed=$(
      $ADB -s "$SERIAL" shell getprop sys.boot_completed \
      2>/dev/null | tr -d '\r'
    )

    echo "${SERIAL} boot status: ${boot_completed}"

  done

  echo "${SERIAL} booted"

#  unlock screen
  $ADB -s "$SERIAL" shell input keyevent 82 || true
}

echo ""
echo "=========================================="
echo "WAITING FOR EMULATORS"
echo "=========================================="

wait_for_boot "${EMU_1_SERIAL}"
wait_for_boot "${EMU_2_SERIAL}"

# ==========================================
# EXTRA STABILIZATION
# ==========================================

echo ""
echo "=========================================="
echo "WAITING FOR STABILIZATION"
echo "=========================================="

sleep 60

# ==========================================
# DEVICES
# ==========================================

echo ""
echo "=========================================="
echo "CONNECTED DEVICES"
echo "=========================================="

$ADB devices

# ==========================================
# RUN MARATHON
# ==========================================

echo ""
echo "=========================================="
echo "RUNNING MARATHON"
echo "=========================================="

set +e

marathon

TEST_EXIT_CODE=$?

set -e

echo ""
echo "=========================================="
echo "MARATHON FINISHED"
echo "=========================================="

# ==========================================
# PULL ALLURE RESULTS
# ==========================================

echo ""
echo "=========================================="
echo "PULLING ALLURE RESULTS"
echo "=========================================="

rm -rf ./allure-results
mkdir -p ./allure-results/device1
mkdir -p ./allure-results/device2

$ADB -s "${EMU_1_SERIAL}" pull \
/sdcard/Documents/allure-results \
./allure-results/device1 || true

$ADB -s "${EMU_2_SERIAL}" pull \
/sdcard/Documents/allure-results \
./allure-results/device2 || true

# ==========================================
# OPEN ALLURE REPORT
# ==========================================

echo ""
echo "=========================================="
echo "OPENING ALLURE REPORT"
echo "=========================================="

allure serve ./marathon/allure-results

exit "${TEST_EXIT_CODE}"
