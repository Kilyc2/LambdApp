package com.kiliancerdan.lambdapp.repository;

import com.kiliancerdan.lambdapp.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayersRepository {

    public List<Player> getPlayers(int numberPlayers) {
        Random rand = new Random();
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < numberPlayers; i++) {
            String name = "Player #".concat(String.valueOf(i + 1));
            float ranking = rand.nextFloat() * (100.0f - 1.0f) + 1.0f;
            players.add(new Player(name, ranking));
        }
        return players;
    }
}
