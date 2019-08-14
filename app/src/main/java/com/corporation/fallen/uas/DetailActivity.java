/*
Tanggal Pengerjaan : 14-08-2019
NIM                : 10116115
Nama               : Aditya Komara Ramadhan
Kelas              : IF-3
 */
package com.corporation.fallen.uas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNim, etNama, etKls, etTelepon, etEmail, etSm;
    String nim, nama, kls, telepon, email, sm;
    Integer id;
    Button btn_ubah, btn_hapus, btn_kembali;
    RealmHelper realmHelper;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Set up
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);
        realmHelper = new RealmHelper(realm);

        // Inisialisasi
        etNim = findViewById(R.id.etNim);
        etNama = findViewById(R.id.etNama);
        etKls = findViewById(R.id.etKls);
        etTelepon = findViewById(R.id.etTelepon);
        etEmail = findViewById(R.id.etEmail);
        etSm = findViewById(R.id.etSm);
        btn_ubah = findViewById(R.id.btnUpdate);
        btn_hapus = findViewById(R.id.btnHapus);
        btn_kembali = findViewById(R.id.btnCancel);

        id = Integer.parseInt(getIntent().getStringExtra("id"));
        nim = getIntent().getStringExtra("nim");
        nama = getIntent().getStringExtra("nama");
        kls = getIntent().getStringExtra("kls");
        telepon = getIntent().getStringExtra("telepon");
        email = getIntent().getStringExtra("email");
        sm = getIntent().getStringExtra("sm");

        etNim.setText(nim);
        etNama.setText(nama);
        etKls.setText(kls);
        etTelepon.setText(telepon);
        etEmail.setText(email);
        etSm.setText(sm);

        btn_kembali.setOnClickListener(this);
        btn_hapus.setOnClickListener(this);
        btn_ubah.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btn_ubah){
            realmHelper.update(id, Integer.parseInt(etNim.getText().toString()),etNama.getText().toString(),etKls.getText().toString(),Integer.parseInt(etTelepon.getText().toString()),etEmail.getText().toString(),etSm.getText().toString());
            Toast.makeText(DetailActivity.this, "Update Success", Toast.LENGTH_SHORT).show();
            etNim.setText("");
            etNama.setText("");
            etKls.setText("");
            etTelepon.setText("");
            etEmail.setText("");
            etSm.setText("");
            finish();
        }else if (v == btn_hapus) {
            realmHelper.delete(id);
            Toast.makeText(DetailActivity.this, "Delete Success", Toast.LENGTH_SHORT).show();
            finish();
        }else if (v == btn_kembali) {
            startActivity(new Intent(DetailActivity.this, TemanActivity.class));
            finish();
        }
    }
}
