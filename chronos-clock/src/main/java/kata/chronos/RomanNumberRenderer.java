package kata.chronos;

public class RomanNumberRenderer implements NumberRenderer {

    @Override
    public String renderHoursOfDay(int hour) {
        return new RomanNumeral(hour).toString();
    }

    @Override
    public String renderMinutesOfHour(int minutesOfHour) {
        return new RomanNumeral(minutesOfHour).toString();
    }

    @Override
    public String renderSecondsOfMinute(int secondsOfMinute) {
        return new RomanNumeral(secondsOfMinute).toString();
    }
}
