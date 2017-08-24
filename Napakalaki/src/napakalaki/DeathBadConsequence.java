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
public class DeathBadConsequence extends NumericBadConsequence{
    
    // Variables
    private boolean death;
    
    // Constructor
    public DeathBadConsequence(String text, boolean death){
        super(text, Player.MAXLEVEL, BadConsequence.MAXTREASURES, 
                BadConsequence.MAXTREASURES);
        setDeath(death);
    }
    
    // Getters
    public boolean getDeath(){
        return death;
    }
    
    // Setters
    public void setDeath(boolean death){
        this.death = death;
    }
    
    @Override
    public String toString(){
        
        return super.toString()+ ", Death = " + death;
        
    }
    
}
