#!/usr/bin/python3
"""
Solves the first problem in the eighth pair of advent of code problems
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

#Initialize count to zero
diff = 0

#Iterate over every line
for line in sys.stdin.readlines():
    #Remove trailing newlines
    line = line.rstrip()
    #Compare the length of the original string with
    #The length of the string with escape sequences evaluated
    #TODO: THIS IS UNSAFE
    #USE REGEX OR ENCODING INSTEAD
    diff += len(line) - len(eval(line))
print(diff)
