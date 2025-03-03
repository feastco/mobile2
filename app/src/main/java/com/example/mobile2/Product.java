package com.example.mobile2;

import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("kode")
    private String kode;

    @SerializedName("merk")
    private String merk;

    @SerializedName("harga")
    private double harga;

    @SerializedName("stok")
    private int stok;

    @SerializedName("foto")
    private String foto;

    // Getter & Setter
    public String getKode() { return kode; }
    public String getMerk() { return merk; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }
    public String getFoto() { return foto; }
}
