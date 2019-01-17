package sample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Card_service_center {
    List<Bank> bank_list = new ArrayList<Bank>();
    List<Query> query_list = new ArrayList<Query>();
    List<Firm> firm_list = new ArrayList<Firm>();
    Iterator<Bank> iterator;

    List<Bank> getBank_list() {
        return bank_list;
    }

    List<Query> getQuery_list() {
        return query_list;
    }

    void add_firm(Firm firm) {
        firm_list.add(firm);
    }

    void add_query(Query query) {
        query_list.add(query);
    }

    void add_bank(Bank bank) {
        bank_list.add(bank);
    }

    void delete_bank(String bank_name_par) {
        for (iterator = bank_list.iterator(); iterator.hasNext(); ) {
            Bank bank_clone = iterator.next();
            if (bank_clone.getBank_name().equals(bank_name_par)) {
                iterator.remove();
                System.out.println("Pomyślnie usunięto bank");
                return;
            }
        }
        System.out.println("Brak podanego banku w bazie");
    }

    @Override
    public String toString() {
        return "Card_service_center{" +
                "bank_list=" + bank_list +
                ", query_list=" + query_list +
                ", firm_list=" + firm_list +
                '}';
    }

}
