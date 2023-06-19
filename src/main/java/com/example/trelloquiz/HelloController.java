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
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    public Button buttonStart;




    public static void main(String[] args) {
        File file = new File("quiz.json");
        String content;

        try {

            content = new String(Files.readAllBytes(Paths.get(file.toURI())));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = new JSONObject(content);

        for (int i = 0; i < jsonObject.length(); i++) {
            JSONObject jsonObject1 = jsonObject.getJSONObject("quiz");

            for (int y = 0; y < jsonObject1.length(); y++) {
                JSONArray jsonArray = jsonObject1.getJSONArray("questions");
                for (int z = 0; z < jsonArray.length(); z++) {
                    JSONObject jsonObject2 = jsonArray.getJSONObject(z);
                    System.out.println(jsonObject2.get("question"));
                    System.out.println(jsonObject2.getJSONArray("answers"));



                }
            }


        }
    }

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