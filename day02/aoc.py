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


with open("input.txt") as f:
    file_input = [x for x in f.readlines()]

print("Python")
part = environ.get("part")

if part == "part2":
    print(getSolutionPart2(file_input))
else:
    print(getSolutionPart1(file_input))
