import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class AocTemplateTest {

    @Test
    internal fun `solutionPart1`() {
        assertEquals(5934, solutionPart1("3,4,3,1,2".split(",").map { it.toInt() }))
    }

    @Test
    internal fun `solutionPart2`() {
        assertEquals(26984457539, solutionPart2("3,4,3,1,2".split(",").map { it.toInt() }))
    }
}