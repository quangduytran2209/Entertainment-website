package dao.impl;

import java.util.List;

import Entity.User;
import dao.AbstractDao;
import dao.UserDao;

public class UserDaoImpl extends  AbstractDao<User> implements UserDao{

	@Override
	public User findByid(Integer id) {
		return super.findById(User.class, id);
	}

	@Override
	public User findByEmail(String Email) {
		String sql = "Select o From User o Where o.email = ?0";
		return super.findOne(User.class, sql,Email);
	}

	@Override
	public User findByUsername(String username) {
		String sql =  "SELECT o FROM User o WHERE o.username =?0";
		return super.findOne(User.class, sql, username);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		String sql = "SELECT o FROM User o WHERE o.username = ?0 AND o.password = ?1";
		return super.findOne(User.class, sql, username,password);
	}

	@Override
	public List<User> findAll() {
		return super.findAll(User.class, true);
	}

	@Override
	public List<User> findAll(Integer pageNumber, Integer pageSize) {
		return super.findAll(User.class, false, pageNumber, pageSize);
	}

	@Override
	public void Create(User entity) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void Delete(User entity) {
		// TODO Auto-generated method stub
		return ;
	}

	@Override
	public User Update(User entity) {
		// TODO Auto-generated method stub
		return entity;
	}
}
