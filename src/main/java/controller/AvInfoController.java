package controller;

import model.AvInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AvInfoService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/av")
public class AvInfoController {

    @Resource
    private AvInfoService avInfoService;

    @RequestMapping(value = "/info")
    @ResponseBody
    public Object select(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") int id) {
        System.out.println("id: " + id);
        System.out.println(avInfoService.listAvInfo().get(0));
        int score = avInfoService.listAvInfo().get(0).getScore();
        return score;
    }

}
