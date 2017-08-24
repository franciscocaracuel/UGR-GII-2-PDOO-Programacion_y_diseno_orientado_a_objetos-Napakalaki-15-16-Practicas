/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author fran
 */
public class Cultist {
    
    // Variables de instancia
    private String name;
    private int gainedLevels;
    
    // Constructores
    public Cultist(String name, int gainedLevels){
        
        setName(name);
        setGainedLevels(gainedLevels);
        
    }
    
    // Getters
    public String getName(){
        return name;
    }
    
    public int getGainedLevels(){
        return gainedLevels;
    }
    
    // Setters
    public void setName(String name){
        this.name = name;
    }
    
    public void setGainedLevels(int gainedLevels){
        this.gainedLevels = gainedLevels;
    }
    
    // Utils
    @Override
    public String toString(){
        
        return "Cultist --> Name: " + name + ", GainedLevels: " + gainedLevels;
        
    }
    
}
