package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

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



//
//        System.out.println("IR1: " + ((Account_level_golden) account).getInterest_rate());
//        System.out.println(account.toString());
//
//        Card_service_center csc = new Card_service_center();
//        csc.bank_list.add(new Bank("x"));
//        try {
//            for (Bank obj : csc.bank_list) {
//                if (obj.bank_name.equals("x")) {
//                    obj.add_account(account);
//                    System.out.println("Dodano konto");
//                    return;
//                }
//            }
//            System.out.println("Brak klienta o podanych danych");
//        } catch (NumberFormatException e) {
//            System.out.println("Wystąpił błąd - podaj odpowiedni numer karty");
//        }
    }


    @Override
    public void handle(ActionEvent event) {
    }


}
