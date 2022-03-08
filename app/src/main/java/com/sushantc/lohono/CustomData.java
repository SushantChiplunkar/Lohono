package com.sushantc.lohono;

public class CustomData {
    private String title;
    private String desc;

    public CustomData(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public CustomData() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
