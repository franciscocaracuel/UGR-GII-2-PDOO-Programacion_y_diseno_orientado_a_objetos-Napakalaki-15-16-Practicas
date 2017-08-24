# encoding: utf-8
# 
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class BadConsequence
    
  attr_accessor :text, :levels, :nVisibleTreasures, :nHiddenTreasures, :death
    
  attr_accessor :specificHiddenTreasures, :specificVisibleTreasures
  
  
  public
  
  def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures, 
    someSpecificVisibleTreasures, someSpecificHiddenTreasures, death)
    @text = aText
    @levels = someLevels
    @nVisibleTreasures = someVisibleTreasures
    @nHiddenTreasures = someHiddenTreasures
    @death = death
    @specificHiddenTreasures = someSpecificHiddenTreasures
    @specificVisibleTreasures = someSpecificVisibleTreasures
  end
  
  # Primer "constructor"
  def BadConsequence.newLevelNumberOfTreasures(aText, someLevels, 
      someVisibleTreasures, someHiddenTreasures)
    
    new(aText, someLevels,someVisibleTreasures, someHiddenTreasures, Array.new, 
      Array.new, false)
    
  end
  
  # Segundo "constructor"
  def BadConsequence.newLevelSpecificTreasures(aText, someLevels, 
      someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    
    new(aText, someLevels, 0, 0, someSpecificVisibleTreasures,
      someSpecificHiddenTreasures, false)
    
  end
  
  def BadConsequence.newDeath(aText)
    
    new(aText, 0, 0, 0, Array.new, Array.new, true)
    
  end
  
  # Se declara el método new privado
  private_class_method :new
  
  # Devuelve un string con la BadConsequence del monstruo
  def to_s
   
    "BD: #{@text}, Levels: #{@levels}, NVisibleTreasures: #{@nVisibleTreasures}," +
        " NHiddenTreasures: #{@nHiddenTreasures}, Death: #{@death}," +
        " SpecificHiddenTreasures: #{@specificHiddenTreasures}," +
        " SpecificVisibleTreasures: #{@specificVisibleTreasures}"
    
  end
  
end
