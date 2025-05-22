package it.giannotti.spring_battleships;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import it.giannotti.spring_battleships.battleships.*;
import it.giannotti.spring_battleships.exceptions.*;

@RestController
public class BattleshipsController {

    BattleshipsGame game = BattleshipsGame.getInstance();

    @PostMapping("/place/{index}/{horizontal}")
    public void placeShip(@PathVariable("index") int index, @PathVariable("horizontal") int horizontal)
            throws AlreadyPlacedException, InvalidShipException, IllegalCoordinatesException {
        boolean isHorizontal = (horizontal == 1) ? true : false;
        game.getBoard1().placeShip(index % 10, index / 10, isHorizontal);
    }

    @PostMapping("/place/random")
    public void randomize() {
        game.getBoard1().randomizeShips();
    }

    @GetMapping("/get-player-board")
    public Board getPlayerBoard() {
        return game.getBoard1();
    }

    @GetMapping("/get-player-hits")
    public List<Node> getPlayerHits() {
        return game.getBoard2().getAttackedList();
    }

    @GetMapping("/get-next-size")
    public int getNextShipSize() {
        return game.getBoard1().getShipLengths()[game.getBoard1().getPlacedShips()];
    }

    @PostMapping("/reset")
    public void reset() {
        game.resetGame();
        game = BattleshipsGame.getInstance();
    }

    @PostMapping("/clear-ships")
    public void clear() {
        game.getBoard1().clear();
    }

    @GetMapping("/p1-attack/{index}")
    public int playerAttack(@PathVariable("index") int index) throws IllegalCoordinatesException, AlreadyAttackedException, NotYourTurnException {
        return game.playerTurn(index % 10, index / 10);
    }

    @GetMapping("/p2-attack")
    public int enemyAttack() throws NotYourTurnException {
        return game.aiTurn();
    }

    @PostMapping("/start-game")
    public void startGame() throws Exception {
        game.startGame();
    }

    @GetMapping("/check-progress")
    public int checkGameProgress() {
        return game.getGameState();
    }
}


