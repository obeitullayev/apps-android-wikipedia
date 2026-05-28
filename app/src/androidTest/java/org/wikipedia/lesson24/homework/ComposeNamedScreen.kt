package org.wikipedia.lesson24.homework

import io.github.kakaocup.compose.node.element.ComposeScreen
import org.wikipedia.lesson18.homework.baseElements.NameHierarchy

abstract class ComposeNamedScreen<T : ComposeScreen<T>> : ComposeScreen<T>() {

    abstract val screenName: String

    private val nameHierarchy by lazy {
        NameHierarchy(screenName)
    }

    fun withParent(name: String): NameHierarchy {
        return NameHierarchy(name, nameHierarchy)
    }
}