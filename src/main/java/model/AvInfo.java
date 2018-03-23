package model;

public class AvInfo {
    private Integer id;
    private int score;

    public AvInfo() {
    }

    public AvInfo(Integer id, int score) {
        this.id = id;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "AvInfo{" +
                "id=" + id +
                ", score=" + score +
                '}';
    }
}
