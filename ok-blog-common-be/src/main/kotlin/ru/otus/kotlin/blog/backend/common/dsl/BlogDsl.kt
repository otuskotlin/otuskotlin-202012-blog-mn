package ru.otus.kotlin.blog.backend.common.dsl

import ru.otus.kotlin.blog.backend.common.models.Blog

@BlogDslMarker
class BlogDsl(
        var userId: Long = 0,
        var style: StyleDsl = StyleDsl.EMPTY,
        var posts: MutableList<PostDsl> = mutableListOf()
) {
    fun build() = Blog(
        userId = this.userId,
        style = this.style.build(),
        posts = this.posts.map { it.build() }.toMutableList()
    )

    fun style(conf: StyleDsl.() -> Unit) {
        style = StyleDsl().apply(conf)
    }

    fun post(conf: PostDsl.() -> Unit) {
        posts.add(PostDsl().apply(conf))
    }
}

fun blog(conf: BlogDsl.() -> Unit) = BlogDsl().apply(conf).build()