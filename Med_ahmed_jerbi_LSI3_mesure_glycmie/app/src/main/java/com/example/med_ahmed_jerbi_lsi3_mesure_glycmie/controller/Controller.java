package com.example.med_ahmed_jerbi_lsi3_mesure_glycmie.controller;

import com.example.med_ahmed_jerbi_lsi3_mesure_glycmie.model.Patient;


public class Controller {
    public Patient patient; // Attribut de la classe Patient
    static Controller instance;

    public Controller(){
        super();
    }

    public void createPatient(int age,float valeurMesuree,boolean isFasting){
        Patient patient1= new Patient(20,0.5f,true);
    }


    // Méthode pour obtenir le résultat de l'analyse du niveau de glycémie
    public String getResponse() {
        return patient.getReponse();
    }
    public static final Controller getInstance(){
        if (Controller.instance==null){
            Controller cr = new Controller();
            return cr;
        }
        else
            return Controller.instance;
    }
}

