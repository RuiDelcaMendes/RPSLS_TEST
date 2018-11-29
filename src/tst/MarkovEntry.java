package tst;

public class MarkovEntry {
    private PlayType pt;
    private Integer count;

    public MarkovEntry(PlayType pt) {
        this.setPt(pt);
        this.setCount(0);
    }


    public PlayType getPt() {
        return pt;
    }

    public void setPt(PlayType pt) {
        this.pt = pt;
    }

    public Integer getCount() {
        return count;
    }

    private void setCount(Integer count) {
        this.count = count;
    }

    public void initCount() {
        this.setCount(0);
    }

    public void increaseCount() {
        this.setCount(this.getCount() + 1);
    }

}
