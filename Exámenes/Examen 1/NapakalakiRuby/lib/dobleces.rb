# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module Dobleces
  
  class AlterEgo
      
  public
  
  @@descripcion = "Un alter ego es una personalidad alternativa y los monstruos también pueden tener amigos"
  
  attr_accessor :nivel_de_bondad, :monstruos_amigos
      
  # Constructor
  def initialize(nivel_de_bondad, monstruos_amigos)
    @nivel_de_bondad = nivel_de_bondad
    @monstruos_amigos = monstruos_amigos
  end
  
  def initialize(nivel_de_bondad)
    @nivel_de_bondad = nivel_de_bondad
    @monstruos_amigos = Array.new
  end
  
  def getNivelDeBondad
    nivel_de_bondad
  end
  
  # Devuelve un string con los datos del monstruo
  def to_s
    
    "AlterEgo: Nivel de bondad: #{nivel_de_bondad}, monstruos: #{monstruos_amigos.length}}"
    
  end
  
end
    
end
