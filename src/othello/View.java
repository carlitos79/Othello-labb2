/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othello;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import othello.GameManager.DrawChip;

/**
 *
 * @author Group 1
 */
public class View extends Application {

    final int player1 = 1;
    final int player2 = 2;
    final int numSqr = 8;

    Model acc2Model = new Model();
    GameManager acc2GM = new GameManager();
    DrawChip chip = new DrawChip();

    public void initBoard(Stage primaryStage) {

        GridPane board = new GridPane();
        /* Here we get access to the functions for displaying chips in GM */
        acc2GM.mouseChipDisplay(board);

        for (int row = 0; row < numSqr; row++) {
            for (int col = 0; col < numSqr; col++) {

                StackPane square = new StackPane();
                String color;

                if ((row + col) % 2 == 0) {
                    color = "FORESTGREEN";
                } else {
                    color = "GREEN";
                }
                square.setStyle("-fx-background-color: " + color + ";");
                board.add(chip.fixBoardSize(), col, row);
                board.add(square, col, row);
            }
        }

        for (int i = 0; i < numSqr; i++) {

            board.getColumnConstraints().add(new ColumnConstraints(10, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
            board.getRowConstraints().add(new RowConstraints(10, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
        }

        Scene scene = new Scene(board, 400, 400);
        primaryStage.setTitle("Othello - Grupp 1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void start(Stage primaryStage) {

        initBoard(primaryStage);
    }
}
