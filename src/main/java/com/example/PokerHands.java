package com.example;

import com.example.enmu.Rank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PokerHands {

    List<Poker> inputStrTransToPokers(String input, Integer type) {
        String black = input.substring(7, 21);
        String white = input.substring(29, 43);
        if (type == 1) {
            return strToPokers(black);
        } else {
            return strToPokers(white);
        }
    }

    public List<Poker> strToPokers(String str) {
        List<Poker> pokers = new ArrayList<>();
        String[] strPoker = str.split(" ");
        for (String item : strPoker) {
            int value = charToNumber(item);
            Poker poker = new Poker(value, item.substring(1));
            pokers.add(poker);
        }
        return pokers;
    }


    public int countRank(List<Poker> pokers) {
        pokers =
                pokers.stream().sorted(Comparator.comparing(Poker::getValue)).collect(Collectors.toList());

        if (isRankStraightFlush(pokers)) {
            return Rank.STRAIGHT_FLUSH;
        }
        if (isRankStraight(pokers)) {
            return Rank.STRAIGHT;
        }
        if (isRankFlush(pokers)) {
            return Rank.FLUSH;
        }
        if (isRankFourKind(pokers)) {
            return Rank.FOUR_KIND;
        }
        if(isRankFullHouse(pokers)){
            return Rank.FULL_HOUSE;
        }
        return 0;
    }

    public boolean isRankFullHouse(List<Poker> pokers) {
        return pokers.stream().map(Poker::getValue).collect(Collectors.toSet()).size() == 2;
    }

    public boolean isRankFourKind(List<Poker> pokers) {
        Integer[] array = pokers.stream().map(Poker::getValue).toArray(Integer[]::new);
        return array[0].intValue() == array[3]
                || array[1].intValue() == array[4];
    }



    public boolean isRankFlush(List<Poker> pokers) {
        return isFlush(pokers);
    }

    public boolean isRankStraightFlush(List<Poker> pokers) {
        return isStraight(pokers) && isFlush(pokers);
    }

    public boolean isRankStraight(List<Poker> pokers) {
        return isStraight(pokers);
    }

    public boolean isStraight(List<Poker> pokers) {
        for (int i = 0; i < pokers.size() - 1; i++) {
            if (pokers.get(i).getValue() + 1 != pokers.get(i + 1).getValue()) {
                return false;
            }
        }
        return true;
    }

    public boolean isFlush(List<Poker> pokers) {
        return pokers.stream().map(Poker::getSuit).collect(Collectors.toSet()).size() == 1;
    }

    public static void main(String[] args) {
        String input = "Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C AH";
        PokerHands pokerHands = new PokerHands();
        pokerHands.inputStrTransToPokers(input, 1);
    }

    public int charToNumber(String item) {
        int value = -1;
        switch (item.charAt(0)) {
            case 'T':
                value = 10;
                break;
            case 'J':
                value = 11;
                break;
            case 'Q':
                value = 12;
                break;
            case 'K':
                value = 13;
                break;
            case 'A':
                value = 14;
                break;
            default:
                value = (int) item.charAt(0) - (int) ('0');
                break;
        }
        return value;
    }
}
