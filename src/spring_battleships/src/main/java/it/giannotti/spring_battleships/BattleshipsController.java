package it.giannotti.spring_battleships;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.giannotti.spring_battleships.battleships.*;
import it.giannotti.spring_battleships.exceptions.*;

@RestController
public class BattleshipsController {

    BattleshipsGame game = BattleshipsGame.getInstance();

    @GetMapping("/place/{index}/{horizontal}")
    public void placeShip(@PathVariable("index") int index, @PathVariable("horizontal") int horizontal)
            throws AlreadyPlacedException, InvalidShipException, IllegalCoordinatesException {
        boolean isHorizontal = (horizontal == 1) ? true : false;
        game.getBoard1().placeShip(index % 10, index / 10, isHorizontal);
    }

    @GetMapping("/place/random")
    public void randomize() {
        game.getBoard1().randomizeShips();
    }

    @GetMapping("/get-player-grid")
    public List<Ship> getPlayerGrid() {
        return game.getBoard1().getShips();
    }

    @GetMapping("/get-next-size")
    public int getNextShipSize() {
        return game.getBoard1().getShipLengths()[game.getBoard1().getPlacedShips()];
    }

    @GetMapping("/reset")
    public void reset() {
        game.resetGame();
        game = BattleshipsGame.getInstance();
    }

    @GetMapping("/clear-ships")
    public void clear() {
        game.getBoard1().clear();
    }
}
