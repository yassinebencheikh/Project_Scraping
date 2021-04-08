/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RDF;

/**
 *
 * @author Abdellah-Bencheikh
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import View.ModelClass;
import java.util.ArrayList;
import java.util.Map;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.util.FileManager;

/**
 *
 * @author Abdellah-Bencheikh
 */
public final class Load {
   
    private ArrayList <String> listAllproduit;

    public Load(ModelClass model) {
        
        listAllproduit = new ArrayList <> ();
        sparql(model.getMap(), this.listAllproduit);
        afficher(listAllproduit);
       
    }
    
static  void sparql(Map<String,String> map, ArrayList <String> listAllproduit){
        
            String query =" ";
	    String value;
            String key1;
            
	 for (String key : map.keySet()) {
                 value = map.get(key);    
                 
            if (value.isEmpty()==true) {
                    if(key.equals("prixmin")){
                        key1 = "prix";
                            if(map.get("prixmax").isEmpty()==false){
                               float prixmax = Float.parseFloat(map.get("prixmax"));
                                 query+=" ?x  mod:"+key1+"  ?"+key1+"."
                                         +"FILTER(?"+key1+ "<=" +prixmax+ ")";
                                 continue;}
                            else{ 
                                 query+=" ?x  mod:"+key1+"  ?"+key1 +".";
                                 continue;} 
                          }
                
                    if(key.equals("prixmax")){
                           continue;
                        }
                    else{  
                          query+=" ?x  mod:"+key+"  ?"+key +".";
                           continue;
                    }
            }	 
            else {   
                 if(key.equals("prixmin")){
                          key1 = "prix";
                            if(map.get("prixmax").isEmpty()==false){
                               float prixmin = Float.parseFloat(map.get("prixmin"));
                               float prixmax = Float.parseFloat(map.get("prixmax"));
                                query+=" ?x  mod:"+key1+"  ?"+key1+"."
                                         +"FILTER(?"+key1+ "<=" +prixmax+ " &&" + "?"+key1+ ">=" +prixmin+ ")";
                                continue;}
                            else{ 
                                 float prixmin = Float.parseFloat(map.get("prixmin"));
                                 query+=" ?x  mod:"+key1+"  ?"+key1 +"."
                                        +"FILTER(?"+key1+ ">=" +prixmin+ ")";
                                continue;}
                          }
                  if(key.equals("prixmax")){
                              continue;
                          } 
                  else{
                         query+=" ?x  mod:"+key+"  ?"+key+ " . ?x  mod:"+key+ " \""+value+"\" .";
                            continue;  }
                         
         }
         } 
                        
                  
        //charger le gestionnaire de fichier 
	FileManager.get().addLocatorClassLoader(Load.class.getClassLoader());
        // charger les données RDF dans un modèle 
	Model model = FileManager.get().loadModel("C:/Users/Abdellah-Bencheikh/Documents/NetBeansProjects/Projet_Web/output/data.rdf");
        
       
	String queryString  = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                              "PREFIX mod: <http://Projet_RDF/> " +
		              "SELECT * WHERE {"+query+"}";
     
            Query querys = QueryFactory.create(queryString);
            QueryExecution qexec = QueryExecutionFactory.create(querys, model);
            
            ResultSet results = qexec.execSelect();
		while (results.hasNext()){
                        //List<String>  listproduit = new ArrayList <String> ();
                        
			QuerySolution soln = results.nextSolution();
			Literal marqueL = soln.getLiteral("marque");
                        Literal carburantL = soln.getLiteral("carburant");
                        Literal prixL = soln.getLiteral("prix");
                        Literal anneeL = soln.getLiteral("annee");
                        Literal kmL = soln.getLiteral("km");
                        Literal puissanceL = soln.getLiteral("puissance");
                                
                      String text = "Name: "+marqueL.getString()+"\nCarburant : "+ carburantL.getString()+ "\nPrix : "+ prixL.getString()+"DH" + "\nAnnee : "+ anneeL.getString()+"\nKM : "+ kmL.getString()+ "Km" + "\nPuissance : "+ puissanceL.getString()+"\n"
                              +"-----------------------------------------------------------------------------\n";
    			
                       listAllproduit.add(text);
                      
                       }
                if(listAllproduit.size()==0){
                    listAllproduit.add("no product");
                }
                
                
                        
                }

    public ArrayList<String> getListAllproduit() {
        return listAllproduit;
    }

    public void setListAllproduit(ArrayList<String> listAllproduit) {
        this.listAllproduit = listAllproduit;
    }
public void afficher(ArrayList<String> list){
    for (String s : list){
    System.out.println(s);
    }
}

}