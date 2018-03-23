package service.impl;

import dao.AvInfoDao;
import model.AvInfo;
import org.springframework.stereotype.Service;
import service.AvInfoService;

import javax.annotation.Resource;
import java.util.List;

@Service("avInfoService")
public class AvInfoServiceImpl implements AvInfoService {

    @Resource
    private AvInfoDao avInfoDao;

    public List<AvInfo> listAvInfo() {
        return avInfoDao.listAvInfo();
    }

    public AvInfo getById(int id) {
        return avInfoDao.getById(id);
    }
}
