package ru.otus.kotlin.blog.backend.common.models

data class Blog(
        val userId: Long,
        val style: Style,
        val posts: MutableList<Post> = mutableListOf()
)