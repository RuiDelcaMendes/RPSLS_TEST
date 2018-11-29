package tst;

import java.util.HashMap;


public class AIPlay {

    private HashMap<PlayType, Integer> otherPlays;
    private PlayType previous;
    private static HashMap<PlayType, AIPlay> aiPlayCont;

    public static AIPlay getInstance(PlayType pt) {
        if (aiPlayCont == null)
            aiPlayCont = new HashMap<>();

        if (aiPlayCont.containsKey(pt)) return aiPlayCont.get(pt);
        else {
            aiPlayCont.put(pt, new AIPlay(pt));
            return aiPlayCont.get(pt);
        }
    }

    public PlayType nextMove() {
        PlayType nextPt = null;
        Integer count = 0;
        for (PlayType pt : this.otherPlays.keySet()
        ) {
            // check if


           /* if (
                    this.getPrevious().losesTo(pt) &&
                            ( nextPt == null || count == null || count < this.otherPlays.get(pt) )) {
                nextPt = pt;
                count = this.otherPlays.get(pt);
                continue;
            }*/
        }

        for (PlayType pt2 : PlayType.values()
        ) {
            if (nextPt.losesTo(pt2))
                return pt2;
        }

        return null;
    }


    protected AIPlay(PlayType pt) {
        this.setPrevious(pt);
        this.initOtherPlays();
    }


    public void setOtherPlays(PlayType otherPlay) {
        this.otherPlays.replace(otherPlay, this.otherPlays.get(otherPlay) + 1);
        this.setPrevious(otherPlay);
    }

    private void initOtherPlays() {
        otherPlays = new HashMap<>();
        for (PlayType other : PlayType.values()
        ) {
            if (other != this.getPrevious())
                otherPlays.put(other, 0);
        }


    }

    protected PlayType getPrevious() {
        return previous;
    }

    protected void setPrevious(PlayType previous) {
        this.previous = previous;
    }
}
