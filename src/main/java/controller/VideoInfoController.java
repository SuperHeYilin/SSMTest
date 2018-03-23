package controller;

import model.VideoInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.VideoService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/video")
public class VideoInfoController {

    @Resource
    private VideoService videoService;

    @RequestMapping("/get")
    public String select(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") int id) {
        System.out.println("id: " + id);
        System.out.println(videoService.listVideoInfo().get(3));
        request.setAttribute("name", videoService.listVideoInfo().get(3).getFileName());
        return "hello";
    }

    @RequestMapping(value = "/json", method = RequestMethod.POST)
    @ResponseBody
    public Object json(@RequestParam("id") int id) {
        System.out.println("json");
        VideoInfo videoInfo = videoService.getVideoInfoById(id);
        return videoInfo;
    }

    @RequestMapping(value = "/init/{path}", method = RequestMethod.GET)
    @ResponseBody
    public Object addVideoInfo(@PathVariable("path") String path) {
        System.out.println("init");
        return videoService.addVideoInfo(path);
    }

//    @RequestMapping(value = "/json", method = RequestMethod.POST)
//    @ResponseBody
//    public Object json(@RequestBody Map<String, Object> map) {
//        System.out.println("json");
//        VideoInfo videoInfo = videoService.getVideoInfoById(Integer.parseInt(map.get("id").toString()));
//        return videoInfo;
//    }

}
