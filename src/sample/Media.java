package sample;

import java.util.ArrayList;

class Media implements Obserwator, Informowanie {
    private ArrayList<Bank> banki;
    private static Media media;

    private Media() {
        banki = new ArrayList<Bank>();
    }

    public static Media getInstance() {
        if (media == null) media = new Media();
        return media;
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
        System.out.println("Nastąpiła aktualizacja danych w Media.");
        System.out.println("Nazwa banku: " + bank.getBank_name());
        System.out.println("Aktualny stan: " + bank.getAktualnystan());
        System.out.println("Poziom bezpieczeństwa: " + (bank.getPoziom_bezp() + 1));
    }

    public void dodajBank(Bank bank) {
        banki.add(bank);
    }

    public void usunBank(Bank bank) {
        banki.remove(bank);
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