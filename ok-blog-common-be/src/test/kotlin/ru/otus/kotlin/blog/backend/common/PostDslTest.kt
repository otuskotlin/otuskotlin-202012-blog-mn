package ru.otus.kotlin.blog.backend.common

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import ru.otus.kotlin.blog.backend.common.dsl.blog
import ru.otus.kotlin.blog.backend.common.models.Blog
import ru.otus.kotlin.blog.backend.common.models.Comment
import ru.otus.kotlin.blog.backend.common.models.Post
import ru.otus.kotlin.blog.backend.common.models.Style
import java.net.URI
import java.time.Instant
import java.time.temporal.ChronoUnit

class PostDslTest: StringSpec({
    "Test blog DSL" {
        val blog: Blog = blog {
            userId = 123
            style {
                headerImg = URI.create("https://localhost:7001/header.jpg")
                fontImg = URI.create("https://localhost:7001/font.jpg")
            }
            post {
                text = "My first post!"
                publishDateTime = Instant.MIN
                numOfLikes = 999
                numOfDislikes = 11
                numOfReposts = 333
                comment {
                    text = "Press F"
                }
                comment {
                    text = "lol"
                }
                comment {
                    text = "I like it!"
                }
            }
            post {
                text = "My second post!"
                publishDateTime = Instant.MIN.plus(10, ChronoUnit.DAYS)
                numOfLikes = 1
                numOfDislikes = 999
                numOfReposts = 3
                comment {
                    text = ":("
                }
                comment {
                    text = "Not agree!"
                }
            }
        }.apply {
            userId shouldBe 123
            style shouldBe Style(
                headerImg = URI.create("https://localhost:7001/header.jpg"),
                fontImg = URI.create("https://localhost:7001/font.jpg")
            )
            posts shouldBe mutableListOf(
                Post(
                    text = "My first post!",
                    publishDateTime = Instant.MIN,
                    numOfLikes = 999,
                    numOfDislikes = 11,
                    numOfReposts = 333,
                    comments = mutableListOf(
                        Comment(
                            text = "Press F"
                        ),
                        Comment(
                            text = "lol"
                        ),
                        Comment(
                            text = "I like it!"
                        )
                    )
                ),
                Post(
                    text = "My second post!",
                    publishDateTime = Instant.MIN.plus(10, ChronoUnit.DAYS),
                    numOfLikes = 1,
                    numOfDislikes = 999,
                    numOfReposts = 3,
                    comments = mutableListOf(
                        Comment(
                            text = ":("
                        ),
                        Comment(
                            text = "Not agree!"
                        )
                    )
                )
            )
        }
    }
})