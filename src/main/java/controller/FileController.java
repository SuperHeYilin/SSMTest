package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import util.VideoPicUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author super
 * @date 2018/3/23 13:28
 */

@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/upload")
    @ResponseBody
    public String test(MultipartFile file, HttpServletRequest request) throws IOException {
        // 图片保存路径
        String path = request.getSession().getServletContext().getRealPath("/images");
        System.out.println("图片保存路径>>" + path);

        String fileName = file.getOriginalFilename();
        System.out.println("文件名称>>" + fileName);
        Long tempFileName = System.currentTimeMillis();
        // 拼接时间戳和文件名
        String temp = tempFileName.toString() + fileName;
        File dir = new File(path, temp);

        System.out.println("dir.exists()>>" + dir.exists());
        if (!dir.exists()) {
            dir.mkdirs();
        }
        System.out.println("dir.exists()>>" + dir.exists());
//      MultipartFile自带的解析方法
        file.transferTo(dir);

        return "ok";
    }

    @RequestMapping("/test")
    public String test1() {
        VideoPicUtil.processImgNum("D:/下载/迅雷下载/马戏Z王.720p.HD韩版中英双字[最新电影www.6vhao.tv].mp4", 1);
        return "hello";
    }
}
