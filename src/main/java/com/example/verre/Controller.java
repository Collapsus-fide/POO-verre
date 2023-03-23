package com.example.verre;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.WorkerStateEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Rectangle;

import java.time.Duration;
import java.time.Instant;

public class Controller {
    @FXML
    Button bstart;
    @FXML
    Rectangle rect;
    @FXML
    TextArea message;

    Verre verre;
    @FXML
    public void initialize(){
        rect.setHeight(0.0);
    }
    @FXML
    public void demarre(){
    verre = new Verre(25);
    bstart.setDisable(true);
    Instant top = Instant.now();
    ScheduledService<Verre> svc = new Remplir(verre);
    svc.setOnSucceeded((WorkerStateEvent event) ->{
        Verre v = svc.getValue();
        rect.setHeight(verre.getVolume());
        message.appendText("Et glou...\n" + verre.getVolume() +"\n");
        if (v.estPlein()){
            Duration duration = Duration.between(top,Instant.now());
            message.appendText("Temps de remplissage : " + duration.toMillis() + "ms");
            svc.cancel();
            bstart.setDisable(false);
        }
    });
    svc.setPeriod(javafx.util.Duration.seconds(1));
    svc.start();
    }
}
