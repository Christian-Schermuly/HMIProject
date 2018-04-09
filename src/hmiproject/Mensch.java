/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmiproject;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Chris
 * 
 * Klasse für Spiel "Mensch ärgere dich nicht"
 */
public class Mensch {
    //einbinden des Würfels
    Dice Dice = new Dice();
    //Nötige Variablen für den Spielablauf
    boolean canBeat;  //Aktueller Spieler kann Figur schlagen
    boolean usedDice; //Es wurde bereits gewürfelt
    boolean movemode; //Es kann gezogen werfen
    boolean homezonemode; //Es kann eine Figur ins Ziel gebracht werden
    int AI = 4; //Anzahl der Menschlichen u. AI Spieler
    int dice; //Ablage für Würfelergebnis
    int desti; //Mögliches Zielfeld der Figur
    int loc; //Startfeld der gewählten Figur
    int homezone;
    int[] win = new int[4];
    private int activePlayer; //Welcher Spieler ist gerade am Zug
    private String design; //Auswahl des FigurenDesign: Todo: Figurendesign!
    int[] field = new int[40]; //das Spielfeld
    int[] startR = new int[4]; //Rotes Startgebiet
    int[] startG = new int[4]; //Grünes Startgebiet
    int[] startY = new int[4]; //Gelbes Startgebiet
    int[] startB = new int[4]; //Blaues Startgebiet
    int[][] home = new int[4][4]; //Homezones
    int[] start = new int[4];
    int[] posR = new int[5];
    int[] posG = new int[5];
    int[] posY = new int[5];
    int[] posB = new int[5];
    
    /*
    Sounds. Quelle Siehe Controller
    */
    
    Media soundMove = new Media(new File("src/hmiproject/Sounds/move.wav").toURI().toString());
    MediaPlayer mpMove = new MediaPlayer(soundMove);
    
    Media soundBeat = new Media(new File("src/hmiproject/Sounds/beat.wav").toURI().toString());
    MediaPlayer mpBeat = new MediaPlayer(soundBeat);
    
    /*
    Statistiken für Siegesbildschirm

    */
    int[] statWurf = new int[4];
    int[] statDist = new int[4];
    int[] statKill = new int[4];
    int[] statDeploy = new int[4];
    
    
    
    
    Mensch(){
        design = changeDesign();
        clearField();
    }
    //AI-Zug
    public int AIRound(){
        if(activePlayer == 2){
                 if(field[10] == 21){
                 return 10;
                }
            if(posG[0]==1){
                for(int i = 1; i<5;i++){
                     if(posG[i] != 100){
                          return posG[i];
                                }
                            }
          
                        }
            if(posG[0]==2){
                int d = Dice.d2();
                int c = 1;
                for(int i = 1; i<5;i++){
                     if(posG[i] != 100){
                         if(c == d){
                          return posG[i];
                                }else{
                             c++;
                         }
                    }
                }
            }
            if(posG[0]==3){
                int d = Dice.d3();
                int c = 1;
                for(int i = 1; i<5;i++){
                     if(posG[i] != 100){
                         if(c == d){
                          return posG[i];
                                }else{
                             c++;
                         }
                    }
                }
            }
            if(posG[0]== 4){
                int d = Dice.d4();
                int c = 1;
                for(int i = 1; i<5;i++){
                     if(posG[i] != 100){
                         if(c == d){
                          return posG[i];
                                }else{
                             c++;
                         }
                    }
                }
            }
            
        }
        
            if(activePlayer == 3){
                if(field[20] == 31){
                    return 20;
                }
                    if(posG[0] == 1 ){
                for(int i = 1; i<5;i++){
                     if(posG[i] != 100){
                          return posG[i];
                                }
                            }
          
                        }
            if(posG[0]==2){
                int d = Dice.d2();
                int c = 1;
                for(int i = 1; i<5;i++){
                     if(posG[i] != 100){
                         if(c == d){
                          return posG[i];
                                }else{
                             c++;
                         }
                    }
                }
            }
            if(posG[0]==3){
                int d = Dice.d3();
                int c = 1;
                for(int i = 1; i<5;i++){
                     if(posG[i] != 100){
                         if(c == d){
                          return posG[i];
                                }else{
                             c++;
                         }
                    }
                }
            }
            if(posG[0]== 4){
                int d = Dice.d4();
                int c = 1;
                for(int i = 1; i<5;i++){
                     if(posG[i] != 100){
                         if(c == d){
                          return posG[i];
                                }else{
                             c++;
                         }
                    }
                }
            }
                
        }
            
                    
            
        
            if(activePlayer == 4){
                if(field[30] == 41){
                return 30;
                }
                if(posB[0] == 1){
                for(int i = 1; i<5;i++){
                     if(posG[i] != 100){
                          return posG[i];
                                }
                            }
          
                        }
            if(posG[0]==2){
                int d = Dice.d2();
                int c = 1;
                for(int i = 1; i<5;i++){
                     if(posG[i] != 100){
                         if(c == d){
                          return posG[i];
                                }else{
                             c++;
                         }
                    }
                }
            }
            if(posG[0]==3){
                int d = Dice.d3();
                int c = 1;
                for(int i = 1; i<5;i++){
                     if(posG[i] != 100){
                         if(c == d){
                          return posG[i];
                                }else{
                             c++;
                         }
                    }
                }
            }
            if(posG[0]== 4){
                int d = Dice.d4();
                int c = 1;
                for(int i = 1; i<5;i++){
                     if(posG[i] != 100){
                         if(c == d){
                          return posG[i];
                                }else{
                             c++;
                         }
                    }
                }
            }
        }
                
        
        
        return 100;
    }
    //Würfelwurf
    public int throwDice(){
        if(usedDice){
            return 0;
        }else{
            usedDice = true;
            dice = Dice.d6();
            statWurf[activePlayer-1] = statWurf[activePlayer-1] + dice;
            return dice;     
        }
    }
    
    boolean getGewurfelt(){
        return usedDice;
    }
    //Figur kann die Startzone verlassen.
    boolean canLaunch(){
        System.out.println(dice);
        System.out.println(usedDice);
        if(dice == 6 && usedDice){
            System.out.println("pass1");
            System.out.println(activePlayer);
            System.out.println(start[3]);
            System.out.println(field[30]);
            if(activePlayer == 1 && field[0] == 1 && start[0] > 0){
                if(posR[0] <4){
               return true;
                }
           }
            if(activePlayer == 2 && field[10] == 2 && start[1] > 0){                
                if(posR[0] <4){
               return true;
                }
           }
           if(activePlayer == 3 && field[20] == 3 && start[2] > 0){
                    if(posR[0] <4){
               return true;
                }
            }
           if(activePlayer == 4 && field[30] == 4 && start[3] > 0){
                    if(posR[0] <4){
               return true;
                }
            }
        }
        return false;
    }
    
    
    int getPlayer(){
        return activePlayer;
    }
    
    public int getDice(){
        return dice;
    }
        //Räumt das Feld auf. Herstellen das Start-Zustandes
    public void clearField(){
        for(int i = 0; i < 40; i++){
            field[i] = 0;
        }
        field[0] = 1;
        field[10] = 2;
        field[20] = 3;
        field[30] = 4;
        posR[0] = 0;
        posY[0] = 0;
        posG[0] = 0;
        posB[0] = 0;
        
        for(int i = 0; i<4; i++){
            startR[i] = 11;
            startG[i] = 21;
            startY[i] = 31;
            startB[i] = 41;
            start[i] = 4;
            home[0][i] = 14;
            home[1][i] = 24;
            home[2][i] = 34;
            home[3][i] = 44;
            
            
            posR[i+1] = 100;
            posY[i+1] = 100;
            posG[i+1] = 100;
            posB[i+1] = 100;
            
            statWurf[i] = 0;
            statDist[i] = 0;
            statKill[i] = 0;
            statDeploy[i] = 0;
                    
        }
        usedDice = false;
        canBeat = false;
        activePlayer = 1;
        
    }
    public int getDesti(){
        return desti;
    }
    //Anzeige des Zielpunktes der ausgewählten Figur
    public int[] showMoveRange(int pos){
        canBeat = false;
        int[] move = field.clone();
        loc = pos;
        homezone = loc + dice;
        System.out.println("Homezone " + homezone);
        if(activePlayer == 1 && homezone > 39){
            System.out.println("ENTER ZE ZONE");
            for(int i = loc; i < 40;i++){
                move[i] = (activePlayer*10)+2;
            }
            homezone = homezone - 39;
            System.out.println("INTO ZE ZONE" + homezone);
            homezonemode = true;
            return move;
        }
        if(activePlayer == 2 && homezone > 9 && loc < 10){
            System.out.println("ENTER ZE ZONE");
            for(int i = loc; i < 10;i++){
                move[i] = (activePlayer*10)+2;
            }
            homezone = homezone - 9;
            System.out.println("INTO ZE ZONE" + homezone);
            homezonemode = true;
            return move;
        }
        if(activePlayer == 3 && homezone > 19 && loc < 20){
            System.out.println("ENTER ZE ZONE");
            for(int i = loc; i < 20;i++){
                move[i] = (activePlayer*10)+2;
            }
            homezone = homezone - 19;
            System.out.println("INTO ZE ZONE" + homezone);
            homezonemode = true;
            return move;
        }
        if(activePlayer == 4 && homezone > 29 && loc < 30){
            System.out.println("ENTER ZE ZONE");
            for(int i = loc; i < 30;i++){
                move[i] = (activePlayer*10)+2;
            }
            homezone = homezone - 29;
            System.out.println("INTO ZE ZONE" + homezone);
            homezonemode = true;
            return move;
        }
        for(int i = dice; i > 1; i--){
            if(pos == 39){
                pos = 0;
            }
            else{
                pos++;
                move[pos] = (activePlayer*10)+2;
            }

          }
        pos++;
        if(move[pos] > 10){
            move[pos] = move[pos]+2;
            canBeat = true;
        }else{
            move[pos] = (activePlayer*10)+2; 
        }
        desti = pos;
        movemode = true;
        System.out.println("Desti " + desti);
        return move;
    }
    //Methode zum Schlagen einer Spielfigur. \o/
    public void beat(int victim){
        start[victim]++;
        mpBeat.play();
        System.out.println("geschlagen wurde " + victim + "Desti " + desti);
        if(victim == 0){
            posR[0]--;
            for(int i = 0; i<5;i++){
                System.out.println(posR[i]);
            }
            
            for(int i = 0;i<4;i++){
                if(posR[i+1] == desti){
                    System.out.println("position" + i +" zurück gesetzt" + posR[i+i]);
                    posR[i+1] = 100;
                }
                if(startR[i]<10){
                    startR[i] = 13;
                    i = i+5;
                }
            }
        }
        if(victim == 1){
            posG[0]--;
            for(int i = 0; i<5;i++){
                System.out.println(posG[i]);
            }
            
            
            for(int i = 0;i<4;i++){
                if(posG[i+1] == desti){
                    System.out.println("position" + i +" zurück gesetzt" + posG[i+i]);
                    posG[i+1] = 100;
                }
                
                if(startG[i]<10){
                    startG[i] = 23;
                    i = i+5;
                }
            }
        }
        if(victim == 2){
            posY[0]--;
            for(int i = 0; i<5;i++){
                System.out.println(posY[i]);
            }
            
            for(int i = 0;i<4;i++){
                if(posY[i+1] == desti){
                    System.out.println("position" + i +" zurück gesetzt" + posY[i+i]);
                    posY[i+1] = 100;
                }
                if(startY[i]<10){
                    startY[i] = 33;
                    i = i+5;
                }
            }
        }
        if(victim == 3){
            posB[0]--;
            for(int i = 0; i<5;i++){
                System.out.println(posB[i]);
            }
            
            for(int i = 0;i<4;i++){
                if(posB[i+1] == desti){
                    System.out.println("position" + i +" zurück gesetzt" + posB[i+i]);
                    posB[i+1] = 100;
                }
                if(startB[i]<10){
                    startB[i] = 43;
                    i = i+5;
                }
            }
        }
    }
    //Bewegen einer Spielfigur
    public void move(int start){
        mpMove.stop();
        mpMove.play();
        System.out.println("LOC" + loc);
        field[loc] = 0;
        if(activePlayer == 1){
            for(int i=1;i<5;i++){
                if(posR[i]== loc){
                    posR[i] = desti;
                }
            }
        }
            if(activePlayer == 2){
            for(int i=1;i<5;i++){
                if(posG[i]== loc){
                    posG[i] = desti;
                }
            }
            }
            if(activePlayer == 3){
            for(int i=1;i<5;i++){
                if(posY[i]== loc){
                    posY[i] = desti;
                }
            }
            }
            if(activePlayer == 4){
            for(int i=1;i<5;i++){
                if(posB[i]== loc){
                    posB[i] = desti;
                }
            }
        }
    
        if(canBeat){
            int rage = (field[desti]-2)/10;
            beat(rage--);
            
        }
        if(loc == 0){
            field[loc] = 1;
        }
        if(loc == 10){
            field[loc] = 2;
        }
        if(loc == 20){
            field[loc] = 3;
        }
        if(loc == 30){
            field[loc] = 4;
        }
        field[desti] = (activePlayer*10)+1;
    }
    
    public boolean getMoveMode(){
        return movemode;
    }
    
    public boolean hatFigur(int pos){
        if(activePlayer == 1 && field[pos] == 11
                || activePlayer == 2 && field[pos] == 21
                || activePlayer == 3 && field[pos] == 31
                || activePlayer == 4 && field[pos] == 41){
            return true;
        }else{
        return false;
        }
    }
    
    public int[] getField(){
        return field;
    }
    
    public int[] getStartR(){
        return startR;
    }
    public int[] getStartG(){
        return startG;
    }
    public int[] getStartY(){
        return startY;
    }
    public int[] getStartB(){
        return startB;
    }
    public int[][] getHome(){
        return home;
    }
    public int canEnterHome(){
        return 0;
    }
    //Betreten des Zielbereiches
    public void enterHomeRed(){
        if(homezonemode){
            
        
        field[loc]=0;
        System.out.println(loc + "  " + field[loc]);
        win[activePlayer-1]++;
        System.out.println(win[activePlayer-1]);
        home[0][homezone-1] = 11;
        homezonemode = false;
        }

        
    }
     public void enterHomeGreen(){
         if(homezonemode){

        field[loc]=0;
        System.out.println(loc + "  " + field[loc]);
        win[activePlayer-1]++;
        System.out.println(win[activePlayer-1]);
        home[1][homezone-1] = 21;
        homezonemode = false;
        }

        
    }
      public void enterHomeYellow(){
          if(homezonemode){
        field[loc]=0;
        System.out.println(loc + "  " + field[loc]);
        win[activePlayer-1]++;
        System.out.println(win[activePlayer-1]);
        home[2][homezone-1] = 31;
        homezonemode = false;
          }

        
    }
       public void enterHomeBlue(){
           if(homezonemode){
        field[loc]=0;
        System.out.println(loc + "  " + field[loc]);
        win[activePlayer-1]++;
        System.out.println(win[activePlayer-1]);
        home[3][homezone-1] = 41;
        homezonemode = false;
           }

        
    }
    
    //Figur auf das Spielfeld bringen.
    public void launchRed(){
        posR[0]++;
        for(int i = 1; i< 5; i++){
            if(posR[i] == 100){
                posR[i] = 0;
                i=i+5;
            }
        }
        field[0] = 11;
        start[0] = start[0]--;
        for(int i = 0; i < 4; i++)
        {
            if(startR[i] == 11 ||startR[i] == 13){
                startR[i] = 1;
                i = 5;
            }
        }
        statDeploy[0]++;
        usedDice = false;
    }
    public void launchGreen(){
        posG[0]++;
        for(int i = 1; i< 5; i++){
            if(posG[i] == 100){
                posG[i] = 10;
                i=i+5;
            }
        }
        field[10] = 21;
        start[1] = start[1]--;
        for(int i = 0; i < 4; i++)
        {
            if(startG[i] == 21 || startG[i] == 23){
                startG[i] = 2;
                i = 5;
            }
        }
        
        statDeploy[1]++;
        usedDice = false;
    }
    public void launchYellow(){
        posY[0]++;
        for(int i = 1; i< 5; i++){
            if(posY[i] == 100){
                posY[i] = 20;
                i=i+5;
            }
        }
        field[20] = 31;
        start[2] = start[2]--;
        for(int i = 0; i < 4; i++)
        {
            if(startY[i] == 31 || startY[i] == 33){
                startY[i] = 3;
                i = 5;
            }
        }
        statDeploy[2]++;
        usedDice = false;
    }
    public void launchBlue(){
        posB[0]++;
        for(int i = 1; i< 5; i++){
            if(posB[i] == 100){
                posB[i] = 30;
                i=i+5;
            }
        }
        field[30] = 41;
        start[3] = start[3]--;
        for(int i = 0; i < 4; i++)
        {
            if(startB[i] == 41 || startB[i] == 43){
                startB[i] = 4;
                i = 5;
            }
        }
        statDeploy[3]++;
        usedDice = false;
    }   
    public void nextPlayer(){
        if(activePlayer == 4){
            activePlayer = 1;
        }else{
            activePlayer++;
        }
        usedDice = false;
        System.out.println(activePlayer);
        movemode = false;
        canBeat = false;
    }

    
    
    public String changeDesign(){
            return "Images/Mensch/Designs/test/";
        }
}
        
    
