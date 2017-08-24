# encoding: utf-8
# 
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class BadConsequence

  MAXTREASURES = 10
  
  public
  
  def initialize(aText, someLevels)
    @text = aText
    @levels = someLevels
  end
    
  # Para utilizar esta clase como abstracta
  private_class_method :new
  
  # Getters
  def get_text
    @text
  end
  
  def get_levels
    @levels
  end
  
  # Setters
  def set_text(t)
    @text = t
  end
  
  def set_levels(l)
    @levels = l
  end
  
  # Utils
  def is_empty
    @levels == 0
  end
  
  def substract_visible_treasure(t)
    raise NotImplementedError.new
  end
  
  def substract_hidden_treasure(t)
    raise NotImplementedError.new
  end
  
  def adjust_to_fit_treasure_lists(v, h)
    raise NotImplementedError.new
  end
  
  def to_s
    "BD: #{@text}, Levels: #{@levels}"
  end
    
end
