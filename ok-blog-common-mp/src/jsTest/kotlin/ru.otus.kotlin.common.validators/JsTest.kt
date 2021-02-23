package ru.otus.kotlin.common.validators

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class JsTest : FunSpec({
    test("test js") {
        sorted(arrayOf(1,2,3)) shouldBe true
    }
})

@JsModule("is-sorted")
@JsNonModule
external fun <T> sorted(a: Array<T>): Boolean