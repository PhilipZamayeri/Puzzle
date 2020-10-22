import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Philip Zamayeri
 * Date: 2020-10-22
 * Time: 12:28
 * Project: Puzzle
 * Copyright: MIT
 */
public class Puzzle {
    JButton newGame;
    JButton cheat;
    JButton[][] button = new JButton[4][4];
    public static final Color buttonColor = new Color(0,51,102);


    private void gameDemo(){
        try {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (Exception e) {
            e.printStackTrace();
        }

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        };

        MouseAdapter mouseAdapter2 = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        };

        MouseAdapter mouseAdapter3 = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        };


        JFrame frame = new JFrame("Puzzle");
        JPanel board = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel panel  = new JPanel();
        Font fn = new Font("Tahoma", Font.BOLD, 60);



        newGame = new JButton("Nytt spel");
        cheat = new JButton("Cheat");
        newGame.addMouseListener(mouseAdapter2);
        cheat.addMouseListener(mouseAdapter3);

        panel.setLayout(new BorderLayout());
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(board);

        buttonPanel.add(newGame);
        buttonPanel.add(cheat);

        int counter = 1;

        board.setLayout(new GridLayout(4, 4));
        for (int i = 0; i < button.length; i++)
            for (int j = 0; j < button[i].length; j++){
                button[i][j] = new JButton(""+ counter++);
                board.add(button[i][j]).setForeground(Color.white);
                button[i][j].setFont(fn);
                button[i][j].setBackground(buttonColor);
                button[i][j].addMouseListener(mouseAdapter);
            }
        button[3][3].setBackground(buttonColor);
        button[3][3].setOpaque(true);
        button[3][3].setText(null);



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