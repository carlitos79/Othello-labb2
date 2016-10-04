/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othello;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Group 1
 */
public class Othello{
    
    public void start(Stage primaryStage) {
      
        // INITIALIZES THE BOARD FROM THE View
        View board = new View();
        board.initBoard(primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
