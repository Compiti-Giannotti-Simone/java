package it.giannotti;

import it.giannotti.battleships.BattleshipsGame;
import it.giannotti.battleships.Coordinates;
import it.giannotti.battleships.Node;
import it.giannotti.battleships.Ship;
import it.giannotti.enums.Direction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class PrimaryController {

    private final String[] colors = new String[] { "AQUA", "RED", "YELLOW", "GREEN", "BLACK",
            "PURPLE", "SADDLEBROWN", "SALMON", "BLUE" };

    private BattleshipsGame game = BattleshipsGame.getInstance();

    @FXML
    private GridPane playerBoard, enemyBoard;

    @FXML
    private ChoiceBox<Direction> directionChoice;

    @FXML
    private VBox setupBox, gameBox, endBox;

    @FXML
    private Button startButton;

    @FXML
    private Label playerResult, enemyResult, gameResult, setupError, attackError;

    private Label nextShip;

    @FXML
    public void initialize() {
        nextShip = (Label) setupBox.getChildren().get(2);
        directionChoice.getItems().add(Direction.HORIZONTAL);
        directionChoice.getItems().add(Direction.VERTICAL);
        directionChoice.setValue(Direction.HORIZONTAL);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Button pButton = new Button();
                pButton.setMinHeight(50);
                pButton.setMinWidth(50);
                pButton.setId(i + "" + j);
                pButton.setStyle("-fx-background-color: white");
                pButton.setFont(Font.font(22));
                pButton.setOnAction((e) -> placeShip(e));
                playerBoard.add(pButton, i, j);

                Button eButton = new Button();
                eButton.setMinHeight(50);
                eButton.setMinWidth(50);
                eButton.setId(i + "" + j);
                eButton.setFont(Font.font(22));
                eButton.setDisable(true);
                eButton.setOpacity(1);
                eButton.setStyle("-fx-background-color: white");
                eButton.setOnAction((e) -> attack(e));
                enemyBoard.add(eButton, i, j);
            }
        }
    }

    @FXML
    public void resetBoard() {
        setupError.setText("");
        startButton.setDisable(true);
        game.getBoard1().clear();
        nextShip.setText("Size of next ship: 4");
        updateBoard();
    }

    @FXML
    public void startGame() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                playerBoard.lookup("#" + i + "" + j).setDisable(true);
                playerBoard.lookup("#" + i + "" + j).setOpacity(1);
                enemyBoard.lookup("#" + i + "" + j).setDisable(false);
            }
        }
        setupBox.setVisible(false);
        gameBox.setVisible(true);

    }

    @FXML
    public void randomizeShips() {
        resetBoard();
        game.getBoard1().randomizeShips();
        nextShip.setText("You placed all the ships");
        startButton.setDisable(false);
        updateBoard();
    }

    public void updateBoard() {

        int color_index = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Button b = (Button) playerBoard.lookup("#" + i + "" + j);
                b.setStyle("-fx-background-color:WHITE");
                b.setText("");
            }
        }

        for (Coordinates c : game.getBoard1().getAttackedList()) {
            Button b = (Button) playerBoard
                    .lookup("#" + c.getPosx() + "" + c.getPosy());
            b.setText("~");
        }

        for (Ship s : game.getBoard1().getShips()) {
            String color = colors[color_index++];
            for (Node n : s.getNodes()) {
                Button b = (Button) playerBoard
                        .lookup("#" + n.getPosition().getPosx() + "" + n.getPosition().getPosy());
                b.setStyle("-fx-background-color:" + color);
                if (n.isHit())
                    b.setText("X");
            }
        }

    }

    public void updateEnemyBoard() {
        int color_index = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Button b = (Button) enemyBoard.lookup("#" + i + "" + j);
                b.setStyle("-fx-background-color:WHITE");
                b.setText("");
            }
        }

        for (Coordinates c : game.getBoard2().getAttackedList()) {
            Button b = (Button) enemyBoard
                    .lookup("#" + c.getPosx() + "" + c.getPosy());
            b.setText("~");
        }
        for (Ship s : game.getBoard2().getShips()) {
            String color = colors[color_index++];
            for (Node n : s.getNodes()) {
                Button b = (Button) enemyBoard.lookup("#" + n.getPosition().getPosx() + "" + n.getPosition().getPosy());
                if (s.isSunk())
                    b.setStyle("-fx-background-color:" + color);
                if (n.isHit())
                    b.setText("X");
            }
        }
    }

    public void attack(ActionEvent event) {
        Button clicked = (Button) event.getSource();
        int posx = Integer.parseInt(clicked.getId().substring(0, 1));
        int posy = Integer.parseInt(clicked.getId().substring(1, 2));
        int playerTurn;
        int enemyTurn;
        try {
            attackError.setText("");
            playerTurn = game.playerTurn(posx, posy);
        } catch (Exception e) {
            attackError.setText(e.getMessage());
            return;
        }
        enemyTurn = game.aiTurn();
        updateBoard();
        updateEnemyBoard();
        switch (playerTurn) {
            case 0:
                playerResult.setText("Missed");
                break;
            case 1:
                playerResult.setText("Hit");
                break;
            case 2:
                playerResult.setText("Hit and sunk");
                break;
            case 3:
                endGame(true);
                return;
        }
        switch (enemyTurn) {
            case 0:
                enemyResult.setText("Missed");
                break;
            case 1:
                enemyResult.setText("Hit");
                break;
            case 2:
                enemyResult.setText("Hit and sunk");
                break;
            case 3:
                endGame(false);
                return;
        }
    }

    @FXML
    public void playAgain() {
        endBox.setVisible(false);
        setupBox.setVisible(true);
        game.resetGame();
        resetBoard();
        playerResult.setText("");
        enemyResult.setText("");
        game = BattleshipsGame.getInstance();
        updateBoard();
        updateEnemyBoard();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                playerBoard.lookup("#" + i + "" + j).setDisable(true);
            }
        }
    }

    public void endGame(boolean won) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                playerBoard.lookup("#" + i + "" + j).setDisable(true);
                playerBoard.lookup("#" + i + "" + j).setOpacity(1);
                enemyBoard.lookup("#" + i + "" + j).setDisable(true);
                enemyBoard.lookup("#" + i + "" + j).setOpacity(1);
            }
        }
        gameBox.setVisible(false);
        endBox.setVisible(true);
        if (won) {
            gameResult.setText("You win!");
        } else {
            gameResult.setText("You lose");
        }
    }

    public void placeShip(ActionEvent event) {
        Button clicked = (Button) event.getSource();
        int posx = Integer.parseInt(clicked.getId().substring(0, 1));
        int posy = Integer.parseInt(clicked.getId().substring(1, 2));
        try {
            setupError.setText("");
            game.getBoard1().placeShip(posx, posy, directionChoice.getValue().IS_HORIZONTAL);
        } catch (Exception e) {
            setupError.setText(e.getMessage());
        }
        nextShip.setText("Size of next ship: " + game.getBoard1().getShipLengths()[game.getBoard1().getPlacedShips()]);
        if (game.getBoard1().getPlacedShips() == 9) {
            nextShip.setText("You placed all the ships");
            startButton.setDisable(false);
        }
        updateBoard();
    }

}
