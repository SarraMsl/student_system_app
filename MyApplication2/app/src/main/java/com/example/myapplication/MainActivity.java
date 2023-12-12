package com.example.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.api.StudentApiService;
import com.example.myapplication.model.Student;
import com.google.gson.Gson;

import java.net.*;
import java.io.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText editTextFirstName, editTextLastName, editTextDOB, editTextEmail, editTextPhoneNumber;
    Button btnAddStudent;
    StudentApiService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://baalsoft.com/Ouared/student/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         apiService = retrofit.create(StudentApiService.class);
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextDOB = findViewById(R.id.editTextDOB);
        editTextEmail = findViewById(R.id.editTextEmail); // Adding Email EditText
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber); // Adding Phone Number EditText

        btnAddStudent = findViewById(R.id.btnAddStudent);
        btnAddStudent.setOnClickListener(v -> addStudent());
    }

    private void addStudent() {
        String firstName = editTextFirstName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();
        String dob = editTextDOB.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim(); // Retrieving email
        String phoneNumber = editTextPhoneNumber.getText().toString().trim();
        Log.w("daaaaaaaaaaaaaaaaaaaaaaaaata",firstName+" "+lastName+" "+phoneNumber);
        Student student = new Student(firstName, lastName, dob, email, phoneNumber);




        Gson gson = new Gson();
        String json = gson.toJson(student);
        Log.d("Request Body", json);
        // Make the API call
        Call<Void> call = apiService.insertData(
                student.getFirstName(),
                student.getLastName(),
                student.getDateOfBirth(),
                student.getEmail(),
                student.getPhoneNumber(),
                student
        );

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Log.d("RESPOOOOOOOOOOOOOOOONS", response.message());

                    Toast.makeText(getApplicationContext(), "Student data inserted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("RESPOOOOOOOOOOOOOOOONS", response.message());

                    Toast.makeText(getApplicationContext(), "Failed to insert student data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("errrrrr",t.getMessage());
                Toast.makeText(getApplicationContext(), "Network error", Toast.LENGTH_SHORT).show();
            }
        });


    }


}
