# encoding: utf-8
# 
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Prize
  
  public
  
  def initialize(treasures, levels) 
    @treasures = treasures
    @level = levels
  end
  
  def get_treasures
    @treasures
  end
  
  def get_levels
    @level
  end

  # Devuelve un string con el buen rollo del monstruo
  def to_s    
    "Prize -> Treasures: #{@treasures}, Level: #{@level}"    
  end
  
end
