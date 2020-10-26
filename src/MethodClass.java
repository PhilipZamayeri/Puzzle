import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;

/**
 * Created by Philip Zamayeri
 * Date: 2020-10-24
 * Time: 06:52
 * Project: Puzzle
 * Copyright: MIT
 */
public class MethodClass {

    public List<JButton> cheat(List<JButton> list, JPanel board){


        int counter =1;
        for(int i=0;i<list.size();i++) {
            list.get(i).setText("" + counter++);

        }
        list.get(15).setBackground(null);
        list.get(15).setOpaque(true);
        list.get(15).setText("15");
        list.get(14).setText("");

        board.revalidate();
        board.repaint();

        return list;
    }

    public void checkWin(List<JButton> buttons){
       /* int k = 0;
        for (int i = 0; i < contollList.size(); i++) {
            if (list.get(i).getText().equals(contollList.get(i).getText())){
                k++;
                if (k == contollList.size()){
                    JOptionPane.showMessageDialog(null,"Grattis du löste pusslet!!!");
                }
            }
        }*/
        if (buttons.get(0).getText().equals("1")
                && buttons.get(1).getText().equals("2") && buttons.get(2).getText().equals("3")
                && buttons.get(3).getText().equals("4") && buttons.get(4).getText().equals("5")
                && buttons.get(5).getText().equals("6") && buttons.get(6).getText().equals("7")
                && buttons.get(7).getText().equals("8") && buttons.get(8).getText().equals("9")
                && buttons.get(9).getText().equals("10") && buttons.get(10).getText().equals("11")
                && buttons.get(11).getText().equals("12")&& buttons.get(12).getText().equals("13")
                && buttons.get(13).getText().equals("14")&& buttons.get(14).getText().equals("15")
                && buttons.get(15).getText().equals("")){
            JOptionPane.showMessageDialog(null,"You solved the puzzle!!");
        }

    }

    public void shuffle(List<JButton> buttons, JPanel board){
        board.removeAll();

        Collections.shuffle(buttons);
        for (JButton button : buttons){
            board.add(button);
        }

        board.revalidate();
        board.repaint();

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
