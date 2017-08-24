# encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.


require_relative "napakalaki"

module NapakalakiGame

  class MainExamen
   
      def prueba
        
        dealer = CardDealer.instance
       
        dealer.init_cards
        
        player1 = Player.new("Fran")
        
        player1.init_treasures
        
        player2 = Player.new("Mel")
        
        player2.init_treasures
        
        puts player1.to_s
        puts "Tesoros visibles de #{player1.get_name}: #{player1.get_visible_treasures.to_s}"
        puts "Tesoros ocultos de #{player1.get_name}: #{player1.get_hidden_treasures.to_s}"
        
        puts "\n"
        
        puts player2.to_s
        puts "Tesoros visibles de #{player2.get_name}: #{player2.get_visible_treasures.to_s}"
        puts "Tesoros ocultos de #{player2.get_name}: #{player2.get_hidden_treasures.to_s}"
        
        player1.giftATreasureToMyFriend(player2)
        
        puts "\n\nDespués de regalar el tesoro...\n\n"
        
        puts player1.to_s
        puts "Tesoros visibles de #{player1.get_name}: #{player1.get_visible_treasures.to_s}"
        puts "Tesoros ocultos de #{player1.get_name}: #{player1.get_hidden_treasures.to_s}"
        
        puts "\n"
        
        puts player2.to_s
        puts "Tesoros visibles de #{player2.get_name}: #{player2.get_visible_treasures.to_s}"
        puts "Tesoros ocultos de #{player2.get_name}: #{player2.get_hidden_treasures.to_s}"
       
      end
      
  end
  
    e = MainExamen.new
    e.prueba()

end