package util;

import ch.qos.logback.core.db.dialect.DBUtil;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ListFileUtil {
    private static int count = 0;
    private static List<String> list = new ArrayList<String>();

    public static void main(String[] args) {

//    listFile("D:\\下载\\BaiduNetdiskDownload\\");
        System.out.println(listFiles("D:\\下载\\BaiduNetdiskDownload\\").size());
//    System.out.println("文件" + count);

    }

    /**
     * 返回所有文件
     *
     * @return
     */
    public static List<String> listFiles(String path) {
        listFile(path);
        return list;
    }

    private static void listFile(String path) {

        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files == null) {
                return;
            }
            if (files.length == 0) {
                System.out.println("文件夹是空的!");
            } else {
                for (File file2 : files) {
                    // 判断是否问文件夹
                    if (file2.isDirectory()) {
                        System.out.println("文件夹:" + file2.getAbsolutePath());
                        listFile(file2.getAbsolutePath());
                    } else {
//            System.out.println("文件:" + file2.getAbsolutePath());
                        String fileName = file2.getName();
                        if (fileName.endsWith("avi") || fileName.endsWith("mp4") || fileName.endsWith("wmv") || fileName.endsWith("FLV")) {
//              VideoPicUtil.processImg(file2.getAbsolutePath(), "D:/ffmpeg/bin/ffmpeg.exe");
                            System.out.println("文件夹:" + file2.getAbsolutePath());
                            System.out.println("文件名:" + file2.getName());
                            System.out.println("文件大小MB:" + file2.length() / 1024 / 1024);
                            System.out.println("文件大小b:" + file2.length());
                            if (file2.length() / 1024 / 1024 < 10) {
                                return;
                            }
                            list.add(file2.getAbsolutePath());
//               保存文件
//              try {
//                PreparedStatement preparedStatement = connection.prepareStatement(sql);
//                preparedStatement.setString(1, file2.getName());
//                preparedStatement.setString(2, file2.getAbsolutePath());
//                preparedStatement.setDouble(3, file2.length()/1024/1024);
//                preparedStatement.setLong(4, file2.length());
//                preparedStatement.execute();
//              } catch (SQLException e) {
//                e.printStackTrace();
//              }


                        }
                        count++;
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }

}
