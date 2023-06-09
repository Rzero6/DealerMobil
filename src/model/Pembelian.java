/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Nama : Reynold Kunarto 
 * NPM : 210711015
 * 
 * Nama : Febiola Ika Putri Wibowo
 * NPM : 210711023
 */
/**
 *
 * @author VICTUS
 */
public class Pembelian {
    private int idPembelian;
    private int idSuplier;
    private int idKendaraan;
    private Suplier suplier;
    private Kendaraan kendaraan;
    private float totalHargaBeli;
    private int jumlahSuplai;
    private String tanggalPembelian;

    public Pembelian(int idPembelian, int idSuplier, int idKendaraan, float totalHargaBeli, int jumlahSuplai, String tanggalPembelian) {
        this.idPembelian = idPembelian;
        this.idSuplier = idSuplier;
        this.idKendaraan = idKendaraan;
        this.totalHargaBeli = totalHargaBeli;
        this.jumlahSuplai = jumlahSuplai;
        this.tanggalPembelian = tanggalPembelian;
    }

    public Pembelian(int idPembelian, Suplier suplier, Kendaraan kendaraan, float totalHargaBeli, int jumlahSuplai, String tanggalPembelian) {
        this.idPembelian = idPembelian;
        this.suplier = suplier;
        this.kendaraan = kendaraan;
        this.totalHargaBeli = totalHargaBeli;
        this.jumlahSuplai = jumlahSuplai;
        this.tanggalPembelian = tanggalPembelian;
    }

    public Pembelian(int idSuplier, int idKendaraan, float totalHargaBeli, int jumlahSuplai) {
        this.idSuplier = idSuplier;
        this.idKendaraan = idKendaraan;
        this.totalHargaBeli = totalHargaBeli;
        this.jumlahSuplai = jumlahSuplai;
        this.tanggalPembelian = getCurrentDateandTime();
    }

    public Pembelian(Suplier suplier, Kendaraan kendaraan, float totalHargaBeli, int jumlahSuplai) {
        this.suplier = suplier;
        this.kendaraan = kendaraan;
        this.totalHargaBeli = totalHargaBeli;
        this.jumlahSuplai = jumlahSuplai;
        this.tanggalPembelian = getCurrentDateandTime();
    }

    public int getIdPembelian() {
        return idPembelian;
    }

    public int getIdSuplier() {
        return idSuplier;
    }

    public int getIdKendaraan() {
        return idKendaraan;
    }

    public Suplier getSuplier() {
        return suplier;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public float getTotalHargaBeli() {
        return totalHargaBeli;
    }

    public int getJumlahSuplai() {
        return jumlahSuplai;
    }

    public String getTanggalPembelian() {
        return tanggalPembelian;
    }

    public void setIdPembelian(int idPembelian) {
        this.idPembelian = idPembelian;
    }

    public void setIdSuplier(int idSuplier) {
        this.idSuplier = idSuplier;
    }

    public void setIdKendaraan(int idKendaraan) {
        this.idKendaraan = idKendaraan;
    }

    public void setSuplier(Suplier suplier) {
        this.suplier = suplier;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    public void setTotalHargaBeli(float totalHargaBeli) {
        this.totalHargaBeli = totalHargaBeli;
    }

    public void setJumlahSuplai(int jumlahSuplai) {
        this.jumlahSuplai = jumlahSuplai;
    }

    public void setTanggalPembelian(String tanggalPembelian) {
        this.tanggalPembelian = tanggalPembelian;
    }
    public String getCurrentDateandTime(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String sqlDateandTime = currentDateTime.format(formatter);
        return sqlDateandTime;
    }
}
