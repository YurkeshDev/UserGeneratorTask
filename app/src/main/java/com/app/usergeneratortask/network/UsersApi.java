package com.app.usergeneratortask.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsersApi {
    @GET("/api/?results=20")
    Call<RouteData> getData();
}
