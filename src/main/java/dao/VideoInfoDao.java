package dao;

import model.VideoInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoInfoDao {
    /**
     * 罗列所有文件
     *
     * @return
     */
    List<VideoInfo> listVideoInfo();

    /**
     * 通过id查找
     *
     * @param id
     * @return
     */
    VideoInfo getVideoInfoById(int id);

    /**
     * 扫描路径 添加信息到数据库
     *
     * @return
     */
    int addVideoInfo(VideoInfo videoInfo);

    /**
     * 更新视频截图
     * @param videoInfo
     * @return
     */
    int updateVideoImg(VideoInfo videoInfo);


}
