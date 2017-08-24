# encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require "singleton"
require_relative "treasure.rb"
require_relative "treasure_kind.rb"
require_relative "monster.rb"
require_relative "bad_consequence.rb"
require_relative "prize.rb"
require_relative "cultist.rb"

class CardDealer
    
  include Singleton
  
  private
    
  def initialize
    @unusedMonsters = Array.new
    @usedMonsters = Array.new
    @unusedTreasures = Array.new
    @usedTreasures = Array.new
    
    #Práctica 4
    @unusedCultist = Array.new
    @usedCultist = Array.new
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
    
    @unusedMonsters << Monster.new_basic_monster("El rey de rosa", 13, 
      NumericBadConsequence.new("Pierdes 5 niveles y 3 tesoros " +
          "visibles", 5, 3, 0), Prize.new(4, 2))
    
    @unusedMonsters << Monster.new_basic_monster("Ángeles de la noche ibicenca", 14,
      SpecificBadConsequence.new("Te atrapan para llevarte de " +
          "fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y " +
          "1 mano oculta", 0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND]), 
      Prize.new(4, 1))
    
    @unusedMonsters << Monster.new_basic_monster("3 Byakhees de bonanza", 8, 
      SpecificBadConsequence.new("Pierdes tu armadura visible y " +
          "otra oculta", 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR]),
      Prize.new(2, 1))
    
    @unusedMonsters << Monster.new_basic_monster("Chibithulhu", 2, 
      SpecificBadConsequence.new("Embobados con el lindo " +
          "primigenio te descartas de tu casco visible", 0, [TreasureKind::HELMET],
        Array.new), Prize.new(1, 1))
    
    @unusedMonsters << Monster.new_basic_monster("El sopor de Dunwich", 2,
      SpecificBadConsequence.new("El primordial bostezo contagioso." +
          " Pierdes el calzado visible", 0, [TreasureKind::SHOE], Array.new), 
      Prize.new(1, 1))
    
    @unusedMonsters << Monster.new_basic_monster("El gorrón en el umbral", 10,
      NumericBadConsequence.new("Pierdes todos tus tesoros visibles", 
        0, BadConsequence::MAXTREASURES, 0), Prize.new(3, 1))
    
    @unusedMonsters << Monster.new_basic_monster("H.P. Munchcraft", 6,
      SpecificBadConsequence.new("Pierdes la armadura visible", 0,
        [TreasureKind::ARMOR], Array.new), Prize.new(2, 1))
    
    @unusedMonsters << Monster.new_basic_monster("Bichgooth", 2,
      SpecificBadConsequence.new("Sientes bichos bajo la ropa. " +
          "Descarta la armadura visible", 0, [TreasureKind::ARMOR], Array.new),
      Prize.new(1, 1))
    
    @unusedMonsters << Monster.new_basic_monster("La que redacta en las tinieblas", 2,
      NumericBadConsequence.new("Toses los pulmones y pierdes 2 " +
          "niveles", 2, 0, 0), Prize.new(1, 1))
    
    @unusedMonsters << Monster.new_basic_monster("Los hondos", 8,
      DeathBadConsequence.new("Estos monstruos resultan bastante superficiales" +
          " y te aburren mortalmente. Estás muerto", true), Prize.new(2, 1))
    
    @unusedMonsters << Monster.new_basic_monster("Semillas Cthulhu", 4,
      NumericBadConsequence.new("Pierdes 2 niveles y 2 tesoros" +
          " ocultos", 2, 0, 2), Prize.new(2, 1))
    
    @unusedMonsters << Monster.new_basic_monster("Dameargo", 1,
      SpecificBadConsequence.new("Te intentas escaquear. Pierdes " +
          "una mano visible", 0, [TreasureKind::ONEHAND], Array.new),
      Prize.new(2, 1))
    
    @unusedMonsters << Monster.new_basic_monster("Pollipólipo volante", 3,
      NumericBadConsequence.new("Da mucho asquito. Pierdes 3 " +
          "niveles", 3, 0, 0), Prize.new(1, 1))
    
    @unusedMonsters << Monster.new_basic_monster("Yskhtihyssg-Goth", 12,
      DeathBadConsequence.new("No le hace gracia que pronuncien mal su nombre. " +
          "Estás muerto", true), Prize.new(3, 1))
    
    @unusedMonsters << Monster.new_basic_monster("Familia feliz", 1,
      DeathBadConsequence.new("La familia te atrapa. Estás muerto", true), 
      Prize.new(4, 1))
    
    @unusedMonsters << Monster.new_basic_monster("Roboggoth", 8,
      SpecificBadConsequence.new("La quinta directiva primaria te " +
          "obliga a perder 2 niveles y un tesoro 2 manos visible", 2, 
        [TreasureKind::BOTHHANDS], Array.new), Prize.new(2, 1))
    
    @unusedMonsters << Monster.new_basic_monster("El espía", 5,
      SpecificBadConsequence.new("Te asusta en la noche. Pierdes " +
          "un casco visible", 0, [TreasureKind::HELMET], Array.new), Prize.new(1, 1))
    
    @unusedMonsters << Monster.new_basic_monster("El Lenguas", 20,
      NumericBadConsequence.new("Menudo susto te llevas. Pierdes" +
          " 2 niveles y 5 tesoros visibles", 2, 5, 0), Prize.new(1, 1))
    
    @unusedMonsters << Monster.new_basic_monster("Bicéfalo", 20,
      SpecificBadConsequence.new("Te faltan manos para tanta cabeza" +
          ". Pierdes 3 niveles y tus tesoros visibles de las manos", 3,
        [TreasureKind::ONEHAND, TreasureKind::ONEHAND, TreasureKind::BOTHHANDS], Array.new),
      Prize.new(1, 1))
    
    @unusedMonsters << Monster.new("El mal indecible impronunciable", 10,
      SpecificBadConsequence.new("Pierdes 1 mano visible", 0,
        [TreasureKind::ONEHAND], Array.new),
      Prize.new(3, 1), -2)
    
    @unusedMonsters << Monster.new("Testigos oculares", 6,
      NumericBadConsequence.new("Pierdes tus tesoros visibles. Jajaja", 
        0, BadConsequence::MAXTREASURES, 0), Prize.new(2, 1), 2)
    
    @unusedMonsters << Monster.new("El gran Cthulhu", 20,
      DeathBadConsequence.new("Hoy no es tu día de suerte. Mueres", true), 
      Prize.new(2, 5), -2)
    
    @unusedMonsters << Monster.new("Serpiente Político", 8,
      NumericBadConsequence.new("Tu gobierno te recorta 2 niveles", 
        2, 0, 0), Prize.new(2, 1), -2)
    
    @unusedMonsters << Monster.new("Felpuggoth", 2,
      SpecificBadConsequence.new("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas", 
        0, [TreasureKind::ARMOR, TreasureKind::HELMET], [TreasureKind::ONEHAND, TreasureKind::ONEHAND, TreasureKind::BOTHHANDS]),
      Prize.new(1, 1), 5)
    
    @unusedMonsters << Monster.new("Shoggoth", 16,
      NumericBadConsequence.new("Pierdes 2 niveles", 
        2, 0, 0), Prize.new(4, 2), -4)
    
    @unusedMonsters << Monster.new("Lolitagooth", 2,
      NumericBadConsequence.new("Pintalabios negro. Pierdes 2 niveles", 
        2, 0, 0), Prize.new(1, 1), 3)
    
    shuffle_monsters
    
  end
  
  # Práctica 4
  def init_cultist_card_deck
    
    @unusedCultist << Cultist.new("Sectario", 1)
    @unusedCultist << Cultist.new("Sectario", 2)
    @unusedCultist << Cultist.new("Sectario", 1)
    @unusedCultist << Cultist.new("Sectario", 2)
    @unusedCultist << Cultist.new("Sectario", 1)
    @unusedCultist << Cultist.new("Sectario", 1)
    
    shuffle_cultist
        
  end
  
  def shuffle_treasures
    @unusedTreasures.shuffle!
  end
  
  def shuffle_monsters
    @unusedMonsters.shuffle!
  end
  
  # Práctica 4
  def shuffle_cultist
    @unusedCultist.shuffle!
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
  
  # Práctica 4
  def next_cultist
    
    if !@unusedCultist.any?
    
      @unusedCultist = Array.new(@usedCultist)
      shuffle_cultist
      @usedCultist.clear
      
    end    
    
    c = @unusedCultist[0]
    
    @unusedCultist.shift
    
    c
    
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
    
    #Práctica 4
    init_cultist_card_deck
    
  end
  
end
