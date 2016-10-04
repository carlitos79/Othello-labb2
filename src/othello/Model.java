/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othello;

/**
 *
 * @author Group 1
 */
public class Model {
    
    final int player1 = 1;
    final int player2 = 2;
    final int matrixSize = 8;
    
    /*
    * Adjacency matrix to hold the status of the nodes in the grid
    */
    int[][] status = new int[matrixSize][matrixSize];

    void populateMatrix() {

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {

                status[i][j] = 0;
            }
        }
    }

    /*
    * Simple functions to add, remove and check if a node is bussy or not
    */
    void setBlackNodeToBussy(int i, int j) {
        status[i][j] = this.player2;
    }

    void setWhiteNodeToBussy(int i, int j) {
        status[i][j] = this.player1;
    }

    void setNodeToFree(int i, int j) {
        status[i][j] = 0;
    }

    int checkNodeStatus(int i, int j) {
        return status[i][j];
    }    
}
