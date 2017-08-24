/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author fran
 */
public class Player {
    
    // Constante
    static final int MAXLEVEL = 10;
    
    // Variables de instancia
    private String name;
    private int level;
    private boolean dead;
    private boolean canISteal;
    
    private Player enemy;
    
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
    
    private BadConsequence pendingBadConsequence;
    
    // Constructores
    public Player(String name){
        setName(name);
        setLevel(1);
        setDead(true);
        setCanISteal(true);
        setPendingBadConsequence(new BadConsequence("", 0, 0, 0));
    }
    
    // Getters
    public String getName(){
        return name;
    }
    
    public int getLevels(){
        return level;
    }
    
    // Método mío porque no me gusta acceder directamente a las variables
    // desde otros métodos
    private boolean getDead(){
        return dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
    
    private BadConsequence getPendingBadConsequence(){
        return pendingBadConsequence;
    }
    
    // Método mío porque no me gusta acceder directamente a las variables
    // desde otros métodos
    private boolean getCanISteal(){
        return canISteal;
    }
    
    //Setters
    private void setName(String name){
        this.name = name;
    }
    
    private void setLevel(int level){
        this.level = level;
    }
    
    private void setDead(boolean dead){
        this.dead = dead;
    }
    
    private void setCanISteal(boolean canISteal){
        this.canISteal = canISteal;
    }
    
    private void setPendingBadConsequence(BadConsequence bc){
        this.pendingBadConsequence = bc;
    }
    
    public void setEnemyPlayer(Player enemy){
        this.enemy = enemy;
    }
    
    // Utils
    private void bringToLife(){        
        setDead(false);        
    }
    
    private int getCombatLevel(){     
        
        // Comienza con el nivel del jugador
        int levelAux = getLevels();
        
        // Se suman los bonus de los tesoros equipados
        for(Treasure t: visibleTreasures){
            levelAux += t.getBonus();
        }
        
        return levelAux;
                
    }
    
    private void incrementLevels(int levels){
                
        if(getLevels()+levels>=MAXLEVEL)
            setLevel(MAXLEVEL);
        else
            setLevel(getLevels()+levels);
        
    }
    
    private void decrementLevels(int levels){
        
        if(getLevels()-levels<=1)
            setLevel(1);
        else
            setLevel(getLevels()-levels);
        
    }
    
    private void applyPrize(Monster currentMonster){
                
        incrementLevels(currentMonster.getLevelsGained());
        
        int nTreasures = currentMonster.getTreasuresGained();
        
        if(nTreasures>0){
                        
            for(int i=0; i<nTreasures; i++){
                
                hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
                
            }
            
        }
        
    }
    
    private void applyBadConsequence(Monster currentMonster){
               
        decrementLevels(currentMonster.getBadConsequence().getLevels());
        
        setPendingBadConsequence(currentMonster.getBadConsequence().adjustToFitTreasureLists(visibleTreasures, hiddenTreasures));
                
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
      
        boolean can = true;
        
        // Se comprueba con switch case el tipo de tesoro que se recibe
        switch(TreasureKind.valueOf(t.getType().toString())){
            
            // Si es armadura, casco o zapatos se comprueba solo que exista
            case ARMOR:
            case HELMET:
            case SHOE:
                
                // Se comprueba si el tipo del tesoro que se recibe, es algún
                // tipo de tesoro que tiene ya el jugador equipado
                int i = 0;                
                while(can && i<visibleTreasures.size()){
                    if(visibleTreasures.get(i).getType() == t.getType())
                        can = false;
                    i++;
                }
                
                break;
                
            // Si son dos guantes se comprueba que no haya dos guantes o uno
            case BOTHHANDS:
                
                i = 0;
                
                // Recorre el array hasta que llegue al final o encuentre
                // un guante o dos
                while(can && i<visibleTreasures.size()){
                    can = visibleTreasures.get(i).getType()!=TreasureKind.ONEHAND
                            && visibleTreasures.get(i).getType()!=TreasureKind.BOTHHANDS;
                    i++;
                }
            
                break;
            
            // Si es un guante no puede haber un tesoro de dos guantes o
            // los dos guantes puestos
            case ONEHAND:
                
                i = 0;
                int totalHands = 0;
                
                // Recorre el array hasta que llegue al final, encuentre
                // dos guantes o dos guantes individuales
                while(can && i<visibleTreasures.size()){
                    
                    if(visibleTreasures.get(i).getType()==TreasureKind.ONEHAND)
                        totalHands++;
                    
                    can = visibleTreasures.get(i).getType()!=TreasureKind.BOTHHANDS
                            && totalHands<2;
                    
                    i++;
                }
                
                break;
            
        }
        
        return can;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        
        int total = 0;
        
        for (Treasure visibleTreasure : visibleTreasures) {
            if (visibleTreasure.getType() == tKind) {
                total++;
            }
        }
        
        return total;
        
    }
    
    private void dieIfNoTreasures(){
        if(hiddenTreasures.isEmpty() && visibleTreasures.isEmpty())
            setDead(true);
    }
    
    public boolean isDead(){
        return getDead();
    }
    
    public CombatResult combat(Monster currentMonster){
        
        CombatResult combatResult;
        
        int myLevel = getCombatLevel();
        
        int monsterLevel = currentMonster.getCombatLevel();
        
        if(myLevel>monsterLevel){
            
            applyPrize(currentMonster);
            
            if(level>=MAXLEVEL)
                combatResult = CombatResult.WINGAME;
            else
                combatResult = CombatResult.WIN;
            
        } else{
            
            applyBadConsequence(currentMonster);
            
            combatResult = CombatResult.LOSE;
            
        }
                
                
        return combatResult;
        
    }
    
    public void makeTreasureVisible(Treasure t){
                
        if(canMakeTreasureVisible(t)){
            
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
            
        }
        
    }
    
    public void discardVisibleTreasure(Treasure t){
        
        visibleTreasures.remove(t);
        
        if(pendingBadConsequence!=null && !pendingBadConsequence.isEmpty()){
            
            pendingBadConsequence.substractVisibleTreasure(t);
            
        }
        
        dieIfNoTreasures();
        
    }
    
    public void discardHiddenTreasure(Treasure t){
        
        hiddenTreasures.remove(t);
        
        if(pendingBadConsequence!=null && !pendingBadConsequence.isEmpty()){
            
            pendingBadConsequence.substractHiddenTreasure(t);
            
        }
        
        dieIfNoTreasures();
        
    }
    
    public boolean validState(){
                
        return getPendingBadConsequence().isEmpty() && 
            getHiddenTreasures().size()<=4;
    }
    
    public void initTreasures(){
        
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        
        bringToLife();
        
        // Coge 1 tesoro
        hiddenTreasures.add(dealer.nextTreasure());
        
        int number = dice.nextNumber();
        
        if(number>1){
            
            // Coge 2 tesoros
            hiddenTreasures.add(dealer.nextTreasure());
            
        }
        
        if(number==6){
            
            // Coge 3 tesoros
            hiddenTreasures.add(dealer.nextTreasure());
            
        }
        
    }
    
    public Treasure stealTreasure(){
        
        Treasure treasure = null;
                
        if(canISteal() && enemy.canYouGiveMeATreasure()){
            
            treasure = enemy.giveMeATreasure();
                                
            hiddenTreasures.add(treasure);
            
            // Se elimina el tesoro robado al enemigo
            enemy.hiddenTreasures.remove(treasure);
                
            haveStolen();
                         
        }
        
        return treasure;
    }
    
    private Treasure giveMeATreasure(){
        
        return hiddenTreasures.get(new Random().nextInt(hiddenTreasures.size()));
        
    }
    
    public boolean canISteal(){
        return getCanISteal();
    }
    
    private boolean canYouGiveMeATreasure(){
        return !(hiddenTreasures.isEmpty() && visibleTreasures.isEmpty());
    }
    
    private void haveStolen(){
        setCanISteal(!getCanISteal());
    }
    
    public void discardAllTreasures(){
        
        ArrayList<Treasure> visibleTreasuresAux = new ArrayList(visibleTreasures);
        ArrayList<Treasure> hiddenTreasuresAux = new ArrayList(hiddenTreasures);
        
        for(Treasure treasure : visibleTreasuresAux){
            
            discardVisibleTreasure(treasure);
            
        }
        
        for(Treasure treasure : hiddenTreasuresAux){
            
            discardHiddenTreasure(treasure);
            
        }
        
    }
    
    @Override
    public String toString(){
        return getName() + ", Nivel " + getLevels() + ", Robar: " 
                + canISteal() + ", Muerto: " + getDead();
    }
    
}
