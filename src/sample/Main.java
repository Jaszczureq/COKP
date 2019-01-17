package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

//    public static Stage stage;

    @Override
    public void start(final Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Centrum obsługi kart płatniczych");
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER)
                    if (primaryStage.getScene().focusOwnerProperty().get() instanceof Button) {
                        ((Button) primaryStage.getScene().focusOwnerProperty().get()).fire();
                    }
            }
        });
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

        System.exit(0);
    }
}
