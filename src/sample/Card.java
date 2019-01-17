package sample;


public class Card {

    protected long card_number;
    private float balance=0;
    protected String owner_name;
    protected String owner_surname;
    String property_of_bank;

    public Card(long card_number, String owner_name, String owner_surname, String property_of_bank){
        this.card_number=card_number;
        this.owner_name=owner_name;
        this.owner_surname=owner_surname;
        this.property_of_bank=property_of_bank;
    }

    public Card(Card card){
        this.card_number=card.card_number;
        this.owner_name=card.owner_name;
        this.owner_surname=card.owner_surname;
        this.property_of_bank=card.property_of_bank;
        this.balance=card.balance;
    }
    public Card(){}
    public long getCard_number() {
        return card_number;
    }

//    public void setCard_number(long card_number) {
//        this.card_number = card_number;
//    }
//
//    public float getBalance() {
//        return balance;
//    }
//
//    public void setBalance(float balance) {
//        this.balance = balance;
//    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getOwner_surname() {
        return owner_surname;
    }

    public void setOwner_surname(String owner_surname) {
        this.owner_surname = owner_surname;
    }

//    public String getProperty_of_bank() {
//        return property_of_bank;
//    }
//
//    public void setProperty_of_bank(String property_of_bank) {
//        this.property_of_bank = property_of_bank;
//    }

    @Override
    public String toString() {
        return "Card{" +
                "card_number=" + card_number +
                ", balance=" + balance +
                ", owner_name='" + owner_name + '\'' +
                ", owner_surname='" + owner_surname + '\'' +
                ", property_of_bank='" + property_of_bank + '\'' +
                '}';
    }
}
