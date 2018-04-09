/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmiproject;

import java.util.Random;

/**
 *
 * @author Chris
 * 
 * Methode zur Bereitstellung eines Würfles für Mensch ärgere dich nicht und Risiko
 * Außerdem Bereitstellung von "Zufalls-Zahlen" für Entscheidungen der Computer-Gegner
 */
public class Dice {
    
    
    public int d6(){
        Random r = new Random();
        return r.nextInt(6)+1;
    }
    public int d2(){
        Random r = new Random();
        return r.nextInt(1)+1;
    }
    public int d3(){
        Random r = new Random();
        return r.nextInt(2)+1;
    }
        public int d4(){
        Random r = new Random();
        return r.nextInt(4)+1;
    }
            public int d5(){
        Random r = new Random();
        return r.nextInt(5)+1;
    }
    
    public int d10(){
        Random r = new Random();
        return r.nextInt(10)+1;
    }
    
    public int d1(){
        return 1;
    }
    

    
    public boolean bool(){
        Random r = new Random();
        int i = r.nextInt(2);
        System.out.println(i);

        if(i == 1){
            System.out.println("True");
            return true;
        }
        System.out.println("False");
        return false;
    }
    
    
}
