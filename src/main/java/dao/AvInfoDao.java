package dao;

import model.AvInfo;

import java.util.List;

public interface AvInfoDao {
    /**
     * 罗列所有信息
     * @return
     */
    List<AvInfo> listAvInfo();

    /**
     * 根据id查找
     * @param id
     * @return
     */
    AvInfo getById(int id);
}
