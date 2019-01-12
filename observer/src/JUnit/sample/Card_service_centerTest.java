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
//public class Card_service_centerTest {
//     List<Bank> bank_list = new ArrayList<Bank>();
//     List<Query>query_list=new ArrayList<Query>();
//     List<Firm>firm_list=new ArrayList<Firm>();
//     boolean authorisation;
//
//
//
//    @Test
//    public void getBank_list() throws Exception {
////        Client client = new Client("test","test");
//        Debit new_card = new Debit(32423423,"test","test", "bank_test");
//        Bank bank = new Bank("test");
//        Account account = new Account("test", "test",3242342,1);
//        bank_list.add(bank);
//        assertEquals(bank_list.get(0), bank);
//
//    }
//
//    @Test
//    public void getFirm_list() throws Exception {
//        Firm firm = new Firm("test");
//        firm_list.add(firm);
//        assertEquals(firm_list.get(0),firm);
//    }
//
//    @Test
//    public void isAuthorisation() throws Exception {
//    }
//
//    @Test
//    public void getQuery_list() throws Exception {
////        Client client = new Client("test","test");
//        Debit new_card = new Debit(32423423,"test","test", "bank_test");
//        Bank bank = new Bank("test");
//        Account account = new Account("test", "test",3242342,1);
//        Firm firm = new Firm("test");
//        Query query = new Query(new_card,"euro",firm.getName_of_firm(),324123);
//        query_list.add(query);
//        assertEquals(query_list.get(0), query);
//    }
//
//    @Test
//    public void setAuthorisation() throws Exception {
//    }
//
//    @Test
//    public void add_firm() throws Exception {
//        Firm firm = new Firm("test");
//        firm_list.add(firm);
//        assertEquals(firm_list.get(0),firm);
//    }
//
//    @Test
//    public void delete_firm() throws Exception {
//        Firm firm = new Firm("test");
//        firm_list.add(firm);
//        firm_list.remove(firm);
//        assertEquals(firm_list.size(),0);
//    }
//
//    @Test
//    public void add_query() throws Exception {
////        Client client = new Client("test","test");
//        Debit new_card = new Debit(2342324,"test","test", "bank_test");
//        Bank bank = new Bank("test");
//        Account account = new Account("test", "test",3242342,1);
//        Firm firm = new Firm("test");
//
//
//        Query query1 = new Query(new_card,"euro",firm.getName_of_firm(),324123);
//        query_list.add(query1);
//        assertEquals(query_list.get(0), query1);
//    }
//
//    @Test
//    public void delete_query() throws Exception {
////        Client client = new Client("test","test");
//        Debit new_card = new Debit(4563,"test","test", "bank_test");
//        Bank bank = new Bank("test");
//        Account account = new Account("test", "test",3242342,1);
//        Firm firm = new Firm("test");
//
//
//        Query query1 = new Query(new_card,"euro",firm.getName_of_firm(),324123);
//        query_list.add(query1);
//        query_list.remove(0);
//
//
//        assertEquals(query_list.size(), 0);
//
//    }
//
//    @Test
//    public void add_bank() throws Exception {
//        Bank bank = new Bank("test");
//        bank_list.add(bank);
//        assertEquals(bank_list.get(0),bank);
//    }
//
//    @Test
//    public void delete_bank() throws Exception {
//        Bank bank = new Bank("test");
//        bank_list.add(bank);
//        bank_list.remove(0);
//        assertEquals(bank_list.size(),0);
//
//    }
//
//    @Test
//    public void set_authorisation() throws Exception {
//    }
//
//}