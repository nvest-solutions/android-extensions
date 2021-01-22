package org.nvest.extension

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CollectionKtTest {
    @Test
    fun `Map is cleared while adding new values`() {
        val mutableMap = mutableMapOf(1 to "One", 2 to "Two")
        val immutableMap = mapOf(3 to "Three")

        mutableMap.clearAndPutAll(immutableMap)

        assertThat(mutableMap).hasSize(1)
    }

    @Test
    fun `List is cleared while adding new values`() {
        val mutableList = mutableListOf(1, 2)
        val immutableList = listOf(3)

        mutableList.clearAndAddAll(immutableList)

        assertThat(mutableList).hasSize(1)
    }

    @Test
    fun `Map is converted to CSV`() {
        val firstMap = mapOf("A" to "Apple", "B" to "Banana", "C" to "Coconut")
        val secondMap = mapOf("A" to "Avocado", "B" to "Berry", "C" to "Cherry")
        val csvMap = mapOf(1 to firstMap, 2 to secondMap)

        val result = csvMap.toCsv()

        assertThat(result).isEqualTo(
            """
A,B,C
Apple,Banana,Coconut
Avocado,Berry,Cherry
        """.trimIndent()
        )
    }

    @Test
    fun `Map returns value with case-insensitive key`() {
        val mutableMap = mutableMapOf("One" to 1)

        val result = mutableMap.getIgnoreCase("oNE")

        assertThat(result).isEqualTo(1)
    }
}