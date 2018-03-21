package com.gcf.sms.bean;

public class Sended {
    private Integer srecordId;

    private Integer adId;

    private String receivephone;

    private Integer deliverystatus;

    private String errorinfo;

    private String smscontent;

    private String sendtime;

    public Integer getSrecordId() {
        return srecordId;
    }

    public void setSrecordId(Integer srecordId) {
        this.srecordId = srecordId;
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public String getReceivephone() {
        return receivephone;
    }

    public void setReceivephone(String receivephone) {
        this.receivephone = receivephone == null ? null : receivephone.trim();
    }

    public Integer getDeliverystatus() {
        return deliverystatus;
    }

    public void setDeliverystatus(Integer deliverystatus) {
        this.deliverystatus = deliverystatus;
    }

    public String getErrorinfo() {
        return errorinfo;
    }

    public void setErrorinfo(String errorinfo) {
        this.errorinfo = errorinfo == null ? null : errorinfo.trim();
    }

    public String getSmscontent() {
        return smscontent;
    }

    public void setSmscontent(String smscontent) {
        this.smscontent = smscontent == null ? null : smscontent.trim();
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime == null ? null : sendtime.trim();
    }
}