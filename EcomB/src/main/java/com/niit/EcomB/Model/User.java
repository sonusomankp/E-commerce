package com.niit.EcomB.Model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="User")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="User_name")
	private String Uname;
	
	@Column(name="User_email")
	private String Uemail;
	
	@Column(name="User_mobno")
	private long Umobno;
	
	@Column(name="User_paas")
	private String Upass;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return Uname;
	}

	public void setUname(String uname) {
		Uname = uname;
	}

	public String getUemail() {
		return Uemail;
	}

	public void setUemail(String uemail) {
		Uemail = uemail;
	}

	public long getUmobno() {
		return Umobno;
	}

	public void setUmobno(long umobno) {
		Umobno = umobno;
	}

	public String getUpass() {
		return Upass;
	}

	public void setUpass(String upass) {
		Upass = upass;
	}

	
	
	
}
