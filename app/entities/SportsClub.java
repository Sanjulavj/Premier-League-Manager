package entities;

import java.io.Serializable;
import java.util.Objects;

public abstract class SportsClub implements Serializable {

    private String sportsClubID;
    private String sportsClubName;
    private String sportsClubLocation;
    private int points;


    public SportsClub(String sportsClubID, String sportsClubName, String sportsClubLocation) {
        this.sportsClubID = sportsClubID;
        this.sportsClubName = sportsClubName;
        this.sportsClubLocation = sportsClubLocation;

    }

    public SportsClub() {
    }



    public String getSportsClubID() {
        return sportsClubID;
    }

    public void setSportsClubID(String sportsClubID) {
        this.sportsClubID = sportsClubID;
    }

    public String getSportsClubName() {
        return sportsClubName;
    }

    public void setSportsClubName(String sportsClubName) {
        this.sportsClubName = sportsClubName;
    }

    public String getSportsClubLocation() {
        return sportsClubLocation;
    }

    public void setSportsClubLocation(String sportsClubLocation) {
        this.sportsClubLocation = sportsClubLocation;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) { this.points = points; }

    //method to calculate points
    public abstract int pointsCalculation();

    //method to check if new club is already added or not
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        SportsClub that = (SportsClub) object;
        return points == that.points &&
                Objects.equals(sportsClubID, that.sportsClubID) &&
                Objects.equals(sportsClubName, that.sportsClubName) &&
                Objects.equals(sportsClubLocation, that.sportsClubLocation);
    }


    @Override
    public int hashCode() {
        return Objects.hash(sportsClubID, sportsClubName, sportsClubLocation, points);
    }

    @Override
    public String toString() {
        return "sportsClubID:" + sportsClubID + "\t" + "sportsClubName:" + sportsClubName + "\t" + "sportsClubLocation:" + sportsClubLocation + "\t"  + "points:" + points;
    }
}


