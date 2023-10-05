package com.test.androidnewfcm;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.jetbrains.annotations.NotNull;

import com.google.gson.Gson;

import java.util.Objects;

public class MyFirebaseService extends FirebaseMessagingService {

    @Override
    public void onNewToken(@NotNull String token) {
        super.onNewToken(token);
        Log.d(Utils.Tag,token);
    }

    @Override
    public void onMessageReceived(@NotNull RemoteMessage message){
        super.onMessageReceived(message);
        String data = null;
        try {
            Log.d("Notification", Objects.requireNonNull(Objects.requireNonNull(message.getNotification()).getBody()).toLowerCase());
            String title= Objects.requireNonNull(message.getNotification()).getTitle();
            String content = message.getNotification().getBody();
            data = new Gson().toJson(message.getData());
            Utils.showNotification(this,title,content);
            Log.d(Utils.Tag,data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
