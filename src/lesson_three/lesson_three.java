package lesson_three;

import java.util.ArrayList;
import java.util.Collections;


public class lesson_three {
    public static void main(String[] args) {
        
        int tree=20;
    // ---------------------------------------  
        String word= "Übung";
        tree(tree);
        noun(word);
        nums();
    // ---------------------------------------   
        int[][] sudoku = {
                {8, 3, 5, 4, 1, 6, 9, 2, 7},
                {2, 9, 6, 8, 5, 7, 4, 3, 1},
                {4, 1, 7, 2, 9, 3, 6, 5, 8},
                {5, 6, 9, 1, 3, 4, 7, 8, 2},
                {1, 2, 3, 6, 7, 8, 5, 4, 9},
                {7, 4, 8, 5, 2, 9, 1, 6, 3},
                {6, 5, 2, 7, 8, 1, 3, 9, 4},
                {9, 8, 1, 3, 4, 5, 2, 7, 6},
                {3, 7, 4, 9, 6, 2, 8, 1, 5}
        };
        int[][] grid2 = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {9, 1, 2, 3, 4, 5, 6, 7, 8},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {6, 7, 8, 9, 1, 2, 3, 4, 5},
                {5, 1, 7, 8, 9, 6, 2, 3, 4},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {2, 3, 4, 5, 6, 7, 8, 9, 1}
        };  
        System.out.println(validation(sudoku));
        
        
        validation(sudoku);
        
        
        
    }
    private static void tree(int height) {
        if (height < 3) {
            System.out.println("A tree must have a height of at least 3");
        }
        System.out.println("I");
        String treeLine = "X";
        int effectiveHeight = height - 2;
        for (int i = 0; i < effectiveHeight; i++) {
            treeLine += (i % 2 == 0) ? "Y" : "X";
            System.out.println(treeLine);
        }
        System.out.println("M");
    }
    
    public static void noun(String word) {
        if (word.endsWith("e") || word.endsWith("ung") ){
            System.out.println("This noun " + word + " is feminine.");
        }else{
            System.out.println("This noun " + word + " is maskuline.");
        }
        }
    
    public static void nums() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i < 5; i ++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        for (int i = 0; i < 3; i ++) {
            System.out.print(numbers.get(i)+", ");
        }
    }
    
    //sudoku
    public static boolean validation(int[][] sudoku){
        int i=0;
        int j=0;
        int k=0;
        boolean isValid=true;

        for(k=0;k<9;k++) {
            for (i = 0; i < 9; i++) {
                for (j = i + 1; j < 9; j++) {
                    if (sudoku[i][k]==sudoku[j][k]){
                        isValid=false;
                        return isValid;
                    }
                }
            }
        }
        for(k=0;k<9;k++) {
            for (i = 0; i < 9; i++) {
                for (j = i + 1; j < 9; j++) {
                    if (sudoku[k][i]==sudoku[k][j]){
                        isValid=false;
                        return isValid;
                    }
                }
            }
        }

        int l;
        int[] flatArray = new int[81];
        int a=0;

        for (k = 0; k < 8; k += 3) {
            for (l = 0; l < 8; l += 3) {
                for (i = k; i < k + 3; i++) {
                    for (j = l; j < l + 3; j++) {
                        flatArray [a]= sudoku[i][j];
                        a++;
                    }
                }
            }
        }

        for (k = 0; k < 81; k+= 9) {
            for (i = k; i < k+8; i++) {
                for (j = i+1; j < k + 9; j++) {
                    if(flatArray[i]==flatArray[j])isValid=false;
                }
            }
        }

        return isValid;
    }
}