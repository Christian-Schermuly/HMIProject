/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmiproject;

/**
 *
 * @author Chris
 * 
 * Class fuer Schachspiel
 * 
 * 
 */
public class Chess {
    public int[][] field = new int[8][8]; // Spielfeld
    
    Chess(){
        setField();
        showField();
    }
    
    public void setField(){
        /*
        
        XY = Figur
        X = Farbe
        Y = Model
        
        Farbe:
        1 = Weis
        2 = Schwarz
        
        Model:
        
        1 = König
        2 = Dame
        3 = Läufer
        4 = Springer
        5 = Turm
        6 = Bauer
        
        */
        
        //Feld zurück setzen
        for(int i = 0; i<8;i++){
            for(int j = 0; j<8;j++){
                field[i][j] = 0;
   
               
            }
        }
        
        //Bauern verpflichten
        for(int i = 0; i<8; i++){
            field[1][i] = 26;
            field[6][i] = 16; 
        }
        //Türmchen bauen
        field[0][0] = 25;
        field[0][7] = 25;
        field[7][0] = 15;
        field[7][7] = 15;
        //Springerlein verteilen
        field[0][1] = 24;
        field[0][6] = 24;
        field[7][1] = 24;
        field[7][6] = 24;
        //Pfaffen platzieren
        field[0][2] = 23;
        field[0][5] = 23;
        field[7][2] = 23;
        field[7][5] = 23;
        //Dame ausführen
        field[0][3] = 22;
        field[7][3] = 12;
        //König aufstellen
        field[0][4] = 21;
        field[7][4] = 11;
        
    }
    //Test-Methode zur ausgabe des Spielfelds auf der Konsole
    public void showField(){
        for(int i = 0; i<8;i++){
            String ausgabe = "";
            for(int j = 0; j<8;j++){
               ausgabe = ausgabe + field[i][j] + " ";
            }
            System.out.println(ausgabe);
        }
        
        
 
}
    
}
