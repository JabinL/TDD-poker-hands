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
    pokers.add(new Poker(3,"H"));
    pokers.add(new Poker(4,"H"));
    pokers.add(new Poker(5,"H"));
    pokers.add(new Poker(6,"H"));
    pokers.add(new Poker(7,"H"));
    int rank = pokerHands.countRank(pokers);
    assertEquals(Rank.STRAIGHT_FLUSH, rank);
  }




}
