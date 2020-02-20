package com.epb.techtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ImpPalestras2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imp_palestras_2);
    }
    public void clickimage2_1(View v)
    {
        Toast.makeText(this, "Show 3", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(ImpPalestras2Activity.this, ImpPalestras3Activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slider_in_right,R.anim.slider_out_left);

    }
    public void clickimage2_2(View v)
    {
        Toast.makeText(this, "Show 1", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(ImpPalestras2Activity.this, ImpPalestras1Activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slider_in_left,R.anim.slider_out_right);

    }
}
