package com.app.usergeneratortask.network;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private static UsersApi usersApi;

    @Override
    public void onCreate() {
        super.onCreate();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        usersApi = retrofit.create(UsersApi.class);
    }

    public static UsersApi getUsersApi() {
        return usersApi;
    }
}
