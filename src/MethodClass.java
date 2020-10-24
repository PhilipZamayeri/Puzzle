import javax.swing.*;
import java.awt.*;
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
    String namn;
    JButton b;
    public void shuffle(List<JButton> buttons, JPanel board){




        Collections.shuffle(buttons);

        for (var button : buttons){
            board.add(button);
        }

    }
    public void shuffleMetod(JButton[][] button) {
        Random random = new Random();

        for (int i = button.length - 1; i > 0; i--) {
            for (int j = button[i].length - 1; j > 0; j--) {
                int m = random.nextInt(i + 1);
                int n = random.nextInt(j + 1);

                String temp = button[i][j].getText();
                button[i][j].setText(button[m][n].getText());
                button[m][n].setText(temp);

            }
        }
    }
}
