package com.example.implementasiapi_10pplg1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    Button btnPremierLeague, btnSpanishLeague;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuv1); // ganti layout jadi menuv1

        btnPremierLeague = findViewById(R.id.btnPremiereLeague);
        btnSpanishLeague = findViewById(R.id.btnSpanishLeague);

        btnPremierLeague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pindah ke MainActivity dengan data "English Premier League"
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                intent.putExtra("league", "English Premier League");
                startActivity(intent);
            }
        });

        btnSpanishLeague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pindah ke MainActivity dengan data "Spanish La Liga"
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                intent.putExtra("league", "Spanish La Liga");
                startActivity(intent);
            }
        });
    }
}
