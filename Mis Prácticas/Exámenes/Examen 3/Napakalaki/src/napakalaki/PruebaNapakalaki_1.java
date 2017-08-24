/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author caracuel
 */
public class PruebaNapakalaki_1 {

    /**
     * @param args the command line arguments
     */
    //public static void main(String[] args) {
        
        /*int COMBAT_LEVEL_MAX = 10;        
                
        // Array con la lista de monstruos
        ArrayList<Monster> monstruos = new ArrayList();
        
        // Se añaden los monstruos al array
        monstruos.add(new Monster("El rey de rosa", 13, 
                new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0), 
                new Prize(4, 2)));
        
        monstruos.add(new Monster("Ángeles de la noche ibicenca", 14, 
                new BadConsequence("Te atrapan para llevarte de fiesta y te "
                        + "dejan caer en mitad del vuelo. Descarta 1 mano "
                        + "visible y 1 mano oculta", 0, 
                            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                            new ArrayList(Arrays.asList(TreasureKind.ONEHAND))), 
                new Prize(4, 1)));
        
        monstruos.add(new Monster("3 Byakhees de bonanza", 8, 
                new BadConsequence("Pierdes tu armadura visible y otra oculta", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                        new ArrayList(Arrays.asList(TreasureKind.ONEHAND))), 
                new Prize(2, 1)));
        
        monstruos.add(new Monster("Chibithulhu", 2, 
                new BadConsequence("Embobados con el lindo primigenio te"
                        + "descartas de tu casco visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.HELMET)), 
                        new ArrayList()), 
                new Prize(1, 1)));
        
        monstruos.add(new Monster("El sopor de Dunwich", 2, 
                new BadConsequence("El primordial bostezo contagioso."
                        + " Pierdes el calzado visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.SHOE)), 
                        new ArrayList()), 
                new Prize(1, 1)));
        
        monstruos.add(new Monster("El gorrón en el umbral", 10, 
                new BadConsequence("Pierdes todos tus tesoros visibles", 0, 5, 0), 
                new Prize(3, 1)));
        
        monstruos.add(new Monster("H.P. Munchcraft", 6, 
                new BadConsequence("Pierdes la armadura visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                        new ArrayList()), 
                new Prize(2, 1)));
        
        monstruos.add(new Monster("Bichgooth", 2, 
                new BadConsequence("Sientes bichos bajo la ropa. Descarta"
                        + "la armadura visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                        new ArrayList()), 
                new Prize(1, 1)));
        
        monstruos.add(new Monster("La que redacta en las tinieblas", 2, 
                new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0), 
                new Prize(1, 1)));
        
        monstruos.add(new Monster("Los hondos", 8, 
                new BadConsequence("Estos monstruos resultan bastante "
                        + "superficiales y te aburren mortalmente. Estás muerto", 
                        true), 
                new Prize(2, 1)));
        
        monstruos.add(new Monster("Semillas Cthulhu", 4, 
                new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2), 
                new Prize(2, 1)));
        
        monstruos.add(new Monster("Dameargo", 1, 
                new BadConsequence("Te intentas escaquear. Pierdes una"
                        + "mano visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                        new ArrayList()), 
                new Prize(2, 1)));
        
        monstruos.add(new Monster("Pollipólipo volante", 3, 
                new BadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0), 
                new Prize(1, 1)));
        
        monstruos.add(new Monster("Yskhtihyssg-Goth", 12, 
                new BadConsequence("No le hace gracia que pronuncien mal su"
                        + "nombre. Estás muerto", true), 
                new Prize(3, 1)));
        
        monstruos.add(new Monster("Familia feliz", 1, 
                new BadConsequence("La familia te atrapa. Estás muerto", true), 
                new Prize(4, 1)));
        
        monstruos.add(new Monster("Roboggoth", 8, 
                new BadConsequence("La quinta directiva primaria te obliga a"
                        + "perder 2 niveles y un tesoro (2 manos visibles)", 2, 
                        new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), 
                        new ArrayList()), 
                new Prize(2, 1)));
        
        monstruos.add(new Monster("El espía", 5, 
                new BadConsequence("Te asusta en la noche. Pierdes tu casco"
                        + "visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.HELMET)), 
                        new ArrayList()), 
                new Prize(1, 1)));
        
        monstruos.add(new Monster("El Lenguas", 20, 
                new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles"
                        + " y 5 tesoros visibles", 2, 5, 0), 
                new Prize(1, 1)));
        
        monstruos.add(new Monster("Bicéfalo", 20, 
                new BadConsequence("Te faltan manos para tanta cabeza. Pierdes"
                        + " 3 niveles y tus tesoros visibles de las manos", 3, 
                        new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS,
                                TreasureKind.ONEHAND, TreasureKind.ONEHAND)), 
                        new ArrayList()), 
                new Prize(1, 1)));
        
        // Número total de monstruos
        int totalMonstruos = monstruos.size();
        
        // Array con los monstruos con nivel superior a 10
        ArrayList<Monster> listMonster10 = new ArrayList();

        // Array con los que tengan un mal rollo que implique sólo pérdida de 
        // niveles.
        ArrayList<Monster> listMonsterLoseLevels = new ArrayList();

        // Array con los que su buen rollo indique una ganancia de niveles 
        // superior a 1.
        ArrayList<Monster> listMonsterCatchLevels = new ArrayList();

        // Array con los que su mal rollo suponga la pérdida de un determinado 
        // tipo de tesoros ya sea visibles y/o ocultos.
        ArrayList<Monster> listMonsterTreasures = new ArrayList();
        
        // Se recorren todos los monstruos
        for(int i=0; i<totalMonstruos; i++){
            
            // Se crea un monstruo para consultar los parámetros
            Monster monsterAux = monstruos.get(i);
            
            if(monsterAux.getCombatLevel() > COMBAT_LEVEL_MAX){
                listMonster10.add(monsterAux);
            }
                
            if(monsterAux.getBadConsequence().getLevels()>0 && 
                    monsterAux.getBadConsequence().getNVisibleTreasures()==0 &&
                    monsterAux.getBadConsequence().getNHiddenTreasures()==0 &&                    
                    monsterAux.getBadConsequence().getSpecificVisibleTreasures().isEmpty() &&
                    monsterAux.getBadConsequence().getSpecificHiddenTreasures().isEmpty()){
                listMonsterLoseLevels.add(monsterAux);
            }      
            
            if(monsterAux.getPrize().getLevel()>1){
                listMonsterCatchLevels.add(monsterAux);
            }
            
            if(monsterAux.getBadConsequence().getNHiddenTreasures()>0 || 
                    monsterAux.getBadConsequence().getNVisibleTreasures()>0){
                listMonsterTreasures.add(monsterAux);
            }
            
        }
        
        // Se lee el tamaño de cada opción para sacar sus nombres
        int lengthMonster10 = listMonster10.size();
        int lengthMonsterLoseLevels = listMonsterLoseLevels.size();
        int lengthMonsterCatchLevels = listMonsterCatchLevels.size();
        int lengthMonsterTreasures = listMonsterTreasures.size();
        
        System.out.println("Monstruos con nivel superior a 10: " + 
                lengthMonster10 + " monstruos");
        for(int i=0; i<lengthMonster10; i++){
            System.out.println(i+1 +": " +listMonster10.get(i).toString());
        }
        
        System.out.println("\nMonstruos que solo hacen perder niveles: " + 
                lengthMonsterLoseLevels + " monstruos");
        for(int i=0; i<lengthMonsterLoseLevels; i++){
            System.out.println(i+1 +": " +listMonsterLoseLevels.get(i).toString());
        }
        
        System.out.println("\nMonstruos que hacen ganar niveles: " + 
                lengthMonsterCatchLevels + " monstruos");
        for(int i=0; i<lengthMonsterCatchLevels; i++){
            System.out.println(i+1 +": " +listMonsterCatchLevels.get(i).toString());
        }
        
        System.out.println("\nMonstruos que hacen perder algun tesoro: " + 
                lengthMonsterTreasures + " monstruos");
        for(int i=0; i<lengthMonsterTreasures; i++){
            System.out.println(i+1 +": " +listMonsterTreasures.get(i).toString());
        }*/

              

               
    //}
    
}
