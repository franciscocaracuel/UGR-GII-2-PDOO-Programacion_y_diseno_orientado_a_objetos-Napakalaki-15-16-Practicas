# encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require "singleton"
require_relative "treasure.rb"
require_relative "treasure_kind.rb"
require_relative "monster.rb"
require_relative "prize.rb"

class CardDealer
    
  include Singleton
  
  private
    
  def initialize
    @unusedMonsters = Array.new
    @usedMonsters = Array.new
    @unusedTreasures = Array.new
    @usedTreasures = Array.new
  end
  
  # Se declara el método new privado
  private_class_method :new
  
  def init_treasure_card_deck
    
    @unusedTreasures << Treasure.new("¡Sí mi amo", 4, 
      TreasureKind::HELMET)
    @unusedTreasures << Treasure.new("Botas de investigación", 3, 
      TreasureKind::SHOE)
    @unusedTreasures << Treasure.new("Capucha de Cthulhu", 3, 
      TreasureKind::HELMET)
    @unusedTreasures << Treasure.new("A prueba de balas", 2, 
      TreasureKind::ARMOR)
    @unusedTreasures << Treasure.new("Botas de lluvia ácida", 1, 
      TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Casco minero", 2, 
      TreasureKind::HELMET)
    @unusedTreasures << Treasure.new("Ametralladora Thompson", 4, 
      TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Camiseta de la UGR", 1, 
      TreasureKind::ARMOR)
    @unusedTreasures << Treasure.new("Clavo de rail ferroviario", 3, 
      TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Cuchillo de sushi arcano", 2, 
      TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Fez alópodo", 3, 
      TreasureKind::HELMET)
    @unusedTreasures << Treasure.new("Hacha prehistórica", 2, 
      TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("El aparato del Pr. Tesla", 4, 
      TreasureKind::ARMOR)
    @unusedTreasures << Treasure.new("Gaita", 4, 
      TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Insecticida", 2, 
      TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Escopeta de 3 cañones", 4, 
      TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Garabato místico", 2, 
      TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("La rebeca metálica", 2, 
      TreasureKind::ARMOR)
    @unusedTreasures << Treasure.new("Lanzallamas", 4, 
      TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Necro-comicón", 1, 
      TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Necronomicón", 5, 
      TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Linterna a 2 manos", 3, 
      TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Necro-gnomicón", 2, 
      TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Necrotelecom", 2, 
      TreasureKind::HELMET)
    @unusedTreasures << Treasure.new("Mazo de los antiguos", 3, 
      TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Necro-playboycón", 3, 
      TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Porra preternatural", 2, 
      TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Shogulador", 1, 
      TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Varita de atizamiento", 3, 
      TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Tentáculo de pega", 2, 
      TreasureKind::HELMET)
    @unusedTreasures << Treasure.new("Zapato deja-amigos", 1, 
      TreasureKind::SHOE)
    
    shuffle_treasures
        
  end
  
  def init_monster_card_deck
    
    @unusedMonsters << Monster.new("El rey de rosa", 13, 
      BadConsequence.new_level_number_of_treasures("Pierdes 5 niveles y 3 tesoros " +
          "visibles", 5, 3, 0), Prize.new(4, 2))
    
    @unusedMonsters << Monster.new("Ángeles de la noche ibicenca", 14,
      BadConsequence.new_level_specific_treasures("Te atrapan para llevarte de " +
          "fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y " +
          "1 mano oculta", 0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND]), 
      Prize.new(4, 1))
    
    @unusedMonsters << Monster.new("3 Byakhees de bonanza", 8, 
      BadConsequence.new_level_specific_treasures("Pierdes tu armadura visible y " +
          "otra oculta", 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR]),
      Prize.new(2, 1))
    
    @unusedMonsters << Monster.new("Chibithulhu", 2, 
      BadConsequence.new_level_specific_treasures("Embobados con el lindo " +
          "primigenio te descartas de tu casco visible", 0, [TreasureKind::HELMET],
        Array.new), Prize.new(1, 1))
    
    @unusedMonsters << Monster.new("El sopor de Dunwich", 2,
      BadConsequence.new_level_specific_treasures("El primordial bostezo contagioso." +
          " Pierdes el calzado visible", 0, [TreasureKind::SHOE], Array.new), 
      Prize.new(1, 1))
    
    @unusedMonsters << Monster.new("El gorrón en el umbral", 10,
      BadConsequence.new_level_number_of_treasures("Pierdes todos tus tesoros visibles", 
        0, 5, 0), Prize.new(3, 1))
    
    @unusedMonsters << Monster.new("H.P. Munchcraft", 6,
      BadConsequence.new_level_specific_treasures("Pierdes la armadura visible", 0,
        [TreasureKind::ARMOR], Array.new), Prize.new(2, 1))
    
    @unusedMonsters << Monster.new("Bichgooth", 2,
      BadConsequence.new_level_specific_treasures("Sientes bichos bajo la ropa. " +
          "Descarta la armadura visible", 0, [TreasureKind::ARMOR], Array.new),
      Prize.new(1, 1))
    
    @unusedMonsters << Monster.new("La que redacta en las tinieblas", 2,
      BadConsequence.new_level_number_of_treasures("Toses los pulmones y pierdes 2 " +
          "niveles", 2, 0, 0), Prize.new(1, 1))
    
    @unusedMonsters << Monster.new("Los hondos", 8,
      BadConsequence.new_death("Estos monstruos resultan bastante superficiales" +
          " y te aburren mortalmente. Estás muerto"), Prize.new(2, 1))
    
    @unusedMonsters << Monster.new("Semillas Cthulhu", 4,
      BadConsequence.new_level_number_of_treasures("Pierdes 2 niveles y 2 tesoros" +
          " ocultos", 2, 0, 2), Prize.new(2, 1))
    
    @unusedMonsters << Monster.new("Dameargo", 1,
      BadConsequence.new_level_specific_treasures("Te intentas escaquear. Pierdes " +
          "una mano visible", 0, [TreasureKind::ONEHAND], Array.new),
      Prize.new(2, 1))
    
    @unusedMonsters << Monster.new("Pollipólipo volante", 3,
      BadConsequence.new_level_number_of_treasures("Da mucho asquito. Pierdes 3 " +
          "niveles", 3, 0, 0), Prize.new(1, 1))
    
    @unusedMonsters << Monster.new("Yskhtihyssg-Goth", 12,
      BadConsequence.new_death("No le hace gracia que pronuncien mal su nombre. " +
          "Estás muerto"), Prize.new(3, 1))
    
    @unusedMonsters << Monster.new("Familia feliz", 1,
      BadConsequence.new_death("La familia te atrapa. Estás muerto"), 
      Prize.new(4, 1))
    
    @unusedMonsters << Monster.new("Roboggoth", 8,
      BadConsequence.new_level_specific_treasures("La quinta directiva primaria te " +
          "obliga a perder 2 niveles y un tesoro 2 manos visible", 2, 
        [TreasureKind::BOTHHANDS], Array.new), Prize.new(2, 1))
    
    @unusedMonsters << Monster.new("El espía", 5,
      BadConsequence.new_level_specific_treasures("Te asusta en la noche. Pierdes " +
          "un casco visible", 0, [TreasureKind::HELMET], Array.new), Prize.new(1, 1))
    
    @unusedMonsters << Monster.new("El Lenguas", 20,
      BadConsequence.new_level_number_of_treasures("Menudo susto te llevas. Pierdes" +
          " 2 niveles y 5 tesoros visibles", 2, 5, 0), Prize.new(1, 1))
    
    @unusedMonsters << Monster.new("Bicéfalo", 20,
      BadConsequence.new_level_specific_treasures("Te faltan manos para tanta cabeza" +
          ". Pierdes 3 niveles y tus tesoros visibles de las manos", 3,
        [TreasureKind::ONEHAND, TreasureKind::ONEHAND, TreasureKind::BOTHHANDS], Array.new),
      Prize.new(1, 1))
    
    shuffle_monsters
    
  end
  
  def shuffle_treasures
    @unusedTreasures.shuffle!
  end
  
  def shuffle_monsters
    @unusedMonsters.shuffle!
  end
  
  public
  
  def next_treasure
    
    if !@unusedTreasures.any?
    
      @unusedTreasures = Array.new(@usedTreasures)
      shuffle_treasures
      @usedTreasures.clear
      
    end    
    
    t = @unusedTreasures[0]
    
    @unusedTreasures.shift
    
    t
    
  end
  
  def next_monster
    
    if !@unusedMonsters.any?
    
      @unusedMonsters = Array.new(@usedMonster)
      shuffle_monsters
      @usedMonster.clear
      
    end    
    
    m = @unusedMonsters[0]
    
    @unusedMonsters.shift
    
    m
    
  end
  
  def give_treasure_back(t)
    @usedTreasures << t
  end
  
  def give_monster_back(m)
    @usedMonsters << m
  end
  
  def init_cards
    
    init_treasure_card_deck
    init_monster_card_deck
    
  end
  
end
