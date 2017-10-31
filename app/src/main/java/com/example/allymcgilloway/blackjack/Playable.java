package com.example.allymcgilloway.blackjack;

import java.util.ArrayList;

/**
 * Created by carolinereid on 31/10/2017.
 */

public interface Playable {

    String getName();
    ArrayList getCards();
    void takeCard();
    int getTotal();
    Card playCard();
}
