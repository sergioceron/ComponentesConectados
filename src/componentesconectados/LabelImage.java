/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package componentesconectados;

import java.util.Stack;

public class LabelImage {

    /**
     * Attributes
     */
    static int[][] label;
    static Stack<int[]> stack;

    /**
     * Creates a new instance of LabelImage
     */
    public LabelImage() {
    }

    /**
     * Method finding connected components
     *
     * @param img a (n x r) matrix where connected components must be labelled
     * @param connectivity if equals to 4, 4-connected elements computed. In ANY
     * other case, 8-connected elements.
     * @return the matrix containing img labels
     */
    public static ConnectedObjects labelImage(int[][] img, int connectivity, int yi, int xi) {
        int nrow = img.length;
        int ncol = img[0].length;
        int lab = -3;
        int[] pos;
        stack = new Stack<int[]>();
        stack.push(new int[]{yi, xi});
        img[yi][xi] = -3;
        /* start the float fill */
        while (!stack.isEmpty()) {
            pos = stack.pop();
            int i = pos[0];
            int j = pos[1];
            if (i >= 1) {
                if (img[i - 1][j] == 1) {
                    stack.push(new int[]{i - 1, j});
                    img[i - 1][j] = lab;
                }
            }
            if (j >= 1) {
                if (img[i][j - 1] == 1) {
                    stack.push(new int[]{i, j - 1});
                    img[i][j - 1] = lab;
                }
            }
            if (j < ncol - 1) {
                if (img[i][j + 1] == 1) {
                    stack.push(new int[]{i, j + 1});
                    img[i][j + 1] = lab;
                }
            }
            if (i < nrow - 1) {
                if (img[i + 1][j] == 1 ) {
                    stack.push(new int[]{i + 1, j});
                    img[i + 1][j] = lab;
                }
            }
            if (connectivity != 4) {
                if (i >= 1 && j >= 1) {
                    if (img[i - 1][j - 1] == 1) {
                        stack.push(new int[]{i - 1, j - 1});
                        img[i - 1][j - 1] = lab;
                    }
                }
                if (i >= 1 && j < ncol - 1) {
                    if (img[i - 1][j + 1] == 1 ) {
                        stack.push(new int[]{i - 1, j + 1});
                        img[i - 1][j + 1] = lab;
                    }
                }
                if (i < nrow - 1 && j >= 1) {
                    if (img[i + 1][j - 1] == 1) {
                        stack.push(new int[]{i + 1, j - 1});
                        img[i + 1][j - 1] = lab;
                    }
                }
                if (i < nrow - 1 && j < ncol - 1) {
                    if (img[i + 1][j + 1] == 1) {
                        stack.push(new int[]{i + 1, j + 1});
                        img[i + 1][j + 1] = lab;
                    }
                }
            }
        }
        return new ConnectedObjects(img, lab);
    }
}