package it.giannotti;

import java.time.LocalDate;
import java.util.Random;

public class Registry {
    private Random random = new Random();

    private Sensor[] sensors;
    private int n_sensors;


    
    public Registry(int size) {
        this.sensors = new Sensor[size];
        this.n_sensors = 0;
    }

    public void addSensor(Sensor s) {
        sensors[n_sensors] = s;
        n_sensors++;

    }

    public void generateSensors(int n) {
        double longitude,latitude;

        for(int i=0;i<n;i++) {
            latitude = random.nextDouble(360) - 180;
            longitude = random.nextDouble(180) - 90;
            addSensor(new Sensor(latitude, longitude));
        }
    }

    public void deleteSensor(String ip) {
        for(int i = 0;i<n_sensors;i++) {
            if(sensors[i].getIp().equals(ip)) {
                sensors[i] = null;
                shiftLeft(i);
                n_sensors--;
                break;
            }
        }
    }

    public Sensor findByIp(String ip) {
        for(int i = 0;i<n_sensors;i++) {
            if(sensors[i].getIp().equals(ip)) {
                return sensors[i];
            }
        }
        return null;
    }

    public void printAllSensorsInArea(double lat_min, double lon_min, double lat_max, double lon_max) {
        for(int i = 0;i<n_sensors;i++) {
            if(sensors[i].getLatitude() > lat_min && sensors[i].getLatitude() < lat_max && sensors[i].getLongitude() > lon_min && sensors[i].getLongitude() < lon_max) {
                sensors[i].toString();
            }
        }
    }

    public void printAllSensors() {
        for(int i = 0;i<n_sensors;i++) {
            sensors[i].toString();
        }
    }

    public void purgeSensors() {
        for(int i = 0;i<n_sensors;i++) {
            if(sensors[i].getLast_replacement().compareTo(LocalDate.now()) > 365) {
                deleteSensor(sensors[i].getIp());
            }
        }
    }

    private void shiftLeft(int pos) {
        for(int i = pos;i < n_sensors-1;i++) {
            sensors[i] = sensors[i+1];
        }
    }
}
