package com.example.smartclassroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ise_Department extends AppCompatActivity implements View.OnClickListener {
    private CardView class101, class102, class103, class104, class105, class106, class107, class108, class109, corridor;


    int[] ids = new int[]{R.id.class101, R.id.class102, R.id.class103, R.id.class104,R.id.class105,R.id.class106,R.id.class107,R.id.class108,R.id.class109,R.id.corridor};


    CardView classes[] = new CardView[ids.length];

    String classnames[] = {"Class 101", "Class 102", "Class 103", "Class 104", "Class 105", "Class 105", "Class 106",
            "Class 107", "Class 108", "Class 109", "corridor"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ise__department);

        for (int i =0; i<ids.length;i++)
        {
            classes[i] = findViewById(ids[i]);
        }


        for (int i =0; i<ids.length;i++)
        {
            classes[i].setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Ise_Department.this, class101.class);

        for (int i=0; i<ids.length; i++){
            if(v.getId()==ids[i]){
                intent.putExtra("class name", classnames[i] );
                startActivity(intent);
            }
        }
    }
}