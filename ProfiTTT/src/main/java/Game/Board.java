package Game;

import Players.Computer;
import Players.Human;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {

    Human player = new Human();
    Computer ai = new Computer();

    static int[] boardState = new int[9];

    public void resetBoardState(){
        for(int i = 0; i<9; i++){
            setBoardState(i,0);
        }
    }

    public static int[] getBoardState() {
        return boardState;
    }

    public void printBoardState(){
        for(int i=0; i< boardState.length;i++){
            System.out.print(boardState[i] + " ");
            if((i+1)%3==0)
                System.out.print('\n');
        }
    }
    public void setBoardState(int index, int value) {
        boardState[index] = value;
    }

    JFrame frame = new JFrame();
    JPanel text_panel = new JPanel();
    JPanel button_panel = new JPanel();
    public JLabel textfield = new JLabel();
    public static JButton[] button = new JButton[9];
    public static int moves_made = 0;
    public boolean player_move = true;

    public static Boolean isMovesLeft()
    {
        return moves_made != 9;
    }

    public static int evaluate()
    {
        for (int row = 0; row < 3; row++)
        {
            if (getBoardState()[row*3] == getBoardState()[row*3+1] &&
                    getBoardState()[row*3+1] == getBoardState()[row*3+2])
            {
                if (getBoardState()[row*3] == 1)
                    return +10;
                else if (getBoardState()[row*3] == 2)
                    return -10;
            }
        }

        for (int col = 0; col < 3; col++)
        {
            if (getBoardState()[col] == getBoardState()[col+3] &&
                    getBoardState()[col+3] == getBoardState()[col+6])
            {
                if (getBoardState()[col] == 1)
                    return +10;

                else if (getBoardState()[col] == 2)
                    return -10;
            }
        }

        if (getBoardState()[0] == getBoardState()[4] && getBoardState()[4] == getBoardState()[8])
        {
            if (getBoardState()[0] == 1)
                return +10;
            else if (getBoardState()[0] == 2)
                return -10;
        }

        if (getBoardState()[2] == getBoardState()[4] && getBoardState()[4] == getBoardState()[6])
        {
            if (getBoardState()[2] == 1)
                return +10;
            else if (getBoardState()[2] == 2)
                return -10;
        }

        return 0;
    }

//    public boolean getPlayer_move() {
//        return player_move;
//    }
//
//    public void setPlayer_move(boolean player_move) {
//        this.player_move = player_move;
//    }

    public static JButton getButton(int i) {
        return button[i];
    }

    public Board() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setTitle("X & 0");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setForeground(new Color(30, 95, 95));
        textfield.setBackground(new Color(0, 0, 75));
        textfield.setFont(new Font("Roboto", Font.BOLD, 60));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Cel mai greu joc de X si 0");
        textfield.setOpaque(true);

        text_panel.setLayout(new BorderLayout());
        text_panel.setBounds(0, 0, 1000, 100);
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {

            button[i] = new JButton();// creating object for each button element of array
            button_panel.add(button[i]);// adding each button to the pannel for buttons
            button[i].setFont(new Font("Roboto", Font.BOLD, 120));
            button[i].setFocusable(false);
            button[i].addActionListener(this);

        }

        text_panel.add(textfield);
        frame.add(text_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        resetBoardState();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == button[i]) {
                if (player_move) {
                    player.makeMove(i);
                    setBoardState(i,1);
                    textfield.setText("O turn");
                    moves_made++;
                    if(!matchCheck()){
//                        setBoardState(ai.makeBestMove(getBoardState()), 2);
                        setBoardState(ai.makeRandMove(),2);
                        textfield.setText("X turn");
                        moves_made++;
                        matchCheck();
                    }
                }
                printBoardState();
            }
        }
    }

    public void gameOver(String s){
        resetBoardState();
        moves_made = 0;
        Object[] option={"Restart","Exit"};
        int n=JOptionPane.showOptionDialog(frame, "Game Over\n"+s,"Game Over",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
        if(n==0){
            frame.dispose();
            new Board();
        }
        else{
            frame.dispose();
        }

    }
    public boolean matchCheck() {// In this function we are checking winning conditions using conditional statments
        if ((button[0].getText() == "X") && (button[1].getText() == "X") && (button[2].getText() == "X")) {
            xWins(0, 1, 2);
            return true;
        }
        else if ((button[0].getText() == "X") && (button[4].getText() == "X") && (button[8].getText() == "X")) {
            xWins(0, 4, 8);
            return true;
        }
        else if ((button[0].getText() == "X") && (button[3].getText() == "X") && (button[6].getText() == "X")) {
            xWins(0, 3, 6);
            return true;
        }
        else if ((button[1].getText() == "X") && (button[4].getText() == "X") && (button[7].getText() == "X")) {
            xWins(1, 4, 7);
            return true;
        }
        else if ((button[2].getText() == "X") && (button[4].getText() == "X") && (button[6].getText() == "X")) {
            xWins(2, 4, 6);
            return true;
        }
        else if ((button[2].getText() == "X") && (button[5].getText() == "X") && (button[8].getText() == "X")) {
            xWins(2, 5, 8);
            return true;
        }
        else if ((button[3].getText() == "X") && (button[4].getText() == "X") && (button[5].getText() == "X")) {
            xWins(3, 4, 5);
            return true;
        }
        else if ((button[6].getText() == "X") && (button[7].getText() == "X") && (button[8].getText() == "X")) {
            xWins(6, 7, 8);
            return true;
        }

        else if ((button[0].getText() == "O") && (button[1].getText() == "O") && (button[2].getText() == "O")) {
            oWins(0, 1, 2);
            return true;
        }
        else if ((button[0].getText() == "O") && (button[3].getText() == "O") && (button[6].getText() == "O")) {
            oWins(0, 3, 6);
            return true;
        }
        else if ((button[0].getText() == "O") && (button[4].getText() == "O") && (button[8].getText() == "O")) {
            oWins(0, 4, 8);
            return true;
        }
        else if ((button[1].getText() == "O") && (button[4].getText() == "O") && (button[7].getText() == "O")) {
            oWins(1, 4, 7);
            return true;
        }
        else if ((button[2].getText() == "O") && (button[4].getText() == "O") && (button[6].getText() == "O")) {
            oWins(2, 4, 6);
            return true;
        }
        else if ((button[2].getText() == "O") && (button[5].getText() == "O") && (button[8].getText() == "O")) {
            oWins(2, 5, 8);
            return true;
        }
        else if ((button[3].getText() == "O") && (button[4].getText() == "O") && (button[5].getText() == "O")) {
            oWins(3, 4, 5);
            return true;
        } else if ((button[6].getText() == "O") && (button[7].getText() == "O") && (button[8].getText() == "O")) {
            oWins(6, 7, 8);
            return true;
        }
        else if(moves_made==9) {
            textfield.setText("Match Tie");
            gameOver("Match Tie");
            return true;
        }
        return false;
    }
    public void xWins(int x1, int x2, int x3) {
        button[x1].setBackground(Color.RED);
        button[x2].setBackground(Color.RED);
        button[x3].setBackground(Color.RED);
        for (int i = 0; i < 9; i++) {
            button[i].setEnabled(false);
        }
        textfield.setText("X wins");
        gameOver("X Wins");
    }
    public void oWins(int x1, int x2, int x3) {
        button[x1].setBackground(Color.RED);
        button[x2].setBackground(Color.RED);
        button[x3].setBackground(Color.RED);
        for (int i = 0; i < 9; i++) {
            button[i].setEnabled(false);
        }
        textfield.setText("O Wins");
        gameOver("O Wins");

    }

}