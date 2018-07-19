package com.example.user_pc.tbcrudsql.Model;

public class ModelData {
    String npm,nama,prodi,fakultas,nik,nortu,pekerjaan,alamat;

    public ModelData(){}

    public ModelData(String npm, String nama, String prodi, String fakultas, String nik, String nortu, String pekerjaan, String alamat) {
        this.npm = npm;
        this.nama = nama;
        this.prodi = prodi;
        this.fakultas = fakultas;

        this.nik = nik;
        this.nortu = nortu;
        this.pekerjaan = pekerjaan;
        this.alamat = alamat;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.npm = nik;
    }

    public String getNortu() {
        return nortu;
    }

    public void setNortu(String nortu) {
        this.nortu = nortu;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
