package com.example.allymcgilloway.blackjack;

import java.util.ArrayList;

/**
 * Created by allymcgilloway on 27/10/2017.
 */

public class Player implements Playable {

    Dealer dealer;

    private String name;
    protected ArrayList<Card> cards;

    public Player(String name){
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void takeCard(Card card){
        this.cards.add(card);
    }

    public int getTotal() {
        int total = 0;
        for (Card card : getCards()) {
            total += card.getValue();
        }
        return total;
    }

    public Card playCard(){
        return cards.remove(0);
    }
}
