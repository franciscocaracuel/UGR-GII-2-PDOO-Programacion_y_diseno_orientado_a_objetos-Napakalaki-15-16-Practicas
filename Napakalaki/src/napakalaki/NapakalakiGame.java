/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import GUI.Dice;
import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author fran
 */
public class NapakalakiGame {

    public static void main(String[] args) {
        
        // Se crea una instancia de Napakalaki
        Napakalaki game = Napakalaki.getInstance();

        // Se crea la vista
        NapakalakiView napakalakiView = new NapakalakiView();

        // Se crea una única instancia del dado gráfico
        Dice.createInstance(napakalakiView);

        // Se crea la ventana para leer los nombres
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);

        // Se centra la pantalla de diálogo en el centro
        namesCapture.setLocationRelativeTo(napakalakiView);

        // Se recogen los nombres de los jugadores
        ArrayList<String> names = namesCapture.getNames();

        // Se inicia el juego
        game.initGame(names);

        // Se enlaza el modelo a la vista
        napakalakiView.setNapakalaki(game);

        // Se muestra la ventana principal de la aplicación
        napakalakiView.setVisible(true);

        // Se muestra la ventana en pantalla completa
        napakalakiView.setExtendedState(MAXIMIZED_BOTH);

    }

}
