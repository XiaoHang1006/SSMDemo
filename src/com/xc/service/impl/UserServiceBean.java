package com.xc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xc.dao.UserDao;
import com.xc.model.User;
import com.xc.service.UserService;

@Service("userService")
public class UserServiceBean implements UserService {

	@Autowired
	private UserDao userdao;

	@Override
	public void add(User user) throws Exception {
		userdao.addUser(user);
	}

	@Override
	public void delete(User user) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserById(int id) throws Exception {
		User user = new User();
		user.setId(id);
		return userdao.getUser(user);
	}

	@Override
	public List<User> listUserByAge(int age) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
