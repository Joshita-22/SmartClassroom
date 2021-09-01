package com.example.smartclassroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Ise_Department extends AppCompatActivity implements View.OnClickListener {
    private CardView class101, class102, class103, class104, class105, class106, class107, class108, class109, corridor;



    
    String classnames[] = {"Class 101", "Class 102", "Class 103", "Class 104", "Class 105", "Class 105", "Class 106",
            "Class 107", "Class 108", "Class 109", "corridor"};

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ise__department);
        class101=findViewById(R.id.class101);
        class102=findViewById(R.id.class102);
        class103=findViewById(R.id.class103);
        class104=findViewById(R.id.class104);
        class105=findViewById(R.id.class105);
        class106=findViewById(R.id.class106);
        class107=findViewById(R.id.class107);
        class108=findViewById(R.id.class108);
        class109=findViewById(R.id.class109);
        corridor=findViewById(R.id.corridor);
        class101.setOnClickListener(this);
        class102.setOnClickListener(this);
        class103.setOnClickListener(this);
        class104.setOnClickListener(this);
        class105.setOnClickListener(this);
        class106.setOnClickListener(this);
        class107.setOnClickListener(this);
        class108.setOnClickListener(this);
        class109.setOnClickListener(this);
        corridor.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Ise_Department.this, class101.class);
        switch(v.getId()){
            case R.id.class101:
                intent.putExtra("class name", classnames[0] );
                startActivity(intent);
                break;
            case R.id.class102:
                intent.putExtra("class name", classnames[1]);
                startActivity(intent);
                break;
            case R.id.class103:
                intent.putExtra("class name", "Class 103" );
                startActivity(intent);
                break;
            case R.id.class104:
                intent.putExtra("class name", "Class 104" );
                startActivity(intent);
                break;
            case R.id.class105:
                intent.putExtra("class name", "Class 105" );
                startActivity(intent);
                break;
            case R.id.class106:
                intent.putExtra("class name", "Class 106" );
                startActivity(intent);
                break;
            case R.id.class107:
                intent.putExtra("class name", "Class 107" );
                startActivity(intent);
                break;
            case R.id.class108:
                intent.putExtra("class name", "Class 108" );
                startActivity(intent);
                break;
            case R.id.class109:
                intent.putExtra("class name", "Class 109" );
                startActivity(intent);
                break;
            case R.id.corridor:
                intent.putExtra("class name", "Corridor" );
                startActivity(intent);
                break;
        }
    }
}