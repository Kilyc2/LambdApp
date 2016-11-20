package com.kiliancerdan.lambdapp.interactor;

import com.kiliancerdan.lambdapp.entity.Player;
import com.kiliancerdan.lambdapp.repository.PlayersRepository;

import java.util.List;

public class PlayersInteractor {

    public interface Callback {
        void providesPlayers(List<Player> players);
    }

    private PlayersRepository repository;
    private Callback callback;

    public PlayersInteractor(Callback callback) {
        repository = new PlayersRepository();
        this.callback = callback;
    }

    public void getPlayers() {
        callback.providesPlayers(repository.getPlayers(100));
    }
}
