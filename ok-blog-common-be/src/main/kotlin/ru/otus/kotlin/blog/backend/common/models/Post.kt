package ru.otus.kotlin.blog.backend.common.models

import java.time.Instant

data class Post (
        var text: String = "",
        val publishDateTime: Instant = Instant.now(),
        var numOfLikes: Long = 0,
        var numOfDislikes: Long = 0,
        var numOfReposts: Long = 0,
        val comments: MutableList<Comment> = mutableListOf()
)