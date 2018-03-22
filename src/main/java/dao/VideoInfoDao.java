package dao;

import model.VideoInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoInfoDao {
    /**
     * 罗列所有文件
     * @return
     */
    List<VideoInfo> listVideoInfo();

    /**
     * 通过id查找
     * @param id
     * @return
     */
    VideoInfo getVideoInfoById(int id);


}
