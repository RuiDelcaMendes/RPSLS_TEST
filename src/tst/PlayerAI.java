package tst;

public class PlayerAI extends Player {
    public PlayerAI(String name) {
        super(name);
        this.setHuman(false);
    }

    @Override
    public PlayType play(PlayType pt) {
        PlayType pt2 = null;


        // determine next move for next player
        pt2 = Player.determineNextMove(Game.getInstance().getNextPlayer(false));
        if(pt2 == null)
            pt2 = Player.randomPlay();
        // pt2 holds determined next move for player
        // now find a move that wins it
        for (PlayType playType: PlayType.values()
             ) {
            if(pt2.losesTo(playType)){
                this.setPrevious(playType);
                return playType;
            }
        }

        return null;
    }
}
