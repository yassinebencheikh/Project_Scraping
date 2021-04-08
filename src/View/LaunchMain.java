package View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Abdellah-Bencheikh
 */
public class LaunchMain extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane = FXMLLoader.load(getClass().getResource("View.fxml"));
        Scene scene = new Scene(anchorPane);
        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.resizableProperty().set(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
