package services;

import entities.Match;
import entities.SportsClub;

import java.io.IOException;

public interface LeagueManager {
    //method to create a SportsClub in the league
    void addFootballClub(SportsClub sportsClub);
    //method to delete a club in the league
    void deleteSportsClub(String clubID);
    //method to display stat of a club in the league
    void displayStatistics(String clubID);
    //method to add match in the club in the league
    void addMatch(Match match);
    //method to save teams data in the league
    void saveLeagueTeamData(String teamsFileName) throws  IOException;
    //method to load team data in the league
    void loadLeagueTeamData(String teamsFileName) throws IOException, ClassNotFoundException;
    //method to save match data in the league
    void saveLeagueMatchData(String matchesFileName) throws IOException;
    //method to load club data in the league
    void loadLeagueMatchData(String matchesFileName) throws IOException, ClassNotFoundException;

}
