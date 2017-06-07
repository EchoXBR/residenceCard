package com.speedata.residencecard;

import android.graphics.Bitmap;

/**
 * Created by brxu on 2017/05/15.
 * 居住证信息
 */

public class IDInfor {
    private String name;
    private String sex;//
    private String nation;//民族
    private String birthday ;
    private String idnum;//居住证号
    private String address ;//常用户口所在地
    private String height ;//身高
    private String politics;//政治面貌
    private String marriage_status;//婚姻状况
    private String educational_level ;//文化程度
    private String army_service ;//服兵役情况
    private Bitmap bmps;//照片

    private boolean isSuccess;
    private String errorMsg = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }


    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdnum() {
        return idnum;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getMarriage_status() {
        return marriage_status;
    }

    public void setMarriage_status(String marriage_status) {
        this.marriage_status = marriage_status;
    }

    public String getEducational_level() {
        return educational_level;
    }

    public void setEducational_level(String educational_level) {
        this.educational_level = educational_level;
    }

    public String getArmy_service() {
        return army_service;
    }

    public void setArmy_service(String army_service) {
        this.army_service = army_service;
    }

    public Bitmap getBmps() {
        return bmps;
    }

    public void setBmps(Bitmap bmps) {
        this.bmps = bmps;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "IDInfor{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", nation='" + nation + '\'' +
                ", birthday='" + birthday + '\'' +
                ", idnum='" + idnum + '\'' +
                ", address='" + address + '\'' +
                ", height='" + height + '\'' +
                ", politics='" + politics + '\'' +
                ", marriage_status='" + marriage_status + '\'' +
                ", educational_level='" + educational_level + '\'' +
                ", army_service='" + army_service + '\'' +
                ", bmps=" + bmps +
                ", isSuccess=" + isSuccess +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
