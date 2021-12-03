import unittest

import aoc


class TestAoc(unittest.TestCase):

    test_input = ["00100",
"11110",
"10110",
"10111",
"10101",
"01111",
"00111",
"11100",
"10000",
"11001",
"00010",
"01010"]

    def test_get_solution_1_should_return_sum_of_input_entries(self):
        self.assertEqual(aoc.getSolutionPart1(self.test_input), 198)

    def test_get_solution_2_should_return_product_of_input_entries(self):
        self.assertEqual(aoc.getSolutionPart2(self.test_input), 230)


if __name__ == "__main__":
    unittest.main()
