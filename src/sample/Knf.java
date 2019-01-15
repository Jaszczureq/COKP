package sample;

import java.util.ArrayList;

class Knf implements Obserwator, Informowanie {
    private ArrayList<Bank> banki;
    private static Knf knf;
    
    private Knf() {
        banki = new ArrayList<Bank>();
    }

    public static Knf getInstance() {
        if (knf == null) knf = new Knf();
        return knf;
    }

    public void update(Bank bank) {
        int index = banki.indexOf(bank);
        if (index == -1) {
            System.out.println("Brak banku");
            return;
        }
        
        Bank istniejacyBank = banki.get(index);
        istniejacyBank.setAktualnystan(bank.getAktualnystan());
        istniejacyBank.setPoziom_bezp(bank.getPoziom_bezp());
        
        informuj(bank);
    }

    public void informuj(Bank bank) {
        System.out.println("Nastąpiła aktualizacja danych w Knf.");        
        System.out.println("Nazwa banku: " + bank.getBank_name());        
        System.out.println("Aktualny stan: " + bank.getAktualnystan());
        System.out.println("Poziom bezpieczeństwa: " + bank.getPoziom_bezp());
    }
    
    public void dodajBank(Bank bank) {
        banki.add(bank);
    }
    
    public void usunBank(Bank bank) {
        banki.remove(bank);
    }
}