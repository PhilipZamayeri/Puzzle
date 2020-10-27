import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

/**
 * Created by Philip Zamayeri & Robin Martinsson
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

    public void isSolved(List<JButton> buttons, List<JButton> correctOrder){
        int k = 0;
        int counter = 1;
        for (int i = 0; i < correctOrder.size(); i++) {
            if (buttons.get(i).getText().equals("" + counter++)){
                k++;
            }
        }
        if (k == (correctOrder.size()-1)){
            JOptionPane.showMessageDialog(null,"Grattis du löste pusslet!!!");
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

    public void moveTiles(List<JButton> buttons, List<JButton> correctOrder, MouseEvent e){
        for (int i = 0; i < buttons.size(); i++) {

            if (e.getSource() == buttons.get(i)) {
                String value = buttons.get(i).getText();
                if (buttons.get(next(i)).getText() == "") {
                    String value2 = buttons.get(next(i)).getText();
                    buttons.get(next(i)).setText(value);
                    buttons.get(i).setText(value2);
                }
            }
            if (e.getSource() == buttons.get(i)) {
                String value = buttons.get(i).getText();
                if (buttons.get(prev(i)).getText() == "") {
                    String value2 = buttons.get(prev(i)).getText();
                    buttons.get(prev(i)).setText(value);
                    buttons.get(i).setText(value2);
                }
            }
            if (e.getSource() == buttons.get(i)) {
                String value = buttons.get(i).getText();
                if (buttons.get(above(i)).getText() == "") {
                    String value2 = buttons.get(above(i)).getText();
                    buttons.get(above(i)).setText(value);
                    buttons.get(i).setText(value2);
                }
            }
            if (e.getSource() == buttons.get(i)) {
                String value = buttons.get(i).getText();
                if (buttons.get(below(i)).getText() == "") {
                    String value2 = buttons.get(below(i)).getText();
                    buttons.get(below(i)).setText(value);
                    buttons.get(i).setText(value2);
                }
            }
        }
        isSolved(buttons,correctOrder);
    }

}
