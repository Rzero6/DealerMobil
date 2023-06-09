package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author kevin
 */


public class Customer {
    private int id;
    private String nama;
    private String tanggalLahir;
    private String alamat;

    public Customer(int id, String nama, String tanggalLahir, String alamat) {
        this.id = id;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.alamat = alamat;
    }

    public Customer(String nama, String tanggalLahir, String alamat) {
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.alamat = alamat;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public int getUmur(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate born;
        LocalDate current = LocalDate.now();
        born = LocalDate.parse(tanggalLahir,format);
        Period age = Period.between(born, current);
        return (int) age.getYears();
    }
    
    @Override
    public String toString(){
        return nama;
    }
    
}
