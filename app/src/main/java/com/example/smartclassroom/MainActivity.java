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
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailmain,passwordmain;
    private Button Login;
    private TextView forgotpasswordmain;

    private FirebaseAuth mAuth;
   // private ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main);

        TextView registermain = (TextView) findViewById(R.id.registermain);
        registermain.setOnClickListener(this);

        Login=(Button) findViewById(R.id.Login);
        Login.setOnClickListener(this);

        emailmain=(EditText)findViewById(R.id.emailmain);
       passwordmain=(EditText)findViewById(R.id.passwordmain);

      // progressBar2=(ProgressBar) findViewById(R.id.progressBar2);
       mAuth=FirebaseAuth.getInstance();
       forgotpasswordmain=(TextView)findViewById(R.id.forgotpasswordmain);
       forgotpasswordmain.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.registermain:
                startActivity(new Intent(this, Register.class));
            break;

            case R.id.Login:
                //progressBar2.setVisibility(View.VISIBLE);
                Login();
                break;
            case R.id.forgotpasswordmain:
                startActivity(new Intent(this,ForgotPassword.class));
                break;


        }
    }

    private void Login() {
        //progressBar2.setVisibility(View.GONE);

        String email1= emailmain.getText().toString().trim();
        String password1= passwordmain.getText().toString().trim();

        if(email1.isEmpty()){
            emailmain.setError("Email is required");
            emailmain.requestFocus();
            return;

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email1).matches()){
            emailmain.setError("Please provide valid email");
            emailmain.requestFocus();
            return;
        }
        if(password1.isEmpty()){
            passwordmain.setError("Password is required");
            passwordmain.requestFocus();
            return;

        }
        if(password1.length()<6){
            passwordmain.setError("Min password length should be 6 characters!");
            passwordmain.requestFocus();
            return;

        }
       // progressBar2.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email1,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user =FirebaseAuth.getInstance().getCurrentUser();
                    if (user.isEmailVerified()){
                        startActivity(new Intent(MainActivity.this,departments.class));
                       // progressBar2.setVisibility(View.GONE);
                    }else{
                        user.sendEmailVerification();
                        Toast.makeText(MainActivity.this,"Check email to verify account!!",Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(MainActivity.this,"Failed to login!!",Toast.LENGTH_LONG).show();
                   //progressBar2.setVisibility(View.GONE);
                }
            }
        });

    }
}

