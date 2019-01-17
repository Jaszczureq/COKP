package sample;

import java.util.ArrayList;
import java.util.List;

public class Bank implements Subject {
    String bank_name;
    List<Account> list_of_acc_in_bank = new ArrayList<>();
    List<Client> list_of_clients = new ArrayList<>();
    private ArrayList<Observer> subjects;
    private int current_balance;
    private int security_level;

    public Bank() {
        subjects = new ArrayList<>();
    }

    public Bank(String bank_name, int current_balance) {
        this();
        this.bank_name = bank_name;
        this.current_balance = current_balance;
    }

    public Bank(Bank bank) {
        this.bank_name = bank.bank_name;
        this.current_balance = bank.current_balance;
        this.list_of_acc_in_bank = bank.list_of_acc_in_bank;

    }

    public void addObserver(Observer o) {
        if (subjects.contains(o))
            return;
        subjects.add(o);
        o.addBank(this);
        String temp = o.getClass().getName().replace("sample.", "");
        System.out.println("Dodano  obserwatora typu: " + temp);
    }

    public void removeObserver(Observer o) {
        int index = subjects.indexOf(o);
        String temp = o.getClass().getName().replace("sample.", "");
        if (index < 0) {
            System.out.println("Brak obserwatorów typu: " + temp);
            return;
        }
        subjects.remove(index);
        o.removeBank(this);
        System.out.println("Usunięto obserwatora typu: " + temp);
    }

    public void notifyObservers(int stan) {
        for (Observer o : subjects) {
            o.update(this, stan);
        }
    }

    void balanceChanged(int stan) {
        setCurrent_balance(stan);
        notifyObservers(stan);
    }

    String getBank_name() {
        return bank_name;
    }

    void add_account(Account account) {
        list_of_acc_in_bank.add(account);
    }

    void delete_account(Account account) {
        list_of_acc_in_bank.remove(account);
    }

    void add_client(Client client) {
        list_of_clients.add(client);
    }

    int getCurrent_balance() {
        return current_balance;
    }

    private void setCurrent_balance(int current_balance) {
        this.current_balance = current_balance;
    }

    int getSecurity_level() {
        return security_level;
    }

    void setSecurity_level(int security_level) {
        this.security_level = security_level;
    }


    @Override
    public String toString() {
        return "Bank{" +
                "bank_name='" + bank_name + '\'' +
                ", bank_capital='" + current_balance + '\'' +
                ", list_of_acc_in_bank=\n" + list_of_acc_in_bank +
                ", list_of_clients=" + list_of_clients +
                "}\n";
    }
}
