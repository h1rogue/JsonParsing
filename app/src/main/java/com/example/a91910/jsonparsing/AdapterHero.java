package com.example.a91910.jsonparsing;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterHero extends RecyclerView.Adapter<AdapterHero.MyViewHolder> {

    private List<Hero> herolists;
    private Context context;

    public AdapterHero(List<Hero> herolists, Context context) {
        this.herolists = herolists;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view=LayoutInflater.from(context).inflate(R.layout.list_items,viewGroup,false);
       return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
     Hero hero=herolists.get(i);
     myViewHolder.nametext.setText(hero.getName());
        myViewHolder.realnametext.setText(hero.getRealname());
        myViewHolder.teamname.setText(hero.getTeam());
        myViewHolder.firstappe.setText(hero.getCreatedby());
        myViewHolder.publis.setText(hero.getPublisher());
        myViewHolder.bio.setText(hero.getBio());
        Picasso.get().load(hero.getImageurl()).into(myViewHolder.image);
    }

    @Override
    public int getItemCount() {
        return herolists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nametext;
        private TextView realnametext;
        private TextView teamname;
        private TextView firstappe;
        private TextView createdby;
        private TextView publis;
        private TextView bio;
        private ImageView image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nametext=itemView.findViewById(R.id.name);
            realnametext=itemView.findViewById(R.id.realname);
            teamname=itemView.findViewById(R.id.team);
            firstappe=itemView.findViewById(R.id.firstapperance);
            createdby=itemView.findViewById(R.id.createdby);
            publis=itemView.findViewById(R.id.publisher);
            bio=itemView.findViewById(R.id.bio);
            image=itemView.findViewById(R.id.imageview);
        }
    }
}
