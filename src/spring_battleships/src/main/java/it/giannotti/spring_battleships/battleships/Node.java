package it.giannotti.spring_battleships.battleships;

import it.giannotti.spring_battleships.exceptions.*;

import lombok.Data;

/**
 * Single node of a ship
 */
@Data
public class Node {
    private Coordinates position;
    private boolean hit = false;

    public Node(int posx, int posy) throws IllegalCoordinatesException {
        this.position = new Coordinates(posx,posy);
    }
}
