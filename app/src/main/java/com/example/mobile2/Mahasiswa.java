package com.example.mobile2;

public class Mahasiswa {
    private String nama;
    private String nim;
    private String email;
    private String fotoUrl;

    public Mahasiswa(String nama, String nim, String email, String fotoUrl) {
        this.nama = nama;
        this.nim = nim;
        this.email = email;
        this.fotoUrl = fotoUrl;
    }

    // Getter methods
    public String getNama() { return nama; }
    public String getNim() { return nim; }
    public String getEmail() { return email; }
    public String getFotoUrl() { return fotoUrl; }
}
