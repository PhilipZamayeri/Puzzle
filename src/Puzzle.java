import javax.swing.*;
import java.awt.*;

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
    String test = "Robin lägger till branch";

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

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (Num == 16) {
                    break;
                }
                else {
                    board.add(new JButton(String.valueOf(+Num))).setFont(fn);
                }
                Num++;
            }
        }

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
