//Solves the second problem in the fourteenth pair of advent of code problems
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
#include <iostream>
class Reindeer
{
public:
    Reindeer():
        m_FlySpeed(0), m_FlyTime(0), m_RestTime(0), m_RemainingFlyTime(0),
        m_RemainingRestTime(0), m_DistanceFlown(0),m_Points(0)
    {

    }
    Reindeer(std::string initName, unsigned int initFlySpeed,
        unsigned int initFlyTime, unsigned int initRestTime):
        m_Name(initName),
        m_FlySpeed(initFlySpeed), m_FlyTime(initFlyTime), m_RestTime(initRestTime),
        m_RemainingFlyTime(initFlyTime), m_RemainingRestTime(0), m_DistanceFlown(0),
        m_Points(0)
    {

    }
    std::string getName()
    {
        return m_Name;
    }
    unsigned int getFlySpeed()
    {
        return m_FlySpeed;
    }
    unsigned int getFlyTime()
    {
        return m_FlyTime;
    }
    unsigned int getRestTime()
    {
        return m_RestTime;
    }
    unsigned int getDistanceFlown()
    {
        return m_DistanceFlown;
    }
    unsigned int getPoints()
    {
        return m_Points;
    }
    void setName(std::string newName)
    {
        m_Name = newName;
    }
    void setFlySpeed(unsigned int newFlySpeed)
    {
        m_FlySpeed = newFlySpeed;
    }
    void setFlyTime(unsigned int newFlyTime)
    {
        m_FlyTime = newFlyTime;
    }
    void setRestTime(unsigned int newRestTime)
    {
        m_RestTime = newRestTime;
    }
    void act()
    {
        if(m_RemainingRestTime > 0)
        {
            --m_RemainingRestTime;
            if(m_RemainingRestTime == 0)
            {
                m_RemainingFlyTime = m_FlyTime;
            }
            return;
        }
        if(m_RemainingFlyTime > 0)
        {
            m_DistanceFlown += m_FlySpeed;
            --m_RemainingFlyTime;
            if(m_RemainingFlyTime == 0)
            {
                m_RemainingRestTime = m_RestTime;
            }
            return;
        }
    }
    void awardPoint()
    {
       ++m_Points;
    }
    friend std::istream& operator>>(std::istream& inputStream, Reindeer &inputReindeer)
    {
        char newName[10];
        unsigned int newFlySpeed;
        unsigned int newFlyTime;
        unsigned int newRestTime;
        inputStream.get(newName, 10, ' ');
        inputReindeer.setName(newName);
        inputStream.ignore(256, ' ');
        inputStream.ignore(256, ' ');
        inputStream.ignore(256, ' ');
        
        inputStream >> newFlySpeed;
        
        inputStream.ignore(256, ' ');
        inputStream.ignore(256, ' ');
        inputStream.ignore(256, ' ');

        inputStream >> newFlyTime;
        
        inputStream.ignore(256, ' ');
        inputStream.ignore(256, ' ');
        inputStream.ignore(256, ' ');
        inputStream.ignore(256, ' ');
        inputStream.ignore(256, ' ');
        inputStream.ignore(256, ' ');
        inputStream.ignore(256, ' ');

        
        inputStream >> newRestTime;
        
        inputStream.ignore(256, ' ');
        inputStream.ignore(256, '\n');
    
        inputReindeer = Reindeer(newName, newFlySpeed, newFlyTime, newRestTime);
    }
    friend std::ostream& operator<<(std::ostream& outputStream, Reindeer &outputReindeer)
    {
        outputStream << "Name: "      << outputReindeer.getName()     << '\n'
                     << "Fly Speed: " << outputReindeer.getFlySpeed() << " km/s \n"
                     << "Fly Time: "  << outputReindeer.getFlyTime()  << " s \n"
                     << "Rest Time: " << outputReindeer.getRestTime() << " s\n";
    }
private:
    std::string m_Name;
    unsigned int m_FlySpeed;
    unsigned int m_FlyTime;
    unsigned int m_RestTime;
    unsigned int m_RemainingFlyTime;
    unsigned int m_RemainingRestTime;
    unsigned int m_DistanceFlown;
    unsigned int m_Points;
};

const unsigned int RACE_TIME = 2503;
const unsigned int NUM_REINDEER = 9;

int main()
{
    Reindeer reindeerList[NUM_REINDEER];
    for(unsigned int reindeerNumber = 0; reindeerNumber < NUM_REINDEER; ++reindeerNumber)
    {
        std::cin >> reindeerList[reindeerNumber];
        //std::cout << reindeerList[reindeerNumber];
        //std::cout << '\n';
    }
    unsigned int maxDistance = 0;
    for(unsigned int curTime = 0; curTime < RACE_TIME; ++curTime)
    {
        for(unsigned int reindeerNumber = 0; reindeerNumber < NUM_REINDEER; ++reindeerNumber)
        {
            reindeerList[reindeerNumber].act();
            if(reindeerList[reindeerNumber].getDistanceFlown() > maxDistance)
            {
                maxDistance = reindeerList[reindeerNumber].getDistanceFlown();
            }
        }
        for(unsigned int reindeerNumber = 0; reindeerNumber < NUM_REINDEER; ++reindeerNumber)
        {
            if(reindeerList[reindeerNumber].getDistanceFlown() == maxDistance)
            {
                reindeerList[reindeerNumber].awardPoint();
            }
        }
    }
    for(unsigned int reindeerNumber = 0; reindeerNumber < NUM_REINDEER; ++reindeerNumber)
    {
        std::cout << reindeerList[reindeerNumber].getName() << ' '
                  << reindeerList[reindeerNumber].getPoints() << '\n';
    }
}
