package com.app.usergeneratortask.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("login")
    @Expose
    private Login login;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("picture")
    @Expose
    private Picture picture;
    @SerializedName("dob")
    @Expose
    private Dob age;

    public Dob getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public Login getLogin() {
        return login;
    }

    public String getPhone() {
        return phone;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public void setAge(Dob age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
