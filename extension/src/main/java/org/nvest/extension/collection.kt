package org.nvest.extension

fun <K, V> MutableMap<K, V>.clearAndPutAll(from: Map<out K, V>) {
    this.clear()
    this.putAll(from)
}

fun <E> MutableList<E>.clearAndAddAll(elements: Collection<E>): Boolean {
    this.clear()
    return this.addAll(elements)
}

fun Map<Int, Map<String, String>>.toCsv(csvSeparator: Char = ','): String {
    val csvBuilder = StringBuilder()


    // add headers
    val headerBuilder = StringBuilder()
    for ((_, monthData) in this.entries) {
        for ((keywords) in monthData.entries) {
            headerBuilder.append(keywords).append(csvSeparator)
        }
        break
    }
    csvBuilder.append(headerBuilder.toString().removeSuffix(csvSeparator.toString()))
        .appendLine()

    // add values
    for ((_, monthData) in this.entries) {
        val bodyBuilder = StringBuilder()
        for ((_, value) in monthData.entries) {
            bodyBuilder.append(value).append(csvSeparator)
        }
        csvBuilder.append(bodyBuilder.toString().removeSuffix(csvSeparator.toString()))

        // don't add new line after the last entry
        if (this.entries.last().value.entries.last().value != monthData.entries.last().value) {
            csvBuilder.appendLine()
        }
    }

    return csvBuilder.toString()
}

fun <V> Map<String, V>.getIgnoreCase(key: String): V {
    return this.filter { it.key.equals(key, true) }.entries.first().value
}