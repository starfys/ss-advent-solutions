//Solves the first problem in the eleventh pair of advent of code problems
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
#include <iostream>
#include <stdio.h>
const unsigned int PASSWORD_LENGTH = 8;

bool isValid(std::string password);

int main()
{
    std::string password;
    std::cin >> password;

    while(!isValid(password))
    {
        for(int index = PASSWORD_LENGTH - 1; index >= 0; --index)
        {
            if(password[index] != 'z')
            {
                ++password[index];
                break;
            }
            else
            {
                password[index] = 'a';
            }
        }
    }
    puts(password.c_str());
}

bool isValid(std::string password)
{
    //Check for forbidden characters
    for(int index = 0; index < PASSWORD_LENGTH; ++index)
    {
        if(password[index] == 'i' ||
           password[index] == 'o' ||
           password[index] == 'l')
        {
            return false;
        }
    }
    //Check for consecutive sequence
    bool has_consecutive = false;
    for(int index = 1; index < PASSWORD_LENGTH - 1; ++index)
    {
        if(password[index - 1] + 1 == password[index] &&
           password[index] + 1 == password[index + 1])
        {
            has_consecutive = true;
            break;
        }
    }
    if(!has_consecutive)
    {
        return false;
    }
    //Check for two different non-overlapping pairs
    bool represented_letters[26];
    for(int index = 0; index < 26; ++index)
    {
        represented_letters[index] = false;
    }
    int num_different_pairs = 0;
    for(int index = 1; index < PASSWORD_LENGTH; ++index)
    {
        if(password[index] == password[index - 1])
        {
            if(!represented_letters[password[index] - 'a'])
            {
                represented_letters[password[index] - 'a'] = true;
                ++num_different_pairs;
            }
        }
    }
    return num_different_pairs >= 2;
}
