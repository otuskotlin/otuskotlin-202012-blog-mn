package ru.otus.kotlin.blog.backend.common.dsl

import ru.otus.kotlin.blog.backend.common.models.Comment

@CommentDslMarker
class CommentDsl(
    var text: String = ""
) {
    fun build(): Comment = Comment (
            text = this.text
    )
}

fun comment(conf: CommentDsl.() -> Unit) = CommentDsl().apply(conf).build()