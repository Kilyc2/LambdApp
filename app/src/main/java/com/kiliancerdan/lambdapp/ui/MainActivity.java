package com.kiliancerdan.lambdapp.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kiliancerdan.lambdapp.R;
import com.kiliancerdan.lambdapp.entity.Player;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainPresenter.MainView {

    MainPresenter presenter;

    RecyclerView playerList;
    PlayerAdapter adapter;
    FloatingActionButton sorter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerList = (RecyclerView)findViewById(R.id.player_list);
        playerList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PlayerAdapter();
        playerList.setAdapter(adapter);
        sorter = (FloatingActionButton)findViewById(R.id.fab);
        sorter.setOnClickListener(v -> presenter.sortPlayersByRanking(adapter.getPlayers()));
        presenter = new MainPresenter(this);
        presenter.getPlayers();
    }

    @Override
    public void refreshData(List<Player> players) {
        if (adapter.getItemCount() == 0) {
            adapter.setPlayers(players);
        }
        adapter.notifyDataSetChanged();
    }
}
