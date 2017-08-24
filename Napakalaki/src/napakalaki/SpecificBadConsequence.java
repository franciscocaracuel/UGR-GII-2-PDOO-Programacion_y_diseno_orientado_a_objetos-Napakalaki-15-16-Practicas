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
public class SpecificBadConsequence extends BadConsequence{
    
    // Variables
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    // Constructor
    public SpecificBadConsequence(String text, int levels, 
            ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        
        super(text, levels);
        setSpecificVisibleTreasures(tVisible);
        setSpecificHiddenTreasures(tHidden);
        
    }
    
    // Getters
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    // Setters
    public void setSpecificVisibleTreasures(ArrayList<TreasureKind> sVisible){
        this.specificVisibleTreasures = new ArrayList(sVisible);
    }
    
    public void setSpecificHiddenTreasures(ArrayList<TreasureKind> sHidden){
        this.specificHiddenTreasures = new ArrayList(sHidden);
    }
    
    // Utils
    @Override
    public boolean isEmpty(){
       
        return specificVisibleTreasures.isEmpty() && 
                specificHiddenTreasures.isEmpty();
        
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        
        // Si el elemento no existe, no hace nada
        specificVisibleTreasures.remove(t.getType());
        
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        
        // Si el elemento no existe, no hace nada
        specificHiddenTreasures.remove(t.getType());
        
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(
        ArrayList<Treasure> visibleTreasures, 
        ArrayList<Treasure> hiddenTreasures){
        
        SpecificBadConsequence bcAux = new SpecificBadConsequence(super.getText(), 
                0, new ArrayList<>(), new ArrayList<>());
        
        // Si los tesoros visibles que se reciben no están vacíos
        if(!visibleTreasures.isEmpty()){
                                      
            // Si el jugador tiene tesoros visibles equipados
            if(!specificVisibleTreasures.isEmpty()){
                
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

            // Si el jugador tiene tesoros ocultos equipados
            if(!specificHiddenTreasures.isEmpty()){
                
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
        
        return super.toString() +
            ", SpecificVisibleTreasures = " + specificVisibleTreasures.toString() +
            ", SpecificHiddenTreasures = " + specificHiddenTreasures.toString();
        
    }
    
}
