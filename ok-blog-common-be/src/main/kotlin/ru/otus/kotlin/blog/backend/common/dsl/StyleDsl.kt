package ru.otus.kotlin.blog.backend.common.dsl

import ru.otus.kotlin.blog.backend.common.models.Style
import java.net.URI

@StyleDslMarker
class StyleDsl (
        var headerImg: URI? = null,
        var fontImg: URI? = null
) {
    companion object {
        val EMPTY = StyleDsl()
    }

    fun build() = Style(
        headerImg = headerImg,
        fontImg = fontImg
    )
}

fun style(conf: StyleDsl.() -> Unit) = StyleDsl().apply(conf).build()