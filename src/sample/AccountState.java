package sample;

public interface AccountState {
    void credit(Account acc, int amount);

    Card add_card(long card_number, String owner_name, String owner_surname, String property_of_bank);

    Query doQuery(Card card, String curr, String firmName, float ammount);

    boolean pay_off_credit(Account acc, int amount);

}

class AccountOpen implements AccountState {
    public void credit(Account acc, int amount) {
        acc.setBalance(acc.getBalance() + amount);
        acc.setCredit_amount(acc.getCredit_amount() + amount);
    }

    @Override
    public Card add_card(long card_number, String owner_name, String owner_surname, String property_of_bank) {
        return new Card(card_number, owner_name, owner_surname, property_of_bank);
    }

    @Override
    public Query doQuery(Card card, String curr, String firmName, float amount) {
        return new Query(card, curr, firmName, amount);
    }

    @Override
    public boolean pay_off_credit(Account acc, int amount) {
        if (amount > acc.getBalance()) {
            System.out.println("Nie wystarczający stan konta");
            return false;
        }
        int temp = acc.getCredit_amount() - amount;
        if (temp < 0) {
            acc.setBalance(acc.getBalance() - acc.getCredit_amount());
            acc.setCredit_amount(0);
        } else {
            acc.setBalance(acc.getBalance() - amount);
            acc.setCredit_amount(acc.getCredit_amount() - amount);
        }
        System.out.println("Pozostała kwota kredytu: " + acc.getCredit_amount());
        return true;
    }
}

class AccountSuspended implements AccountState {
    private String msg = "Konto jest zawieszone";

    public void credit(Account acc, int amount) {
        System.out.println(msg);
    }

    @Override
    public Card add_card(long card_number, String owner_name, String owner_surname, String property_of_bank) {
        System.out.println(msg);
        return new Card(card_number, owner_name, owner_surname, property_of_bank);
    }

    @Override
    public Query doQuery(Card card, String curr, String firmName, float amount) {
        System.out.println(msg);
        return null;
    }

    @Override
    public boolean pay_off_credit(Account acc, int amount) {

        if (amount > acc.getBalance()) {
            System.out.println("Nie wystarczający stan konta");
            return false;
        }
        acc.setBalance(acc.getBalance() - amount);
        acc.setCredit_amount(acc.getCredit_amount() - amount);
        System.out.println("Pozostała kwota kredytu: " + acc.getCredit_amount());
        return true;
    }
}

class AccountClosed implements AccountState {
    private String msg = "Konto jest zamknięte";

    public void credit(Account acc, int amount) {
        System.out.println(msg);
    }

    @Override
    public Card add_card(long card_number, String owner_name, String owner_surname, String property_of_bank) {
        System.out.println(msg);
        return null;

    }

    @Override
    public Query doQuery(Card card, String curr, String firmName, float amount) {
        System.out.println(msg);
        return null;
    }

    @Override
    public boolean pay_off_credit(Account acc, int amount) {
        System.out.println(msg);
        return false;
    }
}
