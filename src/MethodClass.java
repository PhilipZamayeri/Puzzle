import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Philip Zamayeri
 * Date: 2020-10-24
 * Time: 06:52
 * Project: Puzzle
 * Copyright: MIT
 */
public class MethodClass {

    public void shuffle(List<JButton> buttons, JPanel board){
        board.removeAll();

        Collections.shuffle(buttons);
        for (JButton button : buttons){
            board.add(button);
        }

        board.revalidate();
        board.repaint();

    }



}
