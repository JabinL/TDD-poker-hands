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
        return compareSameRank(blackRank, black, white);
    }

    private String compareSameRank(int rank, List<Poker> black, List<Poker> white) {
        List<Integer> blackValue = black.stream().sorted(Comparator.comparing(Poker::getValue))
                .map(Poker::getValue).collect(Collectors.toList());
        List<Integer> whiteValue = white.stream().sorted(Comparator.comparing(Poker::getValue))
                .map(Poker::getValue).collect(Collectors.toList());
        switch (rank) {
            case Rank.HIGH_CARD:
                return compareHighCard(blackValue, whiteValue);
            case Rank.PAIR:
                return comparePair(blackValue, whiteValue);
        }
        return "";
    }

    private String comparePair(List<Integer> blackValue, List<Integer> whiteValue) {
        Integer blackPair = blackValue.stream().collect(Collectors.groupingBy(Integer::valueOf))
                .values()
                .stream()
                .sorted((a, b) -> b.size() - a.size())
                .collect(Collectors.toList()).get(0).get(0);
        Integer whitePair = whiteValue.stream().collect(Collectors.groupingBy(Integer::valueOf))
                .values()
                .stream()
                .sorted((a, b) -> b.size() - a.size())
                .collect(Collectors.toList()).get(0).get(0);

        if(blackPair.equals(whitePair)){
           return compareHighCard(blackValue, whiteValue);
        }
        return blackPair > whitePair ?"Black win":"White win";
    }

    private String compareHighCard(List<Integer> black, List<Integer> white) {
        for (int i = black.size() -1 ; i > 0; i--) {
            if (black.get(i) > white.get(i)) {
                return "Black win";
            } else if (black.get(i) < white.get(i)) {
                return "White win";
            }
        }
        return "Tie";
    }
}
