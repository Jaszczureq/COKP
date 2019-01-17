package sample;

interface Observer {
    void update(Bank bank, int stan);

    void addBank(Bank bank);

    void removeBank(Bank bank);
}