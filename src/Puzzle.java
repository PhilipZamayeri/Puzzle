import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Philip Zamayeri
 * Date: 2020-10-22
 * Time: 12:28
 * Project: Puzzle
 * Copyright: MIT
 */
public class Puzzle{
    JFrame frame = new JFrame("Puzzle");
    JPanel board = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel panel  = new JPanel();
    Font fn = new Font("Tahoma", Font.BOLD, 60);

    JButton newGame;
    JButton cheat;
    List<JButton> buttons = new ArrayList<>();
    //JButton[][] button = new JButton[4][4];
    public static final Color buttonColor = new Color(0,51,102);


    MouseAdapter buttonListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            MethodClass obj = new MethodClass();


        }
    };

    MouseAdapter newGameListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            MethodClass obj = new MethodClass();
            obj.shuffle(buttons);

        }
    };

    MouseAdapter mouseAdapter3 = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            MethodClass test = new MethodClass();
            //test.cheatCode(button);

        }
    };




    private void gameDemo(){
        try {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (Exception e) {
            e.printStackTrace();
        }



        newGame = new JButton("Nytt spel");
        cheat = new JButton("Cheat");
        newGame.addMouseListener(newGameListener);
        cheat.addMouseListener(mouseAdapter3);

        panel.setLayout(new BorderLayout());
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(board);

        buttonPanel.add(newGame);
        buttonPanel.add(cheat);

        int counter = 1;

        board.setLayout(new GridLayout(4, 4));
        for (int i = 0; i < 16; i++) {
                buttons.add(new JButton("" + counter++));
                board.add(buttons.get(i)).setForeground(Color.white);
                buttons.get(i).setName("b" + counter);
                buttons.get(i).setFont(fn);
                buttons.get(i).setBackground(buttonColor);
                buttons.get(i).addMouseListener(buttonListener);
            }
        buttons.get(15).setBackground(buttonColor);
        buttons.get(15).setOpaque(true);
        buttons.get(15).setText(null);


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