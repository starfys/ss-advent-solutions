//Solves the first problem in the third pair of advent of code problems
//Copyright 2015 Steven Sheffey
/*
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
*/
#include <stdio.h>
#include <stdint.h>

int main()
{
    char curInstruction;
    int x = 0;
    int y = 0;


    while((curInstruction = getchar()) != EOF)
    {
        if(curInstruction == '<')
        {
            --x;
        }
        else if(curInstruction == '>')
        {
            ++x;
        }
        else if(curInstruction == '^')
        {
            ++y;
        }
        else
        {
            --y;
        }
    }
    //TODO: finish this
}
