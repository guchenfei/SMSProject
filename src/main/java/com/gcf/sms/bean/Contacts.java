package com.gcf.sms.bean;

public class Contacts {
	private Integer contactId;

	private String conname;

	private Integer consex;

	private String conbirthday;

	private String conphonenum;

	private String conaddress;

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