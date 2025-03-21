package it.giannotti.battleships;

import it.giannotti.exceptions.IllegalCoordinatesException;
import lombok.Data;

/**
 * Coordinates, used to memorize missed attacks
 */
@Data
public class Coordinates {
    private int posx,posy;

    public Coordinates(int posx, int posy) throws IllegalCoordinatesException {
        if(posx < 0 || posy < 0 || posx > 9 || posy > 9) throw new IllegalCoordinatesException("Specified coordinates are out of bounds");
        this.posx = posx;
        this.posy = posy;
    }
}

