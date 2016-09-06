package com.example.chy.challenge.Adepter;

/**
 * Created by 77588 on 2016/9/3.
 */
public class Options {
    private String optionsName;
    private int imageId;
    public Options(String optionsName,int imageId){
        this.optionsName = optionsName;
        this.imageId = imageId;
    }

    public String getOptionsName() {
        return optionsName;
    }

    public int getImageId() {
        return imageId;
    }
}
