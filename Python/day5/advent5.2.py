#!/usr/bin/python3
"""
Solves the second problem in the fifth pair of advent of code problems
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
data=list(map(str.rstrip,data))


def is_really_nice(word):
    has_duplicate_pair = False
    has_alternating_sequence = False
    last_pair = word[0] + word[1]
    pairs=[last_pair]
    for index in range(1, len(word) - 1):
        cur_pair = word[index] + word[index + 1]
        if cur_pair in pairs:
            if cur_pair != last_pair:
                has_duplicate_pair = True
                dup_pair = cur_pair        
        else:
            pairs.append(cur_pair)
        if last_pair != cur_pair:
            last_pair = cur_pair
        else:
            last_pair = ''
        if word[index - 1] == word[index + 1]:
            has_alternating_sequence = True
            alt_seq = word[index - 1:index + 2]
    return has_duplicate_pair and has_alternating_sequence
num_nice = 0
for word in data:
    num_nice += is_really_nice(word)
print(num_nice)
