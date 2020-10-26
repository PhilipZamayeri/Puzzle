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
        list.get(15).setText("");
        //list.get(14).setText("15");

        board.revalidate();
        board.repaint();

        return list;
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
