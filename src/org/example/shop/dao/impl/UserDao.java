package org.example.shop.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.shop.dao.IUserDao;
import org.example.shop.pojo.User;
import org.example.shop.util.DBUtil;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDao implements IUserDao {

	public void add(User user) {
		// TODO Auto-generated method stub
		SqlSession session = DBUtil.createSession();
		if(findUserByName(user.getUsername())==null){
			session.insert(User.class.getName()+".add", user);
			System.out.println("Ìí¼Ó³É¹¦£¡£¡");
			session.commit();	
		}
		DBUtil.closeSession(session);
	}

	public User findUserByName(String username) {
		// TODO Auto-generated method stub
		SqlSession session = DBUtil.createSession();
		User user = session.selectOne(User.class.getName()+".find_name",username);
		DBUtil.closeSession(session);
		return user;
	}
	

	
	public User validate(User user) {
		// TODO Auto-generated method stub
		User u = findUserByName(user.getUsername());
		if(u!=null){
			if(user.getPassword().equals(u.getPassword())){
				return u;
			}
		}
		return null;
	}

	public User findUserBySerial(String serial) {
		// TODO Auto-generated method stub
		SqlSession session = DBUtil.createSession();
		User user = session.selectOne(User.class.getName()+".find_serial",serial);
		DBUtil.closeSession(session);
		return user;
	}
	
	public void changeStatus(User user){
		SqlSession session = DBUtil.createSession();
		if(user!=null){
			session.update(User.class.getName()+".update_status", user.getStatus());
		}
		
		DBUtil.closeSession(session);
	}
	 
}
