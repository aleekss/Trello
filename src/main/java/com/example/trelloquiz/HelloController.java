package com.example.trelloquiz;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    public Button buttonStart;

    @FXML
    public void onButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QuizApplication.class.getResource("questions.fxml"));


        Stage window = (Stage) buttonStart.getScene().getWindow();
        Scene questionsScene = new Scene(fxmlLoader.load(), 650, 366);


        window.setScene(questionsScene);


    }

    public void onButtonEnd(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QuizApplication.class.getResource("end.fxml"));
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene loadingScene = new Scene(fxmlLoader.load(), 650, 366);
        window.setScene(loadingScene);
        window.show();


        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        delay.setOnFinished(event -> window.close());
        delay.play();

    }
}