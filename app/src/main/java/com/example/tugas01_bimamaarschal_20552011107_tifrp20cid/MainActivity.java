package com.example.tugas01_bimamaarschal_20552011107_tifrp20cid;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

//Main Code-Bima(20552011107)

public class MainActivity extends AppCompatActivity {

    Button kirim;
    EditText nik, nama, tempatlahir, tanggallahir, alamat;

    RadioGroup jeniskelamin, pekerjaan, status;
    RadioButton btnjeniskelamin, btnpekerjaan, btnstatus;

    String snik, snama, stempatlahir, stanggallahir, sjeniskelamin, spekerjaan, sstatus, salamat;

    private SimpleDateFormat dateFormatter;
    private EditText stttanggallahir;
    public ImageButton sbtn_date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kirim = findViewById(R.id.kirim);
        nik = findViewById(R.id.nik);
        nama = findViewById(R.id.nama);
        tempatlahir = findViewById(R.id.tempatlahir);

        sbtn_date = findViewById(R.id.btn_date);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        stttanggallahir = findViewById(R.id.tanggallahir);
        tanggallahir = findViewById(R.id.tanggallahir);


        jeniskelamin = (RadioGroup) findViewById(R.id.jeniskelamin);
        pekerjaan = (RadioGroup) findViewById(R.id.pekerjaan);
        status = (RadioGroup) findViewById(R.id.status);

        alamat = findViewById(R.id.alamat);


        sbtn_date.setOnClickListener(view -> showDateDialog());


        kirim.setOnClickListener(v -> {
            snik = nik.getText().toString();
            snama = nama.getText().toString();
            stempatlahir = tempatlahir.getText().toString();
            stanggallahir = tanggallahir.getText().toString();

            int selectjeniskelamin = jeniskelamin.getCheckedRadioButtonId();
            btnjeniskelamin = (RadioButton) findViewById(selectjeniskelamin);
            sjeniskelamin = btnjeniskelamin.getText().toString();

            int selectpekerjaan = pekerjaan.getCheckedRadioButtonId();
            btnpekerjaan = (RadioButton) findViewById(selectpekerjaan);
            spekerjaan = btnpekerjaan.getText().toString();

            int selectstatus = status.getCheckedRadioButtonId();
            btnstatus = (RadioButton) findViewById(selectstatus);
            sstatus = btnstatus.getText().toString();

            salamat = alamat.getText().toString();

            Intent i = new Intent(MainActivity.this, DetailActivity.class);

            if (snik.equals("") || snama.equals("") || stempatlahir.equals("") || stanggallahir.equals("") || sjeniskelamin.equals("") || spekerjaan.equals("") || sstatus.equals("") || salamat.equals("")) {
                Toast.makeText(MainActivity.this, "Tidak boleh ada data yang kosong !", Toast.LENGTH_LONG).show();
            } else {
                i.putExtra("nik", snik);
                i.putExtra("nama", snama);
                i.putExtra("tempatlahir", stempatlahir);
                i.putExtra("tanggallahir", stanggallahir);
                i.putExtra("jeniskelamin", sjeniskelamin);
                i.putExtra("pekerjaan", spekerjaan);
                i.putExtra("status", sstatus);
                i.putExtra("alamat", salamat);
                startActivity(i);
            }

        });

    }

    //Calendar Code-Bima(20552011107)

    private void showDateDialog() {

        Calendar newCalendar = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year, monthOfYear, dayOfMonth) -> {

            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            stttanggallahir.setText(dateFormatter.format(newDate.getTime()));

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }


}