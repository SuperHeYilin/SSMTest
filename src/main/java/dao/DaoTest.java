package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.registry.infomodel.User;

/**
 * @author super
 * @Description: ${TODO}
 * @date 2018/3/21 10:05
 */
// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class DaoTest {

    @Autowired
    private VideoInfoDao dao;

    @Test
    public void testSelectUser() throws Exception {
//        System.out.println(dao.listVideoInfo().size());
        System.out.println(System.currentTimeMillis());
    }
}
