package com.example.categoryapp.Controlleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.categoryapp.Modele.Enseignant;
import com.example.categoryapp.R;
import com.google.android.material.textfield.TextInputLayout;

public class ConnexionActivity extends AppCompatActivity {

    private TextInputLayout pseudoCo, mdpCo;
    Enseignant enseignant = this.getIntent().getParcelableExtra("Enseignant");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        pseudoCo = (TextInputLayout) findViewById(R.id.pseudoCo);
        mdpCo = (TextInputLayout) findViewById(R.id.mdpCo);

    }

    private String getPseudoCo(){
        return pseudoCo.getEditText().getText().toString();
    }
    private String getMdpCo() {
        return mdpCo.getEditText().getText().toString();
    }

    private boolean validerPseudoCo(){
        String strPseudoCo = getPseudoCo().trim();

        if(strPseudoCo.isEmpty()){
            pseudoCo.setError("Ce champ doit être rempli");
            return false;
        } else {
            pseudoCo.setError(null);
            return true;
        }

    }

    private boolean validerMdpCo() {
        String strMdpCo = getMdpCo().trim();

        if(strMdpCo.isEmpty()){
            mdpCo.setError("Ce champ doit être rempli");
            return false;
        } else {
            mdpCo.setError(null);
            return true;
        }

    }

    private String recupPseudoInscription(){
        return enseignant.getPseudo();
    }

    private String recupMdpInscription(){
        return enseignant.getMdp();
    }

    private boolean validerSaisie(){
        return !(!validerPseudoCo() | !validerMdpCo());
    }

    public void seConnecter(View view) {

        if(getPseudoCo().equals(recupPseudoInscription()) && getMdpCo().equals(recupMdpInscription())){
            Intent intent = new Intent(this, CategoryActivity.class);
            startActivity(intent);
        }

    }
}