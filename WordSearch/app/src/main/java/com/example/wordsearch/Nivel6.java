package com.example.wordsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Nivel6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel6);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Nivel6.this, CapitolComplet1.class);
        startActivity(intent);
    }
}