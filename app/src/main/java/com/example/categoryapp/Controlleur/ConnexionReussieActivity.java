package com.example.categoryapp.Controlleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;
import com.example.categoryapp.R;

public class ConnexionReussieActivity extends AppCompatActivity {

    private static int TIME = 2000;

    LottieAnimationView mLottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion_reussie);

        mLottieAnimationView = findViewById(R.id.animation_success);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ConnexionReussieActivity.this, CategoryActivity.class);
                startActivity(intent);
                finish();
            }
        }, TIME);

    }



}