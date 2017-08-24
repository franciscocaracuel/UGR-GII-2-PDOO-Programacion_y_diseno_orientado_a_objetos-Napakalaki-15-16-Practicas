/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author fran
 */
public class NumericBadConsequence extends BadConsequence{
    
    // Variables
    private int nVisibleTreasures, nHiddenTreasures;
    
    // Constructor
    public NumericBadConsequence(String text, int levels, int nVisibleTreasures, 
            int nHiddenTreasures){
        
        super(text, levels);
        setNVisibleTreasures(nVisibleTreasures);
        setNHiddenTreasures(nHiddenTreasures);
        
    }
    
    // Getters
    public int getNVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    // Setters
    public void setNVisibleTreasures(int nVisibleTreasures){
        this.nVisibleTreasures = nVisibleTreasures;
    }
    
    public void setNHiddenTreasures(int nHiddenTreasures){
        this.nHiddenTreasures = nHiddenTreasures;
    }
    
    // Utils
    @Override
    public boolean isEmpty(){
        
        return nVisibleTreasures==0 && nHiddenTreasures==0;
        
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        
        if(nVisibleTreasures>0)
            nVisibleTreasures--;
        
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        
        if(nHiddenTreasures>0)
            nHiddenTreasures--;
        
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(
        ArrayList<Treasure> visibleTreasures, 
        ArrayList<Treasure> hiddenTreasures){
        
        NumericBadConsequence bcAux = new NumericBadConsequence(super.getText(), 0, 0, 0);
        
        // Si el jugador tiene algún tesoro visible y la lista que recibe no
        // está vacía
        if(!visibleTreasures.isEmpty() && nVisibleTreasures>0){
                            
            // Si tiene nVisibleTreasures para descontar
            if(nVisibleTreasures>=visibleTreasures.size())
                bcAux.setNVisibleTreasures(visibleTreasures.size());
            else
                bcAux.setNVisibleTreasures(nVisibleTreasures);
     
        }
        
        // Si los tesoros ocultos que se reciben no están vacíos y si el jugador 
        // no tiene tesoros ocultos equipados y tiene algún tesoro oculto
        if(!hiddenTreasures.isEmpty() && nHiddenTreasures>0){
            
            //  Si tiene nHiddenTreasures para descontar
            if(nHiddenTreasures>=hiddenTreasures.size())
                bcAux.setNHiddenTreasures(hiddenTreasures.size());
            else
                bcAux.setNHiddenTreasures(nHiddenTreasures);
                 
        }
        
        return bcAux;
        
    }
    
    @Override
    public String toString(){
        
        return super.toString() +
            ", NVisibleTreasures = " + Integer.toString(nVisibleTreasures) +
            ", NHiddenTreasures = " + Integer.toString(nHiddenTreasures);      
        
    }
    
}
