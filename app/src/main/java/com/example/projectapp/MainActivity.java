package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectapp.Retrofit.RetrofitClient;
import com.example.projectapp.Retrofit.WebService;
import com.example.projectapp.models.LoginResponse;
import com.example.projectapp.models.UserLoginRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {
    EditText email,password;
    Button logIn;
    TextView newUser;
    String BaseURL="http://10.0.2.2:8080/";
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.name);
        password=findViewById(R.id.password);
        logIn=findViewById(R.id.login);
        newUser=findViewById(R.id.createNewAccount);
        checkBox=findViewById(R.id.checkbox);
        SharedPreferences sp;
        sp=getSharedPreferences("LoginDetail", Context.MODE_PRIVATE);
        SharedPreferences.Editor check=sp.edit();

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBox.isChecked()){

                    check.putString("Email",""+email.getText().toString());
                    check.putString("password",""+password.getText().toString());
                    check.putString("Status","true");
                    check.commit();

                }
                else if(!checkBox.isChecked()){
                    check.putString("Status","false");
                    check.commit();
                }
            }
        });

    }
    public void createUser(View v){
        startActivity(new Intent(MainActivity.this, SignUp.class));
    }

    public void LogIn(View v){


        if (TextUtils.isEmpty(email.getText().toString())){
            email.setError("Please Enter Email");
            return;
        }
        if (TextUtils.isEmpty(password.getText().toString())){
            password.setError("Please Enter Password");
            return;
        }

        SharedPreferences sp;
        sp=getSharedPreferences("LoginDetail", Context.MODE_PRIVATE);
        SharedPreferences.Editor check=sp.edit();

        RetrofitClient client=new RetrofitClient(BaseURL);
        WebService createdClient=client.RetrofitClientObject().create(WebService.class);
        UserLoginRequest LoginData=new UserLoginRequest(email.getText().toString().trim(),password.getText().toString().trim());
        Call<LoginResponse> getResponse=createdClient.LogInRequest(LoginData);
        getResponse.enqueue(new Callback<LoginResponse>() {

            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
               LoginResponse l=response.body();
               if(l.getStatus().toString().equals("Success")) {
                   check.putString("Response",l.getStatus());
                  check.commit();
                   String hamail=sp.getString("Response","did not Get");
                   Toast.makeText(MainActivity.this, "Login Successfull "+hamail, Toast.LENGTH_SHORT).show();
               startActivity(new Intent(MainActivity.this,HomePage.class));
               finish();
               }
                else
                   Toast.makeText(MainActivity.this, "Check Your Id and Password", Toast.LENGTH_SHORT).show();
            }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}