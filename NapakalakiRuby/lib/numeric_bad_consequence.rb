# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "bad_consequence.rb"

class NumericBadConsequence < BadConsequence
  
  public
  
  def initialize(t, l, v, h)
    super(t, l)
    @nVisibleTreasures = v
    @nHiddenTreasures = h
  end
  
  public_class_method :new
  
  # Getters
  def get_n_visible_treasures
    @nVisibleTreasures
  end
  
  def get_n_hidden_treasures
    @nHiddenTreasures
  end
  
  # Setters
  def set_n_visible_treasures(n)
    @nVisibleTreasures = n
  end
  
  def set_n_hidden_treasures(h)
    @nHiddenTreasures = h
  end
  
  # Utils
  def is_empty
    @nVisibleTreasures==0 && @nHiddenTreasures==0
  end
  
  def substract_visible_treasure(t)
    if @nVisibleTreasures>0
      @nVisibleTreasures = @nVisibleTreasures - 1
    end
  end
  
  def substract_hidden_treasure(t)
    if @nHiddenTreasures>0
      @nHiddenTreasures = @nHiddenTreasures - 1
    end
  end
  
  def adjust_to_fit_treasure_lists(v, h)
    
    bc_aux = NumericBadConsequence.new("", 0, 0, 0)
    
    # Si los tesoros visibles que se reciben no están vacíos
    if v.any? && @nVisibleTreasures>0

        # Si tiene nVisibleTreasures para descontar
        if @nVisibleTreasures>=v.length
          bc_aux.set_n_visible_treasures(v.length)
        else
          bc_aux.set_n_visible_treasures(@nVisibleTreasures)
        end
                
    end
    
    # Si los tesoros ocultos que se reciben no están vacíos
    if h.any? && @nHiddenTreasures>0

        # Si tiene nHiddenTreasures para descontar
        if @nHiddenTreasures>=h.length
          bc_aux.set_n_hidden_treasures(h.length)
        else
          bc_aux.set_n_hidden_treasures(@nHiddenTreasures)
        end
                  
    end
    
    bc_aux
    
  end
  
  def to_s
    super + ", NVisibleTreasures: #{@nVisibleTreasures}," +
        " NHiddenTreasures: #{@nHiddenTreasures}"
  end
    
end
