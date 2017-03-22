package com.example.jair.retrofit2.Service;

import com.example.jair.retrofit2.Usuario;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;

/**
 * Created by Brian on 22/03/2017.
 */

public interface APIservice {

    @GET("jairwsji.json")
    Call<List<Usuario>> getUsuarios();
}
