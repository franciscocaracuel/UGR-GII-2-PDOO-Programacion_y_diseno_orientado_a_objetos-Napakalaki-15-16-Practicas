# encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require "singleton"
require_relative "card_dealer.rb"
require_relative "player.rb"
require_relative "bad_consequence.rb"
require_relative "cultist_player.rb"

class Napakalaki
    
  include Singleton
  
  private
    
  def initialize
    @currentMonster
    @currentPlayer
    @players = Array.new
    @dealer = CardDealer.instance
  end
  
  private_class_method :new
  
  # names es un array con el que se inicializan los jugadores
  def init_players(names)
    
    names.each { |name|
          
      @players << Player.new(name)
      
    }
    
    next_player
    
  end
  
  def next_player
    
    # Si no existe el jugador actual, será la primera partida
    if @currentPlayer.nil?
      
      # Se genera el número aleatorio
      i = rand(@players.length) 
      
      @currentPlayer = @players[i]
                  
    # La partida ya ha empezado
    else
      
      # Se guarda el índice de la posición actual + 1
      i = @players.index(@currentPlayer)+1
      
      # Control si desborda
      if @players.length==i
        i = 0
      end
      
    end
    
    @players[i]
    
  end
  
  def next_turn_is_allowed
    
    res = true
    
    unless @currentPlayer.nil?
      res = @currentPlayer.valid_state
    end
    
    res
    
  end
  
  def set_enemies
    
    i = nil
    
    @players.each { |player|
    
      loop do
        
        i = rand(@players.length)
        
        break if i!=@players.index(player)
        
      end
      
      player.set_enemy_player(@players[i])
      
    }
    
  end
  
  public
  
  def develop_combat
    
    combat_result = @currentPlayer.combat(@currentMonster)
    
    @dealer.give_monster_back(@currentMonster)
    
    # Práctica 4
    if combat_result == CombatResult::LOSEANDCONVERT
      
      cp = CultistPlayer.new(@currentPlayer, @dealer.next_cultist)
      
      # Hay que modificar los enemigos de los jugadores en caso de que sean
      # sectarios
      @players.each { |p|
        
        if p.get_enemy == @currentPlayer
          p.set_enemy_player(cp)
        end
        
      }
      
      # @players[@players.index(@currentPlayer)-1] = cp
      @players.delete(@currentPlayer)
      @players << cp
      
      @currentPlayer = cp
      
    end
    
    combat_result
    
  end
  
  def discard_visible_treasures(treasures)
    
    treasures.each { |treasure|
    
      @currentPlayer.discard_visible_treasure(treasure)
      
      @dealer.give_treasure_back(treasure)
      
    }
    
  end
  
  def discard_hidden_treasures(treasures)
    
    treasures.each { |treasure|
    
      @currentPlayer.discard_hidden_treasure(treasure)
      
      @dealer.give_treasure_back(treasure)
      
    }
    
  end
  
  def make_treasures_visible(treasures)
    
    treasures.each { |treasure|
          
      @currentPlayer.make_treasure_visible(treasure)
      
    }
    
  end
  
  def init_game(players)
    
    init_players(players)
    set_enemies
    
    @dealer.init_cards
    
    next_turn
    
  end
  
  def get_current_player
    @currentPlayer
  end
  
  def get_current_monster
    @currentMonster
  end
  
  def next_turn
    
    state_ok = next_turn_is_allowed
    
    if state_ok
      
      @currentMonster = @dealer.next_monster
      
      @currentPlayer = next_player
      
      if @currentPlayer.is_dead
        @currentPlayer.init_treasures
      end
      
    end
    
    state_ok
    
  end
  
  def end_of_game(result)
    
    result==CombatResult::WINGAME
    
  end
  
end
