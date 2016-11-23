package com.desafiolatam.desafioface.network.gets;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.desafiolatam.desafioface.network.Constants;


public class LoginService extends IntentService {

    private static final String START_DOWNLOAD = "com.desafiolatam.desafioface.network.gets.action.START_DOWNLOAD";


    public LoginService() {
        super("LoginService");
    }


    public static void startActionDownload(Context context) {
        Intent intent = new Intent(context, LoginService.class);
        intent.setAction(START_DOWNLOAD);
        context.startService(intent);
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (START_DOWNLOAD.equals(action)) {
                handleStartDownload();
            }


        }
    }


    private void handleStartDownload() {

        for (int i = 0; i < 10000; i++) {
            Log.d("SERVICE", String.valueOf(i));


        }
        broadcastSuccess();

    }

    private void broadcastSuccess(){
        Intent intent = new Intent();
        intent.setAction(Constants.CONNECTION_SUCCESS);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

    }


}
