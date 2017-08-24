/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.Random;

/**
 *
 * @author fran
 */
public class CultistPlayer extends Player{
    
    // Variables de clase
    private static int totalCultistPlayer = 0;
    
    // Variables de instancia
    private Cultist myCultistCard;
    
    // Constructores
    public CultistPlayer(Player p, Cultist c){
        
        super(p);
        setMyCultistCard(c);
        
        totalCultistPlayer++;
        
    }
    
    // Getters
    public Cultist getMyCultistCard(){
        return myCultistCard;
    }
    
    public static int getTotalCultistPlayers(){
        return totalCultistPlayer;
    }
    
    // Setters
    private void setMyCultistCard(Cultist myCultistCard){
        this.myCultistCard = myCultistCard;
    }
    
    // Utils
    
    @Override
    protected int getCombatLevel(){        
        return (int)(super.getCombatLevel() + (super.getCombatLevel()*0.2) + 
                (myCultistCard.getGainedLevels() * totalCultistPlayer));
    }
    
    @Override
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected boolean shouldConvert(){
        return false;
    }
        
    @Override
    protected Treasure giveMeATreasure(){
        return super.getVisibleTreasures().get(new Random().nextInt(super.getVisibleTreasures().size()));
    }
    
    
    @Override
    protected boolean canYouGiveMeATreasure(){
        return !super.getVisibleTreasures().isEmpty();
    }
    
    @Override
    protected void removeTreasure(Treasure treasure){
        super.getVisibleTreasures().remove(treasure);
    }
    
    @Override
    public boolean isCultist(){
        return true;
    }
            
}
