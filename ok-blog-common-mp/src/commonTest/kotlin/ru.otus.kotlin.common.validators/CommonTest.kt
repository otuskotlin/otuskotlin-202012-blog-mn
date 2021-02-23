package ru.otus.kotlin.common.validators

class CommonTest {
    @Test
    fun validatorTest() {
        val validator = SomeValidator()

        val negative = validator.validate(-3)
        assertEquals("negative", negative.errors.first().code)
        assertEquals(HandleError.Level.FATAL, negative.level)
        assertFalse { negative.isOk }
    }
}