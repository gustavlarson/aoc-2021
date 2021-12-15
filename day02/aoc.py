from os import environ


def getSolutionPart1(input_list):
    depth = 0
    position = 0
    for line in input_list:
        (instruction, value) = line.split(" ")
        value = int(value)
        if instruction == "up":
            depth -= value
        if instruction == "down":
            depth += value
        if instruction == "forward":
            position += value
    return depth * position


def getSolutionPart2(input_list):
    depth = 0
    position = 0
    aim = 0
    for line in input_list:
        (instruction, value) = line.split(" ")
        value = int(value)
        if instruction == "up":
            aim -= value
        if instruction == "down":
            aim += value
        if instruction == "forward":
            position += value
            depth += aim * value
    return depth * position

if __name__ == "__main__":
    with open("input.txt") as f:
        file_input = f.readlines()

    if environ.get("part") == "part2":
        print(getSolutionPart2(file_input))
    else:
        print(getSolutionPart1(file_input))
