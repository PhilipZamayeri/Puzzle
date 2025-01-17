import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Philip Zamayeri & Robin Martinsson
 * Date: 2020-10-22
 * Time: 12:28
 * Project: Puzzle
 * Copyright: MIT
 */
public class Puzzle extends JFrame{
    public static final Color buttonColor = new Color(-125);
    JButton newGame;
    JButton cheat;
    List<JButton> buttons = new ArrayList<>();
    List<JButton> correctOrder;

    JFrame frame = new JFrame("Puzzle");
    JPanel board = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel panel  = new JPanel();

    public void gameDemo(){
        MethodClass obj = new MethodClass();

        newGame = new JButton("New game");
        cheat = new JButton("Cheat");
        newGame.addMouseListener(shuffleListener);
        cheat.addMouseListener(cheatListener);


        panel.setLayout(new BorderLayout());
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(board);

        buttonPanel.add(newGame);
        buttonPanel.add(cheat);

        board.setLayout(new GridLayout(4, 4));
        Font fn = new Font("Tahoma", Font.BOLD, 60);
        int counter = 1;

        for (int i = 0; i < 16; i++) {
            buttons.add(new JButton("" + counter++));
            board.add(buttons.get(i)).setForeground(Color.BLACK);
            buttons.get(i).setBackground(buttonColor);
            buttons.get(i).setName("b" + (counter-1));
            buttons.get(i).setFont(fn);
            buttons.get(i).addMouseListener(moveTilesListener);

        }

        buttons.get(15).setBackground(null);
        buttons.get(15).setOpaque(true);
        buttons.get(15).setText("");


        buttonPanel.setBackground(buttonColor);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(600, 90);
        frame.setVisible(true);

        correctOrder = new ArrayList<>(buttons);
        obj.shuffle(buttons,board);

    }

    MouseAdapter shuffleListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            MethodClass obj = new MethodClass();
            obj.shuffle(buttons, board);
        }
    };

    MouseAdapter moveTilesListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            MethodClass obj = new MethodClass();
            obj.moveTiles(buttons,correctOrder,e);
        }
    };

        MouseAdapter cheatListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                MethodClass obj = new MethodClass();
                obj.cheat(buttons, board);
            }
        };


        public static void main(String[] args) {
            Puzzle puzzle = new Puzzle();
            puzzle.gameDemo();

        }

    }

