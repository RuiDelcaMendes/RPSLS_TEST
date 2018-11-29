package tst;

import java.util.HashMap;
import java.util.Random;

public class Player {
    private int score;
    private String name;
    private boolean isHuman;
    private PlayType previous;
    protected HashMap<PlayType, HashMap<PlayType, MarkovEntry>> markovChain;

    public Player(String name) {
        this.setName(name);
        this.setScore(0);
        this.setHuman(true);
        this.previous = null;
        this.initMarkov();

    }

    protected static PlayType randomPlay(){
        Random r = new Random();
        return PlayType.values()[r.nextInt(4)];
    }

    protected static PlayType determineNextMove(Player player) {
        MarkovEntry me = null;
        if (player.getPrevious() == null)
            return null;

        for (MarkovEntry me2 : player.markovChain.get(player.getPrevious()).values()) {
            if (me == null || me.getCount() < me2.getCount())
                me = me2;
        }

        return me.getPt();
    }

    private void initMarkov() {
        HashMap<PlayType, MarkovEntry> markovTable = null;
        this.markovChain = new HashMap<>();
        for (PlayType pt : PlayType.values()
        ) {
            markovTable = new HashMap<>();
            for (PlayType pt2 : PlayType.values()) {
                markovTable.put(pt2, new MarkovEntry(pt2));
            }
            this.markovChain.put(pt, markovTable);
        }
    }

    public PlayType getPrevious() {
        return this.previous;
    }

    protected void buildMarkovChain(PlayType currentPlay) {
        // get previous entry
        if (this.getPrevious() == null)
            return;
        this.markovChain.get(this.getPrevious()).get(currentPlay).increaseCount();
    }

    public void setPrevious(PlayType pt) {
        this.buildMarkovChain(pt);
        this.previous = pt;
    }

    public PlayType play(PlayType pt) {
        this.setPrevious(pt);
        return pt;
    }

    public String toString() {
        return (isHuman ? "Human" : "AI") + " player " + this.getName() + " has " + this.getScore() + " points";
    }

    protected int getScore() {
        return score;
    }

    protected void setScore(int score) {
        this.score = score;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected boolean isHuman() {
        return isHuman;
    }

    protected void setHuman(boolean human) {
        isHuman = human;
    }
}
