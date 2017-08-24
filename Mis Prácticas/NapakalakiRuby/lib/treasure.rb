# encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Treasure
  
  public
  
  def initialize(n, bonus, t)
    @name = n
    @bonus = bonus
    @type = t
  end
  
  def get_name
    @name
  end
  
  def get_bonus
    @bonus
  end
  
  def get_type
    @type
  end
  
  def to_s
    "Treasure: #{@name}, Bonus: #{@bonus}, Type: #{@type}"
  end
  
end
