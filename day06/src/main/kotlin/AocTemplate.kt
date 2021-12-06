import java.io.File

fun main() {
    val input = File("input.txt").readLines()[0].split(",").map { it.toInt() }
    val answer = when (System.getenv("part")) {
        "part2" -> solutionPart2(input)
        else -> solutionPart1(input)
    }
    println(answer)
}

fun solutionPart1(fishes: List<Int>)= simulator(fishes, 80)

fun solutionPart2(fishes: List<Int>) = simulator(fishes, 256)

fun simulator(fishes: List<Int>, days: Int) : Long {
    var state = MutableList(9) { 0L }
    for (age in fishes) {
        state[age]++
    }

    for (day in 1..days) {
        val nextState = MutableList(9) { 0L }
        nextState[6] = state[0]
        nextState[8] = state[0]
        for (i in 0..7) {
            nextState[i] += state[i+1]
        }
        state = nextState
    }
    return state.sum()
}