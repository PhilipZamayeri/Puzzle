import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Philip Zamayeri
 * Date: 2020-10-22
 * Time: 12:28
 * Project: Puzzle
 * Copyright: MIT
 */
public class Puzzle   {
    JButton newGame;
    JButton cheat;
    JButton[][] buttons = new JButton[4][4];
    //JButton[][] buttonsCopy = new JButton[4][4];
    //JButton[][] buttonsCopy = Arrays.copyOf(buttons, buttons.length);
    JButton[][] buttonsCopy;
    boolean solved = false;


    public void gameDemo(){
        JFrame frame = new JFrame("Puzzle");
        JPanel board = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel panel  = new JPanel();

        newGame = new JButton("Nytt spel");
        cheat = new JButton("Cheat");
        newGame.addMouseListener(ma2);
        cheat.addMouseListener(ma3);

        panel.setLayout(new BorderLayout());
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(board);

        buttonPanel.add(newGame);
        buttonPanel.add(cheat);

        board.setLayout(new GridLayout(4, 4));
        Font fn = new Font("Tahoma", Font.BOLD, 60);
        int Num = 1;
        int count = 1;
       //int countName = 0;

        for (int i =0; i < buttons.length; i ++)
            for (int j = 0; j < buttons[i].length; j++){
                buttons[i][j] = new JButton("" + count++);
                //buttons[i][j] = new JButton("" + count++);
                //buttons[i][j] = new JButton().setName();
                board.add(buttons[i][j]).setForeground(Color.black);
                buttons[i][j].setName("b" + (count -1));
                buttons[i][j].setFont(fn);
                //buttons[i][j].addMouseListener(ma1);
                //buttons[i][j].addActionListener(this);
        }
        buttonsCopy = Arrays.copyOf(buttons, buttons.length);

        buttons[3][3].setBackground(null);
        //buttons[3][3].setFont(null);
        buttons[3][3].setText(null);
        buttons[3][3].setOpaque(true);

        buttonPanel.setBackground(new Color(-153));
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(600, 90);
        frame.setVisible(true);

        isSolved();
        if(solved)
            System.out.println("Winner!");
        else
            System.out.println("Looser");

        System.out.println(buttons[1][1].getName());


    }

    MouseAdapter ma1 = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
        }
    };
    MouseAdapter ma2 = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            //super.mouseClicked(e);
            Random random = new Random();

            for (int i = buttons.length - 1; i > 0; i--) {
                for (int j = buttons[i].length - 1; j > 0; j--) {
                    int m = random.nextInt(i + 1);
                    int n = random.nextInt(j + 1);

                    String temp = buttons[i][j].getText();
                    buttons[i][j].setText(buttons[m][n].getText());
                    buttons[m][n].setText(temp);
                }
            }

        }
    };
    MouseAdapter ma3 = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
        }
    };

    public void isSolved() {
        //if (buttons[buttons.length - 1] == null) {
        //if (buttons[3][3] == null) {
            if (Arrays.equals(buttons, buttonsCopy))
            //if (Arrays.deepEquals(buttons, buttonsCopy))
                solved = true;
         //   }
            else {
                solved = false;
            }
    }

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
        Puzzle puzzle = new Puzzle();
        puzzle.gameDemo();

        //puzzle.print();
    }

    /*Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String label = b1.getText();
            if (b2.getText().equals("")) {
                b2.setText(label);
                b1.setText("");
            }
            if (b5.getText().equals("")) {
                b5.setText(label);
                b1.setText("");
            }
        }
        if (e.getSource() == b2) {
            String label = b2.getText();
            if (b1.getText().equals("")) {
                b1.setText(label);
                b2.setText("");
            }
            if (b3.getText().equals("")) {
                b3.setText(label);
                b2.setText("");
            }
            if (b6.getText().equals("")) {
                b6.setText(label);
                b2.setText("");
            }
        }
        if (e.getSource() == b3) {
            String label = b3.getText();
            if (b2.getText().equals("")) {
                b2.setText(label);
                b3.setText("");
            }
            if (b4.getText().equals("")) {
                b4.setText(label);
                b3.setText("");
            }
            if (b7.getText().equals("")) {
                b7.setText(label);
                b3.setText("");
            }
        }
        if (e.getSource() == b4) {
            String label = b4.getText();
            if (b8.getText().equals("")) {
                b8.setText(label);
                b4.setText("");
            }
            if (b3.getText().equals("")) {
                b3.setText(label);
                b4.setText("");
            }
        }
        if (e.getSource() == b5) {
            String label = b5.getText();
            if (b1.getText().equals("")) {
                b1.setText(label);
                b5.setText("");
            }
            if (b6.getText().equals("")) {
                b6.setText(label);
                b5.setText("");
            }
            if (b9.getText().equals("")) {
                b9.setText(label);
                b5.setText("");
            }
        }
        if (e.getSource() == b6) {
            String label = b6.getText();
            if (b5.getText().equals("")) {
                b5.setText(label);
                b6.setText("");
            }
            if (b2.getText().equals("")) {
                b2.setText(label);
                b6.setText("");
            }
            if (b7.getText().equals("")) {
                b7.setText(label);
                b6.setText("");
            }
            if (b10.getText().equals("")) {
                b10.setText(label);
                b6.setText("");
            }
        }
        if (e.getSource() == b7) {
            String label = b7.getText();
            if (b3.getText().equals("")) {
                b3.setText(label);
                b7.setText("");
            }
            if (b8.getText().equals("")) {
                b8.setText(label);
                b7.setText("");
            }
            if (b11.getText().equals("")) {
                b11.setText(label);
                b7.setText("");
            }
            if (b6.getText().equals("")) {
                b6.setText(label);
                b7.setText("");
            }
        }
        if (e.getSource() == b8) {
            String label = b8.getText();
            if (b4.getText().equals("")) {
                b4.setText(label);
                b8.setText("");
            }
            if (b7.getText().equals("")) {
                b7.setText(label);
                b8.setText("");
            }
            if (b12.getText().equals("")) {
                b12.setText(label);
                b8.setText("");
            }
        }
        if (e.getSource() == b9) {
            String label = b9.getText();
            if (b5.getText().equals("")) {
                b5.setText(label);
                b9.setText("");
            }
            if (b10.getText().equals("")) {
                b10.setText(label);
                b9.setText("");
            }
            if (b13.getText().equals("")) {
                b13.setText(label);
                b9.setText("");
            }
        }
        if (e.getSource() == b10) {
            String label = b10.getText();
            if (b6.getText().equals("")) {
                b6.setText(label);
                b10.setText("");
            }
            if (b9.getText().equals("")) {
                b9.setText(label);
                b10.setText("");
            }
            if (b11.getText().equals("")) {
                b11.setText(label);
                b10.setText("");
            }
            if (b14.getText().equals("")) {
                b14.setText(label);
                b10.setText("");
            }
        }
        if (e.getSource() == b11) {
            String label = b11.getText();
            if (b7.getText().equals("")) {
                b7.setText(label);
                b11.setText("");
            }
            if (b10.getText().equals("")) {
                b10.setText(label);
                b11.setText("");
            }
            if (b12.getText().equals("")) {
                b12.setText(label);
                b11.setText("");
            }
            if (b15.getText().equals("")) {
                b15.setText(label);
                b11.setText("");
            }
        }
        if (e.getSource() == b12) {
            String label = b12.getText();
            if (b8.getText().equals("")) {
                b8.setText(label);
                b12.setText("");
            }
            if (b11.getText().equals("")) {
                b11.setText(label);
                b12.setText("");
            }
            if (b16.getText().equals("")) {
                b16.setText(label);
                b12.setText("");
            }
        }
        if (e.getSource() == b13) {
            String label = b13.getText();
            if (b9.getText().equals("")) {
                b9.setText(label);
                b13.setText("");
            }
            if (b14.getText().equals("")) {
                b14.setText(label);
                b13.setText("");
            }
        }
        if (e.getSource() == b14) {
            String label = b14.getText();
            if (b10.getText().equals("")) {
                b10.setText(label);
                b14.setText("");
            }
            if (b13.getText().equals("")) {
                b13.setText(label);
                b14.setText("");
            }
            if (b15.getText().equals("")) {
                b15.setText(label);
                b14.setText("");
            }
        }
        if (e.getSource() == b15) {
            String label = b15.getText();
            if (b11.getText().equals("")) {
                b11.setText(label);
                b15.setText("");
            }
            if (b14.getText().equals("")) {
                b14.setText(label);
                b15.setText("");
            }
            if (b16.getText().equals("")) {
                b16.setText(label);
                b15.setText("");
            }
        }
        if (e.getSource() == b16) {
            String label = b16.getText();
            if (b12.getText().equals("")) {
                b12.setText(label);
                b16.setText("");
            }
            if (b15.getText().equals("")) {
                b15.setText(label);
                b16.setText("");
            }
        }
        if(b1.getText().equals("1") && b2.getText().equals("2") && b3.getText().equals("3") && b4.getText().equals("4")
                && b5.getText().equals("5") && b6.getText().equals("6") && b7.getText().equals("7")
                && b8.getText().equals("8") && b9.getText().equals("9") && b10.getText().equals("10")
                && b11.getText().equals("11")&& b12.getText().equals("12")&& b13.getText().equals("13")
                && b14.getText().equals("14")&& b15.getText().equals("15")&& b16.getText().equals("")){
            //System.out.println("You wont!");
            //JOptionPane.showMessageDialog(null,"You solved the puzzle!!");
            JOptionPane.showMessageDialog(null,new ImageIcon("src/Inlämningsuppgift03/Bilder/thumbsup.jpg"),
                    "You solved the puzzle!", JOptionPane.INFORMATION_MESSAGE);
            //panel.add(winner);
            System.exit(0);
        }
    }
}
    */

   /* @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons[0][0]) {
            String label = buttons[0][0].getText();
            if (buttons[0][1].getText().equals("")) {
                buttons[0][1].setText(label);
                buttons[0][0].setText("");
            }
            if (buttons[1][0].getText().equals("")) {
                buttons[1][0].setText(label);
                buttons[0][0].setText("");
            }
        }
        if (e.getSource() == buttons[0][1]) {
            String label = buttons[0][1].getText();
            if (buttons[0][0].getText().equals("")) {
                buttons[0][0].setText(label);
                buttons[0][1].setText("");
            }
            if (buttons[0][2].getText().equals("")) {
                buttons[0][2].setText(label);
                buttons[0][1].setText("");
            }
            if (buttons[1][1].getText().equals("")) {
                buttons[1][1].setText(label);
                buttons[0][1].setText("");
            }
        }
        if (e.getSource() == buttons[0][2]) {
            String label = buttons[0][2].getText();
            if (buttons[0][1].getText().equals("")) {
                buttons[0][1].setText(label);
                buttons[0][2].setText("");
            }
            if (buttons[1][2].getText().equals("")) {
                buttons[0][2].setText(label);
                buttons[0][2].setText("");
            }
            if (buttons[0][3].getText().equals("")) {
                buttons[0][3].setText(label);
                buttons[0][2].setText("");
            }
        }
        if (e.getSource() == buttons[0][3]) {
            String label = buttons[0][3].getText();
            if (buttons[0][2].getText().equals("")) {
                buttons[0][2].setText(label);
                buttons[0][3].setText("");
            }
            if (buttons[1][3].getText().equals("")) {
                buttons[1][3].setText(label);
                buttons[0][3].setText("");
            }
        }
        if (e.getSource() == buttons[1][0]) {
            String label = buttons[1][0].getText();
            if (buttons[0][0].getText().equals("")) {
                buttons[0][0].setText(label);
                buttons[1][0].setText("");
            }
            if (buttons[1][1].getText().equals("")) {
                buttons[1][1].setText(label);
                buttons[1][0].setText("");
            }
            if (buttons[2][0].getText().equals("")) {
                buttons[2][0].setText(label);
                buttons[1][0].setText("");
            }
        }
        if (e.getSource() == buttons[1][1]) {
            String label = buttons[1][1].getText();
            if (buttons[1][0].getText().equals("")) {
                buttons[1][0].setText(label);
                buttons[1][1].setText("");
            }
            if (buttons[0][1].getText().equals("")) {
                buttons[0][1].setText(label);
                buttons[1][1].setText("");
            }
            if (buttons[1][2].getText().equals("")) {
                buttons[1][2].setText(label);
                buttons[1][1].setText("");
            }
            if (buttons[2][1].getText().equals("")) {
                buttons[2][1].setText(label);
                buttons[1][1].setText("");
            }
        }
        if (e.getSource() == buttons[1][2]) {
            String label = buttons[1][2].getText();
            if (buttons[0][2].getText().equals("")) {
                buttons[0][2].setText(label);
                buttons[1][2].setText("");
            }
            if (buttons[1][3].getText().equals("")) {
                buttons[1][3].setText(label);
                buttons[1][2].setText("");
            }
            if (buttons[2][2].getText().equals("")) {
                buttons[2][2].setText(label);
                buttons[1][2].setText("");
            }
            if (buttons[1][1].getText().equals("")) {
                buttons[1][1].setText(label);
                buttons[1][2].setText("");
            }
        }
        if (e.getSource() == buttons[1][3]) {
            String label = buttons[1][3].getText();
            if (buttons[0][3].getText().equals("")) {
                buttons[0][3].setText(label);
                buttons[1][3].setText("");
            }
            if (buttons[1][2].getText().equals("")) {
                buttons[1][2].setText(label);
                buttons[1][3].setText("");
            }
            if (buttons[2][3].getText().equals("")) {
                buttons[2][3].setText(label);
                buttons[1][3].setText("");
            }
        }
        if (e.getSource() == buttons[2][0]) {
            String label = buttons[2][0].getText();
            if (buttons[1][0].getText().equals("")) {
                buttons[1][0].setText(label);
                buttons[2][0].setText("");
            }
            if (buttons[2][1].getText().equals("")) {
                buttons[2][1].setText(label);
                buttons[2][0].setText("");
            }
            if (buttons[3][0].getText().equals("")) {
                buttons[3][0].setText(label);
                buttons[2][0].setText("");
            }
        }
        if (e.getSource() == buttons[2][1]) {
            String label = buttons[2][1].getText();
            if (buttons[1][1].getText().equals("")) {
                buttons[1][1].setText(label);
                buttons[2][1].setText("");
            }
            if (buttons[3][0].getText().equals("")) {
                buttons[3][0].setText(label);
                buttons[3][1].setText("");
            }
            if (buttons[3][2].getText().equals("")) {
                buttons[3][2].setText(label);
                buttons[3][0].setText("");
            }
            if (buttons[3][1].getText().equals("")) {
                buttons[3][1].setText(label);
                buttons[2][1].setText("");
            }
        }
        if (e.getSource() == buttons[2][2]) {
            String label = buttons[2][2].getText();
            if (buttons[1][2].getText().equals("")) {
                buttons[1][2].setText(label);
                buttons[2][2].setText("");
            }
            if (buttons[2][1].getText().equals("")) {
                buttons[2][1].setText(label);
                buttons[2][2].setText("");
            }
            if (buttons[2][3].getText().equals("")) {
                buttons[2][3].setText(label);
                buttons[2][2].setText("");
            }
            if (buttons[3][2].getText().equals("")) {
                buttons[3][2].setText(label);
                buttons[2][2].setText("");
            }
        }
        if (e.getSource() == buttons[2][3]) {
            String label = buttons[2][3].getText();
            if (buttons[1][3].getText().equals("")) {
                buttons[1][3].setText(label);
                buttons[2][3].setText("");
            }
            if (buttons[2][2].getText().equals("")) {
                buttons[2][2].setText(label);
                buttons[2][3].setText("");
            }
            if (buttons[3][3].getText().equals("")) {
                buttons[3][3].setText(label);
                buttons[2][3].setText("");
            }
        }
        if (e.getSource() == buttons[3][0]) {
            String label = buttons[3][0].getText();
            if (buttons[2][0].getText().equals("")) {
                buttons[2][0].setText(label);
                buttons[3][0].setText("");
            }
            if (buttons[3][1].getText().equals("")) {
                buttons[3][1].setText(label);
                buttons[3][0].setText("");
            }
        }
        if (e.getSource() == buttons[3][1]) {
            String label = buttons[3][1].getText();
            if (buttons[2][1].getText().equals("")) {
                buttons[2][1].setText(label);
                buttons[3][1].setText("");
            }
            if (buttons[3][0].getText().equals("")) {
                buttons[3][0].setText(label);
                buttons[3][1].setText("");
            }
            if (buttons[3][2].getText().equals("")) {
                buttons[3][2].setText(label);
                buttons[3][1].setText("");
            }
        }
        if (e.getSource() == buttons[3][2]) {
            String label = buttons[3][2].getText();
            if (buttons[2][2].getText().equals("")) {
                buttons[2][2].setText(label);
                buttons[3][2].setText("");
            }
            if (buttons[3][1].getText().equals("")) {
                buttons[3][1].setText(label);
                buttons[3][2].setText("");
            }
            if (buttons[3][3].getText().equals("")) {
                buttons[3][3].setText(label);
                buttons[3][2].setText("");
            }
        }
        if (e.getSource() == buttons[3][3]) {
            String label = buttons[3][3].getText();
            if (buttons[2][3].getText().equals("")) {
                buttons[2][3].setText(label);
                buttons[3][3].setText("");
            }
            if (buttons[3][2].getText().equals("")) {
                buttons[3][2].setText(label);
                buttons[3][3].setText("");
            }
        }
        if(buttons[0][0].getText().equals("1")
                && buttons[0][1].getText().equals("2") && buttons[0][2].getText().equals("3")
                && buttons[0][3].getText().equals("4") && buttons[1][0].getText().equals("5")
                && buttons[1][1].getText().equals("6") && buttons[1][2].getText().equals("7")
                && buttons[1][3].getText().equals("8") && buttons[2][0].getText().equals("9")
                && buttons[2][1].getText().equals("10") && buttons[2][2].getText().equals("11")
                && buttons[2][3].getText().equals("12")&& buttons[3][0].getText().equals("13")
                && buttons[3][1].getText().equals("14")&& buttons[3][2].getText().equals("15")
                && buttons[3][3].getText().equals("")){
            //System.out.println("You wont!");
            JOptionPane.showMessageDialog(null,"You solved the puzzle!!");
            //JOptionPane.showMessageDialog(null,new ImageIcon("src/Inlämningsuppgift03/Bilder/thumbsup.jpg"),
              //      "You solved the puzzle!", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

    }
*/
}
