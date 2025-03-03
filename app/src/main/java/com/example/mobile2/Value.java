package com.example.mobile2;

import java.util.List;

public class Value {
    private String value;
    private List<DataMahasiswaRetrofit> result;

    // Getter dan Setter
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<DataMahasiswaRetrofit> getResult() {
        return result;
    }

    public void setResult(List<DataMahasiswaRetrofit> result) {
        this.result = result;
    }
}