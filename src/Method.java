import javax.swing.*;
import java.util.Collections;
import java.util.List;

/**
 * Created by Robin Martinsson
 * Date:    2020-10-25
 * Time:    11:54
 * Project: Inlämningsuppgift03
 * Copyright: MIT
 */
public class Method {

    public void shuffle(JPanel board, List<JButton> buttons){
        board.removeAll();
        Collections.shuffle(buttons);
        for(var button:buttons){
            board.add(button);
        }
        board.revalidate();
        board.repaint();
    }
}
