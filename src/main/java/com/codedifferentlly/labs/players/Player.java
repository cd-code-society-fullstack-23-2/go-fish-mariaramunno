package com.codedifferentlly.labs.players;

public class Player {
    private String name;
    private Integer winningStreak;

    public Player(String name){
        this.name = name;
        this.winningStreak = 0;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getWinningStreak(){
        return winningStreak;
    }

    public void addWin(){
        winningStreak++;
    }

    public void resetWin(){
        winningStreak = 0;
    }

    public String toString(){
        return String.format("Name: %s, Wins: %d", name, winningStreak);
    }


}
