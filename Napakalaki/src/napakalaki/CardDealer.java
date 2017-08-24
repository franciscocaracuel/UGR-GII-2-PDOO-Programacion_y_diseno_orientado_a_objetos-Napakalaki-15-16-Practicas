/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author fran
 */
public class CardDealer {
    
    // Instancia de la clase
    private static final CardDealer instance = new CardDealer();
    
    // Variables de instancia
    private ArrayList<Monster> unusedMonsters = new ArrayList();
    private ArrayList<Monster> usedMonsters = new ArrayList();
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    
    // Práctica 4
    private ArrayList<Cultist> unusedCultist = new ArrayList();
    private ArrayList<Cultist> usedCultist = new ArrayList();
    
    // Constructor privado
    private CardDealer(){
                
    }
    
    // Inicializador de las cartas de los Tesoros
    private void initTreasureCardDeck(){
        
        unusedTreasures.add(new Treasure("¡Si mi amo!", 4, 
            TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Botas de investigacion", 3,
            TreasureKind.SHOE));        
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3,
            TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("A prueba de babas", 2,
            TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Botas de lluvia acida", 1,
            TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Casco minero", 2,
            TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora Thompson", 4,
            TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Camiseta de la UGR", 1,
            TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3,
            TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2,
            TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Fez alopodo", 3,
            TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Hacha prehistorica", 2,
            TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 4,
            TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita", 4,
            TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Insecticida", 2,
            TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4, 
            TreasureKind.BOTHHANDS));        
        unusedTreasures.add(new Treasure("Garabato mistico", 2,
            TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La rebeca metalica", 2,
            TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Lanzallamas", 4,
            TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro comicon", 1, 
            TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicon", 5,
            TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 3,
            TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro-gnomicon", 2,
            TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom", 2,
            TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 3,
            TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necro playboycon", 3,
            TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Porra preternatural", 2,
            TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Shogulador", 1,
            TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento", 3,
            TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentaculo de pega", 2,
            TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 1,
            TreasureKind.SHOE));
        
        // Se barajan los tesoros
        shuffleTreasures();
        
    }
    
    private void initMonsterCardDeck(){
        
        unusedMonsters.add(new Monster("El rey de rosa", 13, 
                new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0), 
                new Prize(4, 2)));
        
        unusedMonsters.add(new Monster("Angeles de la noche ibicenca", 14, 
                new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te "
                        + "dejan caer en mitad del vuelo. Descarta 1 mano "
                        + "visible y 1 mano oculta", 0, 
                            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                            new ArrayList(Arrays.asList(TreasureKind.ONEHAND))), 
                new Prize(4, 1)));
        
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, 
                new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                        new ArrayList(Arrays.asList(TreasureKind.ONEHAND))), 
                new Prize(2, 1)));
        
        unusedMonsters.add(new Monster("Chibithulhu", 2, 
                new SpecificBadConsequence("Embobados con el lindo primigenio te "
                        + "descartas de tu casco visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.HELMET)), 
                        new ArrayList()), 
                new Prize(1, 1)));
        
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, 
                new SpecificBadConsequence("El primordial bostezo contagioso."
                        + " Pierdes el calzado visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.SHOE)), 
                        new ArrayList()), 
                new Prize(1, 1)));
        
        unusedMonsters.add(new Monster("El gorron en el umbral", 10, 
                new NumericBadConsequence("Pierdes todos tus tesoros visibles", 0, 
                        BadConsequence.MAXTREASURES, 0), 
                new Prize(3, 1)));
        
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, 
                new SpecificBadConsequence("Pierdes la armadura visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                        new ArrayList()), 
                new Prize(2, 1)));
        
        unusedMonsters.add(new Monster("Bichgooth", 2, 
                new SpecificBadConsequence("Sientes bichos bajo la ropa. Descarta "
                        + "la armadura visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                        new ArrayList()), 
                new Prize(1, 1)));
        
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, 
                new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0), 
                new Prize(1, 1)));
        
        unusedMonsters.add(new Monster("Los hondos", 8, 
                new DeathBadConsequence("Estos monstruos resultan bastante "
                        + "superficiales y te aburren mortalmente. Estás muerto", 
                        true), 
                new Prize(2, 1)));
        
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, 
                new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2), 
                new Prize(2, 1)));
        
        unusedMonsters.add(new Monster("Dameargo", 1, 
                new SpecificBadConsequence("Te intentas escaquear. Pierdes una "
                        + "mano visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                        new ArrayList()), 
                new Prize(2, 1)));
        
        unusedMonsters.add(new Monster("Pollipolipo volante", 3, 
                new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0), 
                new Prize(1, 1)));
        
        unusedMonsters.add(new Monster("YskhtihyssgGoth", 12, 
                new DeathBadConsequence("No le hace gracia que pronuncien mal su "
                        + "nombre. Estás muerto", true), 
                new Prize(3, 1)));
        
        unusedMonsters.add(new Monster("Familia feliz", 1, 
                new DeathBadConsequence("La familia te atrapa. Estás muerto", true), 
                new Prize(4, 1)));
        
        unusedMonsters.add(new Monster("Roboggoth", 8, 
                new SpecificBadConsequence("La quinta directiva primaria te obliga a "
                        + "perder 2 niveles y un tesoro (2 manos visibles)", 2, 
                        new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), 
                        new ArrayList()), 
                new Prize(2, 1)));
        
        unusedMonsters.add(new Monster("El espia", 5, 
                new SpecificBadConsequence("Te asusta en la noche. Pierdes tu casco "
                        + "visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.HELMET)), 
                        new ArrayList()), 
                new Prize(1, 1)));
        
        unusedMonsters.add(new Monster("El lenguas", 20, 
                new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles"
                        + " y 5 tesoros visibles", 2, 5, 0), 
                new Prize(1, 1)));
        
        unusedMonsters.add(new Monster("Bicefalo", 20, 
                new SpecificBadConsequence("Te faltan manos para tanta cabeza. Pierdes"
                        + " 3 niveles y tus tesoros visibles de las manos", 3, 
                        new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS,
                                TreasureKind.ONEHAND, TreasureKind.ONEHAND)), 
                        new ArrayList()), 
                new Prize(1, 1)));
        
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, 
                new SpecificBadConsequence("Pierdes 1 mano visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                        new ArrayList()), 
                new Prize(3, 1),
                -2));
        
        unusedMonsters.add(new Monster("Testigos Oculares", 6, 
                new NumericBadConsequence("Pierdes tus tesoros visibles. Jajaja", 0, 
                        BadConsequence.MAXTREASURES, 0), 
                new Prize(2, 1),
                2));
        
        unusedMonsters.add(new Monster("El gran cthulhu", 20, 
                new DeathBadConsequence("Hoy no es tu día de suerte. Mueres", true), 
                new Prize(2, 5),
                4));
        
        unusedMonsters.add(new Monster("Serpiente politico", 8, 
                new NumericBadConsequence("Tu gobierno te recorta 2 niveles", 2, 
                        0, 0), 
                new Prize(2, 1),
                -2));
        
        unusedMonsters.add(new Monster("Felpuggoth", 2, 
                new SpecificBadConsequence("Pierdes tu casco y tu armadura visible."
                        + " Pierdes tus manos ocultas", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.HELMET,
                                TreasureKind.ARMOR)), 
                        new ArrayList(Arrays.asList(TreasureKind.ONEHAND,
                                TreasureKind.ONEHAND, TreasureKind.BOTHHANDS))), 
                new Prize(1, 1),
                5));
        
        unusedMonsters.add(new Monster("Shoggoth", 16, 
                new NumericBadConsequence("Pierdes 2 niveles", 2, 
                        0, 0), 
                new Prize(4, 2),
                -4));
        
        unusedMonsters.add(new Monster("Lolitagooth", 2, 
                new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles", 2, 
                        0, 0), 
                new Prize(1, 1),
                3));
        
        // Se barajan los monstruos
        shuffleMonsters();
        
    }
    
    // Práctica 4
    private void initCultistCardDeck(){
        
        unusedCultist.add(new Cultist("Sectario", 1));
        unusedCultist.add(new Cultist("Sectario", 2));
        unusedCultist.add(new Cultist("Sectario", 1));
        unusedCultist.add(new Cultist("Sectario", 2));
        unusedCultist.add(new Cultist("Sectario", 1));
        unusedCultist.add(new Cultist("Sectario", 1));
                
        shuffleCultist();
        
    }
    
    // Baraja los tesoros
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    
    // Baraja los monstruos
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }
    
    //Práctica 4
    private void shuffleCultist(){
        Collections.shuffle(unusedCultist);
    }
    
    // Devuelve la instancia de la clase
    public static CardDealer getInstance(){
        return instance;
    }
    
    public Treasure nextTreasure(){
        
        // Si está vacio se coge el mazo entero y se baraja
        if(unusedTreasures.isEmpty()){
            unusedTreasures = new ArrayList(usedTreasures);
            shuffleTreasures();
            usedTreasures.clear();
        }
        
        // Se coge la primera carta y se lleva al mazo de descartes
        Treasure t = unusedTreasures.get(0);
        unusedTreasures.remove(0);
        
        return t;
        
    }
    
    public Monster nextMonster(){
        
        // Si está vacio se coge el mazo entero y se baraja
        if(unusedMonsters.isEmpty()){
                
            unusedMonsters = new ArrayList(usedMonsters);
            shuffleMonsters();
            usedMonsters.clear();
        }
        
        // Se coge la primera carta y se lleva al mazo de descartes
        Monster m = unusedMonsters.get(0);
        unusedMonsters.remove(0);
        
        return m;
        
    }
    
    // Práctica 4
    public Cultist nextCultist(){
        
        // Si está vacio se coge el mazo entero y se baraja
        if(unusedCultist.isEmpty()){
                
            unusedCultist = new ArrayList(usedCultist);
            shuffleCultist();
            usedCultist.clear();
        }
        
        // Se coge la primera carta y se lleva al mazo de descartes
        Cultist c = unusedCultist.get(0);
        unusedCultist.remove(0);
 
        return c;
        
    }
    
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    
    public void initCards(){
        
        initTreasureCardDeck();
        initMonsterCardDeck();
        initCultistCardDeck();
        
    }
    
}
