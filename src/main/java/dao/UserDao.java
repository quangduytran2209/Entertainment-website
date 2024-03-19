package dao;

import java.util.List;

import Entity.User;

public interface UserDao {
	User findByid(Integer id);
	User findByEmail(String Email);
	User findByUsername(String username);
	User findByUsernameAndPassword(String username, String password);
	List<User> findAll();
	List<User> findAll(Integer pageNumber, Integer pageSize);
	void Create(User entity);
	void Delete(User entity);
	User Update(User entity);
}
