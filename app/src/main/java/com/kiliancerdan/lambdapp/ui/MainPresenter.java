package com.kiliancerdan.lambdapp.ui;


import com.kiliancerdan.lambdapp.entity.Player;
import com.kiliancerdan.lambdapp.interactor.PlayersInteractor;
import com.kiliancerdan.lambdapp.interactor.SorterInteractor;

import java.util.List;

class MainPresenter implements PlayersInteractor.Callback, SorterInteractor.Callback {

    interface MainView {
        void refreshData(List<Player> players);
    }

    private PlayersInteractor playersInteractor;
    private SorterInteractor sorterInteractor;
    private MainView view;

    MainPresenter(MainView view) {
        this.view = view;
        this.playersInteractor = new PlayersInteractor(this);
        this.sorterInteractor = new SorterInteractor(this);
    }

    void getPlayers() {
        playersInteractor.getPlayers();
    }


    @Override
    public void providesPlayers(List<Player> players) {
        view.refreshData(players);
    }

    void sortPlayersByRanking(List<Player> players) {
        sorterInteractor.sortPlayer(players);
    }

    @Override
    public void playersSorter(List<Player> players) {
        view.refreshData(players);
    }

}
