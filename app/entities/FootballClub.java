package entities;


import java.io.Serializable;
import java.util.Objects;

public class FootballClub extends SportsClub implements Serializable, Comparable<FootballClub>{

    private int numMatches;
    private int wins;
    private int draws;
    private int defeats;
    private int goalsFor;
    private int goalsAgainst;


    public FootballClub(String sportsClubID, String sportsClubName, String sportsClubLocation, int numMatches, int wins, int draws, int defeats, int goalsFor, int goalsAgainst) {
        super(sportsClubID, sportsClubName, sportsClubLocation);
        this.numMatches = numMatches;
        this.wins = wins;
        this.draws = draws;
        this.defeats = defeats;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        pointsCalculation();
        matchCheck(numMatches);
    }

    public FootballClub() {
    }

    public int getNumMatches() {
        return numMatches;
    }

    public void setNumMatches(int numMatches) {
        this.numMatches = numMatches;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }


    //method calculate points for a club
    @Override
    public int pointsCalculation() {
        int totalPoints = (wins*3) + (draws*1);
        setPoints(totalPoints);
        return totalPoints;
    }

    //method calculate goal difference
    public int goalDifference(){
        int goalDifference = this.goalsFor - this.goalsAgainst;
        return goalDifference;
    }

    //method to check if new club is already added or not
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        FootballClub that = (FootballClub) object;
        return numMatches == that.numMatches &&
                wins == that.wins &&
                draws == that.draws &&
                defeats == that.defeats &&
                goalsFor == that.goalsFor &&
                goalsAgainst == that.goalsAgainst;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numMatches, wins, draws, defeats, goalsFor, goalsAgainst);
    }


    //method to compare clubs according to points and goals
    @Override
    public int compareTo(FootballClub footballClub) {
        //checking for same point clubs
        if (this.pointsCalculation() == footballClub.pointsCalculation()) {
            return this.goalDifference() - footballClub.goalDifference();
            //else calling for points calculation
        }else{
            return this.pointsCalculation()- footballClub.pointsCalculation();
        }

    }

    //method to check added match count
    public void matchCheck(int numMatches){
        //checking full match total
        if(numMatches == wins + draws + defeats){
            this.numMatches = numMatches;
        }else {
            throw new IllegalArgumentException("Invalid number of matches");
        }
    }

    @Override
    public String toString() {
        return getSportsClubName()+ "\t"+ numMatches+ "\t" + wins + "\t"+ draws + "\t"+ defeats+ "\t" + goalsFor+ "\t" + goalsAgainst+ "\t" +goalDifference()+ "\t" + pointsCalculation();
    }
}


