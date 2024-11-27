package it.giannotti;

import java.time.LocalDate;

public class Dumpster {

    private int id;
    private String type;
    private double latitude, longitude, volume;
    private LocalDate empty_date;
    
    public Dumpster(int id, String type, double latitude, double longitude, double volume, LocalDate last_empty) {
        this.id = id;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.volume = volume;
        this.empty_date = last_empty;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getVolume() {
        return volume;
    }

    public LocalDate getLast_empty() {
        return empty_date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEmpty_date(LocalDate empty_date) {
        this.empty_date = empty_date;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    } 


    
}
