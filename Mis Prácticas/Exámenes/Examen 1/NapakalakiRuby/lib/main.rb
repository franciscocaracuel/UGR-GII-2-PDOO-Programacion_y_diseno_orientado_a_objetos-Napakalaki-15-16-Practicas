# encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative 'monster.rb'
require_relative 'bad_consequence.rb'
require_relative 'prize'
require_relative 'treasure_kind.rb'

# Se define el array que contendrá a todos los monstruos
monsters = Array.new

# Se añaden todos los monstruos al array
monsters << Monster.new("El rey de rosa", 13, 
  BadConsequence.newLevelNumberOfTreasures("Pierdes 5 niveles y 3 tesoros " +
    "visibles", 5, 3, 0), Prize.new(4, 2))

monsters << Monster.new("Ángeles de la noche ibicenca", 14,
  BadConsequence.newLevelSpecificTreasures("Te atrapan para llevarte de " +
    "fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y " +
    "1 mano oculta", 0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND]), 
  Prize.new(4, 1))

monsters << Monster.new("3 Byakhees de bonanza", 8, 
  BadConsequence.newLevelSpecificTreasures("Pierdes tu armadura visible y " +
    "otra oculta", 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR]),
  Prize.new(2, 1))

monsters << Monster.new("Chibithulhu", 2, 
  BadConsequence.newLevelSpecificTreasures("Embobados con el lindo " +
    "primigenio te descartas de tu casco visible", 0, [TreasureKind::HELMET],
    Array.new), Prize.new(1, 1))

monsters << Monster.new("El sopor de Dunwich", 2,
  BadConsequence.newLevelSpecificTreasures("El primordial bostezo contagioso." +
    " Pierdes el calzado visible", 0, [TreasureKind::SHOES], Array.new), 
  Prize.new(1, 1))

monsters << Monster.new("El gorrón en el umbral", 10,
  BadConsequence.newLevelNumberOfTreasures("Pierdes todos tus tesoros visibles", 
    0, 5, 0), Prize.new(3, 1))

monsters << Monster.new("H.P. Munchcraft", 6,
  BadConsequence.newLevelSpecificTreasures("Pierdes la armadura visible", 0,
    [TreasureKind::ARMOR], Array.new), Prize.new(2, 1))

monsters << Monster.new("Bichgooth", 2,
  BadConsequence.newLevelSpecificTreasures("Sientes bichos bajo la ropa. " +
    "Descarta la armadura visible", 0, [TreasureKind::ARMOR], Array.new),
  Prize.new(1, 1))

monsters << Monster.new("La que redacta en las tinieblas", 2,
  BadConsequence.newLevelNumberOfTreasures("Toses los pulmones y pierdes 2 " +
    "niveles", 2, 0, 0), Prize.new(1, 1))

monsters << Monster.new("Los hondos", 8,
  BadConsequence.newDeath("Estos monstruos resultan bastante superficiales" +
    " y te aburren mortalmente. Estás muerto"), Prize.new(2, 1))

monsters << Monster.new("Semillas Cthulhu", 4,
  BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles y 2 tesoros" +
    " ocultos", 2, 0, 2), Prize.new(2, 1))

monsters << Monster.new("Dameargo", 1,
  BadConsequence.newLevelSpecificTreasures("Te intentas escaquear. Pierdes " +
    "una mano visible", 0, [TreasureKind::ONEHAND], Array.new),
  Prize.new(2, 1))

monsters << Monster.new("Pollipólipo volante", 3,
  BadConsequence.newLevelNumberOfTreasures("Da mucho asquito. Pierdes 3 " +
    "niveles", 3, 0, 0), Prize.new(1, 1))

monsters << Monster.new("Yskhtihyssg-Goth", 12,
  BadConsequence.newDeath("No le hace gracia que pronuncien mal su nombre. " +
    "Estás muerto"), Prize.new(3, 1))

monsters << Monster.new("Familia feliz", 1,
  BadConsequence.newDeath("La familia te atrapa. Estás muerto"), 
  Prize.new(4, 1))

monsters << Monster.new("Roboggoth", 8,
  BadConsequence.newLevelSpecificTreasures("La quinta directiva primaria te " +
    "obliga a perder 2 niveles y un tesoro 2 manos visible", 2, 
    [TreasureKind::BOTHHANDS], Array.new), Prize.new(2, 1))

monsters << Monster.new("El espía", 5,
  BadConsequence.newLevelSpecificTreasures("Te asusta en la noche. Pierdes " +
    "un casco visible", 0, [TreasureKind::HELMET], Array.new), Prize.new(1, 1))

monsters << Monster.new("El Lenguas", 20,
  BadConsequence.newLevelNumberOfTreasures("Menudo susto te llevas. Pierdes" +
    " 2 niveles y 5 tesoros visibles", 2, 5, 0), Prize.new(1, 1))

monsters << Monster.new("Bicéfalo", 20,
  BadConsequence.newLevelSpecificTreasures("Te faltan manos para tanta cabeza" +
    ". Pierdes 3 niveles y tus tesoros visibles de las manos", 3,
    [TreasureKind::ONEHAND, TreasureKind::BOTHHANDS], Array.new),
  Prize.new(1, 1))

# Tamaño total del array monster
total_monsters = monsters.length

# Array con los monstruos con nivel superior a 10
list_monsters10 = Array.new

# Array con los que tengan un mal rollo que implique sólo pérdida de 
# niveles.
list_monsters_lose_levels = Array.new
       
# Array con los que su buen rollo indique una ganancia de niveles 
# superior a 1.
list_monsters_catch_levels = Array.new
       
# Array con los que su mal rollo suponga la pérdida de un determinado 
# tipo de tesoros ya sea visibles y/o ocultos.
list_monsters_treasures = Array.new

# Se recorren todos los monstruos para ubicarlos en la lista correspondiente
for i in 0..total_monsters-1
  
  # Monstruos con nivel de combate mayor que 10
  if monsters[i].combatLevel > 10
    list_monsters10 << monsters[i]
  end 
  
  # Monstruos que pierdan niveles
  if monsters[i].bc.levels > 0 &&
      monsters[i].bc.nVisibleTreasures == 0 &&
      monsters[i].bc.nHiddenTreasures == 0 &&
      monsters[i].bc.specificVisibleTreasures.empty? &&
      monsters[i].bc.specificHiddenTreasures.empty?
    
    list_monsters_lose_levels << monsters[i]
    
  end
  
  # Monstruos que ganan más de 1 nivel con el buen rollo
  if monsters[i].prize.level > 1
    list_monsters_catch_levels << monsters[i]
  end
  
  # Pierden algún tesoro visible y oculto
  if monsters[i].bc.nVisibleTreasures > 0 ||
      monsters[i].bc.nHiddenTreasures > 0
    
    list_monsters_treasures << monsters[i]
    
  end
  
end

puts("Monstruos con nivel superior a 10: #{list_monsters10.length} monstruos")
for i in 0..list_monsters10.length-1
  puts(list_monsters10[i].to_s)
end

puts("Monstruos que solo pierden algún nivel: #{list_monsters_lose_levels.length} monstruos")
for i in 0..list_monsters_lose_levels.length-1
  puts(list_monsters_lose_levels[i].to_s)
end

puts("Monstruos que hacen ganar niveles: #{list_monsters_catch_levels.length} monstruos")
for i in 0..list_monsters_catch_levels.length-1
  puts(list_monsters_catch_levels[i].to_s)
end

puts("Monstruos que hacen perder algun tesoro: #{list_monsters_treasures.length} monstruos")
for i in 0..list_monsters_treasures.length-1
  puts(list_monsters_treasures[i].to_s)
end
