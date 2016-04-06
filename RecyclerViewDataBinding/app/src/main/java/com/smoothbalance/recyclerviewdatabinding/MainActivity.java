package com.smoothbalance.recyclerviewdatabinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.smoothbalance.recyclerviewdatabinding.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<User> usersList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        final RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, getUsersList());
        binding.recyclerView.setAdapter(recyclerViewAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.btnCLick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usersList.add(new User("san", "jaisy"));
                String add = new Gson().toJson(usersList);
                recyclerViewAdapter.notifyDataSetChanged();
                Log.i("After Add value", add);
            }
        });
        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usersList.remove(3);
                recyclerViewAdapter.notifyDataSetChanged();
                String del = new Gson().toJson(usersList);
                Log.i("After del", del);
            }
        });

        String json = new Gson().toJson(usersList);
        Log.i("before value",json);

    }

    public ArrayList<User> getUsersList() {
        usersList = new ArrayList<User>();

        usersList.add(new User("firstUser1", "lasuserUser1"));
        usersList.add(new User("firstUser2", "lasuserUser2"));
        usersList.add(new User("firstUser3", "lasuserUser3"));
        usersList.add(new User("firstUser4", "lasuserUser4"));

        return usersList;
    }
}
