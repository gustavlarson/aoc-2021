/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {
    private static final List<Integer> INPUT = List.of(0,
            3,
            4,
            42,
            106,
            107,
            267,
            269);
    App classUnderTest;

    @BeforeEach
    void createSubject() {
        classUnderTest = new App(INPUT);
    }

    @Test void part1SumsInput() {
        assertEquals(2421, classUnderTest.getSolutionPart1());
    }

    @Test void part2MultipliesInput() {
        assertEquals(335, classUnderTest.getSolutionPart2());
    }
}