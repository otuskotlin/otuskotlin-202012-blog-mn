package ru.otus.kotlin.common.cor

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CoreTest : StringSpec({
    "test core" {
        1 + 1 shouldBe 2
    }
})