# encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "card_dealer.rb"
require_relative "dice.rb"
require_relative "combat_result.rb"
require_relative "bad_consequence.rb"
require_relative "numeric_bad_consequence.rb"
require_relative "specific_bad_consequence.rb"
require_relative "death_bad_consequence.rb"
require_relative "monster.rb"

class Player
  
  # A lo largo de la clase hay muchos cambios de private y public para seguir
  # el orden del diagrama
  
  public
  
  MAXLEVEL = 10
  
  def initialize(name)
    @name = name
    @level = 1
    @dead = true
    @canISteal = true
    @enemy
    @hiddenTreasures = Array.new
    @visibleTreasures = Array.new
    @pendingBadConsequence = NumericBadConsequence.new("", 0, 0, 0)
  end
  
  # Práctica 4
  def Player.new_player(p)
    new(p.get_name())
    @level = p.level
    @dead = p.dead
    @canISteal = p.canISteal
    @enemy = p.enemy
    @hiddenTreasures = p.hiddenTreasures
    @visibleTreasures = p.visibleTreasures
    @pendingBadConsequence = p.pendingBadConsequence
  end
  
  def get_name
    @name
  end
  
  def get_levels
    @level
  end
  
  def get_enemy
    @enemy
  end
  
  private
  
  def bring_to_life
    @dead = false
  end
  
  protected
  def get_combat_level
    
    level_aux = @level
    
    @visibleTreasures.each { |t|
    
      level_aux = level_aux + t.get_bonus
      
    }
    
    level_aux
    
  end
  
  private
  def increment_levels(l)
    
    if @level+l>=MAXLEVEL
      @level = MAXLEVEL
    else
      @level += l
    end
    
  end
  
  def decrement_levels(l)
    
    if @level-l<=1
      @level = 1
    else
      @level -= l
    end
    
  end
  
  def set_pending_bad_consequence(bc)
    @pendingBadConsequence = bc
  end
  
  def apply_prize(m)
    
    increment_levels(m.get_levels_gained)
    
    n_treasures = m.get_treasures_gained
    
    if n_treasures>0
      
      i = 0
      
      until i >= n_treasures do
        
        @hiddenTreasures << CardDealer.instance.next_treasure
        
        i += 1
        
      end
      
    end
    
  end
  
  def apply_bad_consequence(m)
    
    decrement_levels(m.get_bad_consequence.get_levels)
    
    set_pending_bad_consequence(m.get_bad_consequence.adjust_to_fit_treasure_lists(@visibleTreasures, @hiddenTreasures))
 
  end
  
  def can_make_treasure_visible(t)
    
    can = true
    
    case t.get_type
      
    when TreasureKind::ARMOR, TreasureKind::HELMET, TreasureKind::SHOE

      i = 0
      
      while can && i<@visibleTreasures.length do
        
        if @visibleTreasures[i].get_type == t.get_type
      
          can = false
        end
        
        i += 1
        
      end
      
    when TreasureKind::BOTHHANDS
    
      i = 0
      
      while can && i<@visibleTreasures.length do
        
        can = @visibleTreasures[i].get_type!=TreasureKind::ONEHAND && @visibleTreasures[i].get_type!=TreasureKind::BOTHHANDS
        
        i += 1
        
      end
      
    when TreasureKind::ONEHAND
   
      i = 0
      total_hands = 0
      
      while can && i<@visibleTreasures.length do
        
        if @visibleTreasures[i].get_type==TreasureKind::ONEHAND
          total_hands += 1
        end
        
        can = @visibleTreasures[i].get_type!=TreasureKind::BOTHHANDS && total_hands<2
        
        i += 1
        
      end
      
    end
    
    can
    
  end
  
  def how_many_visible_treasures(t_kind)
    
    total = 0
    
    @visibleTreasures.each { |treasure|
    
      if treasure.get_type == t_kind
        total += 1
      end
      
    }
    
    total
    
  end
  
  def die_if_no_treasures
    
    if !@visibleTreasures.any? && !@hiddenTreasures.any?
      @dead = true      
    end
    
  end
  
  public
  
  def is_dead
    @dead
  end
  
  def get_hidden_treasures
    @hiddenTreasures
  end
  
  def get_visible_treasures
    @visibleTreasures
  end
  
  def combat(m)
        
    my_level = get_combat_level
    
    monster_level = get_oponent_level(m)
    
    if my_level>monster_level
      
      apply_prize(m)
      
      if @level >= MAXLEVEL
        combat_result = CombatResult::WINGAME
      else
        combat_result = CombatResult::WIN
      end
      
    else
      
      apply_bad_consequence(m)
      
      if(should_convert)
        combat_result = CombatResult::LOSEANDCONVERT
      else
        combat_result = CombatResult::LOSE
      end
      
    end
    
    combat_result
    
  end
  
  def make_treasure_visible(t)
            
    if can_make_treasure_visible(t)
      
      @visibleTreasures << t
      @hiddenTreasures.delete(t)
      
    end
    
  end
  
  def discard_visible_treasure(t)
    
    @visibleTreasures.delete(t)
    
    if !@pendingBadConsequence.nil? && !@pendingBadConsequence.is_empty
      @pendingBadConsequence.substract_visible_treasure(t)
    end
    
    die_if_no_treasures
    
  end
  
  def discard_hidden_treasure(t)
    
    @hiddenTreasures.delete(t)
    
    if !@pendingBadConsequence.is_empty
      @pendingBadConsequence.substract_hidden_treasure(t)
    end
    
    die_if_no_treasures
    
  end
  
  def valid_state
    @pendingBadConsequence.is_empty && @hiddenTreasures.size<=4
  end
  
  def init_treasures
    
    dealer = CardDealer.instance
    dice = Dice.instance
    
    bring_to_life
    
    # Coge 1 tesoro
    @hiddenTreasures << dealer.next_treasure
    
    number = dice.next_number
    
    if number>1
      # Coge 2 tesoros
      @hiddenTreasures << dealer.next_treasure
    end
    
    if number==6
      # Coge 3 tesoros
      @hiddenTreasures << dealer.next_treasure
    end
    
  end
  
  def steal_treasure
    
    treasure = nil
    
    if @canISteal && @enemy.can_you_give_me_a_treasure
      
      treasure = @enemy.give_me_a_treasure
      
      @hiddenTreasures << treasure
      
      # Se elimina el tesoro robado al enemigo
      @enemy.get_hidden_treasures.delete(treasure)
      
      have_stolen
      
    end
    
    treasure
    
  end
  
  def set_enemy_player(enemy)
    @enemy = enemy
  end
  
  protected
  
  def give_me_a_treasure
    
    @hiddenTreasures[rand(@hiddenTreasures.length)]
    
  end
  
  public
  
  def can_i_steal
    @canISteal
  end
  
  protected
  
  def can_you_give_me_a_treasure
    @hiddenTreasures.any? || @visibleTreasures.any?
  end
  
  def have_stolen
    @canISteal = !@canISteal
  end
  
  public
  
  def discard_all_treasures
    
    visible_treasures_aux = Array.new(@visibleTreasures)
    hidden_treasures_aux = Array.new(@hiddenTreasures)
    
    visible_treasures_aux.each { |treasure|
    
      discard_visible_treasure(treasure)
      
    }
    
    hidden_treasures_aux.each { |treasure|
    
      discard_hidden_treasure(treasure)
      
    }
    
  end
  
  #Práctica 4
  protected
  def get_oponent_level(m)    
    m.get_combat_level    
  end
  
  def should_convert
    
    cultist = false
    
    if Dice.instance.next_number==6
      cultist = true
    end
    
    cultist
    
  end
  
  public
  
  def to_s
    "Player --> Name: #{@name}, Level: #{@level}, Dead: #{@dead}, CanISteal: #{@canISteal}"
  end
  
end
