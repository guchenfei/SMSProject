package com.gcf.sms.bean;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class Contacts {
	private Integer contactId;
	// "\\u"是Unicode编码
	@Pattern(regexp = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})", message = "姓名必须是2-5位中文或者6-16位英文和数字等组合")
	private String conname;

	private Integer consex;
	@NotEmpty(message = "生日不能为空！")
	private String conbirthday;
	@Pattern(regexp = "(^[1][3,4,5,7,8][0-9]{9}$)", message = "请输入格式正确的11位手机号")
	private String conphonenum;
	@NotEmpty(message="地址不能为空！")
	private String conaddress;
	@Pattern(regexp = "(^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$)", message = "请按正确的邮箱格式输入")
	private String conemail;

	private Integer concompany;
	// 希望查询联系人的时候他所属的公司也是查询好的
	private Company company;

	@Override
	public String toString() {
		return "Contacts [contactId=" + contactId + ", conname=" + conname + ", consex=" + consex + ", conbirthday="
				+ conbirthday + ", conphonenum=" + conphonenum + ", conaddress=" + conaddress + ", conemail=" + conemail
				+ ", concompany=" + concompany + "]";
	}

	public Contacts(Integer contactId, String conname, Integer consex, String conbirthday, String conphonenum,
			String conaddress, String conemail, Integer concompany) {
		super();
		this.contactId = contactId;
		this.conname = conname;
		this.consex = consex;
		this.conbirthday = conbirthday;
		this.conphonenum = conphonenum;
		this.conaddress = conaddress;
		this.conemail = conemail;
		this.concompany = concompany;
	}

	public Contacts() {
		super();
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getConname() {
		return conname;
	}

	public void setConname(String conname) {
		this.conname = conname == null ? null : conname.trim();
	}

	public Integer getConsex() {
		return consex;
	}

	public void setConsex(Integer consex) {
		this.consex = consex;
	}

	public String getConbirthday() {
		return conbirthday;
	}

	public void setConbirthday(String conbirthday) {
		this.conbirthday = conbirthday == null ? null : conbirthday.trim();
	}

	public String getConphonenum() {
		return conphonenum;
	}

	public void setConphonenum(String conphonenum) {
		this.conphonenum = conphonenum == null ? null : conphonenum.trim();
	}

	public String getConaddress() {
		return conaddress;
	}

	public void setConaddress(String conaddress) {
		this.conaddress = conaddress == null ? null : conaddress.trim();
	}

	public String getConemail() {
		return conemail;
	}

	public void setConemail(String conemail) {
		this.conemail = conemail == null ? null : conemail.trim();
	}

	public Integer getConcompany() {
		return concompany;
	}

	public void setConcompany(Integer concompany) {
		this.concompany = concompany;
	}
}