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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class TemanActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    Realm realm;
    RealmHelper realmHelper;
    RecyclerView recyclerView;
    TemanAdapter mahasiswaAdapter;
    List<MahasiswaModel> mahasiswaModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_teman);

        dl = (DrawerLayout)findViewById(R.id.activity_mahasiswa);
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
                        Intent i = new Intent(TemanActivity.this, MainActivity.class);
                        startActivity(i);
                        break;
                    case R.id.kontak:
                        Intent j = new Intent(TemanActivity.this, MenuKontak.class);
                        startActivity(j);
                        break;
                    case R.id.daftarteman:
                        Intent k = new Intent(TemanActivity.this, MenuDaftarTeman.class);
                        startActivity(k);
                        break;
                    default:
                        return true;
                }


                return true;

            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Setup Realm
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        realmHelper = new RealmHelper(realm);
        mahasiswaModels = new ArrayList<>();

        mahasiswaModels = realmHelper.getAllMahasiswa();

        show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mahasiswaAdapter.notifyDataSetChanged();
        show();
    }

    public void show(){
        mahasiswaAdapter = new TemanAdapter(this, mahasiswaModels);
        recyclerView.setAdapter(mahasiswaAdapter);
    }
}
