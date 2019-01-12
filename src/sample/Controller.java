package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class Controller {

    @FXML
    private TextField card_owner_name_fieldtext;
    @FXML
    private TextField card_owner_surname_fieldtext;
    @FXML
    private TextField card_number_fieldtext;
    @FXML
    private TextField card_bank_assigned_fieldtext;
    @FXML
    private CheckBox is_debit;
    @FXML
    private CheckBox is_credit;

    @FXML
    private TextField bank_name;

    @FXML
    private TextField client_name;
    @FXML
    private TextField client_surname;
    @FXML
    private TextField client_assigned_to_bank;

    @FXML
    private TextField account_owner_name;
    @FXML
    private TextField account_owner_surname;
    @FXML
    private TextField account_number;
    @FXML
    private TextField account_assigned_to_bank;
    @FXML
    private CheckBox golden;
    @FXML
    private CheckBox foreign;

    @FXML
    private TextField Firm_name;

    @FXML
    private TextField query_card_number;
    @FXML
    private TextField query_firm_name;
    @FXML
    private TextField query_currency;
    @FXML
    private TextField query_amount;

    @FXML
    private TextField archive_save_file;
    @FXML
    private TextField archive_open_file;

    ObservableList<String> archive_choice_status_list = FXCollections.observableArrayList("OR", "AND");
    @FXML
    private TextField searching_type;
    @FXML
    private TextField search_phrase;
    private String search_cpy;
    @FXML
//    private ComboBox box;

    Card_service_center card_service_center = new Card_service_center();
    public Controller() {
//        System.out.println("Created controller");
//        final ObservableList<Bank> bank_obs = FXCollections.observableArrayList(card_service_center.bank_list);
//        System.out.println("Created bank_obs");
////        box.setItems(FXCollections.observableArrayList(card_service_center.bank_list));
//        ArrayList<String> list = new ArrayList<String>();
//        list.add("Test1");
////        box.setItems(FXCollections.observableArrayList(list));
//        list.add("Test2");
//        System.out.println("ItemList has been set");
//        final ObservableList<String> bank_obs2 = FXCollections.observableArrayList("s", "t", "x");
//        ObservableList<String> options =
//                FXCollections.observableArrayList(
//                        "Option 1",
//                        "Option 2",
//                        "Option 3"
//                );
//        box=new ComboBox(options);
//        box.setItems(options);
    }

    @FXML
    public void add_card_prompt() {
        if (!is_credit.isSelected() && !is_debit.isSelected()) {
            System.out.println("Nie zaznaczono typu karty");
            return;
        }
        if (is_credit.isSelected() && is_debit.isSelected()) {
            System.out.println("Zaznacz odpowiednio typ karty");
            return;
        }


        for (Bank obj : card_service_center.bank_list) {
            if (obj.bank_name.equals(card_bank_assigned_fieldtext.getText())) {
                for (Account acc : obj.list_of_acc_in_bank) {
                    if (acc.getOwner_name().equals(card_owner_name_fieldtext.getText()) && acc.getOwner_surname().equals(card_owner_surname_fieldtext.getText())) {
                        if (is_credit.isSelected() && !is_debit.isSelected()) {
                            Credit new_card = new Credit(Long.parseLong(card_number_fieldtext.getText()), card_owner_name_fieldtext.getText(),
                                    card_owner_surname_fieldtext.getText(), card_bank_assigned_fieldtext.getText());
                            acc.add_card(new_card);
                            System.out.println("Dodano kartę");
                            return;
                        }
                        if (is_debit.isSelected() && !is_credit.isSelected()) {
                            Debit new_card = new Debit(Long.parseLong(card_number_fieldtext.getText()), card_owner_name_fieldtext.getText(),
                                    card_owner_surname_fieldtext.getText(), card_bank_assigned_fieldtext.getText());
                            acc.add_card(new_card);
                            System.out.println("Dodano kartę");
                            return;
                        }
                    }
                }
            }
        }

        System.out.println("Brak konta o podanych danych");
    }


    @FXML
    public void add_bank_prompt() {
        if (bank_name.getText().isEmpty()) {
            System.out.println("Uzupełnij wszystkie pola!");
            return;
        }
        Bank bank = new Bank(bank_name.getText());
        card_service_center.add_bank(bank);
        System.out.println("Dodano bank");
    }

    @FXML
    public void delete_bank_prompt() {
        if (card_service_center.getBank_list().isEmpty()) {
            System.out.println("Brak banków w bazie");
            return;
        }
        try {

            card_service_center.delete_bank(bank_name.getText());

        } catch (NullPointerException e) {
            System.out.println("Brak podanego banku w bazie");
        }

    }

    @FXML
    public void get_list_of_bank() {
        if (card_service_center.getBank_list().isEmpty()) {
            System.out.println("Brak banków w bazie");
            return;
        }
        System.out.println(card_service_center.bank_list);
    }

    @FXML
    public void add_client() {
        if (client_assigned_to_bank.getText().isEmpty() || client_name.getText().isEmpty() || client_surname.getText().isEmpty()) {
            System.out.println("Uzupełnij wszystkie pola!");
            return;
        }
        Client client = new AddingClients().making_clients(ClientType.ADULT);
//        Client client=new Clie

        for (Bank obj : card_service_center.bank_list) {
            if (obj.bank_name.equals(client_assigned_to_bank.getText())) {
                obj.add_client(client);
                System.out.println("Dodano klienta");
                return;
            }
        }
        System.out.println("Brak banku o podanej nazwie");
    }

    @FXML
    public void add_account() {
        if (account_assigned_to_bank.getText().isEmpty() || account_number.getText().isEmpty() || account_owner_name.getText().isEmpty() || account_owner_surname.getText().isEmpty()) {
            System.out.println("Uzupełnij wszystkie pola!");
            return;
        }
        try {
            Long.parseLong(account_number.getText());

            Account account =new AccountImpl(account_owner_name.getText(), account_owner_surname.getText(), Integer.parseInt(account_number.getText()), 1);
            if(golden.isSelected())
                account=new Account_level_golden(account,2.5);
            if(foreign.isSelected())
                account=new Account_level_foreign(account,"gbp");
            for (Bank obj : card_service_center.bank_list) {
                if (obj.bank_name.equals(account_assigned_to_bank.getText())) {
                    obj.add_account(account);
                    System.out.println("Dodano konto");
                    return;
                }
            }
            System.out.println("Brak klienta o podanych danych");
        } catch (NumberFormatException e) {
            System.out.println("Wystąpił błąd - podaj odpowiedni numer karty");
        }
    }

    @FXML
    public void add_firm() {
        if (Firm_name.getText().isEmpty()) {
            System.out.println("Uzupełnij wszystkie pola!");
            return;
        }
        Firm firm = new Firm(Firm_name.getText());
        card_service_center.add_firm(firm);
        System.out.println("Dodano firmę pomyślnie");
    }

    @FXML
    public void delete_firm() {
        if (Firm_name.getText().isEmpty()) {
            System.out.println("Uzupełnij wszystkie pola!");
            return;
        }
        for (Iterator<Firm> iterator = card_service_center.firm_list.iterator(); iterator.hasNext(); ) {
            Firm firm_clone = iterator.next();
            if (firm_clone.getName_of_firm().equals(Firm_name.getText())) {
                iterator.remove();
                System.out.println("Usunięto firmę pomyślnie");
                return;
            }
        }
        System.out.println("Brak firmy w bazie");
    }

    @FXML
    public void add_query() {
        if (query_card_number.getText().isEmpty() || query_amount.getText().isEmpty() || query_currency.getText().isEmpty() || query_firm_name.getText().isEmpty()) {
            System.out.println("Niepoprawnie uzupełniono pola");
            return;
        }
        try {

            Long.parseLong(query_card_number.getText());
            Float.parseFloat(query_amount.getText());
            long card_number_meth = Long.parseLong(query_card_number.getText());
            float query_amount_meth = Float.parseFloat(query_amount.getText());

            for (Firm firm_clone : card_service_center.firm_list) {
                if (!firm_clone.getName_of_firm().equals(Firm_name.getText())) {
                    System.out.println("Brak firmy w bazie");
                    return;
                }
            }


            for (Bank bank : card_service_center.bank_list) {
                for (Account account : bank.list_of_acc_in_bank) {
                    for (Card card : account.getCard_assigned_to_account()) {
                        if (card.getCard_number() == card_number_meth) {
                            boolean decision = Math.random() < 0.8;
                            if (decision) {
                                Query query = new Query(card, query_currency.getText(), query_firm_name.getText(), query_amount_meth);
                                card_service_center.add_query(query);
                                System.out.println("Transakcja zaakceptowana");
                            } else {
                                System.out.println("Transakcja odrzucona");
                            }
                            return;
                        }
                    }
                }
            }
            System.out.println("Transakcja odrzucona");


        } catch (NumberFormatException e) {
            System.out.println("Wystąpił błąd - podaj odpowiedni numer karty, bądź odpowiednią kwotę");
        }


    }

    @FXML
    public void get_queries() {
        try {
            if (card_service_center.query_list.isEmpty()) {
                throw new NullPointerException();
            }
            System.out.println(card_service_center.getQuery_list());
        } catch (NullPointerException e) {
            System.out.println("Lista zapytań jest pusta - kod błędu: " + e);
        }
    }

    @FXML
    public void save_to_file() throws IOException {
        try {

            File file = new File(archive_save_file.getText());
            FileOutputStream fop = new FileOutputStream(file);
            String output = card_service_center.toString();

            if (!file.exists()) {
                file.createNewFile();
            }

            byte[] contentInBytes = output.getBytes();
            fop.write(contentInBytes);
            fop.flush();
            fop.close();

            System.out.println("Operacja zapisu zakończona");
        } catch (IOException e) {
            System.out.println("Nie podano nazwy pliku do zapisu - kod błędu: " + e);
        }
    }

    @FXML
    public void archive_read_from_file() throws IOException {
        try {
            for (String s : new FileLineIterable(archive_open_file.getText()))
                System.out.println(s);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

//    @FXML
//    public void archive_read_from_file(String[] args) throws IOException {
//        try
//        {
//            for( String s : new FileLineIterable( args[0] ) )
//                System.out.println( s );
//        }
//        catch( Exception ex )
//        {
//            ex.printStackTrace();
//        }
//    }

    @FXML
    public void search() {
        try {
            if (search_phrase.getText().isEmpty() || search_cpy.isEmpty()) {
                throw new Exception();
            }

            String final_string = search_cpy.replaceAll(search_phrase.getText(), " [MATCH]" + search_phrase.getText() + "[MATCH] ");
            System.out.println(final_string);
        } catch (Exception e) {
            System.out.println("Pole 'Szukana fraza' jest puste, bądź nie wczytano archiwum - kod błędu:" + e);
        }
    }


}














