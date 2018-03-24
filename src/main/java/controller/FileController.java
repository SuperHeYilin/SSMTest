package controller;

import model.VideoInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.VideoService;
import util.FileUtil;
import util.VideoPicUtil;

import javax.annotation.Resource;
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

    @Resource
    private VideoService videoService;

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

    /**
     * 通过id打开某个文件
     * @param id
     */
    @RequestMapping(value = "/play", method = RequestMethod.POST)
    @ResponseBody
    public Object play(@RequestParam("id") int id) {
        VideoInfo videoInfo = videoService.getVideoInfoById(id);
        // 获取文件绝对路径
        String path = videoInfo.getPath();
        FileUtil.openFile(path);
        return 1;
    }
}
