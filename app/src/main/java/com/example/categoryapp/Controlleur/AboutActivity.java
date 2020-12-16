package com.example.categoryapp.Controlleur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.categoryapp.Modele.Enseignant;
import com.example.categoryapp.R;

import java.util.ArrayList;
import java.util.List;

public class AboutActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_propos);

        List<Enseignant> lesEnseignants = Enseignant.getEnseignants();
        spinner = findViewById(R.id.spinLisEnseignant);

        ArrayAdapter<Enseignant> adapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,
                lesEnseignants);

        spinner.setAdapter(adapter);
    }
}