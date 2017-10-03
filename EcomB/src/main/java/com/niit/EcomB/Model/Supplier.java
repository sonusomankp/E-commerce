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

@Entity
@Component
@Table(name="Supplier")
public class Supplier implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int s_id;
	
	@Column(name="Sname")
	private String Sname;
	
	@Column(name="Saddr")
	private String Saddr;
	
	 @OneToMany(targetEntity=Product.class,mappedBy="supplier",cascade=CascadeType.ALL)
	    private Set<Product> product;


	

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	public int getId() {
		return s_id;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public void setId(int id) {
		this.s_id = id;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public String getSaddr() {
		return Saddr;
	}

	public void setSaddr(String saddr) {
		Saddr = saddr;
	}
	
	

}
