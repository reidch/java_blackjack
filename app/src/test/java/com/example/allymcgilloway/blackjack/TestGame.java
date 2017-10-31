package com.example.allymcgilloway.blackjack;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

/**
 * Created by carolinereid on 31/10/2017.
 */

public class TestGame {

    Game game;
    Dealer dealer;
    Deck deck;
    Player player;
    Card card;
    Card playerSpyCard;
    Card dealerSpyCard;
    Suit suit;
    Rank rank;

    @Before
    public void setUp() throws Exception {
        deck = new Deck();
        card = new Card(suit, rank);
        playerSpyCard = Mockito.spy(card);
        dealerSpyCard = Mockito.spy(card);
        player = new Player("Bob");
        dealer = new Dealer("Dealer", deck);
        game = new Game(player, dealer, deck);
    }

    @Test
    public void testInitialDeal() {
        game.dealerInitialDeal();
        assertEquals(2, player.getCards().size());
        assertEquals(2, dealer.getCards().size());
    }

//    @Test
//    public void testCompareHands() {
//        Mockito.when(playerSpyCard.getValue()).thenReturn(new Card(Suit.SPADES, Rank.ACE));
//        int playerSum = playerSpyCard.getValue();
//        Mockito.when(dealerSpyCard.getValue()).thenReturn(new Card(Suit.SPADES, Rank.EIGHT));
//        int dealerSum = dealerSpyCard.getValue();
//        assertEquals(11, playerSum);
//        assertEquals(8, dealerSum);
//    }


}
