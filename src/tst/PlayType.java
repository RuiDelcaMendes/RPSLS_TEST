package tst;

import java.util.Arrays;
import java.util.List;

public enum PlayType {
    ROCK,PAPER,SCISSORS,LIZARD,SPOCK;

    private List<PlayType> losesTo;

    public boolean losesTo(PlayType otherPlay){
        return losesTo.contains(otherPlay);
    }

    static{
        SCISSORS.losesTo = Arrays.asList(ROCK,SPOCK);
        PAPER.losesTo = Arrays.asList(SCISSORS,LIZARD);
        ROCK.losesTo = Arrays.asList(PAPER,SPOCK);
        LIZARD.losesTo = Arrays.asList(SCISSORS,ROCK);
        SPOCK.losesTo = Arrays.asList(LIZARD,PAPER);
    }
}
