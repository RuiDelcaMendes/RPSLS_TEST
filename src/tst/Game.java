package tst;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private int currPlayer;
    private static Game singleton;

    public static Game getInstance() {
        if (Game.singleton == null)
            Game.singleton = new Game();
        return Game.singleton;
    }

    private Game() {
        players = new ArrayList<>();
        this.currPlayer = 0;
    }

    public void addPlayer(String name, boolean isHuman) {
        this.players.add((!isHuman ? new PlayerAI(name) : new Player(name)));
    }

    public PlayType play(PlayType pt) {
        Player pl = this.getNextPlayer(true);
        PlayType playType = pl.play(pt);
        System.out.println(pl + " and plays " + playType);
        return playType;
    }

    public Player getNextPlayer(boolean increase) {
        Player pl = this.players.get(this.currPlayer);
        if (increase)
            this.currPlayer = (this.currPlayer == this.players.size() - 1 ? 0 : this.currPlayer + 1);
        return pl;
    }

    public List<Player> getPlayers() {
        return this.players;
    }
}
