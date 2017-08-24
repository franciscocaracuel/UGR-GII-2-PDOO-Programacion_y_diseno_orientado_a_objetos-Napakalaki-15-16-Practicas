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
public abstract class BadConsequence{
    
    // Constantes
    final static int MAXTREASURES = 10;
    
    //Variables
    private String text;
    private int levels;
    
    // Constructor
    public BadConsequence(String text, int levels){
        setText(text);
        setLevels(levels);
    }
    
    // Getters
    public String getText(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    
    // Setters
    public void setText(String text){
        this.text = text;
    }
    
    public void setLevels(int levels){
        this.levels = levels;
    }
    
    // Utils
    public abstract boolean isEmpty();
    
    public abstract void substractVisibleTreasure(Treasure t);
    
    public abstract void substractHiddenTreasure(Treasure t);
    
    public abstract BadConsequence adjustToFitTreasureLists(
        ArrayList<Treasure> visibleTreasures, 
        ArrayList<Treasure> hiddenTreasures);
    
    @Override
    public String toString(){
        
        return "Text = " + text +
                ", Levels = " + Integer.toString(levels);
        
    }
    
}
    
    /*
 
 
    
    
    
    

  
    
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

    
}

*/