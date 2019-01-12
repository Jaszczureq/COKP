package sample;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private AccountState state = null;
    private String owner_name;
    private String owner_surname;
    private int balance = 0;
    private float interest_rate;                                    //
    public long acc_number;
    public List<Card> card_assigned_to_account = new ArrayList<Card>();


    public Account(String owner_name, String owner_surname, int acc_number, float interest_rate) {
        this.owner_name = owner_name;
        this.owner_surname = owner_surname;
        this.acc_number = acc_number;
        this.interest_rate = interest_rate;                     //
        this.state = new AccountOpen();
    }

    public void credit(int amount) {
        this.state.credit(this, amount); // delegacja
    }

    public void close() {
        this.state = new AccountClosed();
    }

    public Account(Account account) {
        this.owner_name = account.owner_name;
        this.owner_surname = account.owner_surname;
        this.acc_number = account.acc_number;
        this.interest_rate = account.interest_rate;             //
        this.balance = account.balance;                         //
        this.card_assigned_to_account = account.card_assigned_to_account;
    }

    public Account() {
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public float getInterest_rate() {
        return interest_rate;
    }   //

    public void setInterest_rate(float interest_rate) {
        this.interest_rate = interest_rate;
    }       //

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

class Account_level extends Account {
    private Account account;

    public Account_level(Account acc) {
        this.account = acc;
    }
}

class Account_level_golden extends Account_level {
    private Account account;

    public Account_level_golden(Account acc) {
        super(acc);
        this.account = acc;
        acc.setInterest_rate(5);
    }

    public void setInteresr_rate(float ir_rt) {
        account.setInterest_rate(ir_rt);
    }

    @Override
    public String toString() {
        return "Golden Account{" +
                "owner_name='" + account.getOwner_name() + '\'' +
                ", owner_surname='" + account.getOwner_surname() + '\'' +
                ", acc_number=" + account.getAcc_number() +
                ", card_assigned_to_account=" + account.getCard_assigned_to_account() +
                '}';
    }
}

class Account_level_silver extends Account_level {
    private Account account;

    public Account_level_silver(Account acc) {
        super(acc);
        this.account = acc;
        acc.setInterest_rate(2);
    }

    @Override
    public String toString() {
        return "Silver Account{" +
                "owner_name='" + account.getOwner_name() + '\'' +
                ", owner_surname='" + account.getOwner_surname() + '\'' +
                ", acc_number=" + account.getAcc_number() +
                ", card_assigned_to_account=" + account.getCard_assigned_to_account() +
                '}';
    }
}