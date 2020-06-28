package com.example.contact_list;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;

public class Second_screen extends AppCompatActivity {
    ImageView myimg;
    TextView contacts,detail;
    String Data1, Data2;
    int myimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seocnd_screen);
        myimg= findViewById(R.id.imageView);
        contacts= findViewById(R.id.title);  //title
        detail= findViewById(R.id.description); //description
        getData();
        setData();
        setContentView(R.layout.activity_seocnd_screen);

    }
    private void getData()
    {
        if( getIntent().hasExtra("myimage") && getIntent().hasExtra("Data1") && getIntent().hasExtra("Data2")) {
            Data1 = getIntent().getStringExtra("Data1");
            Data2 = getIntent().getStringExtra("Data2");
            myimage = getIntent().getIntExtra("myimage", 0);
        }
        else
        {
            Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
        }


    }
    private void  setData()
    {
        contacts.setText(Data1);
        detail.setText(Data2);
        myimg.setImageResource(myimage);
    }

}
