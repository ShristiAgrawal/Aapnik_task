package com.example.aapnik_task;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface services {
@GET("/2.2/search")
    Call<items> getLis(@Query("tagged") String tag,@Query("site") String s);
}
