package sample;

public class Credit extends Card {

    Credit(long card_number, String owner_name, String owner_surname, String property_of_bank) {
        super(card_number, owner_name, owner_surname, property_of_bank);
    }

    Credit(Card card) {
        super(card);
    }

    public String toString() {
        return "Credit{" +
                "card_number=" + card_number +
                ", owner_name='" + owner_name + '\'' +
                ", owner_surname='" + owner_surname + '\'' +
                ", property_of_bank='" + property_of_bank + '\'' +
                '}';
    }
}
