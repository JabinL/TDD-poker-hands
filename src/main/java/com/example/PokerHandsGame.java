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
            case Rank.TWO_PAIRS:
                return compareTwoPair(blackValue, whiteValue);
            case Rank.THREE_KIND:
                return compareThreeKind(blackValue, whiteValue);
            case Rank.STRAIGHT:
                return compareStraight(blackValue, whiteValue);
            case Rank.FLUSH:
                return "Tie";
        }
        return "";
    }

    private String compareStraight(List<Integer> blackValue, List<Integer> whiteValue) {
        return blackValue.get(4)>whiteValue.get(4)?"Black win":"White win";
    }

    private String compareThreeKind(List<Integer> blackValue, List<Integer> whiteValue) {
        Integer blackThreeKind = blackValue.get(2);
        Integer whiteThreeKind = whiteValue.get(2);

        if(blackThreeKind>whiteThreeKind){
            return "Black win";
        }else if(blackThreeKind<whiteThreeKind){
            return "White win";
        }
        blackValue = filterNumbers(blackValue, blackThreeKind);
        whiteValue = filterNumbers(whiteValue, whiteThreeKind);
        return compareHighCard(blackValue,whiteValue);

    }

    private String compareTwoPair(List<Integer> blackValue, List<Integer> whiteValue) {
        Integer blackValueSigleNum = blackValue.get(0) ^ blackValue.get(1) ^ blackValue.get(2) ^ blackValue.get(3) ^ blackValue.get(4);
        Integer whiteValueSigleNum = whiteValue.get(0) ^ whiteValue.get(1) ^ whiteValue.get(2) ^ whiteValue.get(3) ^ whiteValue.get(4);
        blackValue = filterNumbers(blackValue, blackValueSigleNum);
        whiteValue = filterNumbers(whiteValue, whiteValueSigleNum);
        String res = compareHighCard(blackValue, whiteValue);
        if (res.equals("Tie")) {
            if (blackValueSigleNum.equals(whiteValueSigleNum)) {
                return "Tie";
            }
            return blackValueSigleNum > whiteValueSigleNum ? "Black win" : "White win";
        }
        return res;
    }

    private List<Integer> filterNumbers(List<Integer> list, Integer number) {
        return list.stream().filter(item -> !item.equals(number)).collect(Collectors.toList());
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

        if (blackPair.equals(whitePair)) {
            return compareHighCard(blackValue, whiteValue);
        }
        return blackPair > whitePair ? "Black win" : "White win";
    }

    private String compareHighCard(List<Integer> black, List<Integer> white) {
        for (int i = black.size() - 1; i > 0; i--) {
            if (black.get(i) > white.get(i)) {
                return "Black win";
            } else if (black.get(i) < white.get(i)) {
                return "White win";
            }
        }
        return "Tie";
    }
}
