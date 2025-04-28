package com.example.implementasiapi_10pplg1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private Context context;
    private List<Team> teamList;

    public TeamAdapter(Context context, List<Team> teamList) {
        this.context = context;
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_team, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team team = teamList.get(position);
        holder.tvTeamName.setText(team.getStrTeam());

        String imageUrl = team.getStrBadge();
        if (imageUrl != null && imageUrl.startsWith("//")) {
            imageUrl = "https:" + imageUrl;
        }

        Glide.with(context)
                .load(imageUrl)
                .apply(new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.placeholder)  // Your placeholder image
                        .error(R.drawable.error_image))     // Your error image
                .into(holder.ivTeamBadge);
        Picasso.get().load(team.getStrBadge()).into(holder.ivTeamBadge);

    }

    @Override
    public int getItemCount() {
        return teamList == null ? 0 : teamList.size();
    }

    public static class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView tvTeamName;
        ImageView ivTeamBadge;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTeamName = itemView.findViewById(R.id.tvTeamName);
            ivTeamBadge = itemView.findViewById(R.id.ivTeamBadge);
        }
    }
}
