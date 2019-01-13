package sample;

public interface AccountState {
    public void credit(Account acc, int amount);
}
class AccountOpen implements AccountState {
    public void credit(Account acc, int amount) {
        acc.setBalance(acc.getBalance() + amount);
    }
}
class AccountClosed implements AccountState {
    public void credit(Account acc, int amount) {
        System.out.println("The account is closed!");
    }
}
class AccountSuspended implements AccountState {
    public void credit(Account acc, int amount) {
        System.out.println("The account is suspended!");
    }
}
