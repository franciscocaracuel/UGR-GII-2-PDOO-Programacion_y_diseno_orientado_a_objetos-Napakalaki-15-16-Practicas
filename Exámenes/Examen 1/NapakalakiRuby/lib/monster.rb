# encoding: utf-8
# 
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Monster
  
  attr_accessor :name, :combatLevel, :bc, :prize, :miAlterEgo
    
  public
  
  # Constructor
  def initialize(name, combatLevel, bc, prize)
    @name = name
    @combatLevel = combatLevel
    @bc = bc
    @prize = prize
  end
  
  # EXAMEN-inicio
  def getMiAlterEgo
    miAlterEgo
  end
  
  def setMiAlterEgo(mi_alter_ego)
    @miAlterEgo = mi_alter_ego
  end
  
  # EXAMEN-fin
  
  # Devuelve un string con los datos del monstruo
  def to_s
    
    "Monster: #{@name}; CombatLevel: #{@combatLevel}; \n\t#{@bc.to_s}; " +
      "\t#{@prize.to_s}"
    
  end
  
end
