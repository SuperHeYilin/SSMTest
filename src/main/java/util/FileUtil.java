package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件操作工具类
 */
public class FileUtil {
    public static void main(String[] args) {

    }

    /**
     * 打开某个文件或者文件夹
     * @param path 文件路径
     */
    public static void openFile(String path) {
        List<String> commands = new ArrayList<String>();
        commands.add("cmd");
        commands.add("/c");
        commands.add("start");
        commands.add(" ");
        commands.add(path);

        ProcessBuilder builder = new ProcessBuilder();
        builder.command(commands);
        try {
            builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
