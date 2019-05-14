package com.jsf.bean;

import java.io.Serializable;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;

import org.h2.tools.RunScript;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.jsf.model.User;

@ManagedBean
@SessionScoped
public class UserBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = -54255255545386196L;
	private User user;
	
	public UserBean() {
		user = new User();
		
//		//Test
//		String url = "jdbc:h2:~/test";
//		String username = "sa";
//		String password = "";
//		
//		try {
//			Connection connect = DriverManager.getConnection(url, username, password);
//			
//			StringBuilder sb = new StringBuilder();
//			
////			sb = new StringBuilder("DROP TABLE Users;");
////			RunScript.execute(connect, new StringReader(sb.toString()));
//			
////			sb = new StringBuilder(" CREATE TABLE USERS ( \r\n" + 
////					"  id int(11) unsigned NOT NULL AUTO_INCREMENT, \r\n" + 
////					"  username varchar(20) NOT NULL DEFAULT '', \r\n" + 
////					"  password varchar(20) NOT NULL DEFAULT '', \r\n" + 
////					"  PRIMARY KEY (`id`) \r\n" + 
////					") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8; ");
//			
//			sb = new StringBuilder(" CREATE TABLE USERS ( " + 
//					" id int(11) unsigned not null primary key , " + 
//					" username varchar(50) NOT NULL , " + 
//					" password varchar(50) NOT NULL , " + 
//					" enabled boolean not null " + 
//					" ); ");
//			
//			RunScript.execute(connect, new StringReader(sb.toString()));
//			
//			//
//			
//			sb = new StringBuilder(" CREATE TABLE AUTHORITIES ( " + 
//					" id int(11) unsigned not null primary key , " + 
//					" username varchar(50) NOT NULL , " + 
//					" authority  varchar(50) NOT NULL , " + 
//					" constraint fk_authorities_users foreign key(username) references users(username) " + 
//					" ); ");
//			
//			RunScript.execute(connect, new StringReader(sb.toString()));
//			
//			//
//			
//			sb = new StringBuilder(" create unique index ix_auth_username on authorities (username,authority); ");
//			
//			RunScript.execute(connect, new StringReader(sb.toString()));
//			
//		} catch (SQLException ex) {
//			System.out.println("in exec");
//			System.out.println(ex.getMessage());
//		}
		
	}

	public void test() {
		for (User user : getFacade().getUserListTest()) {
			System.out.println(user);
		}
	}
	
	public List<User> listUser() {
		return getFacade().listUser();
	}
	
	public void saveUser() {
		getFacade().saveUser(user);
		user = new User();
	}
	
	public void deleteUser(User user) {
		getFacade().deleteUser(user);
	}
	
	public List<User> getUserListTest() {
		return getFacade().getUserListTest();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getUsername() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth != null) {
			return SecurityContextHolder.getContext().getAuthentication().getName();
		}
		
		return "";
	}

}
