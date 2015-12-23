#!/usr/bin/python3
"""
Solves the first problem in the twelfth pair of advent of code problems
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

import json
import sys

json_data = sys.stdin.read().rstrip()

json_data = json.loads(json_data)

def sum_data(py_object):
    if type(py_object) == str:
            return 0    
    if type(py_object) == int:
            return py_object
    final_sum = 0
    if type(py_object) == dict:
        for value in py_object.values():
            final_sum += sum_data(value)
    if type(py_object) == list:
        for value in py_object:
            final_sum += sum_data(value)
    return final_sum

print(sum_data(json_data))
