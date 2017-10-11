package com.niit.EcomB.Model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Products")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="NAME",nullable=false)
	private String name;
	
	@Column(name="SHORT_DESCRIPTION",nullable=false)
	private String shortDescrption;
	
	@Column(name="PRICE",nullable=false)
	private int price;
	
	@Column(name="STOCK",nullable=false)
	private int stock;
	
	@Column(name="IMAGE")
	private String img;
	
	
   
	@ManyToOne
    @JoinColumn(name="c_id",insertable=true,updatable=true,nullable=false)
    private Category category;
    @ManyToOne
    @JoinColumn(name="s_id",insertable=true,updatable=true,nullable=false)
    private Supplier supplier;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortDescrption() {
		return shortDescrption;
	}
	public void setShortDescrption(String shortDescrption) {
		this.shortDescrption = shortDescrption;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	 public String getImg() {
			return img;
		}
		public void setImg(String img) {
			this.img = img;
		}
    
}

	


