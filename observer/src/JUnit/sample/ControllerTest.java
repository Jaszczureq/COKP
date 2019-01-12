//package sample;
//
//import org.junit.Test;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
///**
// * Created by ajax on 03.06.2017.
// */
//public class ControllerTest {
//    Card_service_center card_service_center = new Card_service_center();
//
//    @Test
//    public void add_card_prompt() throws Exception {
////        Client client = new Client("test","test");
//        Debit new_card = new Debit(32423423,"test","test", "bank_test");
//        Bank bank = new Bank("test");
//        Account account = new Account("test", "test",3242342,1);
//        card_service_center.add_bank(bank);
//        account.add_card(new_card);
//        assertEquals(account.card_assigned_to_account.get(0),new_card);
//        assertEquals(account.getOwner_name(),"test");
//    }
//
//    @Test
//    public void add_bank_prompt() throws Exception {
//        Bank bank = new Bank ("test");
//        Bank bank1 = new Bank ("test");
//        card_service_center.add_bank(bank);
//        assertEquals(card_service_center.bank_list.get(0),bank);
//    }
//
//    @Test
//    public void delete_bank_prompt() throws Exception {
//        Bank bank = new Bank("test");
//        card_service_center.bank_list.add(bank);
//        assertEquals(card_service_center.bank_list.get(0),bank);
//        card_service_center.bank_list.remove(0);
//    }
//
//    @Test
//    public void get_list_of_bank() throws Exception {
//        Bank bank = new Bank("test");
//        card_service_center.bank_list.add(bank);
//        List<Bank> test = new ArrayList<Bank>();
//        test.add(bank);
//        assertEquals(card_service_center.bank_list.get(0).bank_name, test.get(0).bank_name);
//    }
//
//    @Test
//    public void add_client() throws Exception {
////        Client client = new Client("test","test");
//        Bank bank = new Bank("test");
////        bank.list_of_clients.add(client);
////        assertEquals(bank.list_of_clients.get(0), client);
//    }
//
//    @Test
//    public void add_account() throws Exception {
//        Account account = new Account("test","test",1234324,1);
//        Bank bank = new Bank("test");
//        bank.add_account(account);
//        assertEquals(bank.list_of_acc_in_bank.get(0),account);
//
//    }
//
//    @Test
//    public void add_firm() throws Exception {
//        Firm firm = new Firm("test");
//        card_service_center.add_firm(firm);
//        assertEquals(card_service_center.firm_list.get(0),firm);
//    }
//
//    @Test
//    public void delete_firm() throws Exception {
//        Firm firm = new Firm("test");
//        card_service_center.add_firm(firm);
//        List<Firm>  test =new ArrayList<Firm>();
//        test.add(firm);
//        assertEquals(card_service_center.firm_list.get(0),test.get(0));
//    }
//
//    @Test
//    public void add_query() throws Exception {
////        Client client = new Client("test","test");
//        Debit new_card = new Debit(32423423,"test","test", "bank_test");
//        Bank bank = new Bank("test");
//        Account account = new Account("test", "test",3242342,1);
//        Firm firm = new Firm("test");
//        Query query = new Query(new_card,"euro",firm.getName_of_firm(),324123);
//        card_service_center.add_query(query);
//        assertEquals(card_service_center.query_list.get(0), query);
//    }
//
//    @Test
//    public void get_queries() throws Exception {
//        System.out.println(card_service_center.getQuery_list());
//    }
//
//    @Test
//    public void save_to_file() throws Exception {
//    }
//
//    @Test
//    public void archive_read_from_file() throws Exception {
//        InputStream is = new FileInputStream("PKO");
//
//    }

//}