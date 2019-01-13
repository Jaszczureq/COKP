package sample;

class Knf implements Obserwator, Informowanie {
    private int aktualnystan;
    private int poziom_bezp;
    private Bank bank;

    public Knf(Bank bank) {

        this.bank = bank;
    }

    public void update(int t1, int t2) {

        aktualnystan = t1;
        poziom_bezp = t2;

        informuj();
    }

    public void informuj() {
        System.out.println("Nastąpiła aktualizacja danych w Knf");
    }

    @Override
    public String toString() {
        return "Knf:{stan:" + aktualnystan +
                "   bezpieczenstwo: " + poziom_bezp + "}";
    }

    public void usun() {
        bank.usunObserwatora(this);
    }
}