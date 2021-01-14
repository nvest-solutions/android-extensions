package org.nvest.extension

fun <K, V> MutableMap<K, V>.clearAndPutAll(from: Map<out K, V>) {
    this.clear()
    this.putAll(from)
}

fun <E> MutableList<E>.clearAndAddAll(elements: Collection<E>): Boolean {
    this.clear()
    return this.addAll(elements)
}

fun Map<Int, Map<String, String>>.toCsv(): String {
    val csvBuilder = StringBuilder()

    // add headers
    for ((_, monthData) in this.entries) {
        for ((keywords) in monthData.entries) {
            csvBuilder.append(keywords).append(",")
        }
        break
    }

    csvBuilder.append("\n")

    // add values
    for ((_, monthData) in this.entries) {
        for ((_, value) in monthData.entries) {
            csvBuilder.append(value).append(",")
        }
        csvBuilder.append("\n")
    }

    return csvBuilder.toString()
}

fun <V> Map<String, V>.getIgnoreCase(key: String): V {
    return this.filter { it.key.equals(key, true) }.entries.first().value
}