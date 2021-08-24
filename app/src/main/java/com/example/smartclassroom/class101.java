package com.example.smartclassroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Random;

public class class101 extends AppCompatActivity {
    ImageView lighton,lightoff;
    TextView light;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class101);
        lighton=(ImageView)findViewById(R.id.lighton);
        lightoff=(ImageView)findViewById(R.id.lightoff);
        light=(TextView)findViewById(R.id.light);

        Random rand = new Random();
        int a=rand.nextInt(2);
       // Log.i("info","random number is"+a);


        HashMap<String,Object> map = new HashMap<>();
        map.put("light_status",a);
        FirebaseDatabase.getInstance().getReference().child("Ise department").child("class101").updateChildren(map);
        if(a==1){
            light.setText("Light_Status:"+" " +Integer.toString(a)+" "+"ON!!");
            lighton.setVisibility(View.VISIBLE);
            lightoff.setVisibility(View.INVISIBLE);
        }else{
            light.setText("Light_Status:"+" " +Integer.toString(a)+" "+"OFF!!");
            lightoff.setVisibility(View.VISIBLE);
            lighton.setVisibility(View.INVISIBLE);
        }

    }

}