package com.example.categoryapp.Modele;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Enseignant implements Parcelable {

    private static int id = 0;
    private String pseudo;
    private String nomComplet;
    private String email;
    private String telephone;
    private String mdp;

    private static List<Enseignant> enseignants = new ArrayList<>();

    public Enseignant(String strPseudo, String strNomComplet, String strEmail, String strTel, String strMdp){
        this.pseudo = strPseudo;
        this.nomComplet = strNomComplet;
        this.email = strEmail;
        this.telephone = strTel;
        this.mdp = strMdp;
        id++;
        this.addEnseigant();
    }

    //GETTER

    public int getId() {
        return id;
    }
    public String getPseudo() {
        return pseudo;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public String getEmail() {
        return email;
    }
    public String getTelephone() { return telephone; }
    public String getMdp() { return mdp; }

    public static List<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void addEnseigant() {
        enseignants.add(new Enseignant(pseudo, nomComplet, email, telephone, mdp));
    }
    //SETTER

    public static final Creator<Enseignant> CREATOR = new Creator<Enseignant>() {
        @Override
        public Enseignant createFromParcel(Parcel in) {
            return new Enseignant(in);
        }

        @Override
        public Enseignant[] newArray(int size) {
            return new Enseignant[size];
        }
    };

    protected Enseignant(Parcel in) {
        if (in.readByte() == 0) {
            id = 0;
        } else {
            id = in.readInt();
        }
        pseudo = in.readString();
        nomComplet = in.readString();
        email = in.readString();
        telephone = in.readString();
        mdp = in.readString();
    }

    @Override
    public String toString() {
        return "Enseignant{" +
                "id=" + id +
                ", pseudo='" + pseudo + '\'' +
                ", nomComplet='" + nomComplet + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pseudo);
        dest.writeString(nomComplet);
        dest.writeString(email);
        dest.writeString(telephone);
        dest.writeString(mdp);
    }

}
