/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atoudeft.entites;

/**
 *
 * @author usager
 */
public class Monnaie {
    private String monnaie;
    private float valeur;
    public Monnaie()
	{
		this("", 0);
	}
    public Monnaie(String monnaie, float valeur) {
        this.monnaie = monnaie;
        this.valeur = valeur;
    }
    public String getMonnaie() {
        return monnaie;
    }

    public void setMonnaie(String monnaie) {
        this.monnaie = monnaie;
    }

    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }
    
}
