package com.example.verre;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

public class Remplir extends ScheduledService<Verre> {
private Verre verre;

public Remplir(Verre verre){
    super();
    this.verre = verre;
}
@Override
    protected Task<Verre> createTask(){
    return new Task<Verre>() {
        protected Verre call(){
            verre.glou();
            return verre;
        };
    };
}
}
