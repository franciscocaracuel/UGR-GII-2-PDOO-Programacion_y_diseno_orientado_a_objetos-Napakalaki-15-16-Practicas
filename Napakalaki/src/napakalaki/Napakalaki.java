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
public class Napakalaki {
    
    // Variables de instancia
    private Monster currentMonster;
    private Player currentPlayer;
    private ArrayList<Player> players = new ArrayList();
    private CardDealer dealer;
    
    private static final Napakalaki instance = new Napakalaki();
    
    // Constructor
    private Napakalaki(){
        
        dealer = CardDealer.getInstance();
        
    }
    
    // Getters
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    private void initPlayers(ArrayList<String> names){
        
        for(String name: names){
            players.add(new Player(name));
        }
        
        // Para que se quede inicializado currentPlayer
        nextPlayer();
        
    }
    
    private Player nextPlayer(){
        
        int index;
        
        // Si no existe el jugador actual, será la primera partida
        if(currentPlayer==null){            
            
            // Se genera el número aleatorio
            index = getRandomInt(players.size()-1);  
                                    
            currentPlayer = players.get(index);
                        
        // La partida ya ha comenzado
        } else{
            
            // Se guarda en el índice la posición actual +1
            index = players.indexOf(currentPlayer)+1;
            
            //System.out.println("\n\n1 LE TOCA A: " + players.get(index).toString());
            
            // Para controlar que no desborde, si el índice llega al número
            // de jugadores se sigue desde 0
            if(players.size()==index)
                index = 0;
            
        }
        
        //System.out.println("\n\n2 LE TOCA A: " + players.get(index).toString());
        
        return players.get(index);
        
    }
    
    private boolean nextTurnIsAllowed(){
        
        boolean res = true;
        
        if(currentPlayer!=null){
            res = currentPlayer.validState();
        }
        
        return res;
        
    }
    
    private void setEnemies(){
        
        for(Player player: players){
            
            int index;
        
            // Se podría hacer que se genere un número aleatorio y si el resultado
            // es el mismo que el jugador actual, sume un número, pero así el
            // siguiente jugador al actual tendría más probabilidad de ser el
            // enemigo
            do{
                index = getRandomInt(players.size()-1); 
            } while(index==players.indexOf(player));
        
            // Se le asigna al jugador correspondiente
            player.setEnemyPlayer(players.get(index));
            
        }
                
    }
    
    public static Napakalaki getInstance(){
        return instance;
    }
    
    public CombatResult developCombat(){
        
        CombatResult combatResult = currentPlayer.combat(currentMonster);
        
        dealer.giveMonsterBack(currentMonster);
        
        // Práctica 4
        if(combatResult==CombatResult.LOSEANDCONVERT){
            
            CultistPlayer cp = new CultistPlayer(currentPlayer, dealer.nextCultist());
            
            // Hay que modificar los enemigos de los jugadores en caso de que
            // sean sectarios
            for(Player p: players){
                
                if(p.getEnemy().equals(currentPlayer))
                    p.setEnemyPlayer(cp);
                
            }
            
            players.set(players.indexOf(currentPlayer), cp);
            currentPlayer = cp;
            
        }
        
        return combatResult;
        
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        
        for(Treasure treasure : treasures){
            
            currentPlayer.discardVisibleTreasure(treasure);
            
            dealer.giveTreasureBack(treasure);
            
        }
        
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        
        for(Treasure treasure : treasures){
            
            currentPlayer.discardHiddenTreasure(treasure);
            
            dealer.giveTreasureBack(treasure);
            
        }
        
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        
        for(Treasure treasure : treasures){
            
            currentPlayer.makeTreasureVisible(treasure);
            
        }
        
    }
    
  public void initGame(ArrayList<String> players){
        
        initPlayers(players);
        setEnemies();
        
        dealer.initCards();
        
        nextTurn();
        
    }
    
    public boolean nextTurn(){
        
        boolean stateOk = nextTurnIsAllowed();
        
        if(stateOk){
            
            currentMonster = dealer.nextMonster();
            
            currentPlayer = nextPlayer();
                        
            if(currentPlayer.isDead()){
                
                currentPlayer.initTreasures();
                
            }
            
        }
        
        return stateOk;
    }
    
    public boolean endOfGame(CombatResult result){
        return result==CombatResult.WINGAME;
    }
    
    ///////////////////////////////////////////////////////////////////////////
    // Genera un número aleatorio int de 0 al valor que recibe por parámetro
    //
    private int getRandomInt(int number){
        return new Random().nextInt(number+1);
    }
    
}
