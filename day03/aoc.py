from os import environ


def count(list, position):
    zeroes = 0
    ones = 0
    for line in list:
        if line[position] == "0":
            zeroes = zeroes + 1
        else:
            ones = ones + 1
    return zeroes, ones


def getSolutionPart1(input_list):
    result = ""
    for i in range(0, len(input_list[0])):
        zeroes, ones = count(input_list, i)

        if zeroes > ones:
            result = result + "0"
        else:
            result = result + "1"

    gamma = int(result, 2)
    epsilon = int(result.translate(str.maketrans({"0": "1", "1": "0"})), 2)
    return gamma * epsilon


def getSolutionPart2(input_list):
    remaining = input_list
    oxygen = 0
    co2 = 0
    for i in range(0, len(input_list[0])):
        zeroes, ones = count(remaining, i)

        new_list = []
        if zeroes > ones:
            for line in remaining:
                if line[i] == "0":
                    new_list.append(line)
        else:
            for line in remaining:
                if line[i] == "1":
                    new_list.append(line)

        remaining = new_list
        if len(remaining) == 1:
            oxygen = int(remaining[0], 2)
            break

    remaining = input_list
    for i in range(0, len(input_list[0])):
        zeroes, ones = count(remaining, i)

        new_list = []
        if zeroes > ones:
            for line in remaining:
                if line[i] == "1":
                    new_list.append(line)
        else:
            for line in remaining:
                if line[i] == "0":
                    new_list.append(line)

        remaining = new_list
        if len(remaining) == 1:
            co2 = int(remaining[0], 2)
            break

    return oxygen * co2


if __name__ == "__main__":
    with open("input.txt") as f:
        file_input = [x.strip() for x in f.readlines()]

    part = environ.get("part")

    if part == "part2":
        print(getSolutionPart2(file_input))
    else:
        print(getSolutionPart1(file_input))
