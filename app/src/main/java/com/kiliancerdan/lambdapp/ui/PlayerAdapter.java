package com.kiliancerdan.lambdapp.ui;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kiliancerdan.lambdapp.R;
import com.kiliancerdan.lambdapp.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerVH> {

    private List<Player> players;

    PlayerAdapter() {
        this.players = new ArrayList<>();
    }

    @Override
    public PlayerVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_item, parent, false);
        return new PlayerVH(view);
    }

    void setPlayers(List<Player> players) {
        this.players.clear();
        this.players.addAll(players);
    }

    List<Player> getPlayers() {
        return players;
    }

    @Override
    public void onBindViewHolder(PlayerVH holder, int position) {
        Player player = players.get(position);
        holder.setName(player.getName());
        holder.setRanking(String.format(Locale.getDefault(), "%.2f", player.getRanking()));
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    class PlayerVH extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvRanking;

        PlayerVH(View itemView) {
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.name);
            tvRanking = (TextView)itemView.findViewById(R.id.ranking);
        }

        void setName(String name) {
            tvName.setText(name);
        }

        void setRanking(String ranking) {
            tvRanking.setText("Ranking: ".concat(ranking));
        }

    }
}
