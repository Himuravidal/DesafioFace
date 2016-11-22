package com.desafiolatam.desafioface;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.desafiolatam.desafioface.model.UserInfo;
import com.desafiolatam.desafioface.network.sesions.Session;
import com.desafiolatam.desafioface.network.sesions.SessionInterceptor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Session session = new SessionInterceptor().getInterceptor();
        Call<UserInfo> call= session.getLogin("cristian.vidal.lopez@gmail.com","desafioandroid");

        call.enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                UserInfo userInfo = response.body();
                Toast.makeText(LoginActivity.this,userInfo.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {

            }
        });


    }

}
