package sto.spb.auth.basic.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="TBL_USER")
public class Users implements Serializable{

	private static final long serialVersionUID = 4588601253930246761L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="usr_name")
	private String userName;
	@Column(name = "usr_password")
	private String userPassword;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}