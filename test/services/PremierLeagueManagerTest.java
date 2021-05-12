package services;

import entities.FootballClub;
import entities.Match;
import entities.MatchDate;
import entities.SportsClub;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class PremierLeagueManagerTest {
    PremierLeagueManager premierLeagueManager = new PremierLeagueManager();

    @Test
    public void testAddClub(){
        SportsClub sportsClubTest = new FootballClub("4","Team4","Kandy",4,2,2,0,7,6);
        premierLeagueManager.addFootballClub(sportsClubTest);
    }

    @Test
    public void testDeleteClub(){
        premierLeagueManager.deleteSportsClub("1");
    }

    @Test
    public void testLeagueClubStat(){
        premierLeagueManager.displayStatistics("1");
    }

    @Test
    public void testLeagueTable(){
        premierLeagueManager.displayPremierLeagueTable();
    }

    @Test
    public void testAddMatch(){
        Match testMatch = new Match("Team1","Team2",2,2,"Colombo",new MatchDate(2020,07,01));
        premierLeagueManager.addMatch(testMatch);
    }


    @Test
    public void randomMatchUpdate() throws IOException, ClassNotFoundException {
        premierLeagueManager.loadLeagueTeamData("TeamsFile1.txt");
        premierLeagueManager.randomMatchUpdate();
    }



    @Test
    public void testAddSameClubs(){
        SportsClub sportsClubTest1 = new FootballClub("4","Team4","Kandy",4,2,2,0,7,6);
        SportsClub sportsClubTest2 = new FootballClub("4","Team4","Kandy",4,2,2,0,7,6);
        premierLeagueManager.addFootballClub(sportsClubTest1);
        premierLeagueManager.addFootballClub(sportsClubTest2);
    }

    @Test
    public void testAddSameMatches(){
        Match testMatch1 = new Match("Team1","Team2",2,2,"Colombo",new MatchDate(2020,7,1));
        Match testMatch2 = new Match("Team1","Team2",2,2,"Colombo",new MatchDate(2020,7,1));
        premierLeagueManager.addMatch(testMatch2);
        premierLeagueManager.addMatch(testMatch1);
    }






}