package com.gcf.sms.bean;

public class FestivalTemp {
    private Integer festivalId;

    private String festivalName;

    private String templatecon;

    public Integer getFestivalId() {
        return festivalId;
    }

    public void setFestivalId(Integer festivalId) {
        this.festivalId = festivalId;
    }

    public String getFestivalName() {
        return festivalName;
    }

    public void setFestivalName(String festivalName) {
        this.festivalName = festivalName == null ? null : festivalName.trim();
    }

    public String getTemplatecon() {
        return templatecon;
    }

    public void setTemplatecon(String templatecon) {
        this.templatecon = templatecon == null ? null : templatecon.trim();
    }
}