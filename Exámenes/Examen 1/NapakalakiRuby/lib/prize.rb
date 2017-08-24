# encoding: utf-8
# 
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Prize
  
  # Primera forma de crear los consultores
  attr_accessor :treasures, :level  
  
  def initialize(treasures, level) 
    @treasures = treasures
    @level = level
  end

  # Devuelve un string con el buen rollo del monstruo
  def to_s
    
    "Prize -> Treasures: #{@treasures}, Level: #{@level}"
    
  end
    
  # Segunda forma de crear los consultores
  #def treasures
  #  @treasures
  #end
  
  #def level
  #  @teasures
  #end
  
end
