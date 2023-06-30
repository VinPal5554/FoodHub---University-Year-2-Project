package com.example.foodbank_app.web.dto;

public class BusinessRegistrationDto {
	
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private String DOB;
	private String phoneNum;
	private String email;
	private Integer points;
	private String address;
	private String description;
	private String priorityLeast;
	private String priorityMiddle;
	private String priorityMost;
	private String roleType;
	private String donateDetails;
	private String voucherCodes;
	private String myDonations;
	
	public BusinessRegistrationDto() {
		
	}
	
	public BusinessRegistrationDto(String username, String firstName, String lastName, String password, String DOB, String phoneNum, 
			String email, Integer points, String address, String description, String priorityLeast, String priorityMiddle,
			String priorityMost, String roleType, String donateDetails, String voucherCodes, String myDonations) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.DOB = DOB;
		this.phoneNum = phoneNum;
		this.email = email;
		this.points = points;
		this.address = address;
		this.description = description;
		this.priorityLeast = priorityLeast;
		this.priorityMiddle = priorityMiddle;
		this.priorityMost = priorityMost;
		this.roleType = roleType;
		this.donateDetails = donateDetails;
		this.voucherCodes = voucherCodes;
		this.myDonations = myDonations;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String myUserName) {
		this.username = myUserName;
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
	
	public Integer getPoints() {
		return points;
	}
	
	public void setPoints(Integer myPoints) {
		this.points = myPoints;
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
	
	public void setWebsite(String myRoleType) {
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
	
	public void setMyDonations(String myDonations) {
		this.myDonations = myDonations;
	}

}
