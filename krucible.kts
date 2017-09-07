import java.io.File

File("kotlin_keywords.txt")
        .readText()
        .split("\n")
        .filter { !it.isEmpty() }
        .groupBy(keySelector = { it[0] }, valueTransform = { it.substring(1) })
        .map { (prefix, strings) -> Node(prefix).apply { addAll(strings.filterNotEmpty()) } }
        .join()
        .apply { print(this) }

inner class Node(private val prefix: Char, private val nodes: MutableMap<Char, Node> = mutableMapOf()) {

    private fun add(string: String) {
        if (string.isNotEmpty()) nodes.getOrPut(key = string[0]) { Node(string[0]) }.add(string.substring(1))
    }

    fun addAll(strings: List<String>) = strings.forEach { add(it) }

    override fun toString() = "$prefix${nodes.serialize()}"
}

fun List<String>.filterNotEmpty() = filter { it.isNotEmpty() }
fun Collection<Any>.join() = joinToString(prefix = "(", separator = "|", postfix = ")")
fun MutableMap<Char, Node>.serialize(): String = when (size) {
    0 -> ""
    1 -> values.first().toString()
    else -> toSortedMap().values.join()
}

