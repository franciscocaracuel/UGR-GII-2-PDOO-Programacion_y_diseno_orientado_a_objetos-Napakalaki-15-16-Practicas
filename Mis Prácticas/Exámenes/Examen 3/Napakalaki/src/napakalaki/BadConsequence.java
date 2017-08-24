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
    
    // Constantes
    static final int MAXTREASURES = 10;
    
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
        setDeath(false);
        
    }
    
    public BadConsequence(String text, boolean death){
        
        setText(text);
        setDeath(death);
        
        setLevels(Player.MAXLEVEL);
        setNVisibleTreasures(MAXTREASURES);
        setNHiddenTreasures(MAXTREASURES);
        
    }
    
    public BadConsequence(String text, int levels, 
            ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        
        setText(text);
        setLevels(levels);
        setSpecificVisibleTreasures(tVisible);
        setSpecificHiddenTreasures(tHidden);
        setDeath(false);
        
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
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
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
    
    private void setSpecificVisibleTreasures(ArrayList<TreasureKind> sVisible){
        this.specificVisibleTreasures = new ArrayList(sVisible);
    }
    
    private void setSpecificHiddenTreasures(ArrayList<TreasureKind> sHidden){
        this.specificHiddenTreasures = new ArrayList(sHidden);
    }
    
    // Utils
    public boolean isEmpty(){
                
        boolean bad = false;
        
        if(nVisibleTreasures==0 && nHiddenTreasures==0 &&
                specificHiddenTreasures.isEmpty() &&
                specificVisibleTreasures.isEmpty())
            bad = true;
        
        return bad;
        
    }
    
    public void substractVisibleTreasure(Treasure t){
        
        if(specificVisibleTreasures.indexOf(t.getType())==-1){
            
            if(nVisibleTreasures>0)
                nVisibleTreasures--;            
                
        }else
            specificVisibleTreasures.remove(t.getType());
        
    }
    
    public void substractHiddenTreasure(Treasure t){
        
        if(specificHiddenTreasures.indexOf(t.getType())==-1){
            
            if(nHiddenTreasures>0)
                nHiddenTreasures--;            
                
        }else
            specificHiddenTreasures.remove(t.getType());
        
    }
    
    public BadConsequence adjustToFitTreasureLists(
            ArrayList<Treasure> visibleTreasures, 
            ArrayList<Treasure> hiddenTreasures){
        
        BadConsequence bcAux = new BadConsequence(text, 0, 0, 0);
        
        // Si los tesoros visibles que se reciben no están vacíos
        if(!visibleTreasures.isEmpty()){
            
            // Si el jugador no tiene tesoros visibles equipados y tiene
            // algún tesoro visible
            if(specificVisibleTreasures.isEmpty() && nVisibleTreasures>0){
                
                // Si tiene nVisibleTreasures para descontar
                if(nVisibleTreasures>=visibleTreasures.size())
                    bcAux.setNVisibleTreasures(visibleTreasures.size());
                else
                    bcAux.setNVisibleTreasures(nVisibleTreasures);
                
            // Si el jugador tiene tesoros visibles equipados
            } else if(!specificVisibleTreasures.isEmpty()){
                
                ArrayList<TreasureKind> trAux = new ArrayList();
                
                for(Treasure treasure : visibleTreasures){
                    
                    if(specificVisibleTreasures.contains(treasure.getType())){
                        trAux.add(treasure.getType());
                    }
                    
                }
                
                bcAux.setSpecificVisibleTreasures(trAux);
                
            }
            
        }
        
        // Si los tesoros ocultos que se reciben no están vacíos
        if(!hiddenTreasures.isEmpty()){
            
            // Si el jugador no tiene tesoros ocultos equipados y tiene
            // algún tesoro oculto
            if(specificHiddenTreasures.isEmpty() && nHiddenTreasures>0){
                
                // Si tiene nHiddenTreasures para descontar
                if(nHiddenTreasures>=hiddenTreasures.size())
                    bcAux.setNHiddenTreasures(hiddenTreasures.size());
                else
                    bcAux.setNHiddenTreasures(nHiddenTreasures);
                
            // Si el jugador tiene tesoros ocultos equipados
            } else if(!specificHiddenTreasures.isEmpty()){
                
                ArrayList<TreasureKind> trAux = new ArrayList();
                
                for(Treasure treasure : visibleTreasures){
                    
                    if(specificHiddenTreasures.contains(treasure.getType())){
                        trAux.add(treasure.getType());
                    }
                    
                }
                
                bcAux.setSpecificHiddenTreasures(trAux);
                
            }
            
        }
        
        return bcAux;
        
    }
    
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
