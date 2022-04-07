package App;

import Component.Bag;
import Component.Board;
import Player.Player;

import java.util.ArrayList;
//import java.util.Dictionary;
import java.util.List;

public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final List<Player> players = new ArrayList<>();
    //private final Dictionary dictionary = new Dictionary();

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public void play() {
        for (Player player : players) {
            Thread thread= new Thread(player);
            thread.start();
        }
    }

    public Board getBoard() {
        return this.board;
    }

    public Bag getBag() {
        return this.bag;
    }
}
