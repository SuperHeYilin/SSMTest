package model;

public class VideoInfo {
    private Integer id;
    private Integer score;
    private String fileName;
    private String path;
    private double sizeMb;
    private long sizeB;
    private String diskName;
    private int state;
    private String imgName;
    private String imgPath;



    public VideoInfo() {
    }

    public VideoInfo(Integer id, Integer score, String fileName, String path, double sizeMb, long sizeB, String diskName, int state) {
        this.id = id;
        this.score = score;
        this.fileName = fileName;
        this.path = path;
        this.sizeMb = sizeMb;
        this.sizeB = sizeB;
        this.diskName = diskName;
        this.state = state;
    }

    public String getDiskName() {
        return diskName;
    }

    public void setDiskName(String diskName) {
        this.diskName = diskName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
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
