package it.giannotti;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;

public class PrimaryController {

    @FXML
    private ProgressBar horse1Bar, horse2Bar, horse3Bar, horse4Bar, horse5Bar;

    private HorseRace race = new HorseRace(this);


    @FXML
    private void startRace() throws IOException {
        horse1Bar.setProgress(0);
        horse2Bar.setProgress(0);
        horse3Bar.setProgress(0);
        horse4Bar.setProgress(0);
        horse5Bar.setProgress(0);
    }

    public void updateBars() {
        horse1Bar.setProgress((float) (h1.getProgress())/100);
        horse2Bar.setProgress((float) (h2.getProgress())/100);
        horse3Bar.setProgress((float) (h3.getProgress())/100);
        horse4Bar.setProgress((float) (h4.getProgress())/100);
        horse5Bar.setProgress((float) (h5.getProgress())/100);
    }
}
