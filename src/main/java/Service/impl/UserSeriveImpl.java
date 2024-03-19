package Service.impl;

import java.util.List;

import Entity.User;
import Service.UserService;
import dao.UserDao;
import dao.impl.UserDaoImpl;

public class UserSeriveImpl implements UserService {

	private UserDao dao;
	
	public UserSeriveImpl () {
		dao = new UserDaoImpl();
	}
	
	@Override
	public User findByid(Integer id) {
		return dao.findByid(id);
	}

	@Override
	public User findByEmail(String Email) {
		return dao.findByEmail(Email);
	}

	@Override
	public User findByUsername(String username) {
		return dao.findByUsername(username);
	}

	@Override
	public User login(String username, String password) {
		return dao.findByUsernameAndPassword(username, password);
	}

	@Override
	public User resetPassword(String email) {
		User existUser = findByEmail(email);
		if(existUser !=  null) {
			String newPass = String.valueOf((int) (Math.random() * ((9999 - 1000)+1)) + 100);
			existUser.setPassword(newPass);
			return dao.Update(existUser);
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Override
	public List<User> findAll(Integer pageNumber, Integer pageSize) {
		return dao.findAll(pageNumber, pageSize);
	}

	@Override
	public User Create(String username, String password, String email) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setIsAdmin(Boolean.FALSE);
		user.setIsActive(Boolean.TRUE);
		dao.Create(user);
		return user;
	}

	@Override
	public User Update(User user) {
		return dao.Update(user);
	}

	@Override
	public User Delete(String username) {
		User user = dao.findByUsername(username);
		user.setIsActive(Boolean.FALSE);
		return Update(user);
	}

	
}
