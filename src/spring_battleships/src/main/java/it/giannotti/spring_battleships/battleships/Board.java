package it.giannotti.spring_battleships.battleships;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.giannotti.spring_battleships.exceptions.*;

import lombok.Data;

@Data
public class Board {

    private final Integer[] shipLengths = new Integer[] { 4, 3, 3, 3, 2, 2, 2, 1, 1, 0};

    private List<Node> attackedList = new ArrayList<>();
    private List<Ship> ships = new ArrayList<>();
    private int placedShips = 0;
    private boolean hidden;

    public Board(boolean hidden) {
        this.hidden = hidden;
    }

    public void clear() {
        placedShips = 0;
        ships.clear();
    }

    public void randomizeShips() {
        clear();
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < 9; i++) {
            boolean placed = false;
            while (!placed) {
                try {
                    placeShip(r.nextInt(10), r.nextInt(10), r.nextBoolean());
                    placed = true;
                } catch (Exception e) {
                }
            }
        }
    }

    /**
     * 
     * @param posx       - starting position on x-axis
     * @param posy       - starting position on y-axis
     * @param horizontal - boolean do decide whether to place the ship horizontally
     *                   or not
     * @throws AlreadyPlacedException
     * @throws InvalidShipException
     * @throws IllegalCoordinatesException
     */
    public void placeShip(int posx, int posy, boolean horizontal)
            throws AlreadyPlacedException, InvalidShipException, IllegalCoordinatesException {
        if (placedShips == 9)
            return;
        if ((posx + shipLengths[placedShips] - 1 > 9 && horizontal)
                || (posy + shipLengths[placedShips] - 1 > 9 && !horizontal))
            throw new InvalidShipException("Ship is out of bounds");
        for (Ship s : ships) {
            for (Node n : s.getNodes()) {
                for (int i = 0; i < shipLengths[placedShips]; i++) {
                    if (horizontal) {
                        if (n.getPosition().getPosx() == posx + i && n.getPosition().getPosy() == posy)
                            throw new InvalidShipException("Ship collides with another ship");
                    } else {
                        if (n.getPosition().getPosx() == posx && n.getPosition().getPosy() == posy + i)
                            throw new InvalidShipException("Ship collides with another ship");
                    }
                }
            }
        }
        ships.add(new Ship(shipLengths[placedShips], posx, posy, horizontal));
        placedShips++;
    }

    /**
     * 
     * @param pos
     * @return 0 if missed, 1 if hit, 2 if sunk
     * @throws AlreadyAttackedException if attacked position is already in attack
     *                                  list
     */
    public int checkHit(Node pos) throws AlreadyAttackedException {
        int result = 0;
        for (Node n : attackedList) {
            if(n.getPosition().equals(pos.getPosition())) {
                throw new AlreadyAttackedException("The coordinates have already been attacked");
            }
        }
        for (Ship ship : ships) {
            for (Node n : ship.getNodes()) {
                if (n.getPosition().equals(pos.getPosition())) {
                    n.setHit(true);
                    pos.setHit(true);
                    result = ship.checkSunk();
                }
            }
        }
        attackedList.add(pos);
        return result;
    }

    public boolean checkLoss() {
        for (Ship s : ships) {
            if (!s.isSunk())
                return false;
        }
        return true;
    }

}
