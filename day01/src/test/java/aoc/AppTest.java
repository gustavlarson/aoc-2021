/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package aoc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    private static final List<Integer> INPUT = List.of(199,
            200,
            208,
            210,
            200,
            207,
            240,
            269,
            260,
            263);
    App classUnderTest;

    @BeforeEach
    void createSubject() {
        classUnderTest = new App(INPUT);
    }

    @Test
    void part1Input() {
        assertEquals(7, classUnderTest.getSolutionPart1());
    }

    @Test
    void part2Input() {
        assertEquals(5, classUnderTest.getSolutionPart2());
    }
}
