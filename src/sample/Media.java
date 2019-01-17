package sample;

import java.util.ArrayList;

class Media implements Observer, Notifications {
    private ArrayList<Bank> banks;
    private static Media media;

    private Media() {
        banks = new ArrayList<Bank>();
    }

    static Media getInstance() {
        if (media == null)
            synchronized (Media.class) {
                if (media == null)
                    media = new Media();
            }
        return media;
    }
    private int getSecLevel(int stan){
        int security_level=0;
        if (stan > 1000000) {
            security_level = 3;
        }
        if (stan <= 1000000) {
            {
                security_level = 2;
            }
            if (stan <= 500000) {
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
//        existingBank.setCurrent_balance(stan);
        existingBank.setSecurity_level(getSecLevel(stan));

        inform(bank);
    }

    public void inform(Bank bank) {
        System.out.println("Nastąpiła aktualizacja danych w Media.");
        System.out.println("Nazwa banku: " + bank.getBank_name());
        System.out.println("Aktualny stan: " + bank.getCurrent_balance());
        // TODO fix security levels
        System.out.println("Poziom bezpieczeństwa: " + (bank.getSecurity_level() + 1));
    }

    public void addBank(Bank bank) {
        banks.add(bank);
    }

    public void removeBank(Bank bank) {
        banks.remove(bank);
    }

//    public static IConnection getConnection(){
//        return Connection.getInstance();
//    }
//
//    private static class Connection implements IConnection {
//
//        private static Media media;
//
//        private Connection(Media m) {
//            media = m;
//        }
//
//        private static Connection media_connection;
//
//        public static IConnection getInstance() {
//            if (media_connection == null) {
//                synchronized (IConnection.class) {
//                    if (media_connection == null) {
//                        Media media = new Media();
//                        media_connection = new Connection(media);
//                    }
//                }
//            }
//            return media_connection;
//
//        }
//
//    }

}