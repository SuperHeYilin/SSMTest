package service.impl;

import dao.VideoInfoDao;
import model.VideoInfo;
import org.springframework.stereotype.Service;
import service.VideoService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author super
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/219:56
 */

@Service("videoInfoService")
public class VideoInfoImpl implements VideoService {

    @Resource
    private VideoInfoDao dao;

    public List<VideoInfo> listVideoInfo() {
        return this.dao.listVideoInfo();
    }

    public VideoInfo getVideoInfoById(int id) {
        return this.dao.getVideoInfoById(id);
    }
}
