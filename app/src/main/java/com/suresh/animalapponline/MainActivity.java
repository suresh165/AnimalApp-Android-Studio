package com.suresh.animalapponline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimalAdapter.MyClickInterface {

    RecyclerView recyclerView;
    ArrayList<Animal> animals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        animals = new ArrayList<>();

        animals.add(new Animal("Dog",R.drawable.dog));
        animals.add(new Animal("butterfly",R.drawable.butterfly));
        animals.add(new Animal("Dove",R.drawable.dove));
        animals.add(new Animal("fish",R.drawable.fish));
        animals.add(new Animal("parrot",R.drawable.parrot));
        animals.add(new Animal("rabbit",R.drawable.rabbit));
        animals.add(new Animal("tiger",R.drawable.tiger));

        AnimalAdapter animalAdapter = new AnimalAdapter(animals,this,this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(animalAdapter);
    }

    @Override
    public void onItemClick(int positionTheAnimal) {
        Toast.makeText(this, "Clicked"+animals.get(positionTheAnimal).getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,AnimalInfo.class);
        intent.putExtra("image",animals.get(positionTheAnimal).getImage());
        intent.putExtra("name",animals.get(positionTheAnimal).getName());
        startActivity(intent);
    }
}