package it.giannotti.spring_battleships.battleships;

import java.util.Random;

import it.giannotti.spring_battleships.exceptions.*;
import lombok.Data;

@Data
public class BattleshipsGame {

    private Board board1, board2;
    private int currentPlayer;
    private static BattleshipsGame instance;

    public static BattleshipsGame getInstance() {
        if (instance == null) {
            instance = new BattleshipsGame();
        }
        return instance;
    }

    private BattleshipsGame() {
        board1 = new Board(false);
        board2 = new Board(true);
        currentPlayer = 1;
        board2.randomizeShips();
    }
    /**
     * 
     * @return 0 if missed, 1 if hit, 2 if hit and sunk, 3 if won
     */
    public int aiTurn() {
        Random r = new Random(System.currentTimeMillis());
        while (true) {
            try {
                int result = board1.checkHit(new Coordinates(r.nextInt(10), r.nextInt(10)));
                if(board1.checkLoss()) {
                    return 3;
                }
                return result;
            } catch (Exception e) {
            }
        }
    }

    /**
     * 
     * @return 0 if missed, 1 if hit, 2 if hit and sunk, 3 if won
     */
    public int playerTurn(int posx, int posy) throws AlreadyAttackedException, IllegalCoordinatesException {
        int result = board2.checkHit(new Coordinates(posx, posy));
        if(board2.checkLoss()) {
            return 3;
        }
        return result;
    }

    public void resetGame() {
        instance = new BattleshipsGame();
    }

    public void endGame() {
        board2.setHidden(false);
    }
}
