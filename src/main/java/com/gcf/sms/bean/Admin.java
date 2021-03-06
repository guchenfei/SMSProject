package com.gcf.sms.bean;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class Admin {
	private Integer adminId;
    //"\\u"是Unicode编码
	@Pattern(regexp = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})", message = "姓名必须是2-5位中文或者6-16位英文和数字等组合")
	private String username;
	
	@Pattern(regexp = "(^[a-zA-Z0-9_-]{6,18}$)", message = "密码必须为6-18位的字母数字下划线组合")
	private String userpass;

	private Integer usersex;
    @NotEmpty(message="生日不能为空！")
	private String userbirthday;
	
	@Pattern(regexp = "(^[1][3,4,5,7,8][0-9]{9}$)", message = "请输入格式正确的11位手机号")
	private String userpnum;
	
	@NotEmpty(message="地址不能为空！")
	private String useraddress;
	
	@Pattern(regexp = "(^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$)", message = "请按正确的邮箱格式输入")
	private String useremail;

	private Integer usertype;

	private Integer cpyId;

	// 希望查询用户的时候所属公司也能查出来
	private Company company;

	public Admin(Integer adminId, String username, String userpass, Integer usersex, String userbirthday,
			String userpnum, String useraddress, String useremail, Integer usertype, Integer cpyId) {
		super();
		this.adminId = adminId;
		this.username = username;
		this.userpass = userpass;
		this.usersex = usersex;
		this.userbirthday = userbirthday;
		this.userpnum = userpnum;
		this.useraddress = useraddress;
		this.useremail = useremail;
		this.usertype = usertype;
		this.cpyId = cpyId;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", username=" + username + ", userpass=" + userpass + ", usersex="
				+ usersex + ", userbirthday=" + userbirthday + ", userpnum=" + userpnum + ", useraddress=" + useraddress
				+ ", useremail=" + useremail + ", usertype=" + usertype + ", cpyId=" + cpyId + ", getCompany()="
				+ getCompany() + ", getAdminId()=" + getAdminId() + ", getUsername()=" + getUsername()
				+ ", getUserpass()=" + getUserpass() + ", getUsersex()=" + getUsersex() + ", getUserbirthday()="
				+ getUserbirthday() + ", getUserpnum()=" + getUserpnum() + ", getUseraddress()=" + getUseraddress()
				+ ", getUseremail()=" + getUseremail() + ", getUsertype()=" + getUsertype() + ", getCpyId()="
				+ getCpyId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public Admin() {
		super();
	}

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