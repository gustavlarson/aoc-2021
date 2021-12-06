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
    val ocean = Array(1000) { Array(1000) { 0 } }
    val regex = Regex("(\\d+),(\\d+)\\s+->\\s+(\\d+),(\\d+)")
    input.forEach { line ->
        val (xx1, yy1, xx2, yy2) = regex.find(line)!!.destructured
        var x1 = 0;
        var x2 = 0;
        var y1 = 0;
        var y2 = 0;
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

    var b = 0;
    var c = 0;
    for (row in ocean) {
        b++
        for (a in row) {
            c++
            if (a > 1) count++
            print(a)
            if (c > 9) break
        }
        c = 0
        if (b > 9) break;
        println()
    }

    return count
}

fun solutionPart2(input: List<String>): Int {
    val ocean = Array(1000) { Array(1000) { 0 } }
    val regex = Regex("(\\d+),(\\d+)\\s+->\\s+(\\d+),(\\d+)")
    input.forEach { line ->
        val (xx1, yy1, xx2, yy2) = regex.find(line)!!.destructured
        val x1: Int = xx1.toInt();
        val x2: Int = xx2.toInt()
        val y1: Int = yy1.toInt();
        val y2: Int = yy2.toInt()

        val dy: Int = if (yy1.toInt() < yy2.toInt()) {
            1
        } else {
            -1
        }

        if (x1 == x2) {
            for (y in y1 toward y2) {
                print(y)
                ocean[y][x1]++
            }
        } else if (y1 == y2) {
            for (x in x1 toward x2) {
                print(x)
                ocean[y1][x]++
            }
        } else {
            var y = y1
            for (x in x1 toward x2) {
                print("${x},${y} ")
                ocean[y][x]++
                y += dy
            }
        }
    }

    var count = 0

    for (row in ocean) {
        for (a in row) {
            if (a > 1) count++
        }
    }

    return count
}

private infix fun Int.toward(to: Int): IntProgression {
    val step = if (this > to) -1 else 1
    return IntProgression.fromClosedRange(this, to, step)
}