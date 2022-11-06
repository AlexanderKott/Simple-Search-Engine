import java.io.File

// write your code here

fun main(args: Array<String>) {
  val x = File("Topics\\Linear search\\How many repetitions\\data\\dataset\\input.txt").readLines()

val s =  x[1].count { it == x[0] [0] }
  println(s)
}
