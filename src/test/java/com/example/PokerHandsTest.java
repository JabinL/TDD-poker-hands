package com.example;

import org.testng.annotations.Test;

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
}
