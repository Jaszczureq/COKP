package sample;

interface Observer {

    /* aktualizuje dane */
    public void update(Bank bank, int stan);
    public void addBank(Bank bank);
    public void removeBank(Bank bank);
}