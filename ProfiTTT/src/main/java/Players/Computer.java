package Players;

import Game.Board;

import javax.swing.*;
import java.awt.*;

public class Computer extends Player{

    public Computer() {
    }

    @Override
    public void makeMove(int i) {
        JButton button = Board.getButton(i);
        if (button.getText() == "") {
            button.setForeground(new Color(0, 0, 255));
            button.setText("O");
        }
    }

    public int makeRandMove(){
        int i = (int)(Math.random() * 9);
        while (Board.getButton(i).getText() != ""){
            i = (int)(Math.random() * 9);
        }
        JButton button = Board.getButton(i);
        button.setForeground(new Color(0, 0, 255));
        button.setText("O");
        return i;
    }

    static int minimax(int board[], int depth, Boolean isMax)
    {
        int score = Board.evaluate();

        if (score == 10)
            return score;

        if (score == -10)
            return score;

        if (Board.isMovesLeft() == false)
            return 0;

        if (isMax)
        {
            int best = -1000;
            for (int i = 0; i < 9; i++)
            {
                if (board[i] == 0 )
                {
                    board[i] = 1;
                    best = Math.max(best, minimax(board,
                            depth + 1, !isMax));
                    board[i] = 0;
                }

            }
            return best;
        }
        else
        {
            int best = 1000;
            for (int i = 0; i < 9; i++)
            {
                if (board[i] == 0)
                {
                    board[i] = 2;
                    best = Math.min(best, minimax(board,
                            depth + 1, !isMax));
                    board[i] = 0;
                }
            }
            return best;
        }
    }

    public int makeBestMove(int[] board){
        int bestVal = -1000;
        int rez = -1;
        for (int i = 0; i < 9; i++)
        {
            if (board[i] == 0)
            {
                board[i] = 1;
                int moveVal = minimax(board, 0, false);
                board[i] = 0;
                if (moveVal > bestVal)
                {
                    rez=i;
                    bestVal = moveVal;
                }
            }

        }

        System.out.printf("The value of the best Move " +
                "is : %d\n\n", bestVal);

        JButton button = Board.getButton(rez);
        if (button.getText() == "") {
            button.setForeground(new Color(0, 0, 255));
            button.setText("O");
        }
        return rez;
    }

}