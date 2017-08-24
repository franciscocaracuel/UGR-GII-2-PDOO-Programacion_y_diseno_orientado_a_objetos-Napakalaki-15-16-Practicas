# encoding: utf-8
# 
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Monster
      
  public
      
  # Constructor
  def initialize(name, combatLevel, bc, prize)
    @name = name
    @combatLevel = combatLevel
    @badConsequence = bc
    @prize = prize
  end
  
  #Getters
  def get_name
    @name
  end
  
  def get_combat_level
    @combatLevel
  end
  
  def get_bad_consequence
    @badConsequence
  end
  
  def get_levels_gained
    @prize.get_levels()
  end
  
  def get_treasures_gained
    @prize.get_treasures()
  end
  
  def get_prize
    @prize
  end
    
  # Devuelve un string con los datos del monstruo
  def to_s
    
    "Monster: #{@name}; CombatLevel: #{@combatLevel}; \n\t#{@badConsequence.to_s}; " +
      "\t#{@prize.to_s}"
    
  end
  
end
