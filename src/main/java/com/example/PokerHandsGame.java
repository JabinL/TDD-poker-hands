package com.example;

import com.example.enmu.Rank;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PokerHandsGame {

    public PokerHands pokerHands = new PokerHands();

    public String run(String input) {
        return getGameResult(input);
    }

    private String getGameResult(String input) {
        List<Poker> black = pokerHands.inputStrTransToPokers(input, 1);
        List<Poker> white = pokerHands.inputStrTransToPokers(input, 2);
        int blackRank = pokerHands.countRank(black);
        int whiteRank = pokerHands.countRank(white);
        if (blackRank > whiteRank) {
            return "Black win";
        } else if (blackRank < whiteRank) {
            return "White win";
        }
        return "tie";
    }
}
