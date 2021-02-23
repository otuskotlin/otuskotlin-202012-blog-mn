package ru.otus.kotlin.blog.backend.common.models

import java.net.URI

data class Style(
        // TODO: Set default image uri
        var headerImg: URI? = null,
        // TODO: Set font image uri
        var fontImg: URI? = null
)