package entities;

import services.PremierLeagueManager;

import java.io.Serializable;
import java.util.Objects;

public class Match implements Serializable {
    PremierLeagueManager premierLeagueManager = new PremierLeagueManager();

    private String team1;
    private String team2;
    private int team1Goals;
    private int team2Goals;
    private String matchLocation;
    private MatchDate matchDate;

    public Match(String team1, String team2, int team1Goals, int team2Goals, String matchLocation, MatchDate matchDate) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Goals = team1Goals;
        this.team2Goals = team2Goals;
        this.matchLocation = matchLocation;
        this.matchDate = matchDate;
        updateTeamStatistics(team1, team2, team1Goals, team2Goals);

    }

    public Match() {

    }


    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public int getTeam1Goals() {
        return team1Goals;
    }

    public void setTeam1Goals(int team1Goals) {
        this.team1Goals = team1Goals;
    }

    public int getTeam2Goals() {
        return team2Goals;
    }

    public void setTeam2Goals(int team2Goals) {
        this.team2Goals = team2Goals;
    }

    public String getMatchLocation() {
        return matchLocation;
    }

    public void setMatchLocation(String matchLocation) {
        this.matchLocation = matchLocation;
    }

    public MatchDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(MatchDate matchDate) {
        this.matchDate = matchDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Match)) return false;
        Match match = (Match) o;
        return team1Goals == match.team1Goals &&
                team2Goals == match.team2Goals &&
                team1.equals(match.team1) &&
                team2.equals(match.team2) &&
                matchLocation.equals(match.matchLocation) &&
                matchDate.equals(match.matchDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(team1, team2, team1Goals, team2Goals, matchLocation, matchDate);
    }

    @Override
    public String toString() {
        return "matchLocation='" + matchLocation + '\t' + "matchDate=" + matchDate + '\t' + "team1='" + team1 + '\t' + "team2='" + team2 + '\t' + "team1Goals=" + team1Goals + '\t' + "team2Goals=" + team2Goals;
    }


    //method to update the team stats
    public void updateTeamStatistics(String team1, String team2, int team1Goals, int team2Goals) {
        for (SportsClub club : premierLeagueManager.listOfFootballClubs) {
            if (club instanceof FootballClub) {
                int pastGoalsFor = ((FootballClub) club).getGoalsFor();
                int pastGoalsAgainst = ((FootballClub) club).getGoalsAgainst();
                int pastNumMatches = ((FootballClub) club).getNumMatches();
                int pastWins = ((FootballClub) club).getWins();
                int pastDefeats = ((FootballClub) club).getDefeats();
                int pastDraws = ((FootballClub) club).getDraws();


                //finding similar team
                if (club.getSportsClubName().equals(team1)) {
                    ((FootballClub) club).setNumMatches(pastNumMatches + 1);
                    //updating team's goals
                    ((FootballClub) club).setGoalsFor(pastGoalsFor + team1Goals);
                    ((FootballClub) club).setGoalsAgainst(pastGoalsAgainst + team2Goals);

                    //updating wins and defeats and draws
                    if (team1Goals == team2Goals) {
                        ((FootballClub) club).setDraws(pastDraws + 1);
                    }
                    else if (team1Goals > team2Goals) {
                        ((FootballClub) club).setWins(pastWins + 1);
                    } else if (team1Goals < team2Goals) {
                        ((FootballClub) club).setDefeats(pastDefeats + 1);
                    }
                    club.pointsCalculation();

                    //finding similar team
                } else if (club.getSportsClubName().equals(team2)) {
                    ((FootballClub) club).setNumMatches(pastNumMatches + 1);
                    //updating team's goals
                    ((FootballClub) club).setGoalsFor(pastGoalsFor + team2Goals);
                    ((FootballClub) club).setGoalsAgainst(pastGoalsAgainst + team1Goals);

                    //updating wins and defeats
                    //updating stats if match is a draw
                    if (team1Goals == team2Goals) {
                        ((FootballClub) club).setDraws(pastDraws + 1);
                    }
                    else if (team1Goals > team2Goals) {
                        ((FootballClub) club).setDefeats(pastDefeats + 1);
                    } else if (team1Goals < team2Goals) {
                        ((FootballClub) club).setWins(pastWins + 1);
                    }
                    club.pointsCalculation();

                }
            }
        }


    }
}

