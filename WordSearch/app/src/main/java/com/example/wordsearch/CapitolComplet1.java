package com.example.wordsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CapitolComplet1 extends AppCompatActivity {

    Button btnColecteaza1, btnUrmatorul1;
    TextView tvScorComplet1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitol_complet1);

        btnColecteaza1 = findViewById(R.id.btnColecteaza1);
        btnUrmatorul1 = findViewById(R.id.btnUrmatorul1);
        tvScorComplet1 = findViewById(R.id.tvScorComplet1);

        btnColecteaza1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvScorComplet1.setText("75 puncte");
                btnColecteaza1.setEnabled(false);
            }
        });

        btnUrmatorul1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CapitolComplet1.this, Nivel6.class);
                startActivity(intent);
            }
        });
    }
}