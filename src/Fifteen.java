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
        List<JButton> correctOrder;
        //boolean solved = false;
        //List<JButton> correctOrder = new ArrayList<>(buttons);

        JFrame frame = new JFrame("Puzzle");
        JPanel board = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel panel = new JPanel();

        public void gameDemo() {

            restart = new JButton("New game");
            solution = new JButton("Help");
            restart.addMouseListener(shuffle);
            //solution.addMouseListener(ma2);
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

                //correctOrder.add(new JButton("" + counter++));
                //correctOrder.get(i).setName("b" + counter);
                //correctOrder.get(i).setFont(fn);

            }

            buttons.get(15).setBackground(null);
            buttons.get(15).setOpaque(true);
            buttons.get(15).setText(null);
            //List<JButton> correctOrder = new ArrayList<>(buttons);

            buttonPanel.setBackground(new Color(-153));
            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocation(600, 90);
            frame.setVisible(true);

            // System.out.println(buttons.get(14).getText());
            //List<JButton> correctOrder = new ArrayList<>(buttons);
            for (var el1 : buttons)
                System.out.println(el1.getText());
            correctOrder = new ArrayList<>(buttons);
        }

        /*public void correctOrder(){

            Font fn = new Font("Tahoma", Font.BOLD, 60);
            int counter = 1;

            for (int i = 0; i < 16; i++) {


                correctOrder.add(new JButton("" + counter++));
                correctOrder.get(i).setName("b" + counter);
                correctOrder.get(i).setFont(fn);

            }

            correctOrder.get(15).setBackground(null);
            correctOrder.get(15).setOpaque(true);
            correctOrder.get(15).setText(null);


            for(var el:correctOrder)
           System.out.println(el.getText());
        }
    */
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
                board.removeAll();
                buttons = new ArrayList<>(correctOrder);
                //correctOrder = ArrayList
                for(var el:buttons)
                    board.add(el);
                board.revalidate();
                board.repaint();
            }
        };
        MouseAdapter ma3 = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        };

   /* public void isSolved() {
        //if (buttons[buttons.length - 1] == null) {
        //if (buttons[3][3] == null) {
        if (Arrays.equals(buttons, buttonsCopy))
            //if (Arrays.deepEquals(buttons, buttonsCopy))
            solved = true;
            //   }
        else {
            solved = false;
        }
    }*/

       /* if(buttons[buttons.length - 1] != null)
            return false;
        for (int i = buttons - 1; i >= 0; i--) {
            if (buttons[i] != i + 1)
                return false;
        }
        return true;

        */
        //}
        //public void print(){
        //System.out.println(Arrays.toString(buttons));
        //System.out.println(Arrays.toString(buttonsCopy));
        /*for (var el : buttons)
            System.out.println(el);

        for (var el2 : buttonsCopy)
            System.out.println(el2);*/
        //}


        public static void main(String[] args) {
            Fifteen puzzle = new Fifteen();
            puzzle.gameDemo();
            //puzzle.correctOrder();
            //puzzle.gameSolved();

       /* if (puzzle.gameSolved()) {
            JOptionPane.showMessageDialog(null,"You solved the puzzle!!");
        }*/

            //puzzle.print();
        }

        @Override
        public void actionPerformed(ActionEvent e) {

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
            /*if (gameSolved()) {
                JOptionPane.showMessageDialog(null,"You solved the puzzle!!");
                System.exit(0);
            }*/
            }
        }

        public int next(int i) {
            if (i <= 14 && i >= 0) {
                return i + 1;
            } else {
                //return i = buttons.size()-1;
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
}
