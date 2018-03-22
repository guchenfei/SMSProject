package com.gcf.sms.bean;

public class Company {
	private Integer companyId;

	private String companyname;

	public Company(Integer companyId, String companyname) {
		super();
		this.companyId = companyId;
		this.companyname = companyname;
	}

	public Company() {
		super();
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname == null ? null : companyname.trim();
	}
}