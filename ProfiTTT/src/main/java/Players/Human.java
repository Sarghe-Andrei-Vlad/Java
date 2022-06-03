package Players;

import Game.Board;

import javax.swing.*;
import java.awt.*;

public class Human extends Player{

    public Human() {
    }

    @Override
    public void makeMove(int i) {
        JButton button = Board.getButton(i);
        if (button.getText() == "") {
            button.setForeground(new Color(255, 0, 0));
            button.setText("X");
        }
    }
}
