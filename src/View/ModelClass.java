/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Abdellah-Bencheikh
 */
public class ModelClass {
    private String marque;
    private String carburant;
    private String annee;
    private String prixmin;
    private String prixmax;
    private String km;
    private String puissance;
    private Map<String,String> map;

    public ModelClass(String marque, String carburant, String annee, String prixmin, String prixmax, String km, String puissance) {
        this.marque = marque;
        this.carburant = carburant;
        this.annee = annee;
        this.prixmin = prixmin;
        this.prixmax = prixmax;
        this.km = km;
        this.puissance = puissance;
        map = new HashMap();
        map.put("marque",this.marque);
        map.put("carburant",this.carburant);
        map.put("annee", this.annee);
        map.put("prixmin", this.prixmin);
        map.put("prixmax", this.prixmax);
        map.put("km", this.km);
        map.put("puissance", this.puissance);
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getPrixmin() {
        return prixmin;
    }

    public void setPrixmin(String prixmin) {
        this.prixmin = prixmin;
    }

    public String getPrixmax() {
        return prixmax;
    }

    public void setPrixmax(String prixmax) {
        this.prixmax = prixmax;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }
    
    

    
    
}
