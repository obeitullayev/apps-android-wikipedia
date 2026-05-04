package org.wikipedia.lesson24.homework

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.performClick
import io.github.kakaocup.compose.intercept.operation.ComposeAction
import io.github.kakaocup.compose.node.action.NodeActions
import org.wikipedia.lesson18.homework.baseElements.NameHierarchy

class ClickIfEnabledAction : ComposeAction {

    override val type = CustomOperationTypes.CUSTOM_CLICK_ACTION
    override val description = "Click only if element is enabled"

    override fun execute(innerView: SemanticsNodeInteraction) {
        val isDisabled = innerView.fetchSemanticsNode()
            .config
            .contains(SemanticsProperties.Disabled)
        if (!isDisabled) {
            innerView.performClick()
        }
    }
}

fun NodeActions.clickIfEnabled() {
    delegate.perform(ClickIfEnabledAction())
}

private val elements = mutableMapOf<NodeActions, NameHierarchy>()

fun <T : NodeActions> T.name(nameHierarchy: NameHierarchy): T {
    elements[this] = nameHierarchy
    return this
}

fun <T : NodeActions> T.getName(): NameHierarchy {
    return elements[this] ?: NameHierarchy("NO_LABEL", null)
}

fun <T : NodeActions> T.withParent(name: String): NameHierarchy {
    return getName().withParent(name)
}

