package com.example.jiyeyu_comp304lab2.CondominiumDetails;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jiyeyu_comp304lab2.R;

public class Condo1 extends AppCompatActivity implements View.OnClickListener {

    private Button btn_previous, btn_next;

    private ViewFlipper vf;



    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_condo1);



        btn_previous = findViewById(R.id.btn_previous);

        btn_next = findViewById(R.id.btn_next);

        vf = findViewById(R.id.vf);



        btn_previous.setOnClickListener(this);

        btn_next.setOnClickListener(this);




    }

    public void onClick(View v){

        switch(v.getId())

        {

            case R.id.btn_previous:

                vf.showPrevious();

                toast("Previous");

                break;

            case R.id.btn_next:

                vf.showNext();

                toast("Next");

                break;

        }

    }



    public void toast(String text){

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

    }

}