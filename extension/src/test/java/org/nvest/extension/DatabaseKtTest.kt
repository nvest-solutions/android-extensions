package org.nvest.extension

import org.assertj.core.api.Assertions
import org.junit.Test

class DatabaseKtTest {
    @Test
    fun `String db values return with single quote around`() {
        val input = "XYZ"

        val result = input.dbValue()

        Assertions.assertThat(result).isEqualTo("'XYZ'")
    }

    @Test
    fun `null db values return as is`() {
        val input = null

        val result = input.dbValue()

        Assertions.assertThat(result).isNull()
    }
}