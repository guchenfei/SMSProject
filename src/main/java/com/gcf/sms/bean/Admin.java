package com.gcf.sms.bean;

public class Admin {
	private Integer adminId;

	private String username;

	private String userpass;

	private Integer usersex;

	private String userbirthday;

	private String userpnum;

	private String useraddress;

	private String useremail;

	private Integer usertype;

	private Integer cpyId;

	//希望查询用户的时候所属公司也能查出来
	private Company company;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass == null ? null : userpass.trim();
	}

	public Integer getUsersex() {
		return usersex;
	}

	public void setUsersex(Integer usersex) {
		this.usersex = usersex;
	}

	public String getUserbirthday() {
		return userbirthday;
	}

	public void setUserbirthday(String userbirthday) {
		this.userbirthday = userbirthday == null ? null : userbirthday.trim();
	}

	public String getUserpnum() {
		return userpnum;
	}

	public void setUserpnum(String userpnum) {
		this.userpnum = userpnum == null ? null : userpnum.trim();
	}

	public String getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress == null ? null : useraddress.trim();
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail == null ? null : useremail.trim();
	}

	public Integer getUsertype() {
		return usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

	public Integer getCpyId() {
		return cpyId;
	}

	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}

}