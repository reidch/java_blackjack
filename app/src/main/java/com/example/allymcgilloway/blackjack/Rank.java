package com.example.allymcgilloway.blackjack;

/**
 * Created by allymcgilloway on 27/10/2017.
 */

public enum Rank {
    KING(10),
    QUEEN(10),
    JACK(10),
    TEN(10),
    NINE(9),
    EIGHT(8),
    SEVEN(7),
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2),
    ACE(11);

    private int value;

     Rank(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
