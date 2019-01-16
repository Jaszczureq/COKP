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
import javafx.scene.input.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

//    public static Stage stage;

    @Override
    public void start(final Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Centrum obsługi kart płatniczych");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER)
                    if (primaryStage.getScene().focusOwnerProperty().get() instanceof Button) {
                        ((Button) primaryStage.getScene().focusOwnerProperty().get()).fire();
                    }
            }
        });

//        Button button = new Button("Mnem");
//
//        JButton bt = new JButton("Mnemonic");
//        bt.setActionCommand("Switch");
//        KeyCodeCombination left = new KeyCodeCombination(KeyCode.LEFT, KeyCodeCombination.ALT_DOWN);
//        KeyCodeCombination right = new KeyCodeCombination(KeyCode.RIGHT, KeyCodeCombination.ALT_DOWN);
//        bt.setMnemonic(java.awt.event.KeyEvent.VK_ALT);
//
//        stage=primaryStage;
//        primaryStage.getScene().addMnemonic(new Mnemonic(((Node)bt), left));
        primaryStage.show();

    }

//    public static void prepButtun(final Button button) {
//        System.out.println("Button preped");
//        stage.getScene().getAccelerators().put(
//                new KeyCodeCombination(KeyCode.RIGHT, KeyCombination.ALT_DOWN),
//                new Runnable() {
//                    @Override
//                    public void run() {
//                        button.fire();
//                    }
//                }
//        );
//    }

    public static void main(String[] args) {

        Bank bank=new Bank();
        Account acc=new Account_level_foreign(new Account_level_golden(new AccountImpl("j", "k", 123), 2.0));

        if(acc instanceof Account_level_golden||((Account_level_foreign) acc).getAccount() instanceof Account_level_golden)
            System.out.println("YES!");
        else
            System.out.println("NO!");
        launch(args);

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


}
