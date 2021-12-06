import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

internal class AocTemplateTest {

    private val input = File("inputTest.txt").readLines()

    @Test
    internal fun `solutionPart1 should return sum of input`() {
        assertEquals(5, solutionPart1(input))
    }

    @Test
    internal fun `solutionPart2 should return product of input`() {
        assertEquals(12, solutionPart2(input))
    }
}