package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable, ActionListener {

    int time=15;

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Switch")) {
            selectTab();
        }
    }

    @FXML
    public void selectTab() {
        selectionModel.getSelectedIndex();

        selectionModel.selectNext();
    }

    //region controls
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
    TextField bank_capital;

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
    private TextField account_interest_rate;
    @FXML
    private TextField credit_amount;
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
    @FXML
    private TextField obs_bank_name;

    @FXML
    private TabPane tabPane;
    //endregion

    private SingleSelectionModel<Tab> selectionModel;

    private Card_service_center card_service_center = new Card_service_center();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prepareStuff();
        selectionModel = tabPane.getSelectionModel();

//        Main.prepButtun(switchTabs);
//        Main.stage.getScene().getAccelerators().put(
//                new KeyCodeCombination(KeyCode.LEFT, KeyCombination.ALT_DOWN),
//                new Runnable() {
//                    @Override public void run() {
//                        switchTabs.fire();
//                    }
//                }
//        );

    }

    private void prepareStuff() {
        String bank_name = "TestBank", name = "Imie", surname = "Nazwisko";
        int capital = 15000, acc_number = 12349876, credit_amount = 1000, card_number = 15263748;
        Bank bank = new Bank(bank_name, capital);
        card_service_center.add_bank(bank);
        Client client = new Client(name, surname);
        bank.add_client(client);
        Account account = new Account_level_golden(new AccountImpl(name, surname, acc_number), 10.0);
        bank.add_account(account);
        Card card = new Debit(card_number, name, surname, bank.getBank_name());
        account.add_card(card);

        account.credit(credit_amount);
        new Reminder(time);
    }

    private Account find_account() {
        if (account_owner_name.getText().isEmpty()
                || account_owner_surname.getText().isEmpty()
                || account_number.getText().isEmpty()
                || account_assigned_to_bank.getText().isEmpty()) {
            System.out.println("Uzupełnij wszystkie pola!");
            return null;
        }
        for (Bank bank : card_service_center.bank_list) {
            if (bank.getBank_name().equals(account_assigned_to_bank.getText())) {
                for (Account acc : bank.list_of_acc_in_bank) {
                    if (acc.getOwner_name().equals(account_owner_name.getText()) && acc.getOwner_surname().equals(account_owner_surname.getText())) {
                        if (acc.getAcc_number() == Long.parseLong(account_number.getText())) {
                            return acc;
                        }
                    }
                }
            }
        }
        return null;
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
                        if (acc.getState() instanceof AccountClosed || acc.getState() instanceof AccountSuspended) {
                            acc.getState().credit(acc, 1);
                            return;
                        }
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
        if (bank_name.getText().isEmpty() || bank_capital.getText().isEmpty()) {
            System.out.println("Uzupełnij wszystkie pola!");
            return;
        }
        Bank bank = new Bank(bank_name.getText(), Integer.parseInt(bank_capital.getText()));
//        int kapital = Integer.parseInt(bank_capital.getText());

//        bank.balanceChanged(kapital);
        card_service_center.add_bank(bank);

        System.out.println("Dodano bank");
    }

    @FXML
    public void add_media() {
        if (obs_bank_name.getText().isEmpty()) {
            System.out.println("Uzupełnij wszystkie pola!");
            return;
        }

        for (Bank bank : card_service_center.bank_list) {
            if (bank.bank_name == null ? obs_bank_name.getText() == null : bank.bank_name.equals(obs_bank_name.getText())) {
                Media media = Media.getInstance();
                bank.addObserver(media);
                break;
            }
        }
    }

    @FXML
    public void delete_media() {
        if (obs_bank_name.getText().isEmpty()) {
            System.out.println("Uzupełnij wszystkie pola!");
            return;
        }

        for (Bank bank : card_service_center.bank_list) {
            if (bank.bank_name == null ? obs_bank_name.getText() == null : bank.bank_name.equals(obs_bank_name.getText())) {
                Media media = Media.getInstance();
                bank.removeObserver(media);
                break;
            }
        }
    }

    @FXML
    public void add_knf() {
        if (obs_bank_name.getText().isEmpty()) {
            System.out.println("Uzupełnij wszystkie pola!");
            return;
        }

        for (Bank bank : card_service_center.bank_list) {
            if (bank.bank_name == null ? obs_bank_name.getText() == null : bank.bank_name.equals(obs_bank_name.getText())) {
                Knf knf = Knf.getInstance();
                bank.addObserver(knf);
                break;
            }
        }
    }

    @FXML
    public void delete_knf() {
        if (obs_bank_name.getText().isEmpty()) {
            System.out.println("Uzupełnij wszystkie pola!");
            return;
        }

        for (Bank bank : card_service_center.bank_list) {
            if (bank.bank_name == null ? obs_bank_name.getText() == null : bank.bank_name.equals(obs_bank_name.getText())) {
                Knf knf = Knf.getInstance();
                bank.removeObserver(knf);
                break;
            }
        }
    }

    @FXML
    public void change_kapital() {
        if (obs_bank_name.getText().isEmpty()) {
            System.out.println("Uzupełnij wszystkie pola!");
            return;
        }

        for (Bank bank : card_service_center.bank_list) {
            if (bank.bank_name.equals(obs_bank_name.getText())) {
                Random random = new Random();
                int value = random.nextInt(1000000) + 40;
                bank.balanceChanged(value);
                return;
            }
        }
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

        for (Bank obj : card_service_center.bank_list) {
            if (obj.bank_name.equals(client_assigned_to_bank.getText())) {
                for (Client temp : obj.list_of_clients) {
                    if (temp.getName().equals(client_name.getText()) && temp.getSurname().equals(client_surname.getText())) {
                        System.out.println("W tym banku istnieje klient o podanych danych osobowych");
                        return;
                    }
                }
                Client client = new Client(client_name.getText(), client_surname.getText());
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

            for (Bank obj : card_service_center.bank_list) {
                for (Account acc : obj.list_of_acc_in_bank) {
                    if (acc.getAcc_number() == Integer.parseInt(account_number.getText())) {
                        System.out.println("Updating account");
                        Account temp = acc;
                        while (temp instanceof Account_level_golden || temp instanceof Account_level_foreign) {
                            temp = ((Account_level) temp).getAccount();
                        }
                        if (golden.isSelected())
                            temp = new Account_level_golden(temp, 2.5);
                        if (foreign.isSelected())
                            temp = new Account_level_foreign(temp);
                        obj.delete_account(acc);
                        obj.add_account(temp);
                        return;
                    }
                }
            }
            for (Bank obj : card_service_center.bank_list) {
                if (obj.bank_name.equals(account_assigned_to_bank.getText())) {
//                    System.out.println("Creating account");
                    for (Client temp : obj.list_of_clients) {
                        if (temp.getName().equals(account_owner_name.getText()) && temp.getSurname().equals(account_owner_surname.getText())) {

                            Account account = new AccountImpl(temp.getName(), temp.getSurname(), Integer.parseInt(account_number.getText()));
                            if (golden.isSelected()) {
                                if (account_interest_rate.getText().isEmpty()) {
                                    System.out.println("Uzupełnij wszystkie pola!");
                                    return;
                                }
                                account = new Account_level_golden(account, Double.parseDouble(account_interest_rate.getText()));
                            }
                            if (foreign.isSelected())
                                account = new Account_level_foreign(account);
                            obj.add_account(account);
                            System.out.println("Dodano konto");
                            return;
                        }
                    }
                }
            }
            System.out.println("Brak klienta o podanych danych");

        } catch (NumberFormatException e) {
            System.out.println("Wystąpił błąd - podaj odpowiedni numer karty");
        }
    }


    @FXML
    public void take_credit() {
        if (credit_amount.getText().isEmpty()) {
            System.out.println("Uzupełnij wszystkie pola!:credit");
            return;
        }
        Account acc = find_account();
        if (acc == null) {
            System.out.println("Nie ma takiego konta z banku");
            return;
        }
        int amount = Integer.parseInt(credit_amount.getText());

        acc.credit(amount);
    }

    @FXML
    public void open_account() {
        Account acc = find_account();
        if (acc == null)
            return;
        acc.setState(new AccountOpen());
        System.out.println("Konto zostało otwarte");
    }

    @FXML
    public void close_account() {
        Account acc = find_account();
        if (acc == null)
            return;
        acc.setState(new AccountClosed());
        System.out.println("Konto zostało zamkniete");
    }

    @FXML
    public void suspend_account() {
        Account acc = find_account();
        if (acc == null)
            return;
        acc.setState(new AccountSuspended());
        System.out.println("Konto zostało zawieszone");
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
            long card_number_method = Long.parseLong(query_card_number.getText());
            float query_amount_method = Float.parseFloat(query_amount.getText());

            for (Firm firm_clone : card_service_center.firm_list) {
                if (!firm_clone.getName_of_firm().equals(Firm_name.getText())) {
                    System.out.println("Brak firmy w bazie");
                    return;
                }
            }

            for (Bank bank : card_service_center.bank_list) {
                for (Account account : bank.list_of_acc_in_bank) {
                    for (Card card : account.getCard_assigned_to_account()) {
                        if (card.getCard_number() == card_number_method) {
                            boolean decision = Math.random() < 0.8;
                            if (decision) {
                                if (!(account instanceof Account_level_foreign) && !query_currency.getText().toLowerCase().equals("pln")) {
                                    System.out.println("Podane konto nie jest kontem zagranicznym");
                                    return;
                                }
                                if (account.getState() instanceof AccountOpen) {
                                    Query query = new Query(card, query_currency.getText(), query_firm_name.getText(), query_amount_method);
                                    card_service_center.add_query(query);
                                    System.out.println("Transakcja zaakceptowana");
                                } else {
                                    account.credit(1);
                                }
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
    public void save_to_file() {
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
    public void archive_read_from_file() {
        try {
            for (String s : new FileLineIterable(archive_open_file.getText()))
                System.out.println(s);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    class Reminder {
        private Timer timer;

        Reminder(int seconds) {
            timer = new Timer();
            timer.schedule(new RemindTask(), seconds * 1000);
        }

        class RemindTask extends TimerTask {
            public void run() {
                System.out.println("Nowy rok");
                timer.cancel();
                rise();
                new Reminder(time);
            }
        }

        private void rise() {
            for (Bank bank : card_service_center.bank_list)
                for (Account acc : bank.list_of_acc_in_bank)
                    if (acc instanceof Account_level_golden || ((Account_level_foreign) acc).getAccount() instanceof Account_level_golden) {
                        Double val=1+((Account_level_golden)acc).getInterest_rate()/100;
//                        System.out.println(val);
                        Double temp=acc.getBalance()*val;
//                        System.out.println(acc.getBalance());
                        acc.setBalance(temp.intValue());
                    }
        }
    }
}














