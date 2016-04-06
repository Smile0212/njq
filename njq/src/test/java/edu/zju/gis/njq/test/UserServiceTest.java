package edu.zju.gis.njq.test;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.zju.gis.njq.entity.User;
import edu.zju.gis.njq.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class UserServiceTest {
	private static Logger logger = Logger.getLogger(UserServiceTest.class);
	@Resource
	private IUserService userService = null;

	@Test
	public void test1() {
		User user = userService.getUserById(1);
		logger.info("姓名：" + user.getName() + " 密码：" + user.getPassword());
	}

	@Test
	public void testSelectAllUsers() {
		List<User> userList = userService.getAllUsers(0,5);
		logger.info("姓名：" + userList.get(0).getName() + " 密码：" + userList.get(0).getPassword());
	}
}
