package com.example;

import com.example.enmu.Rank;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class PokerHandsTest {

    @Test
    public void should_return_5_pokers_when_inputStrTransToPokers_given_input_str_and_type() {
        String input = "Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C AH";
        PokerHands pokerHands = new PokerHands();
        List<Poker> pokersOfBlack = pokerHands.inputStrTransToPokers(input, 1);
        List<Poker> pokersOfWhite = pokerHands.inputStrTransToPokers(input, 2);
        assertEquals(5, pokersOfBlack.size());
        assertEquals(2, pokersOfBlack.get(0).getValue());
        assertEquals(13, pokersOfBlack.get(4).getValue());
        assertEquals("D", pokersOfBlack.get(4).getSuit());

        assertEquals(5, pokersOfWhite.size());
        assertEquals(2, pokersOfWhite.get(0).getValue());
        assertEquals(14, pokersOfWhite.get(4).getValue());
        assertEquals("H", pokersOfWhite.get(4).getSuit());
    }

    @Test
    public void should_return_straight_flush_when_countRank_given_pokers() {
        PokerHands pokerHands = new PokerHands();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(3, "H"));
        pokers.add(new Poker(4, "H"));
        pokers.add(new Poker(5, "H"));
        pokers.add(new Poker(6, "H"));
        pokers.add(new Poker(7, "H"));
        int rank = pokerHands.countRank(pokers);
        assertEquals(Rank.STRAIGHT_FLUSH, rank);
    }

    @Test
    public void should_return_straight_when_countRank_given_pokers() {
        PokerHands pokerHands = new PokerHands();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(3, "D"));
        pokers.add(new Poker(4, "H"));
        pokers.add(new Poker(5, "H"));
        pokers.add(new Poker(6, "H"));
        pokers.add(new Poker(7, "H"));
        int rank = pokerHands.countRank(pokers);
        assertEquals(Rank.STRAIGHT, rank);
    }

    @Test
    public void should_return_flush_when_countRank_given_pokers() {
        PokerHands pokerHands = new PokerHands();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(3, "H"));
        pokers.add(new Poker(9, "H"));
        pokers.add(new Poker(5, "H"));
        pokers.add(new Poker(6, "H"));
        pokers.add(new Poker(7, "H"));
        int rank = pokerHands.countRank(pokers);
        assertEquals(Rank.FLUSH, rank);
    }

    @Test
    public void should_return_four_kind_when_countRank_given_pokers() {
        PokerHands pokerHands = new PokerHands();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(3, "D"));
        pokers.add(new Poker(3, "H"));
        pokers.add(new Poker(3, "C"));
        pokers.add(new Poker(3, "S"));
        pokers.add(new Poker(7, "H"));
        int rank = pokerHands.countRank(pokers);
        assertEquals(Rank.FOUR_KIND, rank);
    }

    @Test
    public void should_return_full_house_when_countRank_given_pokers() {
        PokerHands pokerHands = new PokerHands();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(3, "D"));
        pokers.add(new Poker(3, "H"));
        pokers.add(new Poker(3, "C"));
        pokers.add(new Poker(7, "S"));
        pokers.add(new Poker(7, "H"));
        int rank = pokerHands.countRank(pokers);
        assertEquals(Rank.FULL_HOUSE, rank);
    }

    @Test
    public void should_return_three_kind_when_countRank_given_pokers() {
        PokerHands pokerHands = new PokerHands();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(3, "D"));
        pokers.add(new Poker(3, "H"));
        pokers.add(new Poker(3, "C"));
        pokers.add(new Poker(7, "S"));
        pokers.add(new Poker(9, "H"));
        int rank = pokerHands.countRank(pokers);
        assertEquals(Rank.THREE_KIND, rank);
    }

    @Test
    public void should_return_two_pairs_when_countRank_given_pokers() {
        PokerHands pokerHands = new PokerHands();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(3, "D"));
        pokers.add(new Poker(3, "H"));
        pokers.add(new Poker(7, "C"));
        pokers.add(new Poker(7, "S"));
        pokers.add(new Poker(9, "H"));
        int rank = pokerHands.countRank(pokers);
        assertEquals(Rank.TWO_PAIRS, rank);
    }

    @Test
    public void should_return_pairs_when_countRank_given_pokers() {
        PokerHands pokerHands = new PokerHands();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(3, "D"));
        pokers.add(new Poker(3, "H"));
        pokers.add(new Poker(7, "C"));
        pokers.add(new Poker(8, "S"));
        pokers.add(new Poker(9, "H"));
        int rank = pokerHands.countRank(pokers);
        assertEquals(Rank.PAIR, rank);
    }

    @Test
    public void should_return_high_card_when_countRank_given_pokers() {
        PokerHands pokerHands = new PokerHands();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(3, "D"));
        pokers.add(new Poker(6, "H"));
        pokers.add(new Poker(7, "C"));
        pokers.add(new Poker(8, "S"));
        pokers.add(new Poker(9, "H"));
        int rank = pokerHands.countRank(pokers);
        assertEquals(Rank.HIGH_CARD, rank);
    }

}
