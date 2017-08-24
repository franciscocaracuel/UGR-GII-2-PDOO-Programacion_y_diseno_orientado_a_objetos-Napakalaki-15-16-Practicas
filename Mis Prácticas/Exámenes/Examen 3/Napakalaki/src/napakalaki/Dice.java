/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.Random;

/**
 *
 * @author fran
 */
public class Dice {
    
    private static final Dice instance = new Dice();
    
    // Constructor privado
    private Dice(){
        
    }
    
    public static Dice getInstance(){
        return instance;
    }
    
    // Genera un número aleatorio entre 1 y 6 (ambos incluidos)
    public int nextNumber(){
        return new Random().nextInt(6)+1;
    }
    
}
