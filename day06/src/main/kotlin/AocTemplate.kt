import java.io.File

fun main() {
    val input = File("input.txt").readLines()[0].split(",").map { it.toInt() }
    val answer = when (System.getenv("part")) {
        "part2" -> solutionPart2(input)
        else -> solutionPart1(input)
    }
    println(answer)
}

fun solutionPart1(fishes: List<Int>): Int {
    var state = fishes
    var nextState: MutableList<Int> = mutableListOf()
    for (day in 1..80) {
        nextState = mutableListOf()
        for (age in state) {
            if (age == 0) {
                nextState.add(6)
                nextState.add(8)
            } else {
                nextState.add(age - 1)
            }
        }
        state = nextState
        println("After day ${day}: ${state.joinToString()}")
    }
    return state.size
}

fun solutionPart2(input: List<Int>) = input.reduce(Int::times)