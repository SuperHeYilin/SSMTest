package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

}
