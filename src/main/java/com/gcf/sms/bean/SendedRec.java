package com.gcf.sms.bean;

public class SendedRec {
    private Integer srecordId;

    private Integer rececompanyid;

    private String topic;

    private String describe;

    private Integer creatorId;

    private Integer masstype;

    private String createtime;

    private String reservetime;

    private String smscon;

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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
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
}