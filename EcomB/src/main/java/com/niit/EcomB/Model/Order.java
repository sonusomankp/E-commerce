package com.niit.EcomB.Model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@SuppressWarnings("unused")

@Entity
@Component
@Table(name="Orders")

public class Order implements Serializable  {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int oid;
		

		@Column(name = "username", nullable = false) 
		private String username;

	    @Column(name = "address", nullable = false) 
	    private String address;

	    @Column(name = "email", nullable = false) 
	    private String email;
	    
	    @Column(name = "mobno", nullable = false) 
	    private long mobno;
	    
	    @Column(name = "totalprice", nullable = false) 
	    private int totalprice;

		public int getOid() {
			return oid;
		}

		public void setOid(int oid) {
			this.oid = oid;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public long getMobno() {
			return mobno;
		}

		public void setMobno(long mobno) {
			this.mobno = mobno;
		}

		public int getTotalprice() {
			return totalprice;
		}

		public void setTotalprice(int totalprice) {
			this.totalprice = totalprice;
		}
	    

}
