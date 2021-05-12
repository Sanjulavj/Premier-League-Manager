package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.PremierLeagueManager;

import java.io.IOException;
import java.util.Collections;


public class PremierLeagueController extends Controller {
    //creating objects of the PremierLeagueManager
    PremierLeagueManager premierLeagueManager = new PremierLeagueManager();


    //calling the method to push club list to the front end
    public Result listClubs() throws IOException, ClassNotFoundException {
        premierLeagueManager.listOfFootballClubs.clear();
        //calling load data method to load data to the array
        premierLeagueManager.loadLeagueTeamData("TeamsFile1.txt");
        Collections.sort(premierLeagueManager.listOfFootballClubs, Collections.reverseOrder());

        //creating jason to push the list of clubs to font end
        JsonNode jsonNode = Json.toJson(ConsoleApplication.premierLeagueManager.listOfFootballClubs);
        return ok(jsonNode).as("application/json");

    }

    //calling the method to push match list to the front end
    public Result listMatches() throws IOException, ClassNotFoundException {
        premierLeagueManager.listOfMatches.clear();
        //calling load data method to load data to the array
        premierLeagueManager.loadLeagueMatchData("MatchesFile1.txt");

        //creating jason to push the list of matches to font end
        JsonNode jsonNode = Json.toJson( ConsoleApplication.premierLeagueManager.listOfMatches);
        return ok(jsonNode).as("application/json");
    }

    //calling the method to push random match to the front end
    public Result randomMatch() throws IOException, ClassNotFoundException {
        premierLeagueManager.listOfMatches.clear();
        //calling load data method to load data to the array
        premierLeagueManager.loadLeagueMatchData("MatchesFile1.txt");

        //calling method to create the random match
        premierLeagueManager.randomMatchUpdate();
        //calling save data method to save data to the array
        premierLeagueManager.saveLeagueMatchData("MatchesFile1.txt");
        premierLeagueManager.saveLeagueTeamData("TeamsFile1.txt");

        //creating jason to push the list of matches to font end
        JsonNode jsonNode = Json.toJson( premierLeagueManager.listOfMatches);
        return ok(jsonNode).as("application/json");
    }






}
