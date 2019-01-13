package sample;

import java.util.ArrayList;
import java.util.List;

public class Bank implements Obserwowany {
    public String bank_name;
    //public int bank_capital;
    public List<Account> list_of_acc_in_bank = new ArrayList<Account>();
    public List<Client> list_of_clients = new ArrayList<Client>();
    private ArrayList<Obserwator> obserwatorzy;
    private int aktualnystan;
    private int poziom_bezp;

    public Bank() {
        obserwatorzy = new ArrayList<Obserwator>();
    }

    public void dodajObserwatora(Obserwator o) {
        obserwatorzy.add(o);
    }

    public void usunObserwatora(Obserwator o) {
        int index = obserwatorzy.indexOf(o);
        obserwatorzy.remove(index);
    }

    public void powiadamiajObserwatorow() {
        for (Obserwator o : obserwatorzy) {
            o.update(aktualnystan, poziom_bezp);
        }
    }

    public void zmianaStanu(int stan) {
        aktualnystan = stan;
        if (aktualnystan > 1000000) {
            poziom_bezp = 3;
        }
        if (aktualnystan <= 1000000) {
            {
                poziom_bezp = 2;
            }
            if (aktualnystan <= 500000) {
                poziom_bezp = 1;
            }
        }
        powiadamiajObserwatorow();
    }

    public int getResults() {

        return aktualnystan;
    }

    public Bank(String bank_name) {
        this();
        this.bank_name = bank_name;
        // this.bank_capital=bank_capital;
    }

    public Bank(Bank bank) {
        this.bank_name = bank.bank_name;
        // this.bank_capital=bank.bank_capital;
        this.list_of_acc_in_bank = bank.list_of_acc_in_bank;

    }

    public String getBank_name() {
        return bank_name;
    }

    // public int getBank_capital() {
    //     return bank_capital;
    // }

    public List<Account> getList_of_acc_in_bank() {
        return list_of_acc_in_bank;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    //   public void setBank_capital(int bank_capital) {
    //      this.bank_capital = bank_capital;
    //  }

    public void setList_of_acc_in_bank(List<Account> list_of_acc_in_bank) {
        this.list_of_acc_in_bank = list_of_acc_in_bank;
    }

    public List<Client> getList_of_clients() {
        return list_of_clients;
    }

    public void setList_of_clients(List<Client> list_of_clients) {
        this.list_of_clients = list_of_clients;
    }

    public void add_account(Account account) {
        list_of_acc_in_bank.add(account);
    }

    public void delete_accont(Account account) {
        list_of_acc_in_bank.remove(account);
    }

    public void add_client(Client client) {
        list_of_clients.add(client);
    }


    @Override
    public String toString() {
        String value = "Bank{" +
                "bank_name='" + bank_name + '\'' +
                ", list_of_acc_in_bank=" + list_of_acc_in_bank +
                ", list_of_clients=" + list_of_clients;
        for (Obserwator o : obserwatorzy) {
            value += o.toString();
        }
        value += '}';
        return value;
    }
}
