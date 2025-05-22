package it.giannotti.spring_battleships.battleships;

import java.util.Random;

import it.giannotti.spring_battleships.exceptions.*;
import lombok.Data;

@Data
public class BattleshipsGame {

    private int gameState; // 0 = setup, 1 = in progress, 2 = finished
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
        currentPlayer = 0; // 0 = no player, 1 = player1, 2 = player2 (AI)
        board2.randomizeShips();
    }

    /**
     * @return 0 if missed, 1 if hit, 2 if hit and sunk, 3 if won
     */
    public int aiTurn() throws NotYourTurnException {
        if (currentPlayer == 2) {
            Random r = new Random(System.currentTimeMillis());
            while (true) {
                try {
                    int result = board1.checkHit(new Node(r.nextInt(10), r.nextInt(10)));
                    if (board1.checkLoss()) {
                        endGame();
                        return 3;
                    }
                    currentPlayer = 1;
                    return result;
                } catch (Exception e) {
                }
            }
        }
        throw new NotYourTurnException("It is not your turn");
    }

    /**
     * @return 0 if missed, 1 if hit, 2 if hit and sunk, 3 if won
     */
    public int playerTurn(int posx, int posy) throws AlreadyAttackedException, IllegalCoordinatesException, NotYourTurnException {
        if (currentPlayer == 1) {
            int result = board2.checkHit(new Node(posx, posy));
            if (board2.checkLoss()) {
                endGame();
                return 3;
            }
            currentPlayer = 2;
            return result;
        }
        throw new NotYourTurnException("It is not your turn");
    }

    public void resetGame() {  
        gameState = 0;
        instance = new BattleshipsGame();
    }

    public void endGame() {
        currentPlayer = 0;
        gameState = 2;
        board2.setHidden(false);
    }

    public void startGame() throws Exception {
        if(board1.getPlacedShips() == 9 && currentPlayer == 0) {
            currentPlayer = 1;
            gameState = 1;
        }
        else throw new Exception("Game already in progress, or not enough ships");
    }
}
