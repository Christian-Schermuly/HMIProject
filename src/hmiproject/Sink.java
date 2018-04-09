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
 * Klasse für Schiffe versenken
 */
public class Sink {
    
    Dice dice = new Dice();
    
    public int[][] seazoneBlue = new int[10][10]; //Spielfeld für Spieler Blau
    public int[][] seazoneRed = new int[10][10];  //Spielfeld für Spieler Rot
        
    Sink(){
        clearBattlefield();
        getRedField();
        getBlueField();
        
    }
    
    private void clearBattlefield(){
        clearRedField();
        clearBlueField();
        
        System.out.println("Sink: The Battlefield has been cleared!");
        
    }
    
    private void clearRedField(){
        for(int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                seazoneRed[i][j]=0;
            }
        }
        
    }
    
        private void clearBlueField(){
        for(int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                seazoneBlue[i][j]=0;
            }
        }
        
    }
        
        private void getRedField(){
            System.out.println("Seazone Red:");
            String row = "";
            for(int i = 0; i<10; i++){
                System.out.println("");
                for(int j = 0; j < 10; j++){
                    row = row + " " + seazoneRed[i][j];
                }
                System.out.println(row);
                row = "";
            }
        }
        
                private void getBlueField(){
            System.out.println("Seazone Blue:");
            String row = "";
            for(int i = 0; i<10; i++){
                System.out.println("");
                for(int j = 0; j < 10; j++){
                    row = row + " " + seazoneRed[i][j];
                }
                System.out.println(row);
                row = "";
            }
        }
    

    public void deployAIFleet(){
        deployAIBattleship(1);
     //   deployAICruiser(1);
    //    deployAICruiser(2);
        getRedField();
    }
   //Positionierung des AI-Battleships
    private void deployAIBattleship(int counter){
        System.out.println("Deploying AI Battleship");
        boolean deploying = true;
        while(deploying){
            boolean diagonal = dice.bool();
            int x = 0;
            int y = 0;
            
            //Check ob man an die bande stößt
            
            if(diagonal){
                x = dice.d5();
                y = dice.d10();
                
            } else {
                x = dice.d10();
                y = dice.d5();
            }


        System.out.println("X = " + x + " Y = " + y + " diagonal = " + diagonal);
        if(checkSpaceRed(x, y, 5, diagonal)){
            deployRed(x,y,5,counter,diagonal);
            deploying = false;
        }
        
        
        //deploying = false;
        }

        
    }
    

    
    private void deployRed(int x, int y, int type, int number, boolean diagonal){
        int write = Integer.parseInt("" +type + number);
        System.out.println(write);
        if(diagonal){
            for(int i = x-1; i < x + type-1; i++){
                seazoneRed[i][y] = write;
            }
        }else{
            for(int i = y-1; i < y + type-1; i++){
                seazoneRed[x][i] = write;
            }
        }
    }

    
    private boolean checkSpaceRed(int x, int y, int length, boolean diagonal){
        if(diagonal){
            for(int i = x-1; i<x+length-1; i++){
                System.out.println(seazoneRed[i][y]);
                if(seazoneRed[i][y] == 0){
                    System.out.println("Frei");
                    return false;
                } else {
                    System.out.println("Frei");
                }
            }
        } else {
            for(int i = y-1; i<y+length-1; i++){
                System.out.println(seazoneRed[x][i]);
                if(seazoneRed[x][i] != 0){
                    System.out.println("Leider schon belegt");
                }else{
                    System.out.println("frei");
                }
            }
        }

        return true;
        
    }
    
    
    
    
            
}
