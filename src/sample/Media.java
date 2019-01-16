package sample;

import java.util.ArrayList;

class Media implements Observer, Notifications {
    private ArrayList<Bank> banks;
    private static Media media;

    private Media() {
        banks = new ArrayList<Bank>();
    }

    public static Media getInstance() {
        if (media == null)
            synchronized (Media.class) {
                if (media == null)
                    media = new Media();
            }
        return media;
    }

    public void update(Bank bank) {
        int index = banks.indexOf(bank);
        if (index == -1) {
            System.out.println("Brak banku");
            return;
        }

        Bank existingBank = banks.get(index);
        existingBank.setCurrent_balance(bank.getCurrent_balance());
        existingBank.setSecurity_level(bank.getSecurity_level());

        inform(bank);
    }

    public void inform(Bank bank) {
        System.out.println("Nastąpiła aktualizacja danych w Media.");
        System.out.println("Nazwa banku: " + bank.getBank_name());
        System.out.println("Aktualny stan: " + bank.getCurrent_balance());
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