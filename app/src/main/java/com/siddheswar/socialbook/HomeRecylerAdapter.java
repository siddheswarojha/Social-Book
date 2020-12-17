package com.siddheswar.socialbook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class HomeRecylerAdapter extends RecyclerView.Adapter<HomeRecylerAdapter.HomeViewHolderRecyler> {
    public String data;

   public HomeRecylerAdapter(String data){
       this.data = data;
   }

    @NonNull
    @Override
    public HomeViewHolderRecyler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_home,parent,false);
        return new HomeViewHolderRecyler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeViewHolderRecyler holder, int position) {


    }

    @Override
    public int getItemCount() {
        return data.length();
    }

    public class HomeViewHolderRecyler extends RecyclerView.ViewHolder{
        TextView txtLikeCount,txtDislikeCount;
        ImageView imgIconLike, imgIconDislike,imgIconShare;
      CardView card;


        public HomeViewHolderRecyler(@NonNull View itemView) {
            super(itemView);
           txtLikeCount = itemView.findViewById(R.id.txtLikeCount);
           txtDislikeCount = itemView.findViewById(R.id.txtDislikeCount);
           imgIconDislike = itemView.findViewById(R.id.iconDislike);
           imgIconLike = itemView.findViewById(R.id.iconLike);
            card = itemView.findViewById(R.id.card);
        }
    }

}
