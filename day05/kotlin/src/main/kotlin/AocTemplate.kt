import java.io.File

fun main() {
    val input = File("input.txt").readLines()
    val answer = when (System.getenv("part")) {
        "part2" -> solutionPart2(input)
        else -> solutionPart1(input)
    }
    println(answer)
}

fun solutionPart1(input: List<String>) = solver(input, false)

fun solutionPart2(input: List<String>) = solver(input, true)

fun solver(input: List<String>, diagonal: Boolean): Int {
    val ocean = Array(1000) { Array(1000) { 0 } }
    val regex = Regex("(\\d+),(\\d+)\\s+->\\s+(\\d+),(\\d+)")
    input.forEach { line ->
        val (xx1, yy1, xx2, yy2) = regex.find(line)!!.destructured
        val x1: Int = xx1.toInt()
        val x2: Int = xx2.toInt()
        val y1: Int = yy1.toInt()
        val y2: Int = yy2.toInt()

        val dy: Int = if (yy1.toInt() < yy2.toInt()) {
            1
        } else {
            -1
        }

        if (x1 == x2) {
            for (y in y1 toward y2) {
                ocean[y][x1]++
            }
        } else if (y1 == y2) {
            for (x in x1 toward x2) {
                ocean[y1][x]++
            }
        } else if (diagonal) {
            var y = y1
            for (x in x1 toward x2) {
                ocean[y][x]++
                y += dy
            }
        }
    }

    var count = 0

    ocean.forEach { row -> row.forEach { if (it > 1) count++ } }

    return count
}

private infix fun Int.toward(to: Int): IntProgression {
    val step = if (this > to) -1 else 1
    return IntProgression.fromClosedRange(this, to, step)
}