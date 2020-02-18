package com.epb.techtech;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ImpPalestras1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imp_palestras_1);


    }
    public void clickimage(View v)
    {
        Toast.makeText(this, "Show 2", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(ImpPalestras1Activity.this, ImpPalestras2Activity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slider_in_right,R.anim.slider_out_left);
    }


}

