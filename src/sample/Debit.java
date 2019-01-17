package sample;

public class Debit extends Card {
//    boolean withdraw_above_0 = false;

    Debit(long card_number, String owner_name, String owner_surname, String property_of_bank) {
        super(card_number, owner_name, owner_surname, property_of_bank);
    }

    Debit(Card card) {
        super(card);
    }

    @Override
    public String toString() {
        return "Debit{" +
                "card_number=" + card_number +
                ", owner_name='" + owner_name + '\'' +
                ", owner_surname='" + owner_surname + '\'' +
                ", property_of_bank='" + property_of_bank + '\'' +
                '}';
    }
}
