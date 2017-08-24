/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author fran
 */
public class AlterEgo {
    
    static String DESCRIPCION = "Un alter ego es una personalidad"
            + "alternativa y los monstruos también pueden tener amigos";
    
    public int nivelDeBondad;
    private ArrayList<Monster> monstruosAmigos;
    
    AlterEgo(int nivelDeBondad, ArrayList<Monster> monstruosAmigos){
        this.nivelDeBondad = nivelDeBondad;
        this.monstruosAmigos = monstruosAmigos;
    }
    
    AlterEgo(int nivelDeBondad){
        this.nivelDeBondad = nivelDeBondad;
        monstruosAmigos = new ArrayList<>();
    }
    
    // Consultor de nivel de bondad
    public int getNivelDeBondad(){        
        return nivelDeBondad;        
    }
    
    @Override
    public String toString(){
        
        return "AlterEgo: Nivel de bondad: " + nivelDeBondad + ", Número de"
                + "amigos: " + monstruosAmigos.size();
        
    }
    
}
