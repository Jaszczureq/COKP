//package sample;
//
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
///**
// * Created by ajax on 03.06.2017.
// */
//public class BankTest {
//    String bank_name;
//    List<Account> list_of_acc_in_bank=new ArrayList<Account>();
//    List<Client> list_of_clients=new ArrayList<Client>();
//
//    @Test
//    public void getBank_name() throws Exception {
//        this.bank_name="test";
//        assertEquals(this.bank_name, "test");
//    }
//
//    @Test
//    public void getList_of_acc_in_bank() throws Exception {
//        Account acc = new Account("test","test",43242,1);
//        list_of_acc_in_bank.add(acc);
//        list_of_acc_in_bank.remove(0);
//        assertEquals(list_of_acc_in_bank.size(),0);
//    }
//
//    @Test
//    public void setBank_name() throws Exception {
//        this.bank_name="test";
//        assertEquals(this.bank_name, "test");
//    }
//
//    @Test
//    public void setList_of_acc_in_bank() throws Exception {
//        List<Account> list_of_acc_in_bank_cp=new ArrayList<Account>();
//        list_of_acc_in_bank=list_of_acc_in_bank_cp;
//        assertEquals(list_of_acc_in_bank,list_of_acc_in_bank_cp);
//    }
//
//    @Test
//    public void getList_of_clients() throws Exception {
////        Client client = new Client("test","test");
////        list_of_clients.add(client);
////        assertEquals(list_of_clients.get(0),client);
//    }
//
//    @Test
//    public void setList_of_clients() throws Exception {
////        List<Client> clients = new ArrayList<Client>();
////        Client client = new Client("test","test");
////        clients.add(client);
////        list_of_clients=clients;
////        assertEquals(list_of_clients,clients);
//    }
//
//    @Test
//    public void add_account() throws Exception {
//        Account acc = new Account("test","test",2342,1);
//        list_of_acc_in_bank.add(acc);
//        assertEquals(list_of_acc_in_bank.get(0),acc);
//    }
//
//    @Test
//    public void delete_accont() throws Exception {
//        Account acc = new Account("test","test",2342,1);
//        list_of_acc_in_bank.add(acc);
//        list_of_acc_in_bank.remove(0);
//        assertEquals(list_of_clients.size(),0);
//    }
//
//    @Test
//    public void add_client() throws Exception {
////        Client client = new Client("test", "test");
////        list_of_clients.add(client);
////        assertEquals(list_of_clients.get(0),client);
//    }
//
//}