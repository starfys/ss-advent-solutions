#!/usr/bin/python3
"""
Solves the first problem in the third pair of advent of code problems
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
import functools
import operator

visited_locations = set()
visited_locations.add((0,0))
instructions=sys.stdin.read()[:-1]

def convert_to_movements(instruction):
    if instruction == '<':
        return (-1,0)
    if instruction == '>':
        return (1,0)
    if instruction == '^':
        return (0,1)
    if instruction == 'v':
        return (0,-1)

def add_tuples(first, second):
    result=tuple(map(operator.add,first,second))
    visited_locations.add(result)
    return result

movement_list=list(map(convert_to_movements, instructions))

functools.reduce(add_tuples, movement_list)

print(len(visited_locations))
