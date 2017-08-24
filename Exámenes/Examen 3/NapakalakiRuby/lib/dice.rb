# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require "singleton"

class Dice

  include Singleton
  
  private
  
  def initialize
    
  end
  
  private_class_method :new
  
  public
  
  def next_number
    rand(6)+1
  end
    
end
