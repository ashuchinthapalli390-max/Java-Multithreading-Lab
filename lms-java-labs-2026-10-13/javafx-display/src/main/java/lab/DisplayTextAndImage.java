package lab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DisplayTextAndImage extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent layout = FXMLLoader.load(getClass().getResource("/display.fxml"));
        stage.setTitle("Text and Image Display");
        stage.setScene(new Scene(layout, 600, 400));
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}
