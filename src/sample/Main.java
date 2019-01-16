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
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.Mnemonic;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application implements EventHandler<ActionEvent>, ActionListener {

    @Override
    public void start(final Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Centrum obsługi kart płatniczych");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode()== KeyCode.ENTER)
                    if (primaryStage.getScene().focusOwnerProperty().get() instanceof Button) {
                        ((Button) primaryStage.getScene().focusOwnerProperty().get()).fire();
                    }
            }
        });

        Button button=new Button("Mnem");

        JButton bt=new JButton("Mnemonic");
        bt.setActionCommand("Switch");
        KeyCodeCombination left=new KeyCodeCombination(KeyCode.LEFT, KeyCodeCombination.ALT_DOWN);
        KeyCodeCombination right=new KeyCodeCombination(KeyCode.RIGHT, KeyCodeCombination.ALT_DOWN);
        bt.setMnemonic(java.awt.event.KeyEvent.VK_ALT);

//        primaryStage.getScene().addMnemonic(new Mnemonic(((Node)bt), left));
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


    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {

    }
}
