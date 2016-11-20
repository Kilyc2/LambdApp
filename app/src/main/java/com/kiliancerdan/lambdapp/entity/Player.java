package com.kiliancerdan.lambdapp.entity;

public class Player {

    private String name;
    private float ranking;

    public Player(String name, float ranking) {
        this.name = name;
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public float getRanking() {
        return ranking;
    }
}
