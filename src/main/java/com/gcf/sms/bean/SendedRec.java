package com.gcf.sms.bean;

public class SendedRec {
	private Integer srecordId;

	private Integer rececompanyid;

	private String topic;

	private String describetask;

	private Integer creatorId;

	private Integer masstype;

	private String createtime;

	private String reservetime;

	private String smscon;

	private Integer status;

	// 希望统计查询的时候创建人的信息也能查询出来
	private Admin admin;

	// 希望统计查询的时候接收对象公司也能查出来
	private Company company;

	
	@Override
	public String toString() {
		return "SendedRec [srecordId=" + srecordId + ", rececompanyid=" + rececompanyid + ", topic=" + topic
				+ ", describetask=" + describetask + ", creatorId=" + creatorId + ", masstype=" + masstype
				+ ", createtime=" + createtime + ", reservetime=" + reservetime + ", smscon=" + smscon + ", status="
				+ status + ", admin=" + admin + ", company=" + company + "]";
	}

	public SendedRec() {
		super();
	}

	public SendedRec(Integer srecordId, Integer rececompanyid, String topic, String describetask, Integer creatorId,
			Integer masstype, String createtime, String reservetime, String smscon, Integer status) {
		super();
		this.srecordId = srecordId;
		this.rececompanyid = rececompanyid;
		this.topic = topic;
		this.describetask = describetask;
		this.creatorId = creatorId;
		this.masstype = masstype;
		this.createtime = createtime;
		this.reservetime = reservetime;
		this.smscon = smscon;
		this.status = status;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Integer getSrecordId() {
		return srecordId;
	}

	public void setSrecordId(Integer srecordId) {
		this.srecordId = srecordId;
	}

	public Integer getRececompanyid() {
		return rececompanyid;
	}

	public void setRececompanyid(Integer rececompanyid) {
		this.rececompanyid = rececompanyid;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic == null ? null : topic.trim();
	}

	public String getDescribetask() {
		return describetask;
	}

	public void setDescribetask(String describetask) {
		this.describetask = describetask == null ? null : describetask.trim();
	}

	public Integer getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	public Integer getMasstype() {
		return masstype;
	}

	public void setMasstype(Integer masstype) {
		this.masstype = masstype;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime == null ? null : createtime.trim();
	}

	public String getReservetime() {
		return reservetime;
	}

	public void setReservetime(String reservetime) {
		this.reservetime = reservetime == null ? null : reservetime.trim();
	}

	public String getSmscon() {
		return smscon;
	}

	public void setSmscon(String smscon) {
		this.smscon = smscon == null ? null : smscon.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}