package model;

public class VideoInfo {
    private Integer id;
    private String fileName;
    private String path;
    private double sizeMb;
    private long sizeB;

    public VideoInfo() {
    }

    public VideoInfo(Integer id, String fileName, String path, double sizeMb, long sizeB) {
        this.id = id;
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
                ", fileName='" + fileName + '\'' +
                ", path='" + path + '\'' +
                ", sizeMb=" + sizeMb +
                ", sizeB=" + sizeB +
                '}';
    }
}
