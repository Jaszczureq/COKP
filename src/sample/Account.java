package sample;

import java.util.ArrayList;
import java.util.List;

public interface Account {
    void add_card(Card card);

    List<Card> getCard_assigned_to_account();

    String getOwner_name();

    String getOwner_surname();

    int getBalance();

    void setBalance(int balance);

    AccountState getState();

    long getAcc_number();

    boolean credit(int amount);

    void setState(AccountState state);

    int getDecorators_count();

    void setDecorators_count(int decorators_count);

    int getCredit_amount();

    void setCredit_amount(int credit_amount);

    double getInterest_rate();

    boolean pay_off_credit(int amount);

    Query doQuery(Card card, String curr, String firmName, float ammount);

    Account removeDecorators();
}

class AccountImpl implements Account {

    private int decorators_count = 0;
    private AccountState state = null;
    private String owner_name;
    private String owner_surname;
    private int balance = 1000;
    private int credit_amount = 0;
    private long acc_number;
    private List<Card> card_assigned_to_account = new ArrayList<>();

    AccountImpl(String owner_name, String owner_surname, int acc_number) {
        this.owner_name = owner_name;
        this.owner_surname = owner_surname;
        this.acc_number = acc_number;
        this.state = new AccountOpen();
    }

    public AccountImpl(AccountImpl account) {
        this.owner_name = account.owner_name;
        this.owner_surname = account.owner_surname;
        this.acc_number = account.acc_number;
        this.balance = account.balance;                         //
        this.card_assigned_to_account = account.card_assigned_to_account;
    }

    public boolean credit(int amount) {
        return this.state.credit(this, amount);
    }

    public boolean pay_off_credit(int amount) {
        return state.pay_off_credit(this, amount);
    }

    public int getCredit_amount() {
        return credit_amount;
    }

    public void setCredit_amount(int credit_amount) {
        this.credit_amount = credit_amount;
    }

    @Override
    public double getInterest_rate() {
        return 0.0;
    }

    @Override
    public Query doQuery(Card card, String curr, String firmName, float amount) {
        System.out.println("AccountImpl");
        if (!"pln".equals(curr.toLowerCase())) {
            System.out.println("Brak konta Foreign");
            return null;
        }
        return getState().doQuery(card, curr, firmName, amount);
    }

    @Override
    public Account removeDecorators() {
        return this;
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

    @Override
    public AccountState getState() {
        return state;
    }

    @Override
    public void setState(AccountState state) {
        this.state = state;
    }

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

    public void add_card(Card card) {
        card_assigned_to_account.add(card);
    }

    public int getDecorators_count() {
        return decorators_count;
    }

    public void setDecorators_count(int decorators_count) {
        this.decorators_count = decorators_count;
    }
    //endregion

    @Override
    public String toString() {
        return "Account{" +
                "owner_name='" + owner_name + '\'' +
                ", owner_surname='" + owner_surname + '\'' +
                ", acc_number=" + acc_number +
                ", acc_balance=" + balance +
                ", card_assigned_to_account=\n\t\t" + card_assigned_to_account +
                "}\n";
    }
}

abstract class Account_level implements Account {
    public Account account;

    Account_level(Account acc) {
        this.account = acc;
    }

    //region Overrides
    public int getCredit_amount() {
        return account.getCredit_amount();
    }

    public void setCredit_amount(int credit_amount) {
        account.setCredit_amount(credit_amount);
    }

    @Override
    public boolean pay_off_credit(int amount) {
        return account.pay_off_credit(amount);
    }

    @Override
    public void setBalance(int balance) {
        account.setBalance(balance);
    }

    @Override
    public long getAcc_number() {
        return account.getAcc_number();
    }

    @Override
    public int getBalance() {
        return account.getBalance();
    }

    @Override
    public AccountState getState() {
        return account.getState();
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

    @Override
    public boolean credit(int amount) {
        return account.credit(amount);
    }

    @Override
    public void setState(AccountState state) {
        account.setState(state);
    }

    @Override
    public int getDecorators_count() {
        return account.getDecorators_count();
    }

    @Override
    public void setDecorators_count(int decorators_count) {
        account.setDecorators_count(decorators_count);
    }

    public double getInterest_rate() {
        return 0.0;
    }

    //endregion

    @Override
    public Query doQuery(Card card, String curr, String firmName, float amount) {
        System.out.println("Account_level");

        if (!"pln".equals(curr.toLowerCase())) {
            System.out.println("Brak konta Foreign");
            return null;
        }
        return getState().doQuery(card, curr, firmName, amount);
    }

    public Account removeDecorators() {
        return account;
    }
}

class Account_level_golden extends Account_level {
    private double interest_rate;

    Account_level_golden(Account acc, double ir) {
        super(acc);
        this.interest_rate = ir;
        setDecorators_count(getDecorators_count() + 1);
    }

    public double getInterest_rate() {
        return interest_rate + super.account.getInterest_rate();
    }

    @Override
    public Query doQuery(Card card, String curr, String firmName, float amount) {
        return super.account.doQuery(card, curr, firmName, amount);
    }

    @Override
    public String toString() {
        return "Golden Account{" + super.account.toString();
    }

    public Account removeDecorators() {
        return super.account.removeDecorators();
    }
}

class Account_level_foreign extends Account_level {

    Account_level_foreign(Account acc) {
        super(acc);
        setDecorators_count(getDecorators_count() + 1);
    }

    public Query doQuery(Card card, String curr, String firmName, float amount) {
        return account.getState().doQuery(card, curr, firmName, amount);
    }

    public double getInterest_rate() {
        return 0 + super.account.getInterest_rate();
    }

    @Override
    public String toString() {
        return "Foreign Account{" + super.account.toString();
    }

    public Account removeDecorators() {
        return super.account.removeDecorators();
    }
}
