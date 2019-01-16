package sample;

import java.util.ArrayList;
import java.util.List;

public class Bank implements Subject {
    public String bank_name;
    public List<Account> list_of_acc_in_bank = new ArrayList<Account>();
    public List<Client> list_of_clients = new ArrayList<Client>();
    private ArrayList<Observer> subjects;
    private int current_balance;
    private int security_level;

    public Bank() {
        subjects = new ArrayList<Observer>();
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

    public void notifyObservers() {
        for (Observer o : subjects) {
            o.update(this);
        }
    }

    public void balanceChanged(int stan) {
        current_balance = stan;
        if (current_balance > 1000000) {
            security_level = 3;
        }
        if (current_balance <= 1000000) {
            {
                security_level = 2;
            }
            if (current_balance <= 500000) {
                security_level = 1;
            }
        }
        notifyObservers();
    }

    public int getResults() {

        return current_balance;
    }

    public String getBank_name() {
        return bank_name;
    }

    public List<Account> getList_of_acc_in_bank() {
        return list_of_acc_in_bank;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public void setList_of_acc_in_bank(List<Account> list_of_acc_in_bank) {
        this.list_of_acc_in_bank = list_of_acc_in_bank;
    }

    public List<Client> getList_of_clients() {
        return list_of_clients;
    }

    public void setList_of_clients(List<Client> list_of_clients) {
        this.list_of_clients = list_of_clients;
    }

    public void add_account(Account account) {
        list_of_acc_in_bank.add(account);
    }

    public void delete_account(Account account) {
        list_of_acc_in_bank.remove(account);
    }

    public void add_client(Client client) {
        list_of_clients.add(client);
    }

    public int getCurrent_balance() {
        return current_balance;
    }

    public void setCurrent_balance(int current_balance) {
        this.current_balance = current_balance;
    }

    public int getSecurity_level() {
        return security_level;
    }

    public void setSecurity_level(int security_level) {
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
