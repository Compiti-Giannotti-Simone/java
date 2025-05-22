package it.giannotti.spring_battleships.battleships;

import it.giannotti.spring_battleships.exceptions.*;

import lombok.Data;

import java.util.Objects;

/**
 * Coordinates, used to simplify position comparisons
 */
@Data
public class Coordinates {
    private int posx,posy;

    public Coordinates(int posx, int posy) throws IllegalCoordinatesException {
        if(posx < 0 || posy < 0 || posx > 9 || posy > 9) throw new IllegalCoordinatesException("Specified coordinates are out of bounds");
        this.posx = posx;
        this.posy = posy;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return posx == that.posx && posy == that.posy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posx, posy);
    }
}

