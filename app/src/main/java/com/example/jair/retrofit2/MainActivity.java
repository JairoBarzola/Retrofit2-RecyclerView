package com.example.jair.retrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jair.retrofit2.Service.APIservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    List<Usuario> usuarioList = new ArrayList<>();
    RecyclerAdapter adapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        /*Estructura para retrofit2*/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jairbarzola.esy.es/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIservice service = retrofit.create(APIservice.class);

       Call<List<Usuario>> call = service.getUsuarios();
        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {

                usuarioList = response.body();
                adapter = new RecyclerAdapter(getApplicationContext(),usuarioList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {

            }
        });



    }
}
