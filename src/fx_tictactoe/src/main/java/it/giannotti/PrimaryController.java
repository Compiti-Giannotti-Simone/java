package it.giannotti;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

public class PrimaryController {

    @FXML
    private AnchorPane main_pane;

    @FXML
    private Pane winner_pane;
    @FXML
    private Label tie_label;

    private TicTacToe game = TicTacToe.getInstance();

    @FXML
    public void initialize() {
        game.reset();
        updateBoard();
    }

    private void updateBoard() {
        int[][] board = game.getBoard();
        for (int i = 0; i < board.length * board.length; i++) {
            Button b = (Button) main_pane.lookup("#b" + i);
            switch (board[i / 3][i % 3]) {
                case 0:
                    b.setText("");
                    break;
                case 1:
                    b.setText("O");
                    b.setTextFill(Paint.valueOf("#ff8282"));
                    break;
                case 2:
                    b.setText("X");
                    b.setTextFill(Paint.valueOf("#73b2ff"));
                    break;
            }
        }
    }

    @FXML
    private void resetGame() {
        for (int i = 0; i < 9; i++) {
            main_pane.lookup("#b" + i).setDisable(false);
        }
        for (int i = 0; i < 8; i++) {
            main_pane.lookup("#win" + i).setVisible(false);
        }
        winner_pane.setVisible(false);
        tie_label.setVisible(false);
        game.reset();
        updateBoard();
    }

    @FXML
    private void pressButton(ActionEvent e) {
        Button pressed = (Button) e.getSource();
        pressed.setDisable(true);
        pressed.setOpacity(1);
        game.playerAction(Integer.parseInt(pressed.getId().substring(1, 2)));
        updateBoard();
        if (game.checkWin() != null)
            displayWin(game.checkWin());
    }

    private void displayWin(Winner w) {
        Line winner_line = (Line) main_pane.lookup("#win" + w.getPosition());
        for (int i = 0; i < 9; i++) {
            main_pane.lookup("#b" + i).setDisable(true);
            main_pane.lookup("#b" + i).setOpacity(1);
        }
        switch (w.getPlayer()) {
            case -1:
                winner_pane.setVisible(true);
                tie_label.setVisible(true);
                break;
            case 1:
                winner_line.setVisible(true);
                winner_line.setStroke(Paint.valueOf("#ff8282"));
                break;
            case 2:
                winner_line.setVisible(true);
                winner_line.setStroke(Paint.valueOf("#73b2ff"));
                break;
        }
    }

}
