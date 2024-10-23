package com.PBL4.test.entity;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Account")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) 
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
public  class Account {
    @Id    
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(nullable = false)

    private String password;

    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String address;
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String cid; // citizen identification card

    // Getters and setters
    // ...

    // Constructors
    public Account() {}

    public Account(String username, String email, String password, String firstName, String lastName,
                   LocalDate dob, String address, String phoneNumber, String cid) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.cid = cid;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", cid=" + cid + "]";
	}

    // toString method
    // ...
}