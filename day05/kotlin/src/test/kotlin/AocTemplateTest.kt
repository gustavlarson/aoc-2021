import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

internal class AocTemplateTest {

    private val input = File("inputTest.txt").readLines()

    @Test
    internal fun `solutionPart1 should return sum of input`() {
        assertEquals(solutionPart1(input), 5)
    }

    @Test
    internal fun `solutionPart2 should return product of input`() {
        assertEquals(solutionPart2(input), 0)
    }
}