package com.app.usergeneratortask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.app.usergeneratortask.adapter.Users;
import com.app.usergeneratortask.models.Result;
import com.app.usergeneratortask.network.App;
import com.app.usergeneratortask.network.RouteData;
import com.app.usergeneratortask.view.DetailInfo;
import com.google.android.material.snackbar.Snackbar;


import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getUserData();
    }

    private void initUsersList(RouteData dataList) {

        Users usersAdapter = new Users(dataList, item -> {
            Map<String, String> userData = generateMapToFragment(item);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, DetailInfo.newInstance(userData))
                    .addToBackStack(DetailInfo.newInstance(userData).toString())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit();
        });

        configureUsersList(usersAdapter);
    }

    private void configureUsersList(Users usersAdapter) {
        RecyclerView usersList = findViewById(R.id.usersListRecyclerView);
        usersList.setLayoutManager(new LinearLayoutManager(this));

        usersList.setAdapter(usersAdapter);
        usersAdapter.notifyDataSetChanged();
    }

    private Map<String, String> generateMapToFragment(Result data) {

        Map<String, String> userData = new HashMap<>();

        userData.put("NAME", data.getName().getFirst() + " " + data.getName().getLast());
        userData.put("GENDER", data.getGender());
        userData.put("DATE", data.getAge().getDate());
        userData.put("PHONE", data.getPhone());
        userData.put("AGE", data.getAge().getAge().toString());

        userData.put("IMG", data.getPicture().getLarge());


        return userData;
    }

    private void getUserData() {
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.fragment_container);

        App.getUsersApi().getData().enqueue(new Callback<RouteData>() {
            @Override
            public void onResponse(Call<RouteData> call, Response<RouteData> response) {
                if (response.body() != null) {
                    initUsersList(response.body());
                } else {
                    Snackbar.make(constraintLayout, "Error of Response", Snackbar.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RouteData> call, Throwable t) {
                Snackbar.make(constraintLayout, "Error", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
