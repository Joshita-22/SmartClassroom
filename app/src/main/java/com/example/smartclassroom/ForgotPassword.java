package com.example.smartclassroom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    private EditText resetemail;
    private Button resetpassword;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forgot_password);

        resetemail=(EditText)findViewById(R.id.resetemail);
        resetpassword=(Button)findViewById(R.id.resetpassword);

        auth=FirebaseAuth.getInstance();
        resetpassword.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });


    }
    private void resetPassword(){
        String email= resetemail.getText().toString().trim();
        if(email.isEmpty()){
            resetemail.setError("Email is required");
            resetemail.requestFocus();
            return;

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            resetemail.setError("Please provide valid email");
            resetemail.requestFocus();
            return;
        }
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(ForgotPassword.this, "check your email to reset your password", Toast.LENGTH_LONG).show();
                }
                    else{
                        Toast.makeText(ForgotPassword.this,"Try again!!Something wrong happened",Toast.LENGTH_LONG).show();

                    }


            }
        });
    }
}