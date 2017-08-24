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
public class Monster {
    
    // Variables
    private String name;
    private int combatLevel;
    
    private BadConsequence bc;
    private Prize prize;
    
    // EXAMEN-inicio
        private AlterEgo miAlterEgo;
    // EXAMEN-fin
    
    // Constructores
    Monster(String name, int combatLevel, BadConsequence bc, Prize prize){
        
        setName(name);
        setCombatLevel(combatLevel);
        setBC(bc);
        setPrize(prize);
        
        // EXAMEN-inicio
        miAlterEgo = new AlterEgo(10);
        // EXAMEN-fin
        
    }
    
    // Getters
    public String getName(){
        return name;
    }
    
    public int GetCombatLevel(){
        return combatLevel;
    }
    
    public BadConsequence getBC(){
        return bc;
    }
    
    public Prize getPrize(){
        return prize;
    }
    
    // EXAMEN-inicio
    public AlterEgo getMiAlterEgo(){
        return miAlterEgo;
    }
    // EXAMEN-fin
    
    // Setters
    private void setName(String name){
        this.name = name;
    }
    
    private void setCombatLevel(int combatLevel){
        this.combatLevel = combatLevel;
    }
    
    private void setBC(BadConsequence bc){
        this.bc = bc;
    }
    
    private void setPrize(Prize prize){
        this.prize = prize;
    }
    
    // EXAMEN-inicio
    public void setMiAlterEgo(AlterEgo alterEgo){
        miAlterEgo = alterEgo;
    }
    // EXAMEN-fin
    
    // Utils
    @Override
    public String toString(){
        return "Name = " + name +
                ", CombatLevel = " + Integer.toString(combatLevel) +
                ", BadConsequence = { " + bc.toString() +
                " }, Prize = {" + prize.toString() + " }";
    }
    
}
