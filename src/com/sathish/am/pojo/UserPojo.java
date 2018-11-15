package com.sathish.am.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="users")
public class UserPojo {
	private Integer id;
	private String username;
	private String password;
	private Integer count;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="username")
	@NotNull
	@NotEmpty
	@Size(min=4,max=9)
	@Pattern(regexp="^[a-zA-Z]+[a-zA-Z0-9]*$",message="enter in correct format")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name="password")
	@NotNull
	@NotEmpty
	@Size(min=4,max=9)
	@Pattern(regexp="^[a-zA-Z]+[a-zA-Z0-9]*$")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="count")
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "UserPojo [username=" + username + ", password=" + password
				+ "]";
	}
	
	
}
