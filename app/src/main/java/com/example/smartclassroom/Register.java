package com.example.smartclassroom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements View.OnClickListener {
    private TextView banner,register;
    private EditText fullname,email,password;
    private ProgressBar progressbar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        banner =(TextView) findViewById(R.id.banner);
        banner.setOnClickListener(this);

        register=(Button) findViewById(R.id.register);
        register.setOnClickListener(this);

        fullname=(EditText)findViewById(R.id.fullname);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        progressbar=(ProgressBar)findViewById(R.id.progressbar);




    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.banner:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.register:
                register();
                break;


        }

    }

    private void register() {
        String emaill = email.getText().toString().trim();
        String passwordd = password.getText().toString().trim();
        String namee = fullname.getText().toString().trim();

        if(namee.isEmpty()){
            fullname.setError("Full name is required");
            fullname.requestFocus();
            return;

        }

        if(emaill.isEmpty()){
            email.setError("Email is required");
            email.requestFocus();
            return;

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(emaill).matches()){
            email.setError("Please provide valid email");
            email.requestFocus();
            return;
        }
        if(passwordd.isEmpty()){
            password.setError("Password is required");
            password.requestFocus();
            return;

        }
        if(passwordd.length()<6){
            password.setError("Min password length should be 6 characters!");
            password.requestFocus();
            return;

        }
        progressbar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(emaill,passwordd)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(namee,emaill);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(Register.this,"User has been registered successfully!",Toast.LENGTH_LONG).show();
                                        progressbar.setVisibility(View.GONE);
                                        //redirect to login layout!!
                                    } else{
                                        Toast.makeText(Register.this,"Failed to register!Try again!",Toast.LENGTH_LONG).show();
                                        progressbar.setVisibility(View.GONE);

                                    }
                                }
                            });

                        }else{
                            Toast.makeText(Register.this,"Already registered",Toast.LENGTH_LONG).show();
                            progressbar.setVisibility(View.GONE);

                        }
                    }
                });


    }
}