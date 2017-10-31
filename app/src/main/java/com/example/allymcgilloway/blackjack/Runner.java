package com.example.allymcgilloway.blackjack;

/**
 * Created by allymcgilloway on 27/10/2017.
 */

public class Runner {

    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player = new Player("Ally");
        Dealer dealer = new Dealer("Dealer", deck);
        Game game = new Game(player, dealer, deck);
        System.out.println(game.start());
    }
}
