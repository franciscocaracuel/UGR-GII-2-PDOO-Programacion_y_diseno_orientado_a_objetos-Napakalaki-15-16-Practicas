# encoding: utf-8
# 
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative 'player.rb'
require_relative 'treasure.rb'

class BadConsequence

  MAXTREASURES = 10
  
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
  def BadConsequence.new_level_number_of_treasures(aText, someLevels, 
      someVisibleTreasures, someHiddenTreasures)
    
    new(aText, someLevels,someVisibleTreasures, someHiddenTreasures, Array.new, 
      Array.new, false)
    
  end
  
  # Segundo "constructor"
  def BadConsequence.new_level_specific_treasures(aText, someLevels, 
      someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    
    new(aText, someLevels, 0, 0, someSpecificVisibleTreasures,
      someSpecificHiddenTreasures, false)
    
  end
  
  def BadConsequence.new_death(aText)
    
    new(aText, Player::MAXLEVEL, MAXTREASURES, MAXTREASURES, Array.new, Array.new, true)
    
  end
  
  # Se declara el método new privado
  private_class_method :new

  # Getters  
  def get_text
    @text
  end
  
  def get_levels
    @levels
  end
  
  def get_n_visible_treasures
    @nVisibleTreasures
  end
  
  def get_n_hidden_treasures
    @nHiddenTreasures
  end
  
  def get_death
    @death
  end
  
  def get_specific_hidden_treasures
    @specificHiddenTreasures
  end
  
  def get_specific_visible_treasures
    @specificVisibleTreasures
  end
  
  private
  
  # Setters
  def set_text(text)
    @text = text
  end
  
  def set_levels(levels)
    @levels = levels
  end
  
  def set_death(death)
    @death = death
  end
  
  # Hay que ponerlo protected porque pendingbadconsequence los usa
  protected
  
  def set_n_visible_treasures(nVisibleTreasures)
    @nVisibleTreasures = nVisibleTreasures
  end
  
  def set_n_hidden_treasures(nHiddenTreasures)
     @nHiddenTreasures = nHiddenTreasures
  end
  
  def set_specific_visible_treasures(sVisible)
    @specificVisibleTreasures = Array.new(sVisible)
  end
  
  def set_specific_hidden_treasures(sHidden)
    @specificHiddenTreasures = Array.new(sHidden)
  end
  
  public
  
  def is_empty
    
    bad = false
    
    if @nVisibleTreasures==0 && @nHiddenTreasures==0 &&
        !@specificHiddenTreasures.any? && !@specificVisibleTreasures.any?
      bad = true
    end
    
    bad
    
  end
  
  def substract_visible_treasure(t)
    
    if @specificVisibleTreasures.index(t.get_type).nil?
      
      if @nVisibleTreasures>0
        @nVisibleTreasures = @nVisibleTreasures - 1
      end
      
    else
      
      # delete borra todas las ocurrencias, en caso de tener 2 onehand borraría
      # las dos. Por eso, se usa delete_at      
      #@specificVisibleTreasures.delete(t.get_type)
      @specificVisibleTreasures.delete_at(@specificVisibleTreasures.index(t.get_type) || @specificVisibleTreasures.length)
      
    end
    
  end
  
  def substract_hidden_treasure(t)
    
    if @specificHiddenTreasures.index(t.get_type).nil?
      
      if @nHiddenTreasures>0
        @nHiddenTreasures = @nHiddenTreasures - 1
      end
      
    else
      
      #@specificHiddenTreasures.delete(t.get_type)
      @specificHiddenTreasures.delete_at(@specificHiddenTreasures.index(t.get_type) || @specificHiddenTreasures.length)
      
    end
    
  end
  
  def adjust_to_fit_treasure_lists(v, h)
        
    bc_aux = BadConsequence.new_level_number_of_treasures("", 0, 0, 0)
    
    # Si los tesoros visibles que se reciben no están vacíos
    if v.any?
      
      # Si el jugador no tiene tesoros visibles equipados y tiene
      # algún tesoro visible
      if(!@specificVisibleTreasures.any? && @nVisibleTreasures>0)
     
        # Si tiene nVisibleTreasures para descontar
        if @nVisibleTreasures>=v.length
          bc_aux.set_n_visible_treasures(v.length)
        else
          bc_aux.set_n_visible_treasures(@nVisibleTreasures)
        end
        
      else
        
        # Si el jugador tiene tesoros visibles equipados
        if @specificVisibleTreasures.any?
          
          tr_aux = Array.new
          
          v.each { |t|
          
            if @specificVisibleTreasures.include?(t.get_type)
              tr_aux << t.get_type
            end
            
          }
          
          bc_aux.set_specific_visible_treasures(tr_aux)
          
        end
        
      end
              
    end
    
    # Si los tesoros ocultos que se reciben no están vacíos
    if h.any?
      
      # Si el jugador no tiene tesoros ocultos equipados y tiene
      # algún tesoro oculto
      if(!@specificHiddenTreasures.any? && @nHiddenTreasures>0)
    
        # Si tiene nHiddenTreasures para descontar
        if @nHiddenTreasures>=h.length
          bc_aux.set_n_hidden_treasures(h.length)
        else
          bc_aux.set_n_hidden_treasures(@nHiddenTreasures)
        end
        
      else
        
        # Si el jugador tiene tesoros ocultos equipados
        if @specificHiddenTreasures.any?
          
          tr_aux_h = Array.new
          
          h.each { |t|
          
            if @specificHiddenTreasures.include?(t.get_type)
              tr_aux_h << t.get_type
            end
            
          }
          
          bc_aux.set_specific_hidden_treasures(tr_aux_h)
          
        end
        
      end
              
    end
    
    bc_aux
    
  end
  
  # Devuelve un string con la BadConsequence del monstruo
  def to_s
   
    "BD: #{@text}, Levels: #{@levels}, NVisibleTreasures: #{@nVisibleTreasures}," +
        " NHiddenTreasures: #{@nHiddenTreasures}, Death: #{@death}," +
        " SpecificHiddenTreasures: #{@specificHiddenTreasures}," +
        " SpecificVisibleTreasures: #{@specificVisibleTreasures}"
    
  end
  
end
