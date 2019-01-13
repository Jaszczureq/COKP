package sample;

import java.util.ArrayList;
import java.util.List;

public interface Account {
    String decorate();

    void add_card(Card card);

    List<Card> getCard_assigned_to_account();

    String getOwner_name();

    String getOwner_surname();

    int getBalance();

    void setBalance(int balance);
}

class AccountImpl implements Account {

    private AccountState state = null;
    private String owner_name;
    private String owner_surname;
    private int balance = 0;
    //    private float interest_rate;                                    //
    public long acc_number;
    public List<Card> card_assigned_to_account = new ArrayList<Card>();


    public AccountImpl() {
    }

    public AccountImpl(String owner_name, String owner_surname, int acc_number, float interest_rate) {
        this.owner_name = owner_name;
        this.owner_surname = owner_surname;
        this.acc_number = acc_number;
//        this.interest_rate = interest_rate;                     //
        this.state = new AccountOpen();
    }

    public void credit(int amount) {
        this.state.credit(this, amount); // delegacja
    }

    public void close() {
        this.state = new AccountClosed();
    }

    public void suspend() {
        this.state = new AccountSuspended();
    }

    public AccountImpl(AccountImpl account) {
        this.owner_name = account.owner_name;
        this.owner_surname = account.owner_surname;
        this.acc_number = account.acc_number;
//        this.interest_rate = account.interest_rate;             //
        this.balance = account.balance;                         //
        this.card_assigned_to_account = account.card_assigned_to_account;
    }

    @Override
    public String decorate() {
        return null;
    }

    //region getters, setters
    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void setBalance(int balance) {
        this.balance = balance;
    }

//    public float getInterest_rate() {
//        return interest_rate;
//}   //
//
//    public void setInterest_rate(float interest_rate) {
//        this.interest_rate = interest_rate;
//    }       //

    public String getOwner_name() {
        return owner_name;
    }

    public String getOwner_surname() {
        return owner_surname;
    }

    public long getAcc_number() {
        return acc_number;
    }

    public List<Card> getCard_assigned_to_account() {
        return card_assigned_to_account;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public void setOwner_surname(String owner_surname) {
        this.owner_surname = owner_surname;
    }

    public void setAcc_number(long acc_number) {
        this.acc_number = acc_number;
    }

    public void setCard_assigned_to_account(List<Card> card_assigned_to_account) {
        this.card_assigned_to_account = card_assigned_to_account;
    }

    public void add_card(Card card) {
        card_assigned_to_account.add(card);
    }

    public void delete_card(Card card) {
        card_assigned_to_account.remove(card);
    }

    public boolean contain_card(Card card) {
        return card_assigned_to_account.contains(card);
    }

    //endregion

    @Override
    public String toString() {
        return "Account{" +
                "owner_name='" + owner_name + '\'' +
                ", owner_surname='" + owner_surname + '\'' +
                ", acc_number=" + acc_number +
                ", card_assigned_to_account=" + card_assigned_to_account +
                '}';
    }
}

abstract class Account_level implements Account {
    public Account account;

    public Account_level(Account acc) {
        this.account = acc;
    }

    @Override
    public String decorate() {

        return null;
    }

    @Override
    public void setBalance(int balance) {
        account.setBalance(balance);
    }

    @Override
    public int getBalance() {
        return account.getBalance();
    }

    @Override
    public String getOwner_name() {
        return account.getOwner_name();
    }

    @Override
    public String getOwner_surname() {
        return account.getOwner_surname();
    }

    @Override
    public void add_card(Card card) {
        account.add_card(card);
    }

    @Override
    public List<Card> getCard_assigned_to_account() {
        return account.getCard_assigned_to_account();
    }
}

class Account_level_golden extends Account_level {
    private double interest_rate;

    public Account_level_golden(Account acc, double ir) {
        super(acc);
        this.interest_rate = ir;
    }

    public double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(double interest_rate) {
        this.interest_rate = interest_rate;
    }

    @Override
    public String decorate() {
        return super.decorate();
    }

    @Override
    public String toString() {
        return "Golden Account{" + super.account.toString();
//                "owner_name='" + account.getOwner_name() + '\'' +
//                ", owner_surname='" + account.getOwner_surname() + '\'' +
//                ", acc_number=" + account.getAcc_number() +
//                ", card_assigned_to_account=" + account.getCard_assigned_to_account() +
//                '}';
    }
}

class Account_level_foreign extends Account_level {
    private String currency;

    public Account_level_foreign(Account acc, String cur) {
        super(acc);
        this.currency = cur;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Foreign Account{" + super.account.toString();
//                "owner_name='" + account.getOwner_name() + '\'' +
//                ", owner_surname='" + account.getOwner_surname() + '\'' +
//                ", acc_number=" + account.getAcc_number() +
//                ", card_assigned_to_account=" + account.getCard_assigned_to_account() +
//                '}';
    }
}