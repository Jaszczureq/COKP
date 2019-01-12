package sample;

/**
 * Created by ajax on 24.05.2017.
 */
public class Credit extends Card{
    private boolean withdraw_above_0 = true;
    private float max_debit_on_credit_card= 10000;

    Credit(long card_number, String owner_name, String owner_surname, String property_of_bank){
        super(card_number,owner_name,owner_surname,property_of_bank);
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
