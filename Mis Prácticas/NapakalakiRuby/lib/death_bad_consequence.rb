# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "numeric_bad_consequence.rb"

class DeathBadConsequence < NumericBadConsequence
  
  def initialize(t, d)
    super(t, Player::MAXLEVEL, BadConsequence::MAXTREASURES, 
      BadConsequence::MAXTREASURES)
    @death = d
  end
  
  # Getters
  def get_death
    @death
  end
  
  # Setters
  def set_death(d)
    @death = d
  end
  
  # Utils
  def is_empty
    super && !@death
  end
  
  def to_s
    super + ", Death = #{@death}"
  end
  
end
