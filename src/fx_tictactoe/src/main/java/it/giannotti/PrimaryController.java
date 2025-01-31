package it.giannotti;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

public class PrimaryController {

    @FXML
    private Pane winner_pane;
    @FXML
    private Label user1_label;
    @FXML
    private Label user2_label;
    @FXML
    private Label tie_label;

    @FXML
    private Button b0;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button b5;
    @FXML
    private Button b6;
    @FXML
    private Button b7;
    @FXML
    private Button b8;

    private Button[] buttons = new Button[9];

    private TicTacToe game = TicTacToe.getInstance();

    @FXML
    public void initialize() {
        game.reset();
        buttons[0] = b0;
        buttons[1] = b1;
        buttons[2] = b2;
        buttons[3] = b3;
        buttons[4] = b4;
        buttons[5] = b5;
        buttons[6] = b6;
        buttons[7] = b7;
        buttons[8] = b8;
        updateBoard();
    }

    private void updateBoard() {
        int[][] board = game.getBoard();
        for (int i = 0; i < board.length * board.length; i++) {
            switch (board[i / 3][i % 3]) {
                case 0:
                    buttons[i].setText("");
                    break;
                case 1:
                    buttons[i].setText("O");
                    buttons[i].setTextFill(Paint.valueOf("#ff8282"));
                    break;
                case 2:
                    buttons[i].setText("X");
                    buttons[i].setTextFill(Paint.valueOf("#73b2ff"));
                    break;
            }
        }
    }

    @FXML
    private void resetGame() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setDisable(false);
        }
        winner_pane.setVisible(false);
        tie_label.setVisible(false);
        user1_label.setVisible(false);
        user2_label.setVisible(false);
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
        if (game.checkWin() != 0)
            displayWin(game.checkWin());
    }

    private void displayWin(int winner) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setDisable(true);
            buttons[i].setOpacity(1);
        }
        winner_pane.setVisible(true);
        switch (winner) {
            case -1:
                tie_label.setVisible(true);
                break;
            case 1:
                user1_label.setVisible(true);
                break;
            case 2:
                user2_label.setVisible(true);
                break;
        }
    }

}
