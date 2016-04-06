package edu.zju.gis.njq.service;

import java.util.List;

import edu.zju.gis.njq.entity.User;

public interface IUserService {
	public User getUserById(int userId);

	public List<User> getAllUsers(int offset, int rows);

	public int getCountUsers();

}
