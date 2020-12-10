package com.example.categoryapp.Controlleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.categoryapp.Modele.Enseignant;
import com.example.categoryapp.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class ConnexionActivity extends AppCompatActivity {

    TextInputLayout pseudoCo, mdpCo;

    public  Enseignant enseignantCo = this.getIntent().getParcelableExtra("Enseignant");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        pseudoCo = findViewById(R.id.pseudoCo);
        mdpCo = findViewById(R.id.mdpCo);


    }

    private String getPseudoCo(){
        return pseudoCo.getEditText().getText().toString();
    }

    private String getMdpCo(){
        return mdpCo.getEditText().getText().toString();
    }

    private boolean verifierPseudoCo(){
        String pseudo = enseignantCo.getPseudo();

        if(validerPseudo()) {
            if (getPseudoCo().equals(pseudo)) {
                return true;
            }
        }
        return false;

    }

    private boolean verifierMdpCo() {
        String mdp = enseignantCo.getMdp();

        if(validerMdp()) {
            if (getMdpCo().equals(mdp)) {
                return true;
            }
        }
        return false;

    }

    private boolean validerPseudo(){

        if(getPseudoCo().trim().isEmpty()){
            pseudoCo.setError("Ce champ doit être rempli");
            return false;
        } else {
            pseudoCo.setError(null);
            return true;
        }

    }

    private boolean validerMdp(){
        if(getMdpCo().trim().isEmpty()){
            mdpCo.setError("Ce champ doit être rempli");
            return false;
        } else {
            mdpCo.setError(null);
            return true;
        }
    }


    public void seConnecter(View view) {

        String pseudo = getPseudoCo();
        String mdp = getMdpCo();

        Enseignant enseignant = this.getIntent().getParcelableExtra("Enseignant");

        if(!verifierPseudoCo() && !verifierMdpCo()){
            return;
        } else {
            Intent intent = new Intent(ConnexionActivity.this, ConnexionReussieActivity.class);
            startActivity(intent);
            finish();
        }

    }
}