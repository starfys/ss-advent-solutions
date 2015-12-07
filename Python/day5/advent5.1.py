#!/usr/bin/python3
"""
Solves the first problem in the fifth pair of advent of code problems
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
data=sys.stdin.readlines()
map(str.rstrip,data)

def is_nice(word):
    forbidden_strings=['ab', 'cd', 'pq', 'xy']
    vowels='aeiou'
    #Initial conditions
    has_three_vowels = False
    has_one_repeat = False
    has_forbidden_strings = False
    num_vowels = 0

    for index in range(len(word) - 1):
        if (word[index] + word[index + 1]) in forbidden_strings:
            has_forbidden_strings = True
            break
        if word[index] in vowels:
            num_vowels += 1
        if word[index] == word[index + 1]:
            has_one_repeat = True
    
    if word[-1] in vowels:
        num_vowels += 1
    has_three_vowels = (num_vowels >= 3)

    return has_three_vowels and has_one_repeat and not has_forbidden_strings

num_nice = 0
for word in data:
    num_nice += is_nice(word)
print(num_nice)
