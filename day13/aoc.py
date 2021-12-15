from os import environ
import numpy as np

def fold(dots, instruction):
    axis, line = instruction.split("=")
    line = int(line)
    axis = 1 if axis == 'y' else 0
    should_fold = dots[:, axis] > line
    dots[should_fold, axis] = line - (dots[should_fold, axis] - line)
    return dots

def getSolutionPart1(dots, instructions):
    return len(np.unique(fold(dots, instructions[0]), axis=0))

def getSolutionPart2(dots, instructions):
    for instruction in instructions:
        dots = fold(dots, instruction)
    
    dotlist = dots.tolist()
    for x in range(max(dots[:,1])+1):
        for y in range(max(dots[:,0])+1):
            if ([y, x] in dotlist):
                print("█", end='')
            else:
                print(" ", end='')
        print("")

if __name__ == "__main__":
    with open("input.txt") as f:
        file_input = f.readlines()
        dots = np.array([[int(y) for y in x.split(",")] for x in file_input if "," in x])
        instructions = [x.replace("fold along ","") for x in file_input if "=" in x]

    if environ.get("part") == "part2":
        getSolutionPart2(dots, instructions)
    else:
        print(getSolutionPart1(dots, instructions))
