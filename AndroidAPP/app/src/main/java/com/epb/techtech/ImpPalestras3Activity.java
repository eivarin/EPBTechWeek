package com.epb.techtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ImpPalestras3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imp_palestras_3);
    }

    public void clickimage3_1(View v)
    {
        Toast.makeText(this, "there are no more activities", Toast.LENGTH_LONG).show();
    }
    public void clickimage3_2(View v)
    {
        Toast.makeText(this, "Show 2", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(ImpPalestras3Activity.this, ImpPalestras2Activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slider_in_left,R.anim.slider_out_right);
    }
}
