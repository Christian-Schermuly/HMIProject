/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmiproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Christian Schermuly
 * MR 1060159
 * 
 * Quellen für Grafiken:
 * Background/Spielfeld: http://spielfibel.de/pics/pachisi-4er.jpg
 * Smily Figuren mit GIMP erstellt. Vorlage: https://image.spreadshirtmedia.net/image-server/v1/designs/7566415,width=178,height=178,version=1385982769/smile-smiley-.png
 *                                           https://image.spreadshirtmedia.net/imageserver/v1/designs/13769216,width=178,height=178,version=1385214804/sad-smiley-1c.png
 * Figur Spielermarkierung: http://www.connexxion24.com/images/product_images/info_images/1459_1-hamakegel-figure-gross-large-kunststoff-spielfiguren-red-rot.jpg
 * Figurset Alternatives Design mit Gimp Erstellt, Vorlage: https://t1.ftcdn.net/jpg/00/40/86/58/240_F_40865852_uwQLPi3DBcynNf5R3sHxWsnI1UeuYL0J.jpg
 * Würfel: http://de.bettermarks.com/wp-content/uploads/media/kem_StochW_StochWGLGB_2.jpg
 * 
 * 
 */


public class HMIProject extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
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
