package com.codedifferentlly.labs.players;

public class Player {
    private String name;
    private Integer winningStreak;
    private Integer points = 0;

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
        resetPoints();
    }

    public void resetPoints() { points = 0; }

    public Integer getPoints(){
        return points;
    }

    public Integer addPoints() {return points++;}

    public void resetWin(){
        winningStreak = 0;
    }

    public String toString(){
        return String.format("Name: %s, Wins: %d", name, winningStreak);
    }

}
