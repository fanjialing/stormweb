package org.storm.usercenter.entity;


import java.io.Serializable;

public class UserManagement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6921928952834970320L;
	
	
	
	private Integer id;
	private String userCode;	
	private String userPwd; 
	private String userName;
	private String userNum ;
	private String userPhone; 
	private String userBirthday;
	private String userAddress;
	private String userStatus;
	private String userEmail;
	private String userLoginType;
	private String userType;
	private String userLastLoginIp;
	private String userLastLoginTime;
	private String userOrgNo;
	private String userDescription;
	private String time;
	private String userOrgName;
	
	
	
	
	private String startDate;
	private String endDate;
	private String roles;
	private String isChecked;
	
	public UserManagement(){}
	
	
	public UserManagement(Integer id, String userCode, String userPwd,
			String userName, String userNum, String userPhone,
			String userBirthday, String userAddress, String userStatus,
			String userEmail, String userLoginType, String userType,
			String userLastLoginIp, String userLastLoginTime, String userOrgNo,
			String userDescription, String time,String userOrgName) {
		super();
		this.id = id;
		this.userCode = userCode;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userNum = userNum;
		this.userPhone = userPhone;
		this.userBirthday = userBirthday;
		this.userAddress = userAddress;
		this.userStatus = userStatus;
		this.userEmail = userEmail;
		this.userLoginType = userLoginType;
		this.userType = userType;
		this.userLastLoginIp = userLastLoginIp;
		this.userLastLoginTime = userLastLoginTime;
		this.userOrgNo = userOrgNo;
		this.userDescription = userDescription;
		this.time = time;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserLoginType() {
		return userLoginType;
	}
	public void setUserLoginType(String userLoginType) {
		this.userLoginType = userLoginType;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserLastLoginIp() {
		return userLastLoginIp;
	}
	public void setUserLastLoginIp(String userLastLoginIp) {
		this.userLastLoginIp = userLastLoginIp;
	}
	public String getUserLastLoginTime() {
		return userLastLoginTime;
	}
	public void setUserLastLoginTime(String userLastLoginTime) {
		this.userLastLoginTime = userLastLoginTime;
	}
	public String getUserOrgNo() {
		return userOrgNo;
	}
	public void setUserOrgNo(String userOrgNo) {
		this.userOrgNo = userOrgNo;
	}
	public String getUserDescription() {
		return userDescription;
	}
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getRoles() {
		return roles;
	}


	public void setRoles(String roles) {
		this.roles = roles;
	}


	public String getUserOrgName() {
		return userOrgName;
	}


	public void setUserOrgName(String userOrgName) {
		this.userOrgName = userOrgName;
	}


	public String getIsChecked() {
		return isChecked;
	}


	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}


	
	
	

}
