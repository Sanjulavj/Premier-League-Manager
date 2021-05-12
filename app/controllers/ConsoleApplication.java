package controllers;


import entities.FootballClub;
import entities.Match;
import entities.MatchDate;
import entities.SportsClub;
import services.LeagueManager;
import services.PremierLeagueManager;

import java.io.EOFException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleApplication {
    //creating objects of the LeagueManager and PremierLeagueManager
    static LeagueManager leagueManager = new PremierLeagueManager();
    static PremierLeagueManager premierLeagueManager = new PremierLeagueManager();


    public static void main(String[] args) throws IOException, ClassNotFoundException, EOFException {
        boolean exit = false;
        //Calling loadData() method to load the data to the application when it starts
        loadData();
        while (!exit) {
            //exiting the main menu
            exit=menu(args);
        }

    }

    //Method to run the main menu of the program
    public static boolean menu(String[] args) throws IOException {
        boolean exit = false; //boolean value to exit the loop

        System.out.println("-----------  MENU  -----------");
        System.out.println("Enter 1 to add a football team");
        System.out.println("Enter 2 to delete a football team");
        System.out.println("Enter 3 to print the statistics for a club");
        System.out.println("Enter 4 to display the Premier League table");
        System.out.println("Enter 5 to add a played match");
        System.out.println("Enter 6 to open the GUI");
        System.out.println("Enter 0 Exit");

        //Try Catch for wrong data inputs
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter: ");
            int userChoice = sc.nextInt();

            switch (userChoice) {
                case 1:
                    //calling ConsoleApplication method to create the club
                    addFootballClubMenu();
                    break;
                case 2:
                    //calling ConsoleApplication method to delete the club
                    deleteFootballClubMenu();
                    break;
                case 3:
                    //calling ConsoleApplication method to display static menu for club
                    displayStatisticsMenu();

                    break;
                case 4:
                    //calling premier league Method to display static menu
                    premierLeagueManager.displayPremierLeagueTable();

                    break;
                case 5:
                    //calling ConsoleApplication method to create the match
                    addMatchMenu();
                    break;
                case 6:
                    //calling premier league method to open the GUI
                    premierLeagueManager.angularGUIOpen();
                    break;
                case 0:
                    //Calling saveData() method to save the data to the application when it stops the program
                    saveData();
                    exit = true;
                    break;
                default:
                    System.out.println("You entered invalid value, please try again");
            }

            return exit;
        }catch (InputMismatchException e){
            System.out.println("Wrong data type,input again");
            return exit;
        }
    }

    //method to call for data loading
    private static void loadData() throws IOException, ClassNotFoundException {
        leagueManager.loadLeagueTeamData("TeamsFile1.txt");
        leagueManager.loadLeagueMatchData("MatchesFile1.txt");
    }

    //method to call for data saving
    private static void saveData() throws IOException {
        leagueManager.saveLeagueTeamData("TeamsFile1.txt");
        leagueManager.saveLeagueMatchData("MatchesFile1.txt");
    }

    //method to call for adding a match
    private static void addMatchMenu() {
        try {
            Scanner sc2 = new Scanner(System.in);
            System.out.print("Match location: ");
            String matchLocation = sc2.next();
            System.out.print("Match day(dd): ");
            int day = sc2.nextInt();
            System.out.print("Match month(mm) : ");
            int month = sc2.nextInt();
            System.out.print("Match year(yyyy) : ");
            int year = sc2.nextInt();
            System.out.print("Team 1: ");
            String team1 = sc2.next();
            System.out.print("Team 2: ");
            String team2 = sc2.next();
            System.out.print("Team 1 goals : ");
            int team1Goals = sc2.nextInt();
            System.out.print("Team 2 goals : ");
            int team2Goals = sc2.nextInt();

            Match match = new Match(team1,team2,team1Goals,team2Goals,matchLocation,new MatchDate(year,month,day));
            leagueManager.addMatch(match);

        }catch (InputMismatchException e){
            System.out.println("Wrong data type,input again");
        }
    }

    //method to call for displaying stats
    private static void displayStatisticsMenu() {
        try {
            premierLeagueManager.clubDetails();
            Scanner sc3 = new Scanner(System.in);
            System.out.print("Enter club's ID : ");
            String sportsClubID = sc3.next();
            leagueManager.displayStatistics(sportsClubID);

        }catch (InputMismatchException e){
            System.out.println("Wrong data type,input again");
        }

    }

    //method to call for deleting a club
    private static void deleteFootballClubMenu() {
        try {
            premierLeagueManager.clubDetails();
            Scanner sc4 = new Scanner(System.in);
            System.out.print("Enter club's ID : ");
            String sportsClubID = sc4.next();
            leagueManager.deleteSportsClub(sportsClubID);

        }catch (InputMismatchException e){
            System.out.println("Wrong data type,input again");
        }
    }

    //method to call for adding a club
    private static void addFootballClubMenu() {
        try {
            Scanner sc5 = new Scanner(System.in);
            System.out.print("Enter club's ID : ");
            String sportsClubID = sc5.next();
            System.out.print("Enter club's name : ");
            String sportsClubName = sc5.next();
            System.out.print("Enter club's location : ");
            String sportsClubLocation = sc5.next();
            System.out.print("Number of matches played: ");
            int numMatches = sc5.nextInt();
            System.out.print("Number of won matches: ");
            int wins = sc5.nextInt();
            System.out.print("Number of drawn matches: ");
            int draws = sc5.nextInt();
            System.out.print("Number of lost matches: ");
            int defeats = sc5.nextInt();
            System.out.print("Number of goals by the team: ");
            int goalsFor = sc5.nextInt();
            System.out.print("Number of goals against the team: ");
            int goalsAgainst = sc5.nextInt();

            SportsClub sportsClub= new FootballClub(sportsClubID,sportsClubName,sportsClubLocation,numMatches,wins,draws,defeats,goalsFor,goalsAgainst);
            premierLeagueManager.addFootballClub(sportsClub);


        }catch (InputMismatchException e){
            System.out.println("Wrong data type,input again");
        }
    }


}





