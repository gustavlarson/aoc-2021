import java.io.File

fun main() {
    val input = File("input.txt").readLines()
    val answer = when (System.getenv("part")) {
        "part2" -> solutionPart2(input)
        else -> solutionPart1(input)
    }
    println(answer)
}

fun solutionPart1(input: List<String>): Int {
    val ocean = Array(1000) {Array(1000) {0} }
    val regex = Regex("(\\d+),(\\d+)\\s+->\\s+(\\d+),(\\d+)")
    input.forEach { line ->
        val (xx1, yy1, xx2, yy2) = regex.find(line)!!.destructured
        var x1 = 0; var x2 = 0; var y1 = 0; var y2 = 0;
        if (xx1.toInt() < xx2.toInt()) {
            x1 = xx1.toInt(); x2 = xx2.toInt()
        } else {
            x1 = xx2.toInt(); x2 = xx1.toInt()
        }
        if (yy1.toInt() < yy2.toInt()) {
            y1 = yy1.toInt(); y2 = yy2.toInt()
        } else {
            y1 = yy2.toInt(); y2 = yy1.toInt()
        }

        if (x1 == x2) {
            for (y in y1..y2) {
                print(y)
                ocean[y][x1]++
            }
            println("x1")
        } else if (y1 == y2) {
            for (x in x1..x2) {
                print(x)
                ocean[y1][x]++
            }
            println("x2")
        } else {
            println("diagonal")
        }
    }

    var count = 0

    for (row in ocean) {
        for (a in row) {
            if (a > 1) count++
            //print(a)
        }
        //println()
    }

    return count
}

fun solutionPart2(input: List<String>) = 0