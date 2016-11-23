package com.desafiolatam.desafioface.model;

import com.orm.SugarRecord;

/**
 * Created by cristian on 22-11-2016.
 */

public class UserInfo extends BaseSugar{

    public UserInfo() {
    }

    private String email,name,auth_token,photo_url;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuth_token() {
        return auth_token;
    }

    public void setAuth_token(String auth_token) {
        this.auth_token = auth_token;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

}
