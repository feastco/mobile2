package com.example.mobile2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Latihan1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_latihan1);

        // Data dummy
        List<Mahasiswa> listMahasiswa = new ArrayList<>();
        listMahasiswa.add(new Mahasiswa(
                "Mikel Andreas",
                "123456789",
                "edi.sugiarto@yahoo.com",
                "https://static.promediateknologi.id/crop/0x0:0x0/0x0/webp/photo/p2/83/2023/06/28/OK-OPINI-FARRY-81530641.jpeg"
        ));
        listMahasiswa.add(new Mahasiswa(
                "John Doe",
                "987654321",
                "john.doe@example.com",
                "https://surveillanceteam.wordpress.com/wp-content/uploads/2013/10/andri-3x4.jpg?w=224"
        ));

        // Setup RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvMahasiswa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MahasiswaAdapter(listMahasiswa));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}