/*
Tanggal Pengerjaan : 14-08-2019
NIM                : 10116115
Nama               : Aditya Komara Ramadhan
Kelas              : IF-3
 */
package com.corporation.fallen.uas;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MahasiswaModel extends RealmObject {

    @PrimaryKey
    private Integer id;
    private Integer nim;
    private Integer telepon;
    private String nama;
    private String kls;
    private String email;
    private String sm;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setNim(Integer nim) {
        this.nim = nim;
    }

    public Integer getNim() {
        return nim;
    }

    public void setTelepon(Integer telepon) {
        this.telepon = telepon;
    }

    public Integer getTelepon() {
        return telepon;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setKls(String kls) {
        this.kls = kls;
    }

    public String getKls() {
        return kls;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }

    public String getSm() {
        return sm;
    }
}
