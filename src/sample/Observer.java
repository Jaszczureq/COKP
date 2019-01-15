package sample;

interface Observer {

    /* aktualizuje dane */
    public void update(Bank bank);
    public void addBank(Bank bank);
    public void removeBank(Bank bank);
}