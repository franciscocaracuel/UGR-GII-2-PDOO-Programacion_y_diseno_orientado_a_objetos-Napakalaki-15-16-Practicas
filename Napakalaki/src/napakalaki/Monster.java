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
    
    private int levelChangeAgainstCultistPlayer;
        
    // Constructores
    Monster(String name, int combatLevel, BadConsequence bc, Prize prize){
        
        setName(name);
        setCombatLevel(combatLevel);
        setBC(bc);
        setPrize(prize);
        setLevelChangeAgainstCultistPlayer(0);
        
    }
    
    Monster(String name, int combatLevel, BadConsequence bc, Prize prize,
            int levelChangeAgainstCultistPlayer){
        
        setName(name);
        setCombatLevel(combatLevel);
        setBC(bc);
        setPrize(prize);
        setLevelChangeAgainstCultistPlayer(levelChangeAgainstCultistPlayer);
        
    }
    
    // Getters
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    public BadConsequence getBadConsequence(){
        return bc;
    }
    
    public Prize getPrize(){
        return prize;
    }
    
    ///////////////////////////////////////////////////////////////////////////
    // Si se devuelve prize no son necesarios los dos siguientes métodos,
    // pero en el esquema UML que tenemos aparecen
    public int getLevelsGained(){
        return prize.getLevel();
    }
    
    public int getTreasuresGained(){
        return prize.getTreasures();
    }
    ///////////////////////////////////////////////////////////////////////////
    
    public int getLevelChangeAgainstCultistPlayer(){
        return levelChangeAgainstCultistPlayer;
    }
        
    // Setters
    // No me gusta que sean public...
    public void setName(String name){
        this.name = name;
    }
    
    public void setCombatLevel(int combatLevel){
        this.combatLevel = combatLevel;
    }
    
    public void setBC(BadConsequence bc){
        this.bc = bc;
    }
    
    public void setPrize(Prize prize){
        this.prize = prize;
    }
    
    public void setLevelChangeAgainstCultistPlayer(int lccp){
        this.levelChangeAgainstCultistPlayer = lccp;
    }
    
    // Métodos incluidos en la sesión 4
    public int getCombatLevelAgainstCultistPlayer(){
        return getCombatLevel()+getLevelChangeAgainstCultistPlayer();
    }
    
    // Utils
    @Override
    public String toString(){
        return "Name = " + name +
                ", CombatLevel = " + Integer.toString(combatLevel) +
                ", BadConsequence = { " + bc.toString() +
                " }, Prize = {" + prize.toString() + " }";
    }
    
}