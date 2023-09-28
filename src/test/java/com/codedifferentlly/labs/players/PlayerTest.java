package com.codedifferentlly.labs.players;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void constructorTest01(){
        String name = "Juice Man";
        Player player = new Player(name);

        String expected = "Name: Juice Man, Wins: 0";
        String actual = player.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getSetName(){
        String name = "Beyonce";
        Player player = new Player(name);

        player.setName("Sasha Fierce");
        String expected = "Sasha Fierce";
        String actual = player.getName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void addGetWinTest01(){
        String name = "Beyonce";
        Player player = new Player(name);

        player.addWin();

        Integer expected = 1;
        Integer actual = player.getWinningStreak();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void resetWinTest01(){
        String name = "Beyonce";
        Player player = new Player(name);

        player.addWin();
        player.resetWin();
        Integer expected = 0;
        Integer actual = player.getWinningStreak();
        Assertions.assertEquals(expected, actual);
    }
}
