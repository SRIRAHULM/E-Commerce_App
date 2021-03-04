package javaDemo.E_com;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(
        uniqueConstraints=
            @UniqueConstraint(columnNames={"user_name"})
    )

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobile_no")
	private String mobileNo;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	private String Role;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "user" )
	
	private List<Address> listOfAddress = new ArrayList<Address>();
	
	User(){}
	
	public User(String name, String email, String mobileNo, String userName, String password, String role) {
		super();
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.userName = userName;
		this.password = password;
		Role = role;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(List<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	
}
