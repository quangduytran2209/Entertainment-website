package Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users" )
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	Integer id;
	@Column(name="username")
	String username;
	@Column(name="password")
	String password;
	@Column(name="email")
	String email;
	@Column(name="isAdmin")
	Boolean isAdmin;
	@Column(name="isActive")
	Boolean isActive;
	
	@OneToMany(mappedBy = "user")
	List<History> history;
	public User() {
		super();
	}
	public User(String username, String password, String email, Boolean idAdmin, Boolean isActive) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.isAdmin = idAdmin;
		this.isActive = isActive;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean idAdmin) {
		this.isAdmin = idAdmin;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
	
}
