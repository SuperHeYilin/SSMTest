package util;

public class VideoInfo {
  private int id;
  private String fileName;
  private String path;
  private int size_mb;
  private long size_b;

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    private String imgPath;

  public VideoInfo() {
  }

  public VideoInfo(int id, String fileName, String path, int size_mb, long size_b) {
    this.id = id;
    this.fileName = fileName;
    this.path = path;
    this.size_mb = size_mb;
    this.size_b = size_b;
  }

  @Override
  public String toString() {
    return "VideoInfo{" +
            "id=" + id +
            ", fileName='" + fileName + '\'' +
            ", path='" + path + '\'' +
            ", size_mb=" + size_mb +
            ", size_b=" + size_b +
            '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
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

  public int getSize_mb() {
    return size_mb;
  }

  public void setSize_mb(int size_mb) {
    this.size_mb = size_mb;
  }

  public long getSize_b() {
    return size_b;
  }

  public void setSize_b(long size_b) {
    this.size_b = size_b;
  }
}
