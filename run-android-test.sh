#!/usr/bin/env bash

set -e

# =========================
# CONFIG
# =========================

AVD_NAME="emulator-5554"
DEVICE_NAME="pixel"
ANDROID_API="33"
SYSTEM_IMAGE="system-images;android-33;google_apis;x86_64"
EMULATOR_PORT="5554"

TEST_CLASS="org.wikipedia.lesson29.homework.ScriptTest#checkArticleTitle"

GRADLE_TASK="app:connectedAlphaDebugAndroidTest"


REPORT_PATH="app/build/reports/androidTests/connected/index.html"

# =========================
# CREATE AVD IF NOT EXISTS
# =========================

echo "Checking AVD..."

if ! avdmanager list avd | grep -q "${AVD_NAME}"; then
  echo "AVD not found. Creating..."

  echo "no" | avdmanager create avd \
    --name "${AVD_NAME}" \
    --package "${SYSTEM_IMAGE}" \
    --device "${DEVICE_NAME}"

  echo "AVD created."
else
  echo "AVD already exists."
fi

# =========================
# START EMULATOR
# =========================

echo "Starting emulator..."

emulator -avd "${AVD_NAME}" \
  -no-snapshot \
  -wipe-data \
  -port "${EMULATOR_PORT}" \
  -skin 720x1280 \
  -gpu host \
  > /tmp/android-emulator.log 2>&1 &

EMULATOR_PID=$!

ADB_DEVICE="emulator-${EMULATOR_PORT}"

# Дополнительная пауза для стабильности
echo "Waiting 60 seconds..."
sleep 60

# =========================
# RUN TEST
# =========================

echo "Running instrumentation test..."

./gradlew "${GRADLE_TASK}" \
  -Pandroid.testInstrumentationRunnerArguments.class="${TEST_CLASS}"

echo "ADB DEVICES AFTER TESTS:"
adb devices

TEST_EXIT_CODE=$?

# =========================
# OPEN REPORT
# =========================

echo "Pulling allure-results from emulator..."
rm -rf ./allure-results
mkdir -p allure-results

adb -s "emulator-${EMULATOR_PORT}" pull \
  /sdcard/Documents/allure-results \
  ./allure-results
adb devices
# =========================
# STOP EMULATOR
# =========================

echo "Stopping emulator..."

adb -s "${ADB_DEVICE}" emu kill || true

wait "${EMULATOR_PID}" || true


echo "Opening Allure report..."

allure serve ./allure-results/allure-results

exit "${TEST_EXIT_CODE}"
