import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class AocTemplateTest {

    @Test
    internal fun `solutionPart1 should return sum of input`() {
        assertEquals(5934, solutionPart1("3,4,3,1,2".split(",").map { it.toInt() }))
    }

    @Test
    internal fun `solutionPart2 should return product of input`() {
        assertEquals(56154, solutionPart2( "".split(",").map { it.toInt() }))
    }
}