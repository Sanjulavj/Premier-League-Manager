package entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatchDateTest {
    MatchDate matchDateTest =new MatchDate();


    @Test(expected = IllegalArgumentException.class)
    public void testMonthCheck(){
       matchDateTest.monthCheck(16);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testDayCheck(){
        matchDateTest.dayCheck(2020,12,35);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testYearCheck(){
        matchDateTest.yearCheck(20202);

    }

    @Test
    public void testMatchDay(){
        MatchDate matchDate =new MatchDate(2020,4,7);
        System.out.println(matchDate);
        String date = "2020/4/7";
        assertEquals(date,matchDate.toString());


    }

}