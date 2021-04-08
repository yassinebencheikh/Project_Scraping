/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Abdellah-Bencheikh
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import RDF.Load;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * FXML Controller class
 *
 * @author Abdellah-Bencheikh
 */
public class Controller {
    private String marque ;
    private String carburant ;
    private String prixmin ;
    private String prixmax ;
    private String annee ;
    private String km ;
    private String puissance ;
    private ArrayList<String> listproduit;
    //private Map<String,String> map;
    @FXML JFXTextField kmmaxTextField;
    @FXML JFXTextField prixminTextField;
    @FXML JFXTextField prixmaxTextField;
    @FXML JFXComboBox marqueComboBox;
    @FXML JFXComboBox carburantComboBox;
    @FXML JFXComboBox anneeComboBox;
    @FXML JFXComboBox puissanceComboBox;
    @FXML JFXTextArea  text;
    
ObservableList<String> marqueliste = FXCollections.observableArrayList("Alfa Romeo", "Audi", "BMW", "Ford", "Fiat","Ferrari","Dacia","Citroen");
ObservableList<String> carburantliste = FXCollections.observableArrayList("Diesel", "Essence", "Electrique", "LPG", "Hybride");
ObservableList<String> anneeliste = FXCollections.observableArrayList("2019", "2018", "2017", "2016", "2015","2014", "2013", "2012", "2011", "2010");
ObservableList<String> puissancetliste = FXCollections.observableArrayList("10CV", "11CV", "12CV", "13CV","14CV", "15CV", "16CV", "17CV", "18CV");

    
    /**
     * Initializes the controller class.
     * @param event
     * @throws java.io.IOException
     */
    public void Rechercher(ActionEvent event) throws IOException{
         text.clear();
         if(marqueComboBox.getSelectionModel().isEmpty()==false)
         {marque = marqueComboBox.getSelectionModel().getSelectedItem().toString();}
         else marque = "";
         if(carburantComboBox.getSelectionModel().isEmpty()==false){
         carburant = carburantComboBox.getSelectionModel().getSelectedItem().toString();}
         else carburant="";
         if(anneeComboBox.getSelectionModel().isEmpty()==false){
         annee = anneeComboBox.getSelectionModel().getSelectedItem().toString();}
         else annee="";
         if(puissanceComboBox.getSelectionModel().isEmpty()==false){
         puissance = puissanceComboBox.getSelectionModel().getSelectedItem().toString();}
         else puissance="";
         prixmin = prixminTextField.getText();
         prixmax = prixmaxTextField.getText();
         km = kmmaxTextField.getText() ;
         //map = new HashMap<>();
         
         ModelClass model = new ModelClass(marque,carburant,annee,prixmin,prixmax,km,puissance);

        
     // génére un fichier RDF
    // ModelRDF modelRdf = new ModelRDF(marque, carburant, prixmin, prixmax, anneemin, anneemax, kmmax, puissance);
    
    // Comparer les produit
     Load load = new Load(model);
     listproduit = new ArrayList<>(load.getListAllproduit());  
     initializeText(listproduit);   
    }
         
    public void initialize (){
        marqueComboBox.setItems(marqueliste);
        carburantComboBox.setItems(carburantliste );
        anneeComboBox.setItems(anneeliste );
        puissanceComboBox.setItems(puissancetliste );

}
    public void initializeText(ArrayList<String> list){
        for (String s : list){
           text.appendText(s);
    }    
    }
}