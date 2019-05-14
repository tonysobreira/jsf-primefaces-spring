package com.jsf.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jsf.model.User;
import com.jsf.service.UserService;

@Service("facade")
public class FacadeImpl implements Facade {

	private UserService userService;

	@Autowired
	public FacadeImpl(@Qualifier("userService") final UserService userService) {
		this.userService = userService;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public void saveUser(User user) {
		this.userService.saveUser(user);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public List<User> listUser() {
		return this.userService.listUser();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public void deleteUser(User user) {
		this.userService.deleteUser(user);
	}

	@Override
	public List<User> getUserListTest() {
		return this.userService.getUserListTest();
	}

}
