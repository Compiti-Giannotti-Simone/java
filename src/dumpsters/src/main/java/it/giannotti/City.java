package it.giannotti;

import java.time.LocalDate;
import java.util.ArrayList;

public class City {

    private ArrayList<Dumpster> dumpsters;

    public City() {
        this.dumpsters = new ArrayList<>();
    }

    public void addDumpster(Dumpster d) {
        dumpsters.add(d);
    }

    public Dumpster getDumpster(int id) {
        for (Dumpster dumpster : dumpsters) {
            if(dumpster.getId() == id) return dumpster;
        }
        return null;
    }

    public void removeDumpster(int id) {
        dumpsters.removeIf(d -> (d.getId() == id));
    }

    public void updateEmptyingDate(int id, LocalDate date) {
        Dumpster d = getDumpster(id);
        int index = dumpsters.indexOf(d);
        d.setEmpty_date(date);
        dumpsters.set(index, d);
    }

    public ArrayList<Dumpster> getDumpstersByType(String type) {
        ArrayList<Dumpster> d_list = new ArrayList<>();
        for (Dumpster dumpster : dumpsters) {
            if(dumpster.getType().equals(type)) d_list.add(dumpster);
        }
        return d_list;
    }

    public ArrayList<Dumpster> getDumpstersInZone(double max_lat, double max_lon, double min_lat, double min_lon) {
        ArrayList<Dumpster> d_list = new ArrayList<>();
        for (Dumpster dumpster : dumpsters) {
            if(dumpster.getLatitude() > min_lat && dumpster.getLatitude() < max_lat && dumpster.getLongitude() > min_lon && dumpster.getLongitude() < max_lon) d_list.add(dumpster);
        }
        return d_list;
    }
}
