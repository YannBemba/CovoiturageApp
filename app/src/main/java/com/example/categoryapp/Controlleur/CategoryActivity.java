package com.example.categoryapp.Controlleur;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.categoryapp.R;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Button inscription, connexion, apropos;

        inscription = findViewById(R.id.inscription);
        connexion = findViewById(R.id.connexion);
        apropos = findViewById(R.id.apropos);

        inscription.setOnClickListener(this);
        connexion.setOnClickListener(this);
        apropos.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.inscription :
                Intent intentInscription = new Intent(CategoryActivity.this, InscriptionActivity.class);
                startActivity(intentInscription);
                Toast.makeText(this, "Inscription", Toast.LENGTH_SHORT).show();
                break;

            case R.id.connexion:
                Intent intentConnexion = new Intent(CategoryActivity.this, ConnexionActivity.class);
                startActivity(intentConnexion);
                Toast.makeText(this, "Connexion", Toast.LENGTH_SHORT).show();
                break;

            case R.id.apropos:
                Intent intentAPropos = new Intent(CategoryActivity.this, AboutActivity.class);
                startActivity(intentAPropos);
                Toast.makeText(this, "A propos", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}