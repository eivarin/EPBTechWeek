package com.epb.techtech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.epb.techtech.ui.notifications.NotificationsFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {


    private void hideNavegationBar()





    {
        this.getWindow().getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                );
    }



    private EditText userName, userPassword, userEmail;
    private Button regButton;
    private TextView UserLogin;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        hideNavegationBar();
        setupUIViews();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    //upload data to the database
                    String user_email = userEmail.getText().toString().trim();
                    String user_password = userPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                Toast.makeText(RegistrationActivity.this, "Registado com Sucesso!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegistrationActivity.this, NotificationsFragment.class));

                            } else {

                                Toast.makeText(RegistrationActivity.this, "Registo Falhou", Toast.LENGTH_SHORT).show();

                            }

                        }
                    });

                }
            }
        });


        UserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View view) {
                        startActivity(new Intent(RegistrationActivity.this, NotificationsFragment.class));
            }
        });
    }


    private void setupUIViews () {
        userName = (EditText)findViewById(R.id.etUserName);
        userPassword = (EditText)findViewById(R.id.etUserPassword);
        userEmail = (EditText)findViewById(R.id.etUserEmail);
        regButton = (Button) findViewById(R.id.btnRegister);
        UserLogin = (TextView) findViewById(R.id.tvUserLogin);
    }

    private Boolean validate() {
        Boolean result = false;
        String name =   userName.getText().toString();
        String password = userPassword.getText().toString();
        String email = userEmail.getText().toString();

        if(name.isEmpty() && (password.isEmpty() && (email.isEmpty()))) {
            Toast.makeText(this, "Têm que indicar todos os dados necessários", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }
        return result;
    }



















}
