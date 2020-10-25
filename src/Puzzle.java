import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class Puzzle extends JFrame{
    public static final Color buttonColor = new Color(-125);
    JButton newGame;
    JButton cheat;
    List<JButton> buttons = new ArrayList<>();
    List<JButton> correctOrder;
    List<JButton> winOrder;

    JFrame frame = new JFrame("Puzzle");
    JPanel board = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel panel  = new JPanel();

    public void gameDemo(){

        newGame = new JButton("New game");
        cheat = new JButton("Cheat");
        newGame.addMouseListener(shuffleListener);


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
            buttons.get(i).setName("b" + counter);
            buttons.get(i).setFont(fn);
            buttons.get(i).addMouseListener(moveTilesListener);

        }

        buttons.get(15).setBackground(null);
        buttons.get(15).setOpaque(true);
        buttons.get(15).setText(null);


        buttonPanel.setBackground(buttonColor);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(600, 90);
        frame.setVisible(true);

        correctOrder = new ArrayList<>(buttons);
        winOrder = new ArrayList<>(buttons);
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
            for (int i = 0; i < buttons.size(); i++) {

                if (e.getSource() == buttons.get(i)) {
                    String value = buttons.get(i).getText();
                    if (buttons.get(next(i)).getText() == null) {
                        String value2 = buttons.get(next(i)).getText();
                        buttons.get(next(i)).setText(value);
                        buttons.get(i).setText(value2);
                    }
                }
                if (e.getSource() == buttons.get(i)) {
                    String value = buttons.get(i).getText();
                    if (buttons.get(prev(i)).getText() == null) {
                        String value2 = buttons.get(prev(i)).getText();
                        buttons.get(prev(i)).setText(value);
                        buttons.get(i).setText(value2);
                    }
                }
                if (e.getSource() == buttons.get(i)) {
                    String value = buttons.get(i).getText();
                    if (buttons.get(above(i)).getText() == null) {
                        String value2 = buttons.get(above(i)).getText();
                        buttons.get(above(i)).setText(value);
                        buttons.get(i).setText(value2);
                    }
                }
                if (e.getSource() == buttons.get(i)) {
                    String value = buttons.get(i).getText();
                    if (buttons.get(below(i)).getText() == null) {
                        String value2 = buttons.get(below(i)).getText();
                        buttons.get(below(i)).setText(value);
                        buttons.get(i).setText(value2);
                    }
                }

            }
        }
    }

        ;
        MouseAdapter ma3 = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        };



        public static void main(String[] args) {
            Puzzle puzzle = new Puzzle();
            puzzle.gameDemo();
            //puzzle.correctOrder();
            //puzzle.gameSolved();

        }

        public int next(int i) {
            if (i <= 14 && i >= 0) {
                return i + 1;
            } else {
                return i = 15;
            }
        }

        public int prev(int i) {
            if (i >= 1 && i <= 15) {
                return i - 1;
            } else {
                return i = 0;
            }
        }

        public int above(int i) {
            if (i >= 4 && i <= 15) {
                return i - 4;
            } else {
                return i;
            }
        }

        public int below(int i) {
            if (i >= 0 && i <= 11) {
                return i + 4;
            } else {
                return i;
            }
        }

        public boolean gameSolved() {
            if (buttons.equals(correctOrder)) {
                System.out.println("Sant");
                return true;
            } else {
                System.out.println("Falskt");
                return false;
            }
        }
    }
