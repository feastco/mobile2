package com.example.mobile2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MahasiswaAdapterRetrofit extends RecyclerView.Adapter<MahasiswaAdapterRetrofit.ViewHolder> {
    private Context context;
    private List<DataMahasiswaRetrofit> results;

    public MahasiswaAdapterRetrofit(Context context, List<DataMahasiswaRetrofit> results) {
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_mhs_retrofit, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataMahasiswaRetrofit result = results.get(position);
        holder.tvNim.setText(result.getNim());
        holder.tvNama.setText(result.getNama());
        holder.tvTelp.setText(result.getTelp());
        holder.tvEmail.setText(result.getEmail());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNim, tvNama, tvTelp, tvEmail;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNim = itemView.findViewById(R.id.tvNim);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvTelp = itemView.findViewById(R.id.tvTelp);
            tvEmail = itemView.findViewById(R.id.tvEmail);
        }
    }
}