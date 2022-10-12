package com.example.javafx;

import com.exemple.TimerPresenter;
import com.exemple.timer.Timer;
import com.exemple.timer.TimerFactory;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController  implements TimerPresenter {
    @FXML
    private Label welcomeText;

    private final Timer timer;

    public HelloController(){
        timer  = new TimerFactory().create();
        timer.addObserver(this);
    }

    @FXML
    protected void onHelloButtonClick() {
        timer.launch();
    }

    @FXML
    protected void onStop(){
        timer.stop();
    }

    @Override
    public void showTime(String time) {

        welcomeText.setText(time);
    }

    @Override
    public void update(Object o) {
        Platform.runLater(() -> showTime((String) o));


    }
}
