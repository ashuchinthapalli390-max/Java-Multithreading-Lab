package lab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TipCalculator extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent layout = FXMLLoader.load(getClass().getResource("/tip.fxml"));
        stage.setTitle("Tip Calculator");
        stage.setScene(new Scene(layout, 420, 360));
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}
