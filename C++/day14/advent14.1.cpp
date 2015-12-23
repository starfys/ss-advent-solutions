//Solves the first problem in the fourteenth pair of advent of code problems
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

class Reindeer
{
public:
    Reindeer(unsigned int initFlySpeed, unsigned int initFlyTime, unsigned int initRestTime):
        m_FlySpeed(initFlySpeed), m_FlyTime(initFlyTime), m_RestTime(initRestTime),
        m_RemainingFlyTime(initFlyTime), m_RemainingRestTime(0), m_DistanceFlown(0)
    {

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
    unsigned int getDistanceFlown()
    {
        return m_DistanceFlown;
    }
private:
    unsigned int m_FlySpeed;
    unsigned int m_FlyTime;
    unsigned int m_RestTime;
    unsigned int m_RemainingFlyTime;
    unsigned int m_RemainingRestTime;
    unsigned int m_DistanceFlown;
};

static const unsigned int raceTime = 2503;


int main()
{
    Reindeer comet(14, 10, 127);
    Reindeer dancer(16, 11, 162);

    for(int curTime = 0; curTime < raceTime; ++curTime)
    {
        comet.act();
        dancer.act();
    }
    printf("Comet: %u km\n"
           "Dancer: %u km\n",
           comet.getDistanceFlown(),
           dancer.getDistanceFlown());
}
