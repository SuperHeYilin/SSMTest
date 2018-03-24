package service;

import model.VideoInfo;

import java.util.List;

public interface VideoService {

    List<VideoInfo> listVideoInfo();

    VideoInfo getVideoInfoById(int id);

    /**
     * 扫描路径 添加信息到数据库
     *
     * @return
     */
    int addVideoInfo(String path, String diskName);
}
