package service.impl;

import dao.VideoInfoDao;
import model.VideoInfo;
import org.springframework.stereotype.Service;
import service.VideoService;
import util.ListFileUtil;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * @author super
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/219:56
 */

@Service("videoInfoService")
public class VideoInfoServiceImpl implements VideoService {

    @Resource
    private VideoInfoDao dao;

    @Override
    public List<VideoInfo> listVideoInfo() {
        return this.dao.listVideoInfo();
    }

    @Override
    public VideoInfo getVideoInfoById(int id) {
        return this.dao.getVideoInfoById(id);
    }

    /**
     * 扫描盘符 添加到数据库
     * @param path
     * @return
     */
    @Override
    public int addVideoInfo(String path, String uPath) {
        List<String> list = ListFileUtil.listFiles(path);
        for (String f :
                list) {
            File file = new File(f);
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setFileName(file.getName());
            videoInfo.setPath(file.getAbsolutePath());
            videoInfo.setSizeMb(file.length() / 1024 / 1024);
            videoInfo.setSizeB(file.length());
            videoInfo.setuName(uPath);
            dao.addVideoInfo(videoInfo);
        }
        return list.size();
    }
}
