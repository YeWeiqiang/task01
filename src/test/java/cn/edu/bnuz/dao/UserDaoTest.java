package cn.edu.bnuz.dao;

import cn.edu.bnuz.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/spring-dao.xml")
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testQueryUser() {
        List<Date> dateList = userDao.queryUserLoginList(1L, 2, 3);
        for (Date date :
                dateList) {
            System.out.println(date);
        }
        assertEquals(8, dateList.size());
    }

    @Test
    public void testQueryUserById() {
        String password = userDao.queryUserByName("学生甲");
        assertEquals("123456", password);
    }

    @Test
    public void testUpdatePassword() {
        int effectedNum = userDao.updatePassword("学生甲", "12345");
        assertEquals(1, effectedNum);
    }

}
