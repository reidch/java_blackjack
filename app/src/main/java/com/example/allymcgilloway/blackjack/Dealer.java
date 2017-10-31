package com.example.allymcgilloway.blackjack;

/**
 * Created by allymcgilloway on 27/10/2017.
 */

public class Dealer extends Player implements Playable {

    Deck deck;

     public Dealer(String name, Deck deck){
         super(name);
         this.deck = deck;
         shuffle();
     }

     public Card deal(){
         return this.deck.removeCard();
     }

     public void shuffle(){
         this.deck.shuffle();
     }
}
