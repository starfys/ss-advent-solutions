#!/usr/bin/python3
"""
Solves the first problem in the sixth pair of advent of code problems
Copyright 2015 Steven Sheffey

    This file is part of ss-advent-solutions

    ss-advent-solutions is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    ss-advent-solutions is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with ss-advent-solutions.  If not, see <http://www.gnu.org/licenses/>.
"""

import sys

data=map(lambda line: line.rstrip().split(' '), sys.stdin.readlines())

def set_lights(matrix, value, start, end):
    for row in range(start[0], end[0] + 1):
        for col in range(start[1], end[1] + 1):
            if value:
                matrix[row][col] += 1
            else:
                matrix[row][col] = max(matrix[row][col] - 1, 0)
def toggle_lights(matrix ,start, end):
    for row in range(start[0], end[0] + 1):
        for col in range(start[1], end[1] + 1):
            matrix[row][col] += 2

matrix_size = 1000
light_matrix = [([0]*matrix_size) for row in range(matrix_size)]

for instruction in data:
    if instruction[0] == 'turn':
        start = list(map(int, instruction[2].split(',')))
        end = list(map(int, instruction[4].split(',')))
        set_lights(light_matrix, instruction[1] == 'on', start, end)
    else:
        start = list(map(int, instruction[1].split(',')))
        end = list(map(int, instruction[3].split(',')))
        toggle_lights(light_matrix, start, end)
print(sum([sum(row) for row in light_matrix]))
