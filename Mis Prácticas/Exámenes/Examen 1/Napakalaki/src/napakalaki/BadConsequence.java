/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author caracuel
 */
public class BadConsequence {
    
    // Variables
    private String text;
    private int levels, nVisibleTreasures, nHiddenTreasures;
    private boolean death;
    
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    // Constructores
    public BadConsequence(String text, int levels, int nVisibleTreasures, 
            int nHiddenTreasures){
        
        setText(text);
        setLevels(levels);
        setNVisibleTreasures(nVisibleTreasures);
        setNHiddenTreasures(nHiddenTreasures);
        
    }
    
    public BadConsequence(String text, boolean death){
        
        setText(text);
        setDeath(death);
        
    }
    
    public BadConsequence(String text, int levels, 
            ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        
        setText(text);
        setLevels(levels);
        setTVisible(tVisible);
        setTHidden(tHidden);
        
    }
    
    // Getters
    public String getText(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    
    public int getNVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    public boolean getDeath(){
        return death;
    }
    
    public ArrayList<TreasureKind> getTVisible(){
        return specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> getTHidden(){
        return specificHiddenTreasures;
    }
    
    // Setters
    private void setText(String text){
        this.text = text;
    }
    
    private void setLevels(int levels){
        this.levels = levels;
    }
    
    private void setNVisibleTreasures(int nVisibleTreasures){
        this.nVisibleTreasures = nVisibleTreasures;
    }
    
    private void setNHiddenTreasures(int nHiddenTreasures){
        this.nHiddenTreasures = nHiddenTreasures;
    }
    
    private void setDeath(boolean death){
        this.death = death;
    }
    
    private void setTVisible(ArrayList<TreasureKind> tVisible){
        this.specificVisibleTreasures = tVisible;
    }
    
    private void setTHidden(ArrayList<TreasureKind> tHidden){
        this.specificHiddenTreasures = tHidden;
    }
    
    // Utils
    @Override
    public String toString(){
        return "Text = " + text +
                ", Levels = " + Integer.toString(levels) +
                ", NVisibleTreasures = " + Integer.toString(nVisibleTreasures) +
                ", NHiddenTreasures = " + Integer.toString(nHiddenTreasures) +
                ", SpecificVisibleTreasures = " + specificVisibleTreasures.toString() +
                ", SpecificHiddenTreasures = " + specificHiddenTreasures.toString() +
                ", Death = " + death;
    }
    
}
