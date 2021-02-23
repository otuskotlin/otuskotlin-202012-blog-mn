package ru.otus.kotlin.blog.backend.common.dsl

import ru.otus.kotlin.blog.backend.common.models.Comment
import ru.otus.kotlin.blog.backend.common.models.Post
import java.time.Instant

@PostDslMarker
class PostDsl (
    var text: String = "",
    var publishDateTime: Instant = Instant.now(),
    var numOfLikes: Long = 0,
    var numOfDislikes: Long = 0,
    var numOfReposts: Long = 0,
    var comments: MutableList<CommentDsl> = mutableListOf()
) {
    companion object {
        val EMPTY = PostDsl()
    }

    fun build() = Post(
        text = this.text,
        publishDateTime = this.publishDateTime,
        numOfLikes = this.numOfLikes,
        numOfDislikes = this.numOfDislikes,
        numOfReposts = this.numOfReposts,
        comments = this.comments.map { it.build() }.toMutableList()
    )

    fun comment(conf: CommentDsl.() -> Unit) {
        comments.add(CommentDsl().apply(conf))
    }
}

fun post(conf: PostDsl.() -> Unit) = PostDsl().apply(conf).build()