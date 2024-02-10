package xyz.s4hype.deathcounter.Tools;

public class NumberFormat {
    public static String addOrdinalSuffix(int number) {
        int last2Digits = Math.abs(number % 100);
        int lastDigit = last2Digits % 10;

        if ((last2Digits > 10 && last2Digits < 14) || lastDigit > 3) {
            return number + "th";
        } else if (lastDigit == 1) {
            return number + "st";
        } else if (lastDigit == 2) {
            return number + "nd";
        } else if (lastDigit == 3) {
            return number + "rd";
        } else {
            return number + "th";
        }
    }
}
