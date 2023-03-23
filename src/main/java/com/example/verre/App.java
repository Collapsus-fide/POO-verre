package com.example.verre;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class App extends Application {
    private static Scene scene;

    private static Parent loadFXML (String fxml) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml+".fxml"));
        return fxmlLoader.load();
    }
    @Override
    public void start (Stage stage) throws IOException {
        scene =new Scene(loadFXML("gui"),640,480);
        stage.setScene(scene);
        stage.show();
    }
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static void main(String[] args){
        launch();
    }
}
