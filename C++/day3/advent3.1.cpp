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
#include <set>

int main()
{
    char curInstruction;
    int64_t currentLocation;
    
    int32_t x = 0;
    int32_t y = 0;

    //Set storing the coordinates of all visited locations
    std::set<int64_t> visitedLocations;
    //Insert the value representing 0,0
    visitedLocations.insert(0);
    //Read in each character
    while((curInstruction = getchar()) != EOF)
    {
        //Handle the instruction
        switch(curInstruction)
        {
            case '<':
                --x;
                break;
            case '>':
                ++x;
                break;
            case '^':
                ++y;
                break;
            case 'v':
                --y;
                break;
        }
        //Initialize the location to X
        currentLocation = x;
        //Shift the value 32 bits to the left
        currentLocation <<= 32;
        //Add y to the location
        currentLocation += y;
        //The resulting currentLocation is unique for each coordinate
        visitedLocations.insert(currentLocation);
    }
    printf("%d\n",visitedLocations.size());
}
