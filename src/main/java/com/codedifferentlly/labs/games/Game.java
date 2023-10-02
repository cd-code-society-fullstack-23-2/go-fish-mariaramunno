package com.codedifferentlly.labs.games;

import com.codedifferentlly.labs.players.Player;

public interface Game {
    void play(Player player);
    String getMenuOption();
}
