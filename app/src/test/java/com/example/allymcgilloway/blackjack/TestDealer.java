package com.example.allymcgilloway.blackjack;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by allymcgilloway on 27/10/2017.
 */

public class TestDealer {


    Dealer dealer;
    Dealer spyDealer;
    Deck deck;

    @Before
    public void setUp() throws Exception {
        deck = new Deck();
        dealer = new Dealer("Dealer", deck);
        spyDealer = Mockito.spy(dealer);
    }

    @Test
    public void hasName(){
        assertEquals("Dealer", dealer.getName());
    }

    @Test
    public void hasEmptyHand(){
        assertEquals(0, dealer.getCards().size());
    }

    @Test
    public void canDeal(){
        Mockito.when(spyDealer.deal()).thenReturn(new Card(Suit.SPADES, Rank.KING));
        Card card = spyDealer.deal();
        assertEquals(Suit.SPADES, card.getSuit());
        assertEquals(Rank.KING, card.getRank());
    }

    @Test
    public void testShuffle(){
        Deck mockDeck = mock(Deck.class);
        dealer = new Dealer("Dealer", mockDeck);
        verify(mockDeck, times(1)).shuffle();
    }
}
