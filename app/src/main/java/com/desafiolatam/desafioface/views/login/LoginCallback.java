package com.desafiolatam.desafioface.views.login;

/**
 * Created by cristian on 22-11-2016.
 */

public interface LoginCallback {

    void succes();

    void fail(String error);

    void invalidEmail(String error);

    void invalidPassword(String error);


}
