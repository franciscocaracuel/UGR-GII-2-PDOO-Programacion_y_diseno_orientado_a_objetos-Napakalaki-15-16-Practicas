# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Cultist
  
  public
  
  def initialize(name, gained_levels)
    @name = name
    @gainedLevels = gained_levels
  end
  
  def get_name
    @name
  end
  
  def get_gained_levels
    @gainedLevels
  end
  
  # Devuelve un string con los datos
  def to_s
    puts "Cultist -> Name: #{@name}, Gained levels: #{@gainedLevels}"
  end
  
end
