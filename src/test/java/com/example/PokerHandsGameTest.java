package com.example;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class PokerHandsGameTest {
    private static PokerHandsGame pokerHandsGame;

    @BeforeClass
    public static void setUp() {
        pokerHandsGame = new PokerHandsGame();
    }

    @Test
    public void should_return_black_win_when_run_game_given_2H_2D_5S_9C_KD_2C_3H_4S_8C_AH() {
        String input = "Black: 2H 2D 5S 9C KD White: 2C 3H 4S 8C AH";
        String result = pokerHandsGame.run(input);
        assertEquals("Black win",result);
    }

    @Test
    public void should_return_white_win_when_run_game_given_2H_2D_5S_9C_KD_3C_3H_3S_8C_AH() {
        String input = "Black: 2H 2D 5S 9C KD White: 3C 3H 3S 8C AH";
        String result = pokerHandsGame.run(input);
        assertEquals("White win",result);
    }

    @Test
    public void should_return_black_win_when_run_game_given_2H_2D_2S_2C_KD_2C_3H_4S_8C_AH() {
        String input = "Black: 2H 2D 2S 2C KD White: 2C 3H 4S 8C AH";
        String result = pokerHandsGame.run(input);
        assertEquals("Black win",result);
    }

    @Test
    public void should_return_white_win_when_run_game_given_2H_2D_5S_9C_KD_3C_4H_5S_6C_7H() {
        String input = "Black: 2H 2D 5S 9C KD White: 3C 4H 5S 6C 7H";
        String result = pokerHandsGame.run(input);
        assertEquals("White win",result);
    }

    @Test
    public void should_return_black_win_when_run_game_given_2H_5D_KS_8C_9D_2C_3H_4S_8C_5H() {
        String input = "Black: 2H 5D KS 8C 9D White: 2C 3H 4S 8C 5H";
        String result = pokerHandsGame.run(input);
        assertEquals("Black win",result);
    }
    @Test
    public void should_return_white_win_when_run_game_given_2H_5D_KS_8C_9D_2C_3H_4S_8C_AH() {
        String input = "Black: 2H 5D KS 8C 9D White: 2C 3H 4S 8C AH";
        String result = pokerHandsGame.run(input);
        assertEquals("White win",result);
    }

    @Test
    public void should_return_tie_when_run_game_given_2H_5D_KS_8C_9D_2H_5D_KS_8C_9D() {
        String input = "Black: 2H 5D KS 8C 9D White: 2H 5D KS 8C 9D";
        String result = pokerHandsGame.run(input);
        assertEquals("Tie",result);
    }

    @Test
    public void should_return_black_win_when_run_game_given_5H_5D_KS_8C_9D_2H_2D_KS_8C_9D() {
        String input = "Black: 5H 5D KS 8C 9D White: 2H 2D KS 8C 9D";
        String result = pokerHandsGame.run(input);
        assertEquals("Black win",result);
    }

    @Test
    public void should_return_white_win_when_run_game_given_2H_2D_KS_8C_9D_5H_5D_KS_8C_9D() {
        String input = "Black: 2H 2D KS 8C 9D White: 5H 5D KS 8C 9D";
        String result = pokerHandsGame.run(input);
        assertEquals("White win",result);
    }

    @Test
    public void should_return_white_win_when_run_game_given_5H_5D_KS_8C_2D_5H_5D_KS_8C_9D() {
        String input = "Black: 5H 5D KS 8C 2D White: 5H 5D KS 8C 9D";
        String result = pokerHandsGame.run(input);
        assertEquals("White win",result);
    }

    @Test
    public void should_return_tie_when_run_game_given_5H_5D_KS_8C_9D_5H_5D_KS_8C_9D() {
        String input = "Black: 5H 5D KS 8C 9D White: 5H 5D KS 8C 9D";
        String result = pokerHandsGame.run(input);
        assertEquals("Tie",result);
    }

    @Test
    public void should_return_tie_when_run_game_given_two_pair_in_compare() {
        String input = "Black: 5H 5D 8S 8C 9D White: 5H 5D 8S 8C 9D";
        String result = pokerHandsGame.run(input);
        assertEquals("Tie",result);
    }

    @Test
    public void should_return_black_win_when_run_game_given_two_pair_in_compare() {
        String input = "Black: 5H 5D 8S 8C TD White: 5H 5D 8S 8C 9D";
        String result = pokerHandsGame.run(input);
        assertEquals("Black win",result);
    }

    @Test
    public void should_return_white_win_when_run_game_given_two_pair_in_compare() {
        String input = "Black: 5H 5D 9S 9C TD White: 5H 5D TS TC 9D";
        String result = pokerHandsGame.run(input);
        assertEquals("White win",result);
    }
    @Test
    public void should_return_white_win_when_run_game_given_three_kind_in_compare() {
        String input = "Black: 5H 5D 5S 9C TD White: 6H 6D 6S TC 9D";
        String result = pokerHandsGame.run(input);
        assertEquals("White win",result);
    }

    @Test
    public void should_return_black_win_when_run_game_given_three_kind_in_compare() {
        String input = "Black: 8H 8D 8S 9C TD White: 6H 6D 6S TC 9D";
        String result = pokerHandsGame.run(input);
        assertEquals("Black win",result);
    }

    @Test
    public void should_return_black_win_when_run_game_given_straight_compare() {
        String input = "Black: 4D 5S 6C 7D 8D White: 3H 4D 6S 7C 5D";
        String result = pokerHandsGame.run(input);
        assertEquals("Black win",result);
    }
    @Test
    public void should_return_tie_win_when_run_game_given_straight_compare() {
        String input = "Black: 3H 4D 6S 7C 5D White: 4D 5S 6C 7D 3D";
        String result = pokerHandsGame.run(input);
        assertEquals("Tie",result);
    }
    @Test
    public void should_return_white_win_when_run_game_given_straight_compare() {
        String input = "Black: 3H 4D 6S 7C 5D White: 4D 5S 6C 7D 8D";
        String result = pokerHandsGame.run(input);
        assertEquals("White win",result);
    }

    @Test
    public void should_return_tie_when_run_game_given_flush_compare() {
        String input = "Black: 3H 4H 9H 7H 5H White: 4D 5D 6D 7D 9D";
        String result = pokerHandsGame.run(input);
        assertEquals("Tie",result);
    }
    @Test
    public void should_return_black_win_when_run_game_given_full_house_compare() {
        String input = "Black: 3H 3H 3H 5D 5H White: 4D 4S 2D 2H 2S";
        String result = pokerHandsGame.run(input);
        assertEquals("Black win",result);
    }

    @Test
    public void should_return_white_win_when_run_game_given_full_house_compare() {
        String input = "Black: 4D 4S 2D 2H 2S White: 3H 3H 3H 5D 5H";
        String result = pokerHandsGame.run(input);
        assertEquals("White win",result);
    }
    @Test
    public void should_return_black_win_when_run_game_given_four_kind_compare() {
        String input = "Black: 3H 3C 3S 3D 5H White: 2D 4S 2C 2H 2S";
        String result = pokerHandsGame.run(input);
        assertEquals("Black win",result);
    }

    @Test
    public void should_return_white_win_when_run_game_given_four_kind_compare() {
        String input = "Black: 2D 4S 2C 2H 2S White: 3H 3C 3S 3D 5H";
        String result = pokerHandsGame.run(input);
        assertEquals("White win",result);
    }

    @Test
    public void should_return_black_win_when_run_game_given_straight_flush_compare() {
        String input = "Black: 4D 5D 6D 7D 8D White: 3H 4D 6S 7C 5D";
        String result = pokerHandsGame.run(input);
        assertEquals("Black win",result);
    }
    @Test
    public void should_return_white_win_when_run_game_given_straight_flush_compare() {
        String input = "Black: 3H 4D 6S 7C 5D White: 4D 5D 6D 7D 8D";
        String result = pokerHandsGame.run(input);
        assertEquals("White win",result);
    }
    @Test
    public void should_return_tie_win_when_run_game_given_straight_flush_compare() {
        String input = "Black: 3H 4H 6H 7H 5H White: 4D 5D 6D 7D 3D";
        String result = pokerHandsGame.run(input);
        assertEquals("Tie",result);
    }
}