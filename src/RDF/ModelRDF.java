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


import java.io.FileWriter;
import java.io.IOException;
import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;


/**
 *
 * @author Abdellah-Bencheikh
 */
public class ModelRDF {
    private String marque;
    private String carburant;
    private float  prixmin;
    private float  prixmax;
    private String annee;
    private int    km;
    private String puissance;
    private String fileName = "C:/Users/Abdellah-Bencheikh/Documents/NetBeansProjects/Proget_web_semantique/output/modelRDF.rdf";
    
    public ModelRDF(String marque, String carburant, float prixmin, float prixmax, String annee, int km, String puissance) throws IOException{
       this.marque = marque;
       this.carburant = carburant;
       this.prixmin = prixmin;
       this.prixmax = prixmax;
       this.annee = annee;
       this.km = km;
       this.puissance = puissance;
        
        String BASE = "http://Projet_RDF/";
        // créer un modèle vide
        Model model = ModelFactory.createDefaultModel();
        model.setNsPrefix("mod", BASE);
        
        // créer la ressource
        Resource resource = model.createResource(BASE + "resource");
        
        // créers les propriétés
        Property propertyMarque = model.createProperty(BASE + "marque");
        Property propertyCarburant = model.createProperty(BASE + "carburant");
        Property propertyPrixmin = model.createProperty(BASE + "prixmin");
        Property propertyPrixmax = model.createProperty(BASE + "prixmax");
        Property propertyAnnee = model.createProperty(BASE + "annee");
        Property propertyKm = model.createProperty(BASE + "km");
        Property propertyPuissace = model.createProperty(BASE + "puissance");
        
        // créer les littéraux typés
        RDFNode marqueLiteral = model.createTypedLiteral(marque, XSDDatatype.XSDstring);
        RDFNode carburantLiteral = model.createTypedLiteral(carburant, XSDDatatype.XSDstring);
        RDFNode prixminLiteral = model.createTypedLiteral(prixmin, XSDDatatype.XSDfloat);
        RDFNode prixmaxLiteral = model.createTypedLiteral(prixmax, XSDDatatype.XSDfloat);
        RDFNode anneeLiteral = model.createTypedLiteral(annee, XSDDatatype.XSDstring);
        RDFNode kmLiteral = model.createTypedLiteral(km, XSDDatatype.XSDint);
        RDFNode puissanceLiteral = model.createTypedLiteral(puissance, XSDDatatype.XSDstring);
        
        // ajouter des propriétés en cascade
        resource.addProperty(propertyPuissace, puissanceLiteral).addProperty(propertyKm, kmLiteral).addProperty(propertyAnnee, anneeLiteral).addProperty(propertyPrixmax, prixmaxLiteral).addProperty(propertyPrixmin, prixminLiteral).addProperty(propertyCarburant, carburantLiteral).addProperty(propertyMarque, marqueLiteral);
        
        // affiche le modèle comme RDF/XML
       // model.write(new PrintWriter(System.out), "RDF/XML-ABBREV");
        
        try {
            // maintenant on écrit le modèle sous forme RDF dans un fichier
            FileWriter file = new FileWriter(fileName);
            model.write(file, "RDF/XML-ABBREV");
        }catch(IOException e){
        e.printStackTrace(); }   
    
    
    }
        
}
