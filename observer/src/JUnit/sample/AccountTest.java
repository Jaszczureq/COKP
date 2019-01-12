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
//public class AccountTest {
//     String owner_name;
//     String owner_surname;
//     long acc_number;
//     List<Card> card_assigned_to_account= new ArrayList<Card>();
//
//
//    @Test
//    public void getOwner_name() throws Exception {
//        this.owner_name="test";
//        assertEquals(this.owner_name,"test");
//    }
//
////    @Test
//    public void getOwner_surname() throws Exception {
//        this.owner_surname="test";
//        assertEquals(this.owner_surname,"test");
//    }
//
//    @Test
//    public void getAcc_number() throws Exception {
//        this.acc_number=1111;
//        assertEquals(this.acc_number,1111);
//    }
//
//    @Test
//    public void getCard_assigned_to_account() throws Exception {
//        Card card = new Card();
//        card_assigned_to_account.add(card);
//        assertEquals(card_assigned_to_account.size(),1);
//    }
//
//    @Test
//    public void setOwner_name() throws Exception {
//        this.owner_name="test";
//        assertEquals(this.owner_name,"test");
//    }
//
//    @Test
//    public void setOwner_surname() throws Exception {
//        this.owner_surname="test";
//        assertEquals(this.owner_surname,"test");
//    }
//
//    @Test
//    public void setAcc_number() throws Exception {
//        this.acc_number=1;
//        assertEquals(this.acc_number,1);
//    }
//
//    @Test
//    public void setCard_assigned_to_account() throws Exception {
//        List<Card> cards = new ArrayList<Card>();
//        Card card = new Card();
//        cards.add(card);
//        card_assigned_to_account=cards;
//        assertEquals(card_assigned_to_account.size(),1);
//    }
//
//    @Test
//    public void add_card() throws Exception {
//        Card card = new Card();
//        card_assigned_to_account.add(card);
//        assertEquals(card_assigned_to_account.get(0),card);
//    }
//
//    @Test
//    public void delete_card() throws Exception {
//        Card card = new Card();
//        card_assigned_to_account.add(card);
//        card_assigned_to_account.remove(card);
//        assertEquals(card_assigned_to_account.size(),0);
//    }
//}