package com.example.smartclassroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ise_Department extends AppCompatActivity implements View.OnClickListener {
    private CardView class101,class102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ise__department);
        class101=(CardView)findViewById(R.id.class101);
        class102=(CardView)findViewById(R.id.class102);
        class101.setOnClickListener(this);
        class102.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.class101:
                startActivity(new Intent(Ise_Department.this, class101.class));
                break;
            case R.id.class102:
                startActivity(new Intent(Ise_Department.this, class102.class));
                break;

        }
    }
}