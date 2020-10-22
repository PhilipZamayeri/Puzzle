import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;

/**
 * Created by Philip Zamayeri
 * Date: 2020-10-22
 * Time: 12:28
 * Project: Puzzle
 * Copyright: MIT
 */
public class Puzzle {
    JButton reset;
    JButton cheat;
    //String test = "Robin lägger till branch";
    JButton[][] buttons = new JButton[4][4];

    private void gameDemo(){
        JFrame frame = new JFrame("Puzzle");
        JPanel board = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel panel  = new JPanel();

        reset = new JButton("Nytt spel");
        cheat = new JButton("Cheat");

        panel.setLayout(new BorderLayout());
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(board);

        buttonPanel.add(reset);
        buttonPanel.add(cheat);

        board.setLayout(new GridLayout(4, 4));
        Font fn = new Font("Tahoma", Font.BOLD, 60);
        int Num = 1;
        int count = 1;

        /*for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (Num == 16) {
                    break;
                }
                else {
                    //board.add(new JButton(String.valueOf(+Num))).setFont(fn);
                }
                Num++;
            }
        }*/

        for (int i =0; i < buttons.length; i ++)
            for (int j = 0; j < buttons[i].length; j++){
                buttons[i][j] = new JButton("" + count++);
                board.add(buttons[i][j]).setForeground(Color.black);
                board.add(buttons[i][j]).setFont(fn);
        }

        //JButton buttonEmpty = new JButton();
          //  buttonPanel.add(buttonEmpty);
        buttons[3][3].setBackground(null);
        buttons[3][3].setFont(null);
        buttons[3][3].setText(null);
        buttons[3][3].setOpaque(true);

        buttonPanel.setBackground(new Color(255-255-153));
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(600, 90);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle();
        puzzle.gameDemo();
    }
}
