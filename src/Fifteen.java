import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

/**
 * Created by Robin Martinsson
 * Date:    2020-10-22
 * Time:    10:01
 * Project: Inlämningsuppgift03
 * Copyright: MIT
 */
public class Fifteen extends JFrame implements ActionListener {
    JButton restart;
    JButton solution;
    List<JButton> buttons = new ArrayList<>();

    JFrame frame = new JFrame("Puzzle");
    JPanel board = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel panel = new JPanel();

    public void gameDemo() {

        restart = new JButton("New game");
        solution = new JButton("Help");
        restart.addMouseListener(shuffle);
        solution.addMouseListener(ma2);

        panel.setLayout(new BorderLayout());
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(board);

        buttonPanel.add(restart);
        buttonPanel.add(solution);

        board.setLayout(new GridLayout(4, 4));
        Font fn = new Font("Tahoma", Font.BOLD, 60);
        int counter = 1;

        for (int i = 0; i < 16; i++) {
            buttons.add(new JButton("" + counter++));
            board.add(buttons.get(i)).setForeground(Color.black);
            buttons.get(i).setName("b" + counter);
            buttons.get(i).setFont(fn);
            buttons.get(i).addActionListener(this);

        }

        buttons.get(15).setBackground(null);
        buttons.get(15).setOpaque(true);
        buttons.get(15).setText("");

        buttonPanel.setBackground(new Color(-153));
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(600, 90);
        frame.setVisible(true);

        //isSolved();
    }

    MouseAdapter shuffle = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            Method obj = new Method();
            obj.shuffle(board, buttons);
        }
    };
    MouseAdapter ma2 = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int counter = 1;
            for (int i = 0; i < buttons.size(); i++) {
                buttons.get(i).setText("" + counter++);

            }
            buttons.get(14).setBackground(null);
            buttons.get(14).setOpaque(true);
            buttons.get(14).setText("");
            buttons.get(15).setText("15");
            board.revalidate();
            board.repaint();
        }
    };

    public boolean isSolved() {

        if (buttons.get(0).getText().equals("1") && buttons.get(1).getText().equals("2")
                && buttons.get(2).getText().equals("3") && buttons.get(3).getText().equals("4")
                && buttons.get(4).getText().equals("5") && buttons.get(5).getText().equals("6")
                && buttons.get(6).getText().equals("7") && buttons.get(7).getText().equals("8")
                && buttons.get(8).getText().equals("9") && buttons.get(9).getText().equals("10")
                && buttons.get(10).getText().equals("11") && buttons.get(11).getText().equals("12")
                && buttons.get(12).getText().equals("13") && buttons.get(13).getText().equals("14")
                && buttons.get(14).getText().equals("15") && buttons.get(15).getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You solved the puzzle!!");
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        Fifteen puzzle = new Fifteen();
        puzzle.gameDemo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < buttons.size(); i++) {

            if (e.getSource() == buttons.get(i)) {
                String value = buttons.get(i).getText();
                if (buttons.get(next(i)).getText().equals("")) {
                    String value2 = buttons.get(next(i)).getText();
                    buttons.get(next(i)).setText(value);
                    buttons.get(i).setText(value2);
                }
            }
            if (e.getSource() == buttons.get(i)) {
                String value = buttons.get(i).getText();
                if (buttons.get(prev(i)).getText().equals("")) {
                    String value2 = buttons.get(prev(i)).getText();
                    buttons.get(prev(i)).setText(value);
                    buttons.get(i).setText(value2);
                }
            }
            if (e.getSource() == buttons.get(i)) {
                String value = buttons.get(i).getText();
                if (buttons.get(above(i)).getText().equals("")) {
                    String value2 = buttons.get(above(i)).getText();
                    buttons.get(above(i)).setText(value);
                    buttons.get(i).setText(value2);
                }
            }
            if (e.getSource() == buttons.get(i)) {
                String value = buttons.get(i).getText();
                if (buttons.get(below(i)).getText().equals("")) {
                    String value2 = buttons.get(below(i)).getText();
                    buttons.get(below(i)).setText(value);
                    buttons.get(i).setText(value2);
                }
            }

        }
        isSolved();
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

}