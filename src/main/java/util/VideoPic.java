package util;

import java.io.File;
import java.util.List;

public class VideoPic {
  // 视频工具文件位置
  public static final String FFMPEG_PATH = "D:/ffmpeg/bin/ffmpeg.exe";

  public static void main(String[] args) {

    processImg("D:/下载/迅雷下载/马戏Z王.720p.HD韩版中英双字[最新电影www.6vhao.tv].mp4", FFMPEG_PATH);

  }

  public static boolean processImg(String videoPath,String ffmpeg_path) {
    File file = new File(videoPath);
    if (!file.exists()) {
      System.err.println("路径[" + videoPath + "]对应的视频文件不存在!");
      return false;
    }
    List<String> commands = new java.util.ArrayList<String>();
    commands.add(ffmpeg_path);
    commands.add("-i");
    commands.add(videoPath);
    commands.add("-y");
    commands.add("-f");
    commands.add("image2");
    commands.add("-ss");
    commands.add("100");//这个参数是设置截取视频300秒(5分钟)时的画面
//    commands.add("-t");
//    commands.add("2.0");
//    commands.add("-s");
//    commands.add("700x525");
//    commands.add(veido_path.substring(0, veido_path.lastIndexOf(".")).replaceFirst("vedio", "file") + ".jpg");
    commands.add("D:/"+file.getName().substring(0, file.getName().lastIndexOf(".")) + ".jpg");
    System.out.println("D:/pic/"+file.getName().substring(0, file.getName().lastIndexOf(".")) + ".jpg");
    try {
//      ProcessBuilder builder = new ProcessBuilder();
      ProcessBuilder builder = BuilderUtil.getInstance();
      builder.command(commands);
      builder.start();
      System.out.println("截取成功");
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

}
