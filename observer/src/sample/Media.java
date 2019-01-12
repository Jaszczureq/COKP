package sample;

class Media implements Obserwator, Informowanie {
    private int aktualnystan;
    private int poziom_bezp;
    private Bank bank;

    public Media (Bank bank){

    this.bank=bank;
    }

    public void update(int t1,int t2){

        aktualnystan=t1;
        poziom_bezp=t2;

    informuj();
    }

    public void informuj()
    {
            System.out.println("Nastąpiła aktualizacja danych w Mediach");

    }
    @Override
    public String toString() {
        return "Media:{   bezpieczenstwo: " +(poziom_bezp+1)+"}   ";
    }
    public void usun(){
    bank.usunObserwatora(this);
    }
}