package com.suresh.animalapponline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalRowHolder> {

    ArrayList<Animal> AnimalData;
    Context context;
    MyClickInterface myClickInterface;

    public AnimalAdapter(ArrayList<Animal> AnimalData, Context context, MyClickInterface myClickInterface){
        this.context = context;
        this.AnimalData = AnimalData;
        this.myClickInterface = myClickInterface;
    }


    @NonNull
    @Override
    public AnimalRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.animal_row,parent,false);
        return new AnimalRowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalRowHolder holder, int position) {
        holder.textAnimalName.setText(AnimalData.get(position).getName());
        holder.ImageAnimal.setImageResource(AnimalData.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return AnimalData.size();
    }

    class AnimalRowHolder extends RecyclerView.ViewHolder{
        TextView textAnimalName;
        ImageView ImageAnimal;

        public AnimalRowHolder(@NonNull View itemView) {
            super(itemView);

            textAnimalName = itemView.findViewById(R.id.textAnimalName);
            ImageAnimal = itemView.findViewById(R.id.img_animal);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myClickInterface.onItemClick(getAdapterPosition());
                }
            });
        }
    }
    interface MyClickInterface{
        void onItemClick(int positionTheAnimal);
    }
}
