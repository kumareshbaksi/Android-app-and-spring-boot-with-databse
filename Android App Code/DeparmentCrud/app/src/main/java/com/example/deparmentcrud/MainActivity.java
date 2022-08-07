package com.example.deparmentcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.deparmentcrud.model.Deparment;
import com.example.deparmentcrud.retrofit.DeparmentApi;
import com.example.deparmentcrud.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText departmentName, departmentAddress, departmentCode;
    Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        departmentName = findViewById(R.id.departmentName);
        departmentAddress = findViewById(R.id.departmentAddress);
        departmentCode = findViewById(R.id.departmentCode);
        sendBtn = findViewById(R.id.sendBtn);


        RetrofitService retrofitService = new RetrofitService();
        DeparmentApi deparmentApi = retrofitService.getRetrofit().create(DeparmentApi.class);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Deparment deparment = new Deparment();


                String name = departmentName.getText().toString();
                String address = departmentAddress.getText().toString();
                String code = departmentCode.getText().toString();

                deparment.setDepartmentName(name);
                deparment.setDepartmentAddress(address);
                deparment.setDepartmentCode(code);

                deparmentApi.save(deparment)
                        .enqueue(new Callback<Deparment>() {
                            @Override
                            public void onResponse(Call<Deparment> call, Response<Deparment> response) {
                                Toast.makeText(MainActivity.this, "Save done", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<Deparment> call, Throwable t) {
                                Toast.makeText(MainActivity.this, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}