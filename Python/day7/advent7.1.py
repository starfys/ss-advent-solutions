#!/usr/bin/python3
"""
Solves the first problem in the seventh pair of advent of code problems
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
wires={}
def calculate(output):
    
    #print(output)
    if(isinstance(output,int)):
        return output
    if(output.isnumeric()):
        return int(output)
    expression = output.split(' ')
    #print(expression)
    if len(expression) == 1:
        wires[output]=calculate(wires[output])
        return wires[output]
    if len(expression) == 2:
        return ~calculate(expression[1])
    left = calculate(expression[0])
    right = calculate(expression[2])
    if expression[1] == "AND":
        return left & right
    if expression[1] == "AND":
        return left & right
    if expression[1] == "OR":
        return left | right
    if expression[1] == "LSHIFT":
        return left << right
    if expression[1] == "RSHIFT":
        return left >> right


data=sys.stdin.readlines()
for line in data:
    line=line.rstrip()
    line = line.split(' -> ')
    wires[line[1]] = line[0]
print(calculate('a'))
    
