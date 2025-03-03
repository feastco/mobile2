package com.example.mobile2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ViewHolder> {
    private List<Mahasiswa> listMahasiswa;

    public MahasiswaAdapter(List<Mahasiswa> listMahasiswa) {
        this.listMahasiswa = listMahasiswa;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvNama, tvNim, tvEmail;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.ivFoto);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNim = itemView.findViewById(R.id.tvNim);
            tvEmail = itemView.findViewById(R.id.tvEmail);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mahasiswa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mahasiswa mahasiswa = listMahasiswa.get(position);

        // Gunakan Glide untuk memuat gambar
        Glide.with(holder.itemView.getContext())
                .load(mahasiswa.getFotoUrl())
                .into(holder.ivFoto);

        holder.tvNama.setText(mahasiswa.getNama());
        holder.tvNim.setText("NIM: " + mahasiswa.getNim());
        holder.tvEmail.setText("Email: " + mahasiswa.getEmail());
    }

    @Override
    public int getItemCount() {
        return listMahasiswa.size();
    }
}
