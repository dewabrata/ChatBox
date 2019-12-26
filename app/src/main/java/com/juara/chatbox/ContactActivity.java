package com.juara.chatbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ContactActivity extends AppCompatActivity {

    ModelChat mc;
    ImageView image;
    EditText txtNama, txtTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        mc = getIntent().getParcelableExtra("data");

        txtNama = findViewById(R.id.txtNama);
        txtTanggal = findViewById(R.id.txtTanggal);
        image = findViewById(R.id.image);

        txtNama.setText(mc.getText());
        txtTanggal.setText(mc.getDate());

        Picasso.get().load(mc.getImage()).into(image);



    }
}
