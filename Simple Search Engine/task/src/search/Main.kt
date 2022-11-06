package search

import java.io.File

fun main(args: Array<String>) {
    val lines = File(args[1]).readLines()

    val indexedWords = mutableMapOf<String, List<Int>>()
    lines.forEach { item ->
        val words = item.split(" ")
        for (word in words) {
            val results = mutableListOf<Int>()
            lines.forEachIndexed { j, line ->
                if (line.lowercase().contains(word.lowercase())) {
                    results.add(j)
                }
            }
            indexedWords[word.lowercase()] = results
        }
    }


    while (true) {
        println("=== Menu ===\n1. Find a person\n2. Print all people\n0. Exit")
        val menuChoose = readlnOrNull()?.toInt() ?: 0
        if (menuChoose !in 0..2) {
            println("Incorrect option! Try again.")
            continue
        }

        when (menuChoose) {
            1 -> {
                println("Select a matching strategy: ALL, ANY, NONE")
                val strategy = readLine()!!

                println("Enter a name or email to search all suitable people.")
                val searchLine = readlnOrNull()?.split(" ") ?: listOf<String>()

                val stringToDisplay = mutableListOf<Int>()
                for (word in searchLine) stringToDisplay.addAll(indexedWords[word.lowercase()] ?: listOf())

                val results = when (strategy.lowercase()) {
                    "none" -> lines.filterIndexed { index, _ -> !stringToDisplay.contains(index) }

                    "all" -> {
                        val resultsY =
                            stringToDisplay.groupingBy { it }.eachCount()
                                .filter { it.value == searchLine.size }
                                .map { it.key }
                        lines.filterIndexed { index, _ -> resultsY.contains(index) }
                    }

                    "any" -> lines.filterIndexed { index, _ -> stringToDisplay.contains(index) }

                    else -> listOf<String>()
                }
                println("${results.size} persons found:")
                println(results.joinToString("\n"))
            }

            2 -> {
                println("=== List of people ===")
                lines.forEach { println(it) }
            }

            0 -> {
                println("Bye!")
                return
            }
        }
    }
}