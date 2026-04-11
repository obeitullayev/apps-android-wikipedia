package org.wikipedia.lesson18.homework.exploreScreen

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView
import org.wikipedia.lesson18.homework.baseElements.NamedScreen
import org.wikipedia.lesson18.homework.baseElements.name

object ExploreScreenNamed: NamedScreen<ExploreScreenNamed>() {

    override val screenName = "Экран Explore"
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val logo by lazy {
        KImageView {
            withId(R.id.main_toolbar_wordmark)
        }.name(withParent("Логотип в тулбаре"))
    }
    val title by lazy {
        KTextView {
            withId(R.id.articleTitle)
        }.name(withParent("Тайтл в статье"))
    }
    val items by lazy {
        KRecyclerView(
            builder = { withId(R.id.feed_view) },
            itemTypeBuilder = {
                itemType(::SearchItemNamed)
                itemType(::CustomizeItemNamed)
                itemType(::DayItemNamed)
                itemType(::TopReadItemNamed)
                itemType(::NewsItemNamed)
                itemType(::FeaturedArticleNamed)
            }
        ).name(withParent("Список статей в Explore"))
    }

}

