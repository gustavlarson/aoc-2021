import unittest

import aoc


class TestAoc(unittest.TestCase):

    test_input = ["forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2"]

    def test_part_1(self):
        self.assertEqual(aoc.getSolutionPart1(self.test_input), 150)

    def test_part_2(self):
        self.assertEqual(aoc.getSolutionPart2(self.test_input), 900)


if __name__ == "__main__":
    unittest.main()
