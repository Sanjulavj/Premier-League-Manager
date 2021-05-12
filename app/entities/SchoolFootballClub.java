package entities;

import java.io.Serializable;

public class SchoolFootballClub extends FootballClub implements Serializable{
    private String schoolName;


    public SchoolFootballClub(String sportsClubID, String sportsClubName, String sportsClubLocation, int numMatches, int wins, int draws, int defeats, int goalsFor, int goalsAgainst, String schoolName) {
        super(sportsClubID, sportsClubName, sportsClubLocation, numMatches, wins, draws, defeats, goalsFor, goalsAgainst);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "schoolName: " + schoolName;
    }
}
