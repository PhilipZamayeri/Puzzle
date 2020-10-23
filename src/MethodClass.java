import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Philip Zamayeri
 * Date: 2020-10-22
 * Time: 18:03
 * Project: Puzzle
 * Copyright: MIT
 */
public class MethodClass {
    int m,n;

        public void shuffleMetod(JButton[][] button){
        Random random = new Random();

        for (int i = button.length - 1; i > 0; i--) {
            for (int j = button[i].length - 1; j > 0; j--) {
                int m = random.nextInt(i + 1);
                int n = random.nextInt(j + 1);

                String temp = button[i][j].getText();
                button[i][j].setText(button[m][n].getText());
                button[m][n].setText(temp);

            }
        }
    }

    public void moveTiles(JButton[][] button ,int i, int j){
         /*   if ((i+1 == m || j == n) || (i-1 == m && j==n) || (i==m && j+1==n) || (i==m && j-1==n))

            button[m][n].setText(button[i][j].getText());
            button[m][n].setText("");
            m=i; n=j;

          */
    }


    public void cheatCode(JButton[][] button, int colNr) {


           /*
            int col = button.length-15;

            for (int i = 0; i < button.length; i++) {
                for (int j = 0; j <button[i].length; j++){
                    System.out.println(button[i][j].getText());
                }
            }*/
    }
/*
    public void slideMethod(){
        boolean moved = false;

        if(row - 1 > 0 && grid[row - 1][col] == 0){  // Move block up
            grid[row - 1][col] = blockId
            moved = true;
        }
        else if(row + 1 < gridLength - 1 && grid[row + 1][col] == 0) { // Move block down
            grid[row + 1][col] = blockId
            moved = true;
        }
        else if(col - 1 > 0 && grid[row][col - 1] == 0) {  // Move block left
            grid[row][col - 1] = blockId
            moved = true;
        }
        else if(col + 1 < gridLength - 1 && grid[row][col + 1] == 0) { // Move block right
            grid[row][col + 1] = blockId
            moved = true;
        }

        if moved
        grid[row][col] = 0 // Delete the piece from old position
    }


    public static void main(String[] args) {
        MethodClass method = new MethodClass();

    }*/
}
