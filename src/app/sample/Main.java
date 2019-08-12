package app.sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Dungeons of Zirkonia 2");
        primaryStage.setScene(new Scene(root, 768, 768));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
