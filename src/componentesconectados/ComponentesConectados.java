/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package componentesconectados;

/**
 *
 * @author sergio
 */
public class ComponentesConectados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int image[][] = new int[][]{
            {0, 0, 1, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 0, 0},
            {1, 0, 0, 1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 0}
        };

            ConnectedObjects co = LabelImage.labelImage(image, 8, 0, 0);
        
        int result[][] = co.getMatrix();
        for( int[] r : result ){
            for( int x : r ){
                System.out.print(x + " ");
            }
            System.out.println("\n");
        }
    }
}
