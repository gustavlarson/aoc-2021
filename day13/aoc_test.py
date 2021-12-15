import unittest

import aoc


class TestAoc(unittest.TestCase):

    test_input = ["6,10",
"0,14",
"9,10",
"0,3",
"10,4",
"4,11",
"6,0",
"6,12",
"4,1",
"0,13",
"10,12",
"3,4",
"3,0",
"8,4",
"1,10",
"2,14",
"8,10",
"9,0",
"",
"fold along y=7",
"fold along x=5"
    ]

    def test_part_1(self):
        self.assertEqual(aoc.getSolutionPart1(self.test_input), 17)

    def test_part_2(self):
        self.assertEqual(aoc.getSolutionPart2(self.test_input), 0)


if __name__ == "__main__":
    unittest.main()
