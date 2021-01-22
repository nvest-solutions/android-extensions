package org.nvest.extension

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.text.ParseException
import java.util.*

class TextKtTest {
    @Test
    fun `Substring is removed from String when it is present in String`() {
        val input = "ABC"

        val result = input.remove("B")

        assertThat(result).isEqualTo("AC")
    }

    @Test
    fun `Nothing is removed from String when removable substring is not present in String`() {
        val input = "ABC"

        val result = input.remove("D")

        assertThat(result).isEqualTo("ABC")
    }

    @Test
    fun `Correct date in String returns Calendar instance`() {
        val input = "1 Jan 2050"

        val result = input.toCalendar()

        assertThat(result).isInstanceOf(Calendar::class.java)
    }

    @Test(expected = ParseException::class)
    fun `Incorrect date in String throws ParseException`() {
        val input = "ABC"

        input.toCalendar()
    }
}