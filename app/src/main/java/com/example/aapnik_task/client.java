package com.example.aapnik_task;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class client {


    private static String base_url="https://api.stackexchange.com";

    private static Retrofit instance;


    public static Retrofit getInstance() {
        if(instance==null)
            instance=new Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build();
        return instance;
    }
}

