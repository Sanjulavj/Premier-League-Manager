package services;

import entities.FootballClub;
import entities.Match;
import entities.MatchDate;
import entities.SportsClub;

import java.io.*;
import java.util.*;


public class PremierLeagueManager implements LeagueManager,Serializable{
    //calling arraylist to store club data
    public static List<SportsClub> listOfFootballClubs = new ArrayList<>();
    //calling arraylist to store match data
    public static List<Match> listOfMatches = new ArrayList<>();
    //assigning the max club slots to 40
    static int maxTeamSlots = 40;


    //method to add football club in the premier league
    public void addFootballClub(SportsClub sportsClub) {
        //calling for array size
        int addedClubCount = listOfFootballClubs.size();
        //checking for similar clubs
        for (SportsClub club : listOfFootballClubs) {
            if (club.equals(sportsClub)) {
                System.out.println("Already added to the Premier League");
                return;
            }
        }
        //checking for club list maximum storage
        if (maxTeamSlots != 0) {
            listOfFootballClubs.add(sportsClub);
            //adding the club count and reducing team slots
            addedClubCount++;
            maxTeamSlots--;
            System.out.println("Football club added successfully");
            System.out.println(addedClubCount+" clubs have added out of 40 slots.");
        } else {
            System.out.println("Premier League table is full");
        }
    }

    //method to delete football club
    @Override
    public void deleteSportsClub(String clubID) {
        boolean clubFound = false;

        //to avoid concurrentmodificationexception used iterator interface
        Iterator<SportsClub> iterator = listOfFootballClubs.iterator();

        while (iterator.hasNext()) {
            SportsClub club = iterator.next();
            //checking for similar club to the id
            if (club.getSportsClubID().equals(clubID)) {
                iterator.remove();
                System.out.println("Club (" + clubID + ") removed successfully");
                maxTeamSlots++;
                clubFound = true;
            }
        }
        //checking invalid userID input
        if (!clubFound) {
            System.out.println("Invalid clubID");
        }

    }


    //method display statistics of a selected club
    @Override
    public void displayStatistics(String clubID) {
        boolean clubFound = false;

        System.out.println("___________________________________________________________________________________");
        System.out.printf("%17s %1s %5s %1s %5s %1s %5s %1s %5s %1s %5s %1s %5s %1s %5s %1s %5s %1s %n","Club" , "|" , "MP" ,
                "|" , "W" , "|" , "D" , "|" , "L" , "|" , "GF" , "|" ,"GA" , "|" , "GD" , "|" , "Pts","|");
        System.out.println("-----------------------------------------------------------------------------------");



        for (SportsClub club : listOfFootballClubs) {
            //calling the similar club
            if (club.getSportsClubID().equals(clubID)) {
                //calling the football club
                if(club instanceof FootballClub) {
                    System.out.printf("%17s %1s %5s %1s %5s %1s %5s %1s %5s %1s %5s %1s %5s %1s %5s %1s %5s %1s %n", club.getSportsClubName(), "|", ((FootballClub) club).getNumMatches(), "|",
                            ((FootballClub) club).getWins(),"|",((FootballClub) club).getDraws(),"|",((FootballClub) club).getDefeats(),"|",((FootballClub) club).getGoalsFor(),"|",((FootballClub) club).getGoalsAgainst(),"|",
                            ((FootballClub) club).goalDifference(),"|",club.pointsCalculation(),"|");
                }
                clubFound = true;
            }
        }
        System.out.println("-----------------------------------------------------------------------------------");
        //checking invalid userID input
        if (!clubFound) {
            System.out.println("Invalid clubID");
        }


    }

    //method to display premier league table
    public void displayPremierLeagueTable() {
        //validating empty club
        if (listOfFootballClubs.isEmpty()) {
            System.out.println("No added clubs in the Premier League Table");
        } else {
            //sorting the club list according to the points
            Collections.sort(listOfFootballClubs, Collections.reverseOrder());

            System.out.println("___________________________________________________________________________________");
            System.out.printf("%17s %1s %5s %1s %5s %1s %5s %1s %5s %1s %5s %1s %5s %1s %5s %1s %5s %1s %n","Club" , "|" , "MP" ,
                    "|" , "W" , "|" , "D" , "|" , "L" , "|" , "GF" , "|" ,"GA" , "|" , "GD" , "|" , "Pts","|");
            System.out.println("-----------------------------------------------------------------------------------");
            for (SportsClub club : listOfFootballClubs) {
                System.out.printf("%17s %1s %5s %1s %5s %1s %5s %1s %5s %1s %5s %1s %5s %1s %5s %1s %5s %1s %n", club.getSportsClubName(), "|", ((FootballClub) club).getNumMatches(), "|",
                        ((FootballClub) club).getWins(),"|",((FootballClub) club).getDraws(),"|",((FootballClub) club).getDefeats(),"|",((FootballClub) club).getGoalsFor(),"|",((FootballClub) club).getGoalsAgainst(),"|",
                        ((FootballClub) club).goalDifference(),"|",club.pointsCalculation(),"|");

            }
            System.out.println("-----------------------------------------------------------------------------------");
        }

    }

    //method to add a match
    @Override
    public void addMatch(Match match) {
        for (Match newMatch : listOfMatches) {
            //calling the similar match
            if (newMatch.equals(match)) {
                System.out.println("Already added this match");
                return;
            }
        }
        //adding the match to the club
        listOfMatches.add(match);
        System.out.println("Match added successfully");
        for (Match matchList : listOfMatches) {
            System.out.println(matchList);
        }
    }

    //method to save team data to a file
    @Override
    public void saveLeagueTeamData(String teamsFileName) throws IOException{
        //calling File outputstream by calling club file name
        FileOutputStream teamsFileOutput = new FileOutputStream(teamsFileName);
        //calling objectoutput stream by calling File outputstream
        ObjectOutputStream teamsObjectOutput = new ObjectOutputStream(teamsFileOutput);

        //looping through club list
        for (SportsClub sportsClub : listOfFootballClubs) {
            //writing club data to the file
            teamsObjectOutput.writeObject(sportsClub);
        }


        teamsObjectOutput.flush();//flushing the club object ouputstream
        teamsFileOutput.close(); //closing the club File ouputsream
        teamsObjectOutput.close(); //closing the club File objectouput stream

    }

    //method to load club data to the array
    @Override
    public void loadLeagueTeamData(String teamsFileName) throws IOException,ClassNotFoundException {
        //try and catch for Io exception
        try {
            //calling File inputstream by calling team file name
            FileInputStream teamsFileInput = new FileInputStream(teamsFileName);
            //calling objectinput stream by calling File inputsream
            ObjectInputStream teamsObjectInput = new ObjectInputStream(teamsFileInput);

            //looping through infinity array
            for (; ; ) {
                try {
                    //reading object from infinity array
                    SportsClub sportsClub = (SportsClub) teamsObjectInput.readObject();
                    listOfFootballClubs.add(sportsClub);

                } catch (EOFException e) {
                    break;

                }

            }
        }catch (IOException e) {
            System.out.println("File will load after quiting the programT");
        }
    }


    //method to save match data to a file
    @Override
    public void saveLeagueMatchData(String matchesFileName) throws IOException{
        //calling File outputstream by calling match file name
        FileOutputStream matchesFileOutput = new FileOutputStream(matchesFileName);
        //calling objectoutput stream by calling File outputstream
        ObjectOutputStream matchesObjectOutput = new ObjectOutputStream(matchesFileOutput);

        //looping through match list
        for (Match match : listOfMatches){
            //writing match data to the file
            matchesObjectOutput.writeObject(match);
        }

        matchesObjectOutput.flush(); //flushing the match objectouputstream
        matchesFileOutput.close(); //closing the match File ouputsream
        matchesObjectOutput.close(); //closing the match File objectouput stream

    }

    //method to load match data to the array
    @Override
    public void loadLeagueMatchData(String matchesFileName) throws IOException,ClassNotFoundException {
        //try and catch for Io exception
        try{
            //calling File inputstream by calling matches file name
            FileInputStream matchesFileInput = new FileInputStream(matchesFileName);
            ObjectInputStream matchesObjectInput = new ObjectInputStream(matchesFileInput);
            //looping through infinity array
            for (; ; ) {
                try {
                    //reading object from array
                    Match match = (Match) matchesObjectInput.readObject();
                    listOfMatches.add(match);

                } catch (EOFException e) {
                    break;

                }

            }
        }catch (IOException e) {
            System.out.println("File will load after quiting the programM");
        }
    }

    //method to create a random match

    public void randomMatchUpdate() {
        Random random = new Random();
        //creating random clubs
        SportsClub randomSportsClub = listOfFootballClubs.get(random.nextInt(listOfFootballClubs.size()));
        int randomIndex1 = listOfFootballClubs.indexOf(randomSportsClub);

        SportsClub randomSportsClub2;
        int randomIndex2;

        //getting two different random teams from the list
        do {
            randomSportsClub2 = listOfFootballClubs.get(random.nextInt(listOfFootballClubs.size()));
            randomIndex2 = listOfFootballClubs.indexOf(randomSportsClub2);
        } while (randomIndex1 == randomIndex2);


        String club1 = randomSportsClub.getSportsClubName();
        String club2 = randomSportsClub2.getSportsClubName();
        String clubLocation1 = randomSportsClub.getSportsClubLocation();
        String clubLocation2 = randomSportsClub2.getSportsClubLocation();
        //creating random locations
        String[] location  = {clubLocation1, clubLocation2};
        String randomLocation= location[random.nextInt(location.length)];



        //getting random dates and goals
        int day =  random.nextInt(31 - 10 + 01) + 10;  //bound to put the range
        int month = random.nextInt(12 - 10 + 01) + 10;
        int year = 2020;
        //random goals
        int team1Goals = random.nextInt(5);
        int team2Goals = random.nextInt(5);




        Match match = new Match(club1, club2, team1Goals, team2Goals, randomLocation, new MatchDate(year, month, day));
        listOfMatches.add(match);
        System.out.println("Match added successfully");


    }


    //method to call the angular project by cmd
    public static void angularGUIOpen(){
        //calling the array
        String URLAngular = "http://localhost:4200/";
        //Try and catch to Io Exception handling
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(URLAngular));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method read club and id to call in console
    public void clubDetails(){
        for (SportsClub club : listOfFootballClubs) {
            System.out.println(club.getSportsClubID()+" = "+club.getSportsClubName());
        }
        System.out.println("Please refer to above IDs to find club ID.");
        System.out.println("");

    }



}


