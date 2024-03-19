package Service;

import java.util.List;

import Entity.User;

public interface UserService {
	User findByid(Integer id);
	User findByEmail(String Email);
	User findByUsername(String username);
	User login(String username, String password);
	User resetPassword(String email);
	List<User> findAll();
	List<User> findAll(Integer pageNumber, Integer pageSize);
	User Create(String username, String password , String email );
	User Update(User user);
	User Delete(String username);
}
