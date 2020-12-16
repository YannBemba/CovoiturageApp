package com.example.categoryapp.Controlleur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.categoryapp.Modele.Enseignant;
import com.example.categoryapp.R;
import com.google.android.material.textfield.TextInputLayout;

import www.sanju.motiontoast.MotionToast;

public class InscriptionActivity extends AppCompatActivity {

    //Variables
    private TextInputLayout pseudo, nomComplet, email, tel, mdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        pseudo = findViewById(R.id.pseudo);
        nomComplet = findViewById(R.id.nomComplet);
        email = findViewById(R.id.email);
        tel = findViewById(R.id.tel);
        mdp = findViewById(R.id.mdp);

    }

    private String getPseudo(){
        return pseudo.getEditText().getText().toString();
    }
    private String getNomComplet() {
        return nomComplet.getEditText().getText().toString();
    }
    private String getEmail(){
        return email.getEditText().getText().toString();
    }
    private String getTel(){
        return tel.getEditText().getText().toString();
    }
    private String getMdp() {
        return mdp.getEditText().getText().toString();
    }

    private boolean validerEmail(){
        String strEmail = getEmail().trim();

        if (strEmail.isEmpty()){
            email.setError("L'email doit être rempli");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }

    private boolean validerNomComplet() {
        String strNomComp = getNomComplet().trim();

        if(strNomComp.isEmpty()){
            nomComplet.setError("Le nom doit être rempli");
            return false;
        } else {
            nomComplet.setError(null);
            return true;
        }
    }

    private boolean validerPseudo() {
        String strPseudo = getPseudo().trim();

        if(strPseudo.isEmpty()) {
            pseudo.setError("Ce champ doit être rempli");
            return false;
        } else if (strPseudo.length() > 15) {
            pseudo.setError("Pseudo trop long");
            return false;
        } else {
            pseudo.setError(null);
            return true;
        }

    }

    private boolean validerTel() {
        String strTel = getTel().trim();

        if(strTel.isEmpty()){
            tel.setError("Ce champ doit être rempli");
            return false;
        } else {
            tel.setError(null);
            return true;
        }

    }

    private boolean validerMdp() {
        String strMdp = getMdp().trim();

        if(strMdp.isEmpty()){
            mdp.setError("Ce champ doit être rempli");
            return false;
        } else {
            mdp.setError(null);
            return true;
        }

    }

    public boolean valider(){
        return !(!validerEmail() | !validerMdp() | !validerNomComplet() |
                !validerPseudo() | !validerTel());
    }

    public void confirmerSaisie(View view) {

        Enseignant enseignant = new Enseignant(getPseudo(), getNomComplet(), getEmail(), getTel(), getMdp());
        Intent intent = new Intent(InscriptionActivity.this, ConnexionActivity.class);

        intent.putExtra("Enseignant", enseignant);

        String infoSaisie = "Pseudo : " + getPseudo();

        MotionToast.Companion.darkToast(this,
                "Inscription réussie",
                infoSaisie,
                MotionToast.TOAST_SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(this, R.font.helvetica_regular));

        startActivity(intent);


    }


}