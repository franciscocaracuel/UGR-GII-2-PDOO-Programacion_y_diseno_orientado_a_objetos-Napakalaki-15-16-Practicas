/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import napakalaki.Test.GameTester;

/**
 *
 * @author caracuel
 */
public class EjemploMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*Napakalaki game = Napakalaki.getInstance();
        GameTester test = GameTester.getInstance();

        // Poner el numero de jugadores con el que se quiera probar
        test.play(game, 2);*/
        
        
        
        Monster m = Monster.newMonster("m", 0, new BadConsequence("1", true), new Prize(0, 0));
        
        
        System.out.println(m.toString());
        
        
        
        System.out.println(Monster.getInstance(2));
        

    }

}
