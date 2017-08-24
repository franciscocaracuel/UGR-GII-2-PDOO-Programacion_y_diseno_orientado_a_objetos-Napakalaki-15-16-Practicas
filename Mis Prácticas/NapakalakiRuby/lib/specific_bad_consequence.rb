# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "bad_consequence.rb"

class SpecificBadConsequence < BadConsequence
  
  public
  
  def initialize(t, l, v ,h)
    super(t, l)
    @specificVisibleTreasures = v
    @specificHiddenTreasures = h
  end
    
  public_class_method :new
  
  # Getters
  def get_specific_visible_treasures
    @specificVisibleTreasures
  end
  
  def get_specific_hidden_treasures
    @specificHiddenTreasures
  end
  
  # Setters
  def set_specific_visible_treasures(v)
    @specificVisibleTreasures = v
  end
  
  def set_specific_hidden_treasures(h)
    @specificHiddenTreasures = h
  end
  
  # Utils
  def is_empty
    
    if @specificHiddenTreasures.nil?
      @specificHiddenTreasures = Array.new
    end
    
    @specificVisibleTreasures.empty? and @specificHiddenTreasures.empty?
          
  end
  
  def substract_visible_treasure(t)
    @specificVisibleTreasures.delete_at(@specificVisibleTreasures.index(t.get_type) || @specificVisibleTreasures.length)
  end
  
  def substract_hidden_treasure(t)
    @specificHiddenTreasures.delete_at(@specificHiddenTreasures.index(t.get_type) || @specificHiddenTreasures.length)
  end
  
  def adjust_to_fit_treasure_lists(v, h)
    
    bc_aux = SpecificBadConsequence.new("", 0, Array.new, Array.new)
    
    # Si los tesoros visibles que se reciben no están vacíos
    if v.any? && @specificVisibleTreasures.any?
                    
          tr_aux = Array.new
          
          v.each { |t|
          
            if @specificVisibleTreasures.include?(t.get_type)
              tr_aux << t.get_type
            end
            
          }
          
          bc_aux.set_specific_visible_treasures(tr_aux)
                  
    end
    
    # Si los tesoros ocultos que se reciben no están vacíos
    if h.any? && @specificHiddenTreasures.any?
                       
          tr_aux_h = Array.new
          
          h.each { |t|
          
            if @specificHiddenTreasures.include?(t.get_type)
              tr_aux_h << t.get_type
            end
            
          }
          
          bc_aux.set_specific_hidden_treasures(tr_aux_h)
                     
    end
    
    bc_aux
    
  end
  
  def to_s
    super + ", SpecificHiddenTreasures: #{@specificHiddenTreasures}," +
        " SpecificVisibleTreasures: #{@specificVisibleTreasures}"
  end
  
end
