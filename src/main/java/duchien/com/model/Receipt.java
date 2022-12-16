package duchien.com.model;

import java.io.Serializable;
import java.sql.Date;

public class Receipt implements Serializable {
	private int id;
	private String address;
	private String sdt;
	private User buyer;
	private Cart cart;
	private int saleOf;
	
	public Receipt() {
		super();
	}
	
	public Receipt(int id, String address, String sdt, User buyer, Cart cart, int saleOf) {
		super();
		this.id = id;
		this.address = address;
		this.sdt = sdt;
		this.buyer = buyer;
		this.cart = cart;
		this.saleOf = saleOf;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public User getBuyer() {
		return buyer;
	}
	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public int getSaleOf() {
		return saleOf;
	}
	public void setSaleOf(int saleOf) {
		this.saleOf = saleOf;
	}
	
	
}
