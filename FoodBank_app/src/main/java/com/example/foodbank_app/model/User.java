package com.example.foodbank_app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "DOB")
	private String DOB;
	
	@Column(name = "phoneNum")
	private String phoneNum;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "points")
	private Integer points;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "priorityLeast")
	private String priorityLeast;
	
	@Column(name = "priorityMiddle")
	private String priorityMiddle;
	
	@Column(name = "priorityMost")
	private String priorityMost;
	
	@Column(name = "roleType")
	private String roleType;
	
	@Column(name = "donateDetails")
	private String donateDetails;
	
	@Column(name = "voucherCodes")
	private String voucherCodes;
	
	@Column(name="myDonations")
	private String myDonations;
	
	@Column(name = "reset_password_token")
	private String resetPasswordToken;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(
						name = "userid", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
							name = "roleid", referencedColumnName = "id"))		
	public Set<Role> roles = new HashSet<>();
	
	public User() {
		
	}
	
	public User(String username, String firstName, String lastName, String password, String DOB, String phoneNum, String email,String resetPasswordToken, Set<Role> roles, 
			Integer myPoints, String myAddress, String myDescription, String priorityLeast, String priorityMiddle, String priorityMost, String myRoleType, 
			String myDonateDetails, String myVoucherCodes, String myDonations) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.DOB = DOB;
		this.phoneNum = phoneNum;
		this.email = email;
		this.roles = roles;
		this.points = myPoints;
		this.address = myAddress;
		this.description = myDescription;
		this.priorityLeast = priorityLeast;
		this.priorityMiddle = priorityMiddle;
		this.priorityMost = priorityMost;
		this.roleType = myRoleType;
		this.donateDetails = myDonateDetails;
		this.voucherCodes = myVoucherCodes;
		this.myDonations = myDonations;
		this.resetPasswordToken = resetPasswordToken;
	}
	
	
	public Long getid() {
		return id;
	}
	
	public void setid(Long myid) {
		this.id = myid;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String myUsername) {
		this.username = myUsername;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String myFirstName) {
		this.firstName = myFirstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String myLastName) {
		this.lastName = myLastName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String myPassword) {
		this.password = myPassword;
	}
	
	public String getDOB() {
		return DOB;
	}
	
	public void setDOB(String myDOB) {
		this.DOB = myDOB;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public void setPhoneNum(String myPhoneNum) {
		this.phoneNum = myPhoneNum;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String myEmail) {
		this.email = myEmail;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> string) {
		this.roles = string;
	}
	
	public void addRole(Role role) {
		roles.add(role);
	}
	
	public void removeRole(Role role) {
		roles.remove(role);
	}
	
	public Integer getPoints() {
		return points;
	}
	
	public void setPoints(Integer myPoints) {
		this.points = myPoints;
	}
	
	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String myresetPasswordToken) {
		this.resetPasswordToken = myresetPasswordToken;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String myAddress) {
		this.address = myAddress;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String myDescription) {
		this.description = myDescription;
	}
	
	public String getPriorityLeast() {
		return priorityLeast;
	}
	
	public void setPriorityLeast(String priorityLeast) {
		this.priorityLeast = priorityLeast;
	}
	
	public String getPriorityMiddle() {
		return priorityMiddle;
	}
	
	public void setPriorityMiddle(String priorityMiddle) {
		this.priorityMiddle = priorityMiddle;
	}
	
	public String getPriorityMost() {
		return priorityMost;
	}
	
	public void setPriorityMost(String priorityMost) {
		this.priorityMost = priorityMost;
	}
	
	public String getRoleType() {
		return roleType;
	}
	
	public void setRoleType(String myRoleType) {
		this.roleType = myRoleType;
	}
	
	public String getDonateDetails() {
		return donateDetails;
	}
	
	public void setDonateDetails(String myDonateDetails) {
		this.donateDetails = myDonateDetails;
	}
	
	public String getVoucherCodes() {
		return voucherCodes;
	}
	
	public void setVoucherCodes(String myVoucherCodes) {
		this.voucherCodes = myVoucherCodes;
	}
	
	public String getMyDonations() {
		return myDonations;
	}
	
	public void setMyDonations(String myDonations ) {
		this.myDonations = myDonations;
	}
	
	
	

}
