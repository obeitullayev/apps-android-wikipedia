package org.wikipedia.lesson24.homework

import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import io.github.kakaocup.compose.node.element.KNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemBuilder
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListNode
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.compose.uitest.Tags.LANGUAGE_CANONICAL_NAME
import org.wikipedia.compose.uitest.Tags.LOCALIZED_LANGUAGE_NAME
import org.wikipedia.compose.uitest.Tags.LANGUAGE_LIST
import org.wikipedia.compose.uitest.Tags.LANGUAGE_LIST_TITLE
import org.wikipedia.lesson18.homework.baseElements.name
import org.wikipedia.lesson24.homework.AddLanguageScreenCompose.items
import org.wikipedia.lesson24.homework.withParent

object AddLanguageScreenCompose : ComposeNamedScreen<AddLanguageScreenCompose>(){
    override val screenName = "Language Screen"

    val headerTextAllLanguages by lazy {
        child <KNode>{
            hasTestTag(LANGUAGE_LIST_TITLE)
        }.name(withParent("Заголовок All languages "))
    }

    val items by lazy  {
            createLazyList(
                viewBuilderAction = {
                    hasTestTag(LANGUAGE_LIST)
                },
                itemTypeBuilder = { itemType(::LanguageItem) }
            )
    }
}

class LanguageItem(
    semanticsNode: SemanticsNode,
    semanticsProvider: SemanticsNodeInteractionsProvider? =null
): KLazyListItemNode<LanguageItem>(semanticsNode, semanticsProvider!!){

    val localName by lazy {
        child<KNode>{
            hasTestTag(LOCALIZED_LANGUAGE_NAME)
        }.name(withParent("localName"))
    }

    val canonicName by lazy {
        child<KNode>{
            hasTestTag(LANGUAGE_CANONICAL_NAME)
        }.name(withParent("canonicName"))
    }
}

fun itemPosition(index: Int, fnc: LanguageItem.() -> Unit) {
    items.invokeAtIndex<LanguageItem>(index, fnc)
}
