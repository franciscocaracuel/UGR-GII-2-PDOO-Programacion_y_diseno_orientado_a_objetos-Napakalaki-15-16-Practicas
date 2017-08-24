/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author caracuel
 */
public class Prize {
    
    // Variables
    private int treasures, level;
    
    // Constructor
    Prize(int treasures, int level){
        
        setTreasures(treasures);
        setLevel(level);
        
    }
    
    // Getters
    public int getTreasures(){
        return treasures;
    }
    
    public int getLevel(){
        return level;        
    }
    
    // Setters
    private void setTreasures(int treasures){
        this.treasures = treasures;
    }
    
    private void setLevel(int level){
        this.level = level;
    }
    
    // Utils
    @Override
    public String toString(){
        return "Treasures = " + Integer.toString(treasures) +
                ", Level = " + Integer.toString(level);
    }
    
}
