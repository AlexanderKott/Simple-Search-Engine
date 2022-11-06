fun main() {
    val studentsMarks = mutableMapOf<String, Int>()
    do {
        var name = readLine()!!
        name = if (name.lowercase() != "stop") name else break
        studentsMarks.putIfAbsent(name, readLine()?.toInt() ?: 0)
    } while (true)
    println(studentsMarks)
}