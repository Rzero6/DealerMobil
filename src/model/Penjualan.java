/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 
 */
/**
 *
 * @author VICTUS
 */
public class Penjualan {
    private int idPenjualan;
    private int idKendaraan;
    private int idCustomer;
    private int idStaff;
    private Kendaraan kendaraan;
    private Customer customer;
    private Staff staff;
    private float totalHarga;
    private String jenisPembayaran;
    private String tanggalPenjualan;
    private int jumlahPenjualan;

    public Penjualan(int idPenjualan, Kendaraan kendaraan, Customer customer, Staff staff, float totalHarga, String jenisPembayaran, String tanggalPenjualan,int jumlahPenjualan) {
        this.idPenjualan = idPenjualan;
        this.kendaraan = kendaraan;
        this.customer = customer;
        this.staff = staff;
        this.totalHarga = totalHarga;
        this.jenisPembayaran = jenisPembayaran;
        this.tanggalPenjualan = tanggalPenjualan;
        this.jumlahPenjualan = jumlahPenjualan;
    }

    public Penjualan(Kendaraan kendaraan, Customer customer, Staff staff, float totalHarga, String jenisPembayaran,int jumlahPenjualan) {
        this.kendaraan = kendaraan;
        this.customer = customer;
        this.staff = staff;
        this.totalHarga = totalHarga;
        this.jenisPembayaran = jenisPembayaran;
        this.tanggalPenjualan = getCurrentDateandTime();
        this.jumlahPenjualan = jumlahPenjualan;
    }

    public Penjualan(int idPenjualan, int idKendaraan, int idCustomer, int idStaff, float totalHarga, String jenisPembayaran, String tanggalPenjualan, int jumlahPenjualan) {
        this.idPenjualan = idPenjualan;
        this.idKendaraan = idKendaraan;
        this.idCustomer = idCustomer;
        this.idStaff = idStaff;
        this.totalHarga = totalHarga;
        this.jenisPembayaran = jenisPembayaran;
        this.tanggalPenjualan = tanggalPenjualan;
        this.jumlahPenjualan = jumlahPenjualan;
    }

    public Penjualan(int idKendaraan, int idCustomer, int idStaff, float totalHarga, String jenisPembayaran, int jumlahPenjualan) {
        this.idKendaraan = idKendaraan;
        this.idCustomer = idCustomer;
        this.idStaff = idStaff;
        this.totalHarga = totalHarga;
        this.jenisPembayaran = jenisPembayaran;
        this.tanggalPenjualan = getCurrentDateandTime();
        this.jumlahPenjualan = jumlahPenjualan;
    }
    
    public String getCurrentDateandTime(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String sqlDateandTime = currentDateTime.format(formatter);
        return sqlDateandTime;
    }

    public int getIdPenjualan() {
        return idPenjualan;
    }

    public int getIdKendaraan() {
        return idKendaraan;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public int getIdStaff() {
        return idStaff;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public float getTotalHarga() {
        return totalHarga;
    }

    public String getJenisPembayaran() {
        return jenisPembayaran;
    }

    public String getTanggalPenjualan() {
        return tanggalPenjualan;
    }

    public int getJumlahPenjualan() {
        return jumlahPenjualan;
    }

    public void setJumlahPenjualan(int jumlahPenjualan) {
        this.jumlahPenjualan = jumlahPenjualan;
    }

    public void setIdPenjualan(int idPenjualan) {
        this.idPenjualan = idPenjualan;
    }

    public void setIdKendaraan(int idKendaraan) {
        this.idKendaraan = idKendaraan;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void setTotalHarga(float totalHarga) {
        this.totalHarga = totalHarga;
    }

    public void setJenisPembayaran(String jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
    }

    public void setTanggalPenjualan(String tanggalPenjualan) {
        this.tanggalPenjualan = tanggalPenjualan;
    }
    
    
}
