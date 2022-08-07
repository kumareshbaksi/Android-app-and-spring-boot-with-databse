package com.example.deparmentcrud.retrofit;

import com.example.deparmentcrud.model.Deparment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DeparmentApi {

    @GET("/departments")
    Call<List<Deparment>> getAllDepartments();

    @POST("/departments")
    Call<Deparment> save(@Body Deparment deparment);

}
