package com.jsf.facade;

import java.util.List;

import com.jsf.model.User;

public interface Facade {

	public void saveUser(User user);

	public List<User> listUser();

	public void deleteUser(User user);
	
	public List<User> getUserListTest();

}
