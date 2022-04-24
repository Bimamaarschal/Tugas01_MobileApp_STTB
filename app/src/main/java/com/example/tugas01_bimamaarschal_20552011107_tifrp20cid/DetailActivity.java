package com.example.tugas01_bimamaarschal_20552011107_tifrp20cid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

//Detail Code-Bima(20552011107)

public class DetailActivity extends AppCompatActivity {

    EditText hs_nik, hs_nama, hs_tempatlahir, hs_tanggallahir, hs_jeniskelamin, hs_pekerjaan, hs_status, hs_alamat;
    String nik, nama, tempatlahir, tanggallahir, jeniskelamin, pekerjaan, status, alamat;
    Button kembali;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        hs_nik = (EditText) findViewById(R.id.hs_nik);
        hs_nama = (EditText) findViewById(R.id.hs_nama);
        hs_tempatlahir = (EditText) findViewById(R.id.hs_tempatlahir);
        hs_tanggallahir = (EditText) findViewById(R.id.hs_tanggallahir);
        hs_jeniskelamin = (EditText) findViewById(R.id.hs_jeniskelamin);
        hs_pekerjaan = (EditText) findViewById(R.id.hs_pekerjaan);
        hs_status = (EditText) findViewById(R.id.hs_status);
        hs_alamat = (EditText) findViewById(R.id.hs_alamat);

        Button kembali = findViewById(R.id.kembali);

        if (getIntent().getStringExtra("nik") != null) {
            nik = getIntent().getStringExtra("nik");
            hs_nik.setText(nik);
        }
        if (getIntent().getStringExtra("nama") != null) {
            nama = getIntent().getStringExtra("nama");
            hs_nama.setText(nama);
        }
        if (getIntent().getStringExtra("tempatlahir") != null) {
            tempatlahir = getIntent().getStringExtra("tempatlahir");
            hs_tempatlahir.setText(tempatlahir);
        }
        if (getIntent().getStringExtra("tanggallahir") != null) {
            tanggallahir = getIntent().getStringExtra("tanggallahir");
            hs_tanggallahir.setText(tanggallahir);
        }
        if (getIntent().getStringExtra("jeniskelamin") != null) {
            jeniskelamin = getIntent().getStringExtra("jeniskelamin");
            hs_jeniskelamin.setText(jeniskelamin);
        }
        if (getIntent().getStringExtra("pekerjaan") != null) {
            pekerjaan = getIntent().getStringExtra("pekerjaan");
            hs_pekerjaan.setText(pekerjaan);
        }
        if (getIntent().getStringExtra("status") != null) {
            status = getIntent().getStringExtra("status");
            hs_status.setText(status);
        }
        if (getIntent().getStringExtra("alamat") != null) {
            alamat = getIntent().getStringExtra("alamat");
            hs_alamat.setText(alamat);
        }

//Back Button Code-Bima(20552011107)

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailActivity.this, MainActivity.class));
            }
        });

    }

}