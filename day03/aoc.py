from os import environ


def getSolutionPart1(input_list):
    result = ""
    for i in range(0, len(input_list[0]) - 1):
        zeroes = 0
        ones = 0

        for line in input_list:
            if line[i] == "0":
                zeroes = zeroes + 1
            else:
                ones = ones + 1

        if zeroes > ones:
            result = result + "0"
        else:
            result = result + "1"
    
    gamma = int(result, 2)
    epsilon = int(result.translate(str.maketrans({'0':'1','1':'0'})), 2)
    return gamma * epsilon


def getSolutionPart2(input_list):

    return 1

if __name__ == "__main__":
    with open("input.txt") as f:
        file_input = [x for x in f.readlines()]

    part = environ.get("part")

    if part == "part2":
        print(getSolutionPart2(file_input))
    else:
        print(getSolutionPart1(file_input))
