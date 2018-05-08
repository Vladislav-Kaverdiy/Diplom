package diploma.com.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String fullName;
	private String email;
	private String login;
	private String password;
	private Integer roleId;
	private Date registerDate;
	private boolean blocked;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Date getRegisterDate() {
		return (Date)registerDate.clone();
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = (Date)registerDate.clone();
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName + ", email="
				+ email + ", login=" + login + ", password=" + password
				+ ", roleId=" + roleId + ", registerDate=" + registerDate
				+ ", blocked=" + blocked + "]";
	}


}
