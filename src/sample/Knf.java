package sample;

import java.util.ArrayList;

class Knf implements Observer, Notifications {
    private ArrayList<Bank> banks;
    private static Knf knf;

    private Knf() {
        banks = new ArrayList<Bank>();
    }

    static Knf getInstance() {
        if (knf == null)
            synchronized (Knf.class) {
                if (knf == null)
                    knf = new Knf();
            }
        return knf;
    }

    private int getSecLevel(int stan){
        int security_level=0;
        if (stan > 750000) {
            security_level = 3;
        }
        if (stan <= 750000) {
            {
                security_level = 2;
            }
            if (stan <= 350000) {
                security_level = 1;
            }
        }
        return security_level;
    }

    public void update(Bank bank, int stan) {
        int index = banks.indexOf(bank);
        if (index == -1) {
            System.out.println("Brak banku");
            return;
        }

        Bank existingBank = banks.get(index);
//        existingBank.setCurrent_balance(bank.getCurrent_balance());
        existingBank.setSecurity_level(getSecLevel(stan));

        inform(bank);
    }

    public void inform(Bank bank) {
        System.out.println("Nastąpiła aktualizacja danych w Knf.");
        System.out.println("Nazwa banku: " + bank.getBank_name());
        System.out.println("Aktualny stan: " + bank.getCurrent_balance());
        System.out.println("Poziom bezpieczeństwa: " + bank.getSecurity_level());
    }

    public void addBank(Bank bank) {
        banks.add(bank);
    }

    public void removeBank(Bank bank) {
        banks.remove(bank);
    }
}