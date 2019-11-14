package com.fc.andriod.newcptdemo3.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public  class Message implements MultiItemEntity {
    public static final int MINE = 0;
    public static  final int OTHERS=1;

    private  String message;
    private  int imgId;
    private  int type;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int getItemType() {
        return getType()==0 ? MINE :  OTHERS;
    }
}
