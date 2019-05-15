package com.jsf.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jsf.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	//private static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

//	@Autowired
//	private SessionFactory sessionFactory;
//
//	public void setSessionFactory(SessionFactory sf) {
//		this.sessionFactory = sf;
//	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public void saveUser(User user) {
//		Session session = this.sessionFactory.getCurrentSession();
//		session.persist(user);
//		logger.info("User saved successfully, User Details: " + user);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public List<User> listUser() {
//		Session session = this.sessionFactory.getCurrentSession();
//
//		List<User> userList = session.createQuery("from User").list();
//
//		for (User user : userList) {
//			logger.info("User List:: " + user);
//		}
//
//		return userList;
		return null;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public void deleteUser(User user) {
//		Session session = this.sessionFactory.getCurrentSession();
//		session.delete(user);
//		logger.info("User removed successfully, User Details: " + user);
	}
	
	@Override
	public List<User> getUserListTest() {

		List<User> users = new ArrayList<User>();
		User user;
		
		for (int i = 0; i < 5; i++) {
			user = new User();
			user.setId(i);
			user.setUsername("name " + i);
			user.setPassword("password " + i);
			user.setEnabled(true);
			users.add(user);
		}

		for (User u : users) {
			System.out.println(u);
		}

		return users;
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}