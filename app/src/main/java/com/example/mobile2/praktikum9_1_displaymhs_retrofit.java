package com.example.mobile2;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class praktikum9_1_displaymhs_retrofit extends AppCompatActivity {

    public static final String URL = "http://192.168.1.9/webserver/";
    private List<DataMahasiswaRetrofit> results = new ArrayList<>();
    private MahasiswaAdapterRetrofit viewAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praktikum91_displaymhs_retrofit);

        // Initialize RecyclerView
        viewAdapter = new MahasiswaAdapterRetrofit(this, results);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);

        // Load data from API
        loadDataMahasiswaRetrofit();
    }

    private void loadDataMahasiswaRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<Value> call = api.view();
        Log.i("Info", "Load Data Mahasiswa Retrofit");

        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                if (response.isSuccessful() && response.body() != null) {
                    results.clear(); // Clear existing data
                    results.addAll(response.body().getResult()); // Add new data
                    viewAdapter.notifyDataSetChanged(); // Update RecyclerView
                    Log.i("Info", "Data Loaded, Updating Adapter");
                } else {
                    Log.i("Info", "Response not successful: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                Log.i("Info", "Load Error: " + t.toString());
            }
        });
    }
}