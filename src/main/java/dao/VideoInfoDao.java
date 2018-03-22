package dao;

import model.VideoInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoInfoDao {
    List<VideoInfo> listVideoInfo();
    VideoInfo getVideoInfoById(int id);
}
