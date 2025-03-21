package it.giannotti.battleships;

import java.util.ArrayList;
import java.util.List;

import it.giannotti.exceptions.IllegalCoordinatesException;
import lombok.Data;

@Data
public class Ship {

    private List<Node> nodes = new ArrayList<>();
    private boolean sunk = false;

    public Ship(int length, int posx, int posy, boolean horizontal) throws IllegalCoordinatesException {
        for(int i = 0;i < length; i++) {
            if(horizontal){
                nodes.add(new Node(posx+i, posy));
            }
            else {
                nodes.add(new Node(posx, posy+i));
            }
        }
    }

    public int checkSunk() {
        for (Node n : this.getNodes()) {
            if(!n.isHit()) return 1;
        }
        sunk = true;
        return 2;
    }
}
