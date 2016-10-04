/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othello;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Group 1
 */

public class GameManager {

    private int count = 0;
    final int player1 = 1;
    final int player2 = 2;

    Model acc2Model = new Model();
    DrawChip chip = new DrawChip();


    public void mouseChipDisplay(GridPane reversi) {

        /* Mouse recognition and action performance */
        reversi.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent me) {

                final int pointX = (int) me.getSceneX() / 51;
                final int pointY = (int) me.getSceneY() / 51;
                
                /* 
                * Here are displayed and set to bussy as well the two white and
                * the two black chips typical in the onset of the game 
                */
                reversi.add(chip.drawBlackChip(), 4, 3);
                acc2Model.setBlackNodeToBussy(4, 3);
                reversi.add(chip.drawBlackChip(), 3, 4);
                acc2Model.setBlackNodeToBussy(3, 4);
                reversi.add(chip.drawWhiteChip(), 3, 3);
                acc2Model.setWhiteNodeToBussy(3, 3);
                reversi.add(chip.drawWhiteChip(), 4, 4);
                acc2Model.setWhiteNodeToBussy(4, 4);                

                if (count % 2 + 1 == player2) {
                    reversi.add(chip.drawBlackChip(), pointX, pointY);
                    acc2Model.setBlackNodeToBussy(pointX, pointY);
                    count++;

                } else if (count % 2 + 1 == player1) {
                    reversi.add(chip.drawWhiteChip(), pointX, pointY);
                    acc2Model.setWhiteNodeToBussy(pointX, pointY);
                    count++;
                }

                /* This code if for debugging purposes only */
                System.out.println("coordinate " + "x:" + pointX + " y:" + pointY);
                System.out.println("counter: " + count);
                System.out.println("Node status: " + acc2Model.checkNodeStatus(pointX, pointY));
                System.out.println("Next node status: " + acc2Model.checkNodeStatus(pointX + 1, pointY + 1));
            }
        });
    }
    
    /* Class for drawing and handling them */
    static class DrawChip{

        public Circle drawBlackChip() {

            Circle chip = new Circle(30, 30, 15);

            chip.setStroke(Color.WHITE);
            chip.setFill(Color.BLACK);

            return chip;
        }

        public Circle drawWhiteChip() {

            Circle chip = new Circle(30, 30, 15);

            /*chip.setCenterX(30);
    chip.setCenterY(30);
    chip.setRadius(15);*/
            chip.setStroke(Color.BLACK);
            chip.setFill(Color.WHITE);

            return chip;
        }

        public Circle fixBoardSize() {

            Circle chip;

            chip = new Circle(40, 40, 20);

            return chip;
        }

        /* This method shows a node's info */
        public Node getNode(final int row, final int column, GridPane gridPane) {

            Node result = null;

            ObservableList<Node> children = gridPane.getChildren();

            for (Node node : children) {

                if (gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                    result = node;
                    break;
                }
            }
            return result;
        }
    }
}
