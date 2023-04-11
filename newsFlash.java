package com.example.myhomes;

public class newsFlash {
    private String NewsUpdate;
   private String BroadCast;
    private  String Description;

    public newsFlash() {
    }

    public newsFlash(String newsUpdate, String broadCast, String description) {
        NewsUpdate = newsUpdate;
        BroadCast = broadCast;
        Description = description;
    }

    public String getNewsUpdate() {
        return NewsUpdate;
    }

    public void setNewsUpdate(String newsUpdate) {
        NewsUpdate = newsUpdate;
    }

    public String getBroadCast() {
        return BroadCast;
    }

    public void setBroadCast(String broadCast) {
        BroadCast = broadCast;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
