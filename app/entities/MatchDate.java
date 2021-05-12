package entities;

import java.io.Serializable;
import java.util.Objects;

public class MatchDate implements Serializable {
    private int matchYear;
    private int matchMonth;
    private int matchDay;

    public MatchDate() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatchDate)) return false;
        MatchDate matchDate = (MatchDate) o;
        return matchYear == matchDate.matchYear &&
                matchMonth == matchDate.matchMonth &&
                matchDay == matchDate.matchDay;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchYear, matchMonth, matchDay);
    }

    public MatchDate(int matchYear, int matchMonth, int matchDay) {
        this.matchYear = matchYear;
        this.matchMonth = matchMonth;
        this.matchDay = matchDay;
        monthCheck(matchMonth);
        dayCheck(matchYear,matchMonth,matchDay);
        yearCheck(matchYear);

    }

    public int getMatchYear() {
        return matchYear;
    }

    public void setMatchYear(int matchYear) {
        this.matchYear = matchYear;
    }

    public int getMatchMonth() {
        return matchMonth;
    }

    public void setMatchMonth(int matchMonth) {
        this.matchMonth = matchMonth;
    }

    public int getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(int matchDay) {
        this.matchDay = matchDay;
    }

    //validation for months
    public void monthCheck(int matchMonth) {
        //checking for 12 months
        if(matchMonth>0 && matchMonth <=12){
            this.matchMonth = matchMonth;
        }else {
            throw new IllegalArgumentException("Invalid Month");
        }
    }

    //validation for days
    public void dayCheck(int matchYear,int matchMonth,int matchDay) {
        //validate 30days months
        if (matchMonth == 4 || matchMonth == 6 || matchMonth == 9 || matchMonth == 11) {
            //chceking for 30 days
            if (matchDay > 0 && matchDay <= 30) {
                this.matchDay = matchDay;
            } else {
                //throwing exception handling
                throw new IllegalArgumentException("Invalid day");
            }

            //validate February month
        } else if (matchMonth == 2) {
            //check for leap years
            if (matchYear % 4 == 0) {
                //checking for 29 days
                if (matchDay > 0 && matchDay <= 29) {
                    this.matchDay = matchDay;
                } else {
                    //throwing exception handling
                    throw new IllegalArgumentException("Invalid day");
                }
            } else if (matchYear % 4 != 0) {
                //checking for 28 days
                if (matchDay > 0 && matchDay <= 28) {
                    this.matchDay = matchDay;
                } else {
                    throw new IllegalArgumentException("Invalid day");
                }
            }

            //validate 31days months
        } else if (matchMonth == 1 || matchMonth == 3 || matchMonth == 5 || matchMonth == 7 || matchMonth == 8 || matchMonth == 10 || matchMonth == 12) {
            //checking for 31 days
            if (matchDay > 0 && matchDay <= 31) {
                this.matchDay = matchDay;
            } else {
                //throwing exception handling
                throw new IllegalArgumentException("Invalid day");
            }


        }
    }

    //validation for year
    public void yearCheck(int matchYear){
        int count = 0;
        int lengthOfYear = String.valueOf(matchYear).length();

        //count the characters of the year
        for(int i=1; i <= lengthOfYear; i++ ){
            count++;
        }
        //checking for number of digits of the match
        if(count == 4){
            this.matchYear = matchYear;

        }else{
            //throwing exception handling
            throw new IllegalArgumentException("Invalid year");
        }
    }





    @Override
    public String toString() {
        return matchYear + "/" + matchMonth + "/" + matchDay;


    }
}


