package javaDemo.E_com;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PurchaseOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "purchase_date")
	private String purhcaseDate;
	
	@Column(name = "total_price")
	private Double totalPrice;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	
	@OneToMany(mappedBy = "purchaseOrder")
	private List<PurchaseOrderItem> list = new ArrayList<PurchaseOrderItem>();
	
	public PurchaseOrder() {}
	
	public PurchaseOrder(String purhcaseDate, Double totalPrice, User user, Address address) {
		
		super();
		this.purhcaseDate = purhcaseDate;
		this.totalPrice = totalPrice;
		this.user = user;
		this.address = address;
	}

	public List<PurchaseOrderItem> getList() {
		return list;
	}

	public void setList(List<PurchaseOrderItem> list) {
		this.list = list;
	}
	
	public String getPurhcaseDate() {
		return purhcaseDate;
	}

	public void setPurhcaseDate(String purhcaseDate) {
		this.purhcaseDate = purhcaseDate;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}
