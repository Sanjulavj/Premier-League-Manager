package entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class FootballClubTest {
    FootballClub footballClubTest =  new FootballClub();

    @Test(expected = IllegalArgumentException.class)
    public void testMatchCheck(){
        footballClubTest.matchCheck(3);
    }

    @Test
    public void testGoalDifference(){
        footballClubTest.goalDifference();
    }

    @Test
    public void testPointsCalculation(){
        footballClubTest.pointsCalculation();
    }
}