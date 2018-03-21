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