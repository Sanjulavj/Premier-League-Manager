package entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatchTest {
    Match match = new Match();

    @Test
    public void testUpdateMatch(){
        match.updateTeamStatistics("Team1","Team2",2,2);
    }

    @Test
    public void testMatch(){
        Match match = new Match("Team1","Team2",2,2,"Mathara",new MatchDate(2020,12,12));
        String matchTest = "matchLocation='" + "Mathara" + '\t' + "matchDate=" + "2020/12/12" + '\t' + "team1='" + "Team1" + '\t' + "team2='" + "Team2" + '\t' + "team1Goals=" + 2 + '\t' + "team2Goals=" + 2;
        assertEquals(matchTest,match.toString());

    }

}