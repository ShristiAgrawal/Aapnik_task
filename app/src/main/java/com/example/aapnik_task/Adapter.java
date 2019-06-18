package com.example.aapnik_task;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
//private CardView cardView;
    //CardView c;
   private Context context;
   private List<itemlist> list;

    public Adapter(Context context, List<itemlist> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.items,viewGroup,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        user u=list.get(i).getU_list();


        Glide.with(context).load(u.getProfile_image()).into(viewHolder.i);

        // Glide.with(this).load("http://goo.gl/gEgYUd").into(imageView);
viewHolder.t1.setText("Answer count-"+String.valueOf(list.get(i).getAnswer_count()));
viewHolder.t2.setText("Question owner-"+u.getDisplay_name());
viewHolder.t3.setText("Creation date-"+list.get(i).getCreation_date());
viewHolder.t4.setText(list.get(i).getLink());
viewHolder.t5.setText("Score-"+String.valueOf(list.get(i).getScore()));
if(list.get(i).isIs_answered()==true)

    viewHolder.card.setCardBackgroundColor(Color.BLUE);
else viewHolder.card.setCardBackgroundColor(Color.BLACK);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView i;
        CardView card;
        TextView t1,t2,t3,t4,t5;
        ImageView iv;
        public ViewHolder(@NonNull View itemView) {


            super(itemView);
            i=itemView.findViewById(R.id.iv);
            card=itemView.findViewById(R.id.cv);
            t1=itemView.findViewById(R.id.tv1);
            t2=itemView.findViewById(R.id.tv2);
            t3=itemView.findViewById(R.id.tv3);
            t4=itemView.findViewById(R.id.tv4);
            t5=itemView.findViewById(R.id.tv5);

        }
    }
}
