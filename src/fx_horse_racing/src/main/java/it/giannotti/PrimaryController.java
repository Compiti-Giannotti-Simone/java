package it.giannotti;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;

public class PrimaryController {

    @FXML
    private ProgressBar horse1Bar, horse2Bar, horse3Bar, horse4Bar, horse5Bar;

    @FXML
    private Label endLabel;

    @FXML
    private Pane endPane;

    @FXML
    private Button startButton, restartButton;

    private HorseRace race;


    @FXML
    private void initialize() {
        race = new HorseRace(this);
    }

    @FXML
    private void startRace() {
        startButton.setDisable(true);
        horse1Bar.setProgress(0);
        horse2Bar.setProgress(0);
        horse3Bar.setProgress(0);
        horse4Bar.setProgress(0);
        horse5Bar.setProgress(0);
        race.startRace();
    }

    @FXML
    private void restartRace() {
        race.restartRace();
        horse1Bar.setProgress(0);
        horse2Bar.setProgress(0);
        horse3Bar.setProgress(0);
        horse4Bar.setProgress(0);
        horse5Bar.setProgress(0);
        endPane.setVisible(false);
        restartButton.setDisable(true);
        startButton.setDisable(false);
    }

    public void endRace() {
        restartButton.setDisable(false);
        ArrayList<Horse> leaderboard = race.getLeaderboard();
        int pos = 1;
        StringBuilder s = new StringBuilder();
        for (Horse h : leaderboard) {
            s.append(pos).append(". Horse ").append(h.getId()).append("\n");
            pos++;
        }
        endPane.setVisible(true);
        endLabel.setText(s.toString());
    }

    public void updateBars() {
        horse1Bar.setProgress((float) (race.getHorse1().getProgress())/100);
        horse2Bar.setProgress((float) (race.getHorse2().getProgress())/100);
        horse3Bar.setProgress((float) (race.getHorse3().getProgress())/100);
        horse4Bar.setProgress((float) (race.getHorse4().getProgress())/100);
        horse5Bar.setProgress((float) (race.getHorse5().getProgress())/100);
    }
}
