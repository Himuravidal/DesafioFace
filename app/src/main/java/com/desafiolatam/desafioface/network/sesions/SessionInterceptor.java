package com.desafiolatam.desafioface.network.sesions;

import com.desafiolatam.desafioface.network.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cristian on 22-11-2016.
 */

public class SessionInterceptor {

    public Session getInterceptor()
    {
        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Session login = interceptor.create(Session.class);
        return login;
    }



}
