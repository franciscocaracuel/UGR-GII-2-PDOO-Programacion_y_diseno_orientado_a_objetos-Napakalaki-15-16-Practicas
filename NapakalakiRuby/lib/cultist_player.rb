# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "player.rb"
require_relative "cultist.rb"

class CultistPlayer < Player
  
  @@totalCultistPlayer = 0
  
  def initialize(p, c)
    super(p)
    @myCultistCard = c
    @@totalCultistPlayer += 1    
  end
  
  def get_my_cultist_card
    @myCultistCard
  end
  
  def self.get_total_cultist_players
    @@totalCultistPlayer
  end
  
  protected
  def get_combat_level
    (super + super*0.2 + 
      @myCultistCard.get_gained_levels * @@totalCultistPlayer).ceil
  end
  
  def get_oponent_level(m)
    m.get_combat_level_against_cultist_player
  end
  
  def should_convert
    false
  end
  
  def give_me_a_treasure
    @visibleTreasures[rand(@visibleTreasures.length)]
  end
  
  def can_you_give_me_a_treasure
    return @visibletreasures.any? 
  end
  
  def remove_treasure(t)
    @visibletreasures.delete(t)
  end
  
  public  
  def to_s
    super + ", Cultist: si"
  end
    
end
