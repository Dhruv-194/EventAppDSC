package com.example.minervamun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText textEmail, textPassword;
    Button Loginbtn;
    ProgressBar progressBar;
    TextView Gotosignup;

    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser()!=null)
        {
            Intent i = new Intent(MainActivity.this,GroupChatOne.class);
            startActivity(i);
        }

        else {
            setContentView(R.layout.activity_main);
            textEmail = findViewById(R.id.EmailAddress);
            textPassword = findViewById(R.id.editTextTextPassword);
            Loginbtn = findViewById(R.id.LoginBtn);
            progressBar = findViewById(R.id.progressBarLogin);
            Gotosignup = findViewById(R.id.gotosign);


            Loginbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String email= textEmail.getText().toString();
                String password = textPassword.getText().toString();

                if(!email.equals("") && !password.equals("") )
                {
                    auth.signInWithEmailAndPassword(email,password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful())
                                    {
                                        progressBar.setVisibility(View.GONE);
                                        Toast.makeText(getApplicationContext(),"Login Successful", Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(MainActivity.this,GroupChatOne.class);
                                        startActivity(i);
                                    }
                                    else {
                                        Toast.makeText(MainActivity.this, "Wrong Email/Password",Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });
                }

                }
            });
            Gotosignup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                    startActivity(i);
                }
            });

        }

    }
}