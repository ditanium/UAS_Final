/*
Tanggal Pengerjaan : 14-08-2019
NIM                : 10116115
Nama               : Aditya Komara Ramadhan
Kelas              : IF-3
 */
package com.corporation.fallen.uas;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("mahasiswa.db")
                .schemaVersion(0)
                .build();
        Realm.setDefaultConfiguration(configuration);
    }

}
