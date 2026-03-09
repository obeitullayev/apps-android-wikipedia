package org.wikipedia.lesson09.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView
import org.wikipedia.lesson8.homework.CustomizeItem
import org.wikipedia.lesson8.homework.DayItem
import org.wikipedia.lesson8.homework.NewsItem
import org.wikipedia.lesson8.homework.SearchItem
import org.wikipedia.lesson8.homework.TopReadItem

object CustomizeFeedScreen: KScreen<CustomizeFeedScreen>() {
    override val layoutId = null
    override val viewClass = null

    val items = KRecyclerView (
        builder = {withId( R.id.content_types_recycler)},
        itemTypeBuilder = {
            itemType(::FeaturedArticle)
        }
    )
}