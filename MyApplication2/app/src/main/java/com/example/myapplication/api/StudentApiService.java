package com.example.myapplication.api;

import com.example.myapplication.model.Student;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface StudentApiService {
    @Headers("Content-Type: application/json")
    @POST("addStudent.php")
    Call<Void> insertData( @Query("first_name") String firstName,
                           @Query("last_name") String lastName,
                           @Query("date_of_birth") String dateOfBirth,
                           @Query("email") String email,
                           @Query("phone_number") String phoneNumber,
                           @Body Student data);
}