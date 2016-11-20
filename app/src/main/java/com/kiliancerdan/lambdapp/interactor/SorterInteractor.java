package com.kiliancerdan.lambdapp.interactor;

import com.kiliancerdan.lambdapp.entity.Player;

import java.util.Comparator;
import java.util.List;

public class SorterInteractor {

    public interface Callback {
        void playersSorter(List<Player> players);
    }

    private Callback callback;

    public SorterInteractor(Callback callback) {
        this.callback = callback;
    }

    public void sortPlayer(List<Player> players) {
        players.sort(getComparator());
        callback.playersSorter(players);
    }

    private Comparator<Player> getComparator() {
        return (player1, player2) -> {
            float player1Ranking = player1.getRanking();
            float player2Ranking = player2.getRanking();
            if (player1Ranking < player2Ranking)
                return -1;
            else if (player1Ranking > player2Ranking)
                return 1;
            else
                return player1.getName().compareTo(player2.getName()) * -1;
        };
    }
}
