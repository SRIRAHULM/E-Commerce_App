package javaDemo.E_com;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "name" }))
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private Double price;

	@Column(name = "colour")
	private String colour;

	@Column(name = "Brand")
	private String Brand;

	@Column(name = "quantity")
	private Integer Quantity;

	@Column(name = "rating")
	private Double Rating;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_type_id")
	private ProductType productType;

	public Product() {

	}

	public Product(String name, Double price, String colour, String brand, Integer quantity, ProductType productType) {
		super();
		this.name = name;
		this.price = price;
		this.colour = colour;
		Brand = brand;
		Quantity = quantity;
		this.productType = productType;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public Double getRating() {
		return Rating;
	}

	public void setRating(Double Rating) {
		this.Rating = Rating;
	}

}
