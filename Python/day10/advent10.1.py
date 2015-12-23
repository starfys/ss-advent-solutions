#!/usr/bin/python3
"""
Solves the first problem in the tenth pair of advent of code problems
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

digits = sys.stdin.read().rstrip()

for iteration in range(40):
    last_digit = digits[0]
    cur_streak = 1
    next_digits = ''
    for index in range(1,len(digits)):
        if digits[index] == last_digit:
            cur_streak += 1
        else:
            next_digits += str(cur_streak)
            next_digits += last_digit
            last_digit = digits[index]
            cur_streak = 1
    next_digits += str(cur_streak)
    next_digits += last_digit
    digits = next_digits

print(len(digits))
