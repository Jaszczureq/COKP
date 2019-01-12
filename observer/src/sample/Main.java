package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent> {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Centrum obsługi kart płatniczych");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

        Account account = new Account("Adam", "NieAdam", 12341234, 1);
        Account_level_golden acc_lvl = new Account_level_golden(account);
        acc_lvl.setInteresr_rate(5);

        System.out.println("IR1: " + account.getInterest_rate());
        System.out.println(acc_lvl.toString());
    }

    @Override
    public void handle(ActionEvent event) {
    }


}
