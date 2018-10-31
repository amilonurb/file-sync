package app.tests.javafx;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TesteFXMLMain extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("TesteFXML.fxml"));
        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Aplicação");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
