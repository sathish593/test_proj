package com.sathish.am.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="audit")
public class AuditPojo {
	private int id;
	private String property;
	private String per;
	private String cur;
	private Date time;
	private String ip;
	private String entity;
	private UserPojo pojo;
	@Id
	@Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="property")
	public String getProperty() {
		return property;
	}
	
	public void setProperty(String property) {
		this.property = property;
	}
	@Column(name="per")
	public String getPer() {
		return per;
	}
	public void setPer(String per) {
		this.per = per;
	}
	@Column(name="cur")
	public String getCur() {
		return cur;
	}
	public void setCur(String cur) {
		this.cur = cur;
	}
	@Column(name="time")
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Column(name="ip")
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Column(name="entity")
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	@ManyToOne
	@JoinColumn(name="userid")
	public UserPojo getPojo() {
		return pojo;
	}

	public void setPojo(UserPojo pojo) {
		this.pojo = pojo;
	}
	
	

}
