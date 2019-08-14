/*
Tanggal Pengerjaan : 14-08-2019
NIM                : 10116115
Nama               : Aditya Komara Ramadhan
Kelas              : IF-3
 */
package com.corporation.fallen.uas;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MenuDaftarTeman extends AppCompatActivity implements View.OnClickListener {
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    Button btnSimpan, btnTampil;
    EditText nim, nama, kls, telepon, email, sm;
    String sNama, sKls, sEmail, sSm;
    Integer sNim, sTelepon;
    Realm realm;
    RealmHelper realmHelper;
    MahasiswaModel mahasiswaModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_teman);

        dl = (DrawerLayout)findViewById(R.id.activity_main2);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.profil:
                        Intent i = new Intent(MenuDaftarTeman.this, MainActivity.class);
                        startActivity(i);
                        break;
                    case R.id.kontak:
                        Intent j = new Intent(MenuDaftarTeman.this, MenuKontak.class);
                        startActivity(j);
                        break;
                    case R.id.daftarteman:
                        Intent k = new Intent(MenuDaftarTeman.this, MenuDaftarTeman.class);
                        startActivity(k);
                        break;
                    default:
                        return true;
                }


                return true;

            }
        });

        //Inisialisasi
        btnSimpan = findViewById(R.id.btnSimpan);
        btnTampil = findViewById(R.id.btnTampil);
        nim = findViewById(R.id.nim);
        nama = findViewById(R.id.nama);
        kls = findViewById(R.id.kls);
        telepon = findViewById(R.id.telepon);
        email = findViewById(R.id.email);
        sm = findViewById(R.id.sm);

        //Set up Realm
        Realm.init(MenuDaftarTeman.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        btnSimpan.setOnClickListener(this);
        btnTampil.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v == btnSimpan){
            sNim = Integer.parseInt(nim.getText().toString());
            sNama = nama.getText().toString();
            sKls = kls.getText().toString();
            sTelepon = Integer.parseInt(telepon.getText().toString());
            sEmail = email.getText().toString();
            sSm = sm.getText().toString();

            if (!sNim.equals("") && !sNama.isEmpty() && !sKls.isEmpty() && !sTelepon.equals("") && !sEmail.isEmpty() && !sSm.isEmpty()){
                mahasiswaModel = new MahasiswaModel();
                mahasiswaModel.setNim(sNim);
                mahasiswaModel.setNama(sNama);
                mahasiswaModel.setKls(sKls);
                mahasiswaModel.setTelepon(sTelepon);
                mahasiswaModel.setEmail(sEmail);
                mahasiswaModel.setSm(sSm);

                realmHelper = new RealmHelper(realm);
                realmHelper.save(mahasiswaModel);

                Toast.makeText(MenuDaftarTeman.this, "Berhasil Disimpan!", Toast.LENGTH_SHORT).show();

                nim.setText("");
                nama.setText("");
                kls.setText("");
                telepon.setText("");
                email.setText("");
                sm.setText("");
            }else {
                Toast.makeText(MenuDaftarTeman.this, "Terdapat inputan yang kosong", Toast.LENGTH_SHORT).show();
            }
        }else if (v == btnTampil){
            startActivity(new Intent(MenuDaftarTeman.this, TemanActivity.class));
        }
    }
}
