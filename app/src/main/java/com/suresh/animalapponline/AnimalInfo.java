package com.suresh.animalapponline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalInfo extends AppCompatActivity {

    ImageView img;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_info);

        img = findViewById(R.id.imgClick);
        txt = findViewById(R.id.animal);

        Intent intent = getIntent();

        img.setImageResource(intent.getIntExtra("Image",R.drawable.ic_launcher_foreground));
        txt.setText(intent.getStringExtra("name"));
    }
}