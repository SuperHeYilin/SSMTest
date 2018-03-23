package service;

import model.VideoInfo;

import java.util.List;

public interface VideoService {
    List<VideoInfo> listVideoInfo();

    VideoInfo getVideoInfoById(int id);
}
