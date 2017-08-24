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
public class Monster {
    
    // EXAMEN
    private static ArrayList<Monster> myMonsterList = new ArrayList();
    
    static final int MAX_MONSTERS = 100;
    // FIN EXAMEN
    
    // Variables
    private String name;
    private int combatLevel;
    
    private BadConsequence bc;
    private Prize prize;
        
    // Constructores
    // EXAMEN
    private Monster(String name, int combatLevel, BadConsequence bc, Prize prize){
        
        setName(name);
        setCombatLevel(combatLevel);
        setBC(bc);
        setPrize(prize);
        
    }
    
    public static Monster newMonster(String name, int combatLevel, BadConsequence bc, Prize prize){
        
        Monster m = null;
        
        if(myMonsterList.size()<MAX_MONSTERS){
            m = new Monster(name, combatLevel, bc, prize);
            myMonsterList.add(m);
        }
        
        return m;
        
    }
    
    public static Monster getInstance(int pos){
        
        Monster m = null;
        
        if(pos<myMonsterList.size())
            m = myMonsterList.get(pos);
        
        return m;
        
    
    }
    
    // FIN EXAMEN
    
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
    
    // Utils
    @Override
    public String toString(){
        return "Name = " + name +
                ", CombatLevel = " + Integer.toString(combatLevel) +
                ", BadConsequence = { " + bc.toString() +
                " }, Prize = {" + prize.toString() + " }";
    }
    
}