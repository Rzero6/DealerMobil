/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.text.DecimalFormat;

/**
 
 */
/**
 *
 * @author VICTUS
 */
public class Kendaraan {
    private int id;
    private String nama;
    private String jenis;
    private String merk;
    private float harga;
    private int jumlah;

    public Kendaraan(int id, String nama, String jenis, String merk, float harga, int jumlah) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.merk = merk;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public Kendaraan(String nama, String jenis, String merk, float harga, int jumlah) {
        this.nama = nama;
        this.jenis = jenis;
        this.merk = merk;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getJenis() {
        return jenis;
    }

    public String getMerk() {
        return merk;
    }

    public float getHarga() {
        return harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
    public String toString(){
        return nama;
    }
    
}
