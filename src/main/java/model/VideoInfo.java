package model;

public class VideoInfo {
    private Integer id;
    private Integer score;
    private String fileName;
    private String path;
    private double sizeMb;
    private long sizeB;
    private String uName;
    private int state;

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public VideoInfo() {
    }

    public VideoInfo(Integer id, Integer score, String fileName, String path, double sizeMb, long sizeB) {
        this.id = id;
        this.score = score;
        this.fileName = fileName;
        this.path = path;
        this.sizeMb = sizeMb;
        this.sizeB = sizeB;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public double getSizeMb() {
        return sizeMb;
    }

    public void setSizeMb(double sizeMb) {
        this.sizeMb = sizeMb;
    }

    public long getSizeB() {
        return sizeB;
    }

    public void setSizeB(long sizeB) {
        this.sizeB = sizeB;
    }

    @Override
    public String toString() {
        return "VideoInfo{" +
                "id=" + id +
                ", score=" + score +
                ", fileName='" + fileName + '\'' +
                ", path='" + path + '\'' +
                ", sizeMb=" + sizeMb +
                ", sizeB=" + sizeB +
                '}';
    }
}
