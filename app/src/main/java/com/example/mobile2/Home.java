package com.example.mobile2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Home extends AppCompatActivity {

    TextView tvwelcome;
    Button btnkcluar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Di onCreate() MainActivityHome:
        ImageView banner = findViewById(R.id.banner);
        Glide.with(this)
                .load(R.drawable.banner)
                .override(1080, 500)
                .into(banner);

        // Set judul action bar
        getSupportActionBar().setTitle("Halaman Depan");

        // Inisialisasi komponen UI
        tvwelcome = findViewById(R.id.tvWelcome);
        btnkcluar = findViewById(R.id.btnLogout);

        // Ambil data dari intent
        String username = getIntent().getStringExtra("username");
        String email = getIntent().getStringExtra("email");

        // Tampilkan pesan selamat datang
        tvwelcome.setText("Selamat Datang: " + username + " (" + email + ")");

        // Set listener untuk tombol logout
        btnkcluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Kembali ke MainActivity
                Intent intent = new Intent(Home.this, Login.class);
                startActivity(intent);
                finish(); // Tutup activity saat ini
            }
        });
    }
}