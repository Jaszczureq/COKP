package sample;

interface Obserwator {

    /* aktualizuje dane */
    public void update(Bank bank);
    public void dodajBank(Bank bank);
    public void usunBank(Bank bank);
}