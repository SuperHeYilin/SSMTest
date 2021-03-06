package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VideoPicUtil {
    // 视频工具文件位置
    private static final String FFMPEG_PATH = "D:/ffmpeg/bin/ffmpeg.exe";

    public static void main(String[] args) {

        processImgNum("D:/下载/迅雷下载/马戏Z王.720p.HD韩版中英双字[最新电影www.6vhao.tv].mp4", 1);
//        processImg("D:/下载/迅雷下载/马戏Z王.720p.HD韩版中英双字[最新电影www.6vhao.tv].mp4", 1);

    }

    /**
     * 某个文件截图
     * @param videoPath 文件路径
     * @param num 执行次数
     */
    public static void processImgNum(String videoPath, int num) {
        // 产生随机数时间 秒  根据视频时长
        int rand = 1;
        List<String> commands = new java.util.ArrayList<String>();
        commands.add(FFMPEG_PATH);
        commands.add("-i");
        commands.add(videoPath);
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commands);
            final Process p = builder.start();

            //从输入流中读取视频信息
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();

            //从视频信息中解析时长
            String regexDuration = "Duration: (.*?), start: (.*?), bitrate: (\\d*) kb\\/s";
            Pattern pattern = Pattern.compile(regexDuration);
            Matcher m = pattern.matcher(sb.toString());
            if (m.find()) {
                rand = getTimelen(m.group(1));
//                int time = m.group(1);
//                log.info(video_path+",视频时长："+time+", 开始时间："+m.group(2)+",比特率："+m.group(3)+"kb/s");
                System.out.println("视频时长：" + getTimelen(m.group(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 根据次数 对某个视频文件随机截图n次
        for (int i = 0; i < num; i++) {
            int temp = 1 + (int)(Math.random() * rand);
            System.out.println("截取指定位置：" + temp);
            processImg(videoPath, temp);
        }
    }

    /**
     * @param videoPath 视频文件路径
     * @param time 视频时长 秒
     * @return
     */
    public static String processImg(String videoPath, int time) {
        File file = new File(videoPath);
        // 记录文件大小
        long size = file.length();

        if (!file.exists()) {
            System.err.println("路径[" + videoPath + "]对应的视频文件不存在!");
            return "视频路径错误";
        }
        List<String> commands = new java.util.ArrayList<String>();
        commands.add(FFMPEG_PATH);
        commands.add("-i");
        commands.add(videoPath);
        commands.add("-y");
        commands.add("-f");
        commands.add("image2");
        commands.add("-ss");
        //这个参数是设置截取视频300秒(5分钟)时的画面
        commands.add(Integer.toString(time));
//        commands.add("100");
//    commands.add("-t");
//    commands.add("2.0");
//    commands.add("-s");
//    commands.add("700x525");
//    commands.add(veido_path.substring(0, veido_path.lastIndexOf(".")).replaceFirst("vedio", "file") + ".jpg");
//    commands.add("D:/"+file.getName().substring(0, file.getName().lastIndexOf(".")) + ".jpg");
//        commands.add("F:\\Studio\\Workspace\\worksapce_for_idea\\self\\frame\\SSMTest\\src\\main\\webapp\\images\\" + file.getName().substring(0, file.getName().lastIndexOf(".")) + ".jpg");
        // 获取时间戳
        Long tempFileName = System.currentTimeMillis();
        String imgPath = "F:\\Studio\\Workspace\\worksapce_for_idea\\self\\frame\\SSMTest\\src\\main\\webapp\\images\\" + tempFileName.toString() + ".jpg";
        commands.add(imgPath);
//    System.out.println("D:/pic/"+file.getName().substring(0, file.getName().lastIndexOf(".")) + ".jpg");
        try {
//      ProcessBuilder builder = new ProcessBuilder();
            ProcessBuilder builder = BuilderUtil.getInstance();
            builder.command(commands);
            builder.start();
            System.out.println("截取成功" + imgPath);
            return tempFileName.toString() + ".jpg";
        } catch (Exception e) {
            e.printStackTrace();
            return "异常";
        }
    }

    //格式:"00:00:10.68"
    private static int getTimelen(String timelen){
        int min=0;
        String strs[] = timelen.split(":");
        if (strs[0].compareTo("0") > 0) {
            min+=Integer.valueOf(strs[0])*60*60;//秒
        }
        if(strs[1].compareTo("0")>0){
            min+=Integer.valueOf(strs[1])*60;
        }
        if(strs[2].compareTo("0")>0){
            min+=Math.round(Float.valueOf(strs[2]));
        }
        return min;
    }

}
