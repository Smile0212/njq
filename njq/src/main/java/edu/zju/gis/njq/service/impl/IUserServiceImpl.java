package edu.zju.gis.njq.service.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import edu.zju.gis.njq.dao.UserMapper;
import edu.zju.gis.njq.entity.User;
import edu.zju.gis.njq.service.IUserService;

@Service("userService")
public class IUserServiceImpl implements IUserService {
	@Resource
	private UserMapper userMapper;

	public User getUserById(int userId) {
		return this.userMapper.selectByPrimaryKey(userId);
	}

	public List<User> getAllUsers(int offset, int rows) {
		return this.userMapper.selectAllUsers(offset, rows);
	}

	public int getCountUsers() {
		return this.userMapper.selectCountUsers();
	}

}
