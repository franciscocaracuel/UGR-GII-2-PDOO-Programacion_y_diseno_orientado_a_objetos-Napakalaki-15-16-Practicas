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
public class Treasure {
    
    // Variables de instancia
    private String name;
    private int bonus;
    
    private TreasureKind type;
    
    // Constructor
    public Treasure(String name, int bonus, TreasureKind type){
        setName(name);
        setBonus(bonus);
        setType(type);
    }
    
    // Getters
    public String getName(){
        return name;
    }
    
    public int getBonus(){
        return bonus;
    }
    
    public TreasureKind getType(){
        return type;
    }
    
    // Setters
    private void setName(String name){
        this.name = name;
    }
    
    private void setBonus(int bonus){
        this.bonus = bonus;
    }
    
    private void setType(TreasureKind type){
        this.type = type;
    }
    
    @Override
    public String toString(){
        return getName() + " Tipo: " + getType() + " Bonus: " + getBonus();
    }
    
}
