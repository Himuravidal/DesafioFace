package com.desafiolatam.desafioface.views.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.desafiolatam.desafioface.MainActivity;
import com.desafiolatam.desafioface.R;
import com.desafiolatam.desafioface.data.UserInfoData;
import com.desafiolatam.desafioface.model.UserInfo;
import com.desafiolatam.desafioface.network.Constants;
import com.desafiolatam.desafioface.network.gets.LoginService;
import com.desafiolatam.desafioface.network.sesions.Session;
import com.desafiolatam.desafioface.network.sesions.SessionInterceptor;
import com.github.ybq.android.spinkit.SpinKitView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.button;
import static android.R.attr.password;


public class LoginActivity extends AppCompatActivity implements LoginCallback {

    private TextInputLayout emailTil, passwordTil;
    private EditText emailEt, passwordET;
    private SpinKitView loading;
    private Button button;
    private BroadcastReceiver broadcastReceiver;
    private IntentFilter intentFilter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        emailTil = (TextInputLayout) findViewById(R.id.emailHolder);
        passwordTil = (TextInputLayout) findViewById(R.id.passwordHolder);

        emailEt = (EditText) findViewById(R.id.emailInput);
        passwordET = (EditText) findViewById(R.id.passwordInput);

        loading = (SpinKitView) findViewById(R.id.loginLoading);

        button = (Button) findViewById(R.id.loginBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEt.getText().toString();
                String password = passwordET.getText().toString();
                hideViews();
                new LogUser(LoginActivity.this, email, password).validation();

            }
        });

        if (new UserInfoData().isLoged()) {
            succes();
        }

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (Constants.CONNECTION_SUCCESS.equals(action)) ;
                goToMain();
            }
        };

        intentFilter = new IntentFilter();
        intentFilter.addAction(Constants.CONNECTION_SUCCESS);

    }

    @Override
    protected void onResume() {
        super.onPostResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver,intentFilter);

    }

    @Override
    protected void onPause() {

        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }

private void goToMain(){

    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);


}


    @Override
    public void succes() {
        hideViews();
        LoginService.startActionDownload(this);


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void fail(String error) {
        Snackbar.make((View) emailTil.getParent(), error, Snackbar.LENGTH_LONG).show();

    }

    @Override
    public void invalidEmail(String error) {
        emailTil.setError(error);


    }

    @Override
    public void invalidPassword(String error) {

        passwordTil.setError(error);
    }


    private void hideViews() {

        if (emailTil.getError() != null) {

            emailTil.setError(null);
        }
        if (passwordTil.getError() != null) {
            passwordTil.setError(null);
        }


        emailTil.setVisibility(View.GONE);
        passwordTil.setVisibility(View.GONE);
        button.setVisibility(View.GONE);
        loading.setVisibility(View.VISIBLE);


    }

    private void showViews() {

        emailTil.setVisibility(View.VISIBLE);
        passwordTil.setVisibility(View.VISIBLE);
        button.setVisibility(View.VISIBLE);
        loading.setVisibility(View.GONE);

    }

}
