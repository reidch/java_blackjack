package com.example.allymcgilloway.blackjack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by allymcgilloway on 27/10/2017.
 */

public class TestPlayer {

    Player player;
    Dealer dealer;
    Deck deck;
    Card card;
    Card card1;
    Card card2;
    Card card3;
    Card card4;


    @Before
    public void setup() throws Exception {
        deck = new Deck();
        player = new Player("Bob");
        dealer = new Dealer("Dealer", deck);
        card = new Card(Suit.HEARTS, Rank.NINE);
        card1 = new Card(Suit.SPADES, Rank.NINE);
        card2 = new Card(Suit.HEARTS, Rank.NINE);
        card3 = new Card(Suit.CLUBS, Rank.TWO);
        card4 = new Card(Suit.DIAMONDS, Rank.TWO);
    }

    @Test
    public void canTakeCard() {
        player.takeCard(card);
        assertEquals(1, player.getCards().size());
    }

    @Test
    public void canPlayCard(){
        player.takeCard(card);
        Card card = player.playCard();
        assertEquals(Suit.HEARTS, card.getSuit());
        assertEquals(Rank.NINE, card.getRank());
    }

    @Test
    public void canTotalCards() {
        player.takeCard(card1);
        player.takeCard(card2);
        dealer.takeCard(card3);
        dealer.takeCard(card4);
        assertEquals(18, player.getTotal());
        assertEquals(4, dealer.getTotal());
    }

}
