package it.giannotti;

import java.time.LocalDate;
import java.util.Random;

public class Sensor {
    private Random random = new Random();

    private String ip;
    private double latitude, longitude;
    private LocalDate last_replacement, next_replacement;

    public Sensor(double latitude, double longitude) {
        this.ip = generateIp();
        this.latitude = latitude;
        this.longitude = longitude;
        this.last_replacement = generateDate(random.nextInt(2) + 2023); //data randomica tra 2023 e fine 2024
        this.next_replacement = generateDate(2025);
    }

    private String generateIp() {
        return "" + random.nextInt(256) + "." + random.nextInt(256) + "." + random.nextInt(256) + "." + random.nextInt(256);
    }
    
    private LocalDate generateDate(int year) {
        return LocalDate.ofYearDay(year, random.nextInt(366));
    }

    public String getIp() {
        return ip;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public LocalDate getLast_replacement() {
        return last_replacement;
    }

    public LocalDate getNext_replacement() {
        return next_replacement;
    }
    
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLast_replacement(LocalDate last_replacement) {
        this.last_replacement = last_replacement;
    }

    public void setNext_replacement(LocalDate next_replacement) {
        this.next_replacement = next_replacement;
    }

    @Override
    public String toString() {
        return "Sensor [ip=" + ip + ", latitude=" + latitude + ", longitude=" + longitude + ", last_replacement="
                + last_replacement + ", next_replacement=" + next_replacement + "]";
    }

    

}
