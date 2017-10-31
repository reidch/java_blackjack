package com.example.allymcgilloway.blackjack;

import java.util.ArrayList;

/**
 * Created by allymcgilloway on 27/10/2017.
 */

public class Game {

    Player player;
    Dealer dealer;
    Deck deck;
    ArrayList<Card> pile;
    boolean isWon;

    public Game(Player player, Dealer dealer, Deck deck) {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
        this.pile = new ArrayList<>();
        this.isWon = false;

    }

    public String start() {
        dealerInitialDeal();

        return play();
    }

    public void dealerInitialDeal() {
            this.player.takeCard(dealer.deal());
            this.dealer.takeCard(dealer.deal());
            this.player.takeCard(dealer.deal());
            this.dealer.takeCard(dealer.deal());
    }

//    private void dealerDeal() {
//        while (!deck.getCards().isEmpty()) {
//            this.player.takeCard(dealer.deal());
//            this.dealer.takeCard(dealer.deal());
//        }
//    }

    public String compareHands() {
        int playerSum = 0;
        for (Card card : player.getCards()) {
            playerSum += card.getValue();
        }
        int dealerSum = 0;
        for (Card card : dealer.getCards()) {
            dealerSum += card.getValue();
        }
        if (playerSum > dealerSum && playerSum <= 21) {
            return "Player wins";
        } else {
            return "Dealer wins";
        }
    }

    private String play() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(this.dealer);
        players.add(this.player);

        return takeTurns(players);
    }


    public String takeTurns(ArrayList<Player> players) {
        while (!this.isWon && this.pile.size() < 52) {
            for (Player player : players) {
                this.pile.add(player.playCard());
                if (this.pile.size() >= 2) {
                    if (checkWin()) {
                        return gameOver(player);
                    }
                }
            } //end of for loop
        } // end of while
        return "Nobody Won no cards left!";
    }

    public boolean checkWin() {
        if (this.pile.get(this.pile.size() - 1).getValue() == this.pile.get(this.pile.size() - 2).getValue()) {
            this.isWon = true;
            return true;
        }
        return false;
    }

    public String gameOver(Player player) {
        return "Snap! " + player.getName() + " has won";
    }
}
