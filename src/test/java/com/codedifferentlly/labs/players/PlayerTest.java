package com.codedifferentlly.labs.players;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void constructorTest01(){
        String name = "name";
        Player player = new Player(name);

        String expected = "Name: name, Wins: 0";
        String actual = player.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getSetName(){
        String name = "Name";
        Player player = new Player(name);

        player.setName("name1");
        String expected = "name1";
        String actual = player.getName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void addGetWinTest01(){
        String name = "name";
        Player player = new Player(name);

        player.addWin();

        Integer expected = 1;
        Integer actual = player.getWinningStreak();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void addGetWinTest02(){
        String name = "name";
        Player player = new Player(name);

        player.addWin();
        player.addWin();
        player.addWin();
        player.addWin();

        Integer expected = 4;
        Integer actual = player.getWinningStreak();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void resetWinTest01(){
        String name = "name";
        Player player = new Player(name);

        player.addWin();
        player.resetWin();
        Integer expected = 0;
        Integer actual = player.getWinningStreak();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void resetWinTest02(){
        String name = "name";
        Player player = new Player(name);

        player.addWin();
        player.addWin();
        player.addWin();
        player.addWin();

        player.resetWin();
        Integer expected = 0;
        Integer actual = player.getWinningStreak();
        Assertions.assertEquals(expected, actual);
    }
}
