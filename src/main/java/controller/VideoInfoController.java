package controller;

import dao.VideoInfoDao;
import model.VideoInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.VideoService;
import util.VideoPicUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/video")
public class VideoInfoController {

    @Resource
    private VideoService videoService;
    @Resource
    private VideoInfoDao videoInfoDao;

    /**
     * 罗列所有文件
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object select(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("list: ");
        List<VideoInfo> list = videoService.listVideoInfo();
        return list;
    }

    @RequestMapping(value = "/json", method = RequestMethod.POST)
    @ResponseBody
    public Object json(@RequestParam("id") int id) {
        System.out.println("json");
        VideoInfo videoInfo = videoService.getVideoInfoById(id);
        return videoInfo;
    }

    @RequestMapping(value = "/init", method = RequestMethod.POST)
    @ResponseBody
    public Object addVideoInfo(@RequestParam("path") String path, @RequestParam("diskName") String diskName) {
        System.out.println("init");
        return videoService.addVideoInfo(path, diskName);
    }

    /**
     * 根据id 为某个视频生成图片
     * @param id
     * @return
     */
    @RequestMapping(value = "/addimg", method = RequestMethod.POST)
    @ResponseBody
    public Object addVideoImg(@RequestParam("id") int id) {
        VideoInfo videoInfo = videoService.getVideoInfoById(id);
        // 生成图片 100秒处
        String imgPath = VideoPicUtil.processImg(videoInfo.getPath(), 100);
        videoInfo.setImgPath(imgPath);
        videoInfoDao.updateVideoImg(videoInfo);
        System.out.println(imgPath);
        return 1;
    }

    /**
     * 生成随机两条视频数据
     * @return
     */
    @RequestMapping(value = "/random", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getRandomVideo() {
        int count, randA, randB;
        List<VideoInfo> list = videoService.listVideoInfo();
        // 记录总数
        count = list.size();

        randA = (int)(Math.random() * count);

        do {
            randB = (int)(Math.random() * count);
        } while (randA == randB);

        Map<String, Object> map = new HashMap<String, Object>(2);

        map.put("randA", list.get(randA));
        map.put("randB", list.get(randB));

        return map;
    }

}
