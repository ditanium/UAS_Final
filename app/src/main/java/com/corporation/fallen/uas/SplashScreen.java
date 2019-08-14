/*
Tanggal Pengerjaan : 20-05-2019
NIM                : 10116115
Nama               : Aditya Komara Ramadhan
Kelas              : IF-3
 */
package com.corporation.fallen.uas;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                finish();
            }
        },2000);

    }
}
