package com.xc.service;

import java.util.List;

import com.xc.model.User;

public interface UserService {
    public void add(User user) throws Exception;
    public void delete(User user) throws Exception;
    public User getUserById(int id) throws Exception;
    public List<User> listUserByAge(int age) throws Exception;
}
