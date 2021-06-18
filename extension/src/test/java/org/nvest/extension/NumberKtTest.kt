package org.nvest.extension

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class NumberKtTest {
    @Test
    fun `Number is rounded properly`() {
        val input = 123.456

        val result = input.round(2)

        assertThat(result).isEqualTo(123.46)
    }

    @Test
    fun `Double in String is a number`() {
        val input = "123.456"

        val result = input.isNumber()

        assertThat(result).isTrue
    }

    @Test
    fun `Integer in String is a number`() {
        val input = "123"

        val result = input.isNumber()

        assertThat(result).isTrue
    }

    @Test
    fun `Text in String is not a number`() {
        val input = "123Abc"

        val result = input.isNumber()

        assertThat(result).isFalse
    }

    @Test
    fun `null is not a number`() {
        val input = null

        val result = input.isNumber()

        assertThat(result).isFalse
    }

    @Test
    fun `some string is not a number`() {
        val input = "a"

        val result = input.isNotNumber()

        assertThat(result).isTrue
    }
}