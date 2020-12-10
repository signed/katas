package kata.chronos;

public interface NumberRenderer {
    String renderHoursOfDay(int hour);

    String renderMinutesOfHour(int minutesOfHour);

    String renderSecondsOfMinute(int secondsOfMinute);
}
