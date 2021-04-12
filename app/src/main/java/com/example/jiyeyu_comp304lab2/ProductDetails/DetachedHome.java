package com.example.jiyeyu_comp304lab2.ProductDetails;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jiyeyu_comp304lab2.DetacedHomeDetails.Detached1;
import com.example.jiyeyu_comp304lab2.DetacedHomeDetails.Detached2;
import com.example.jiyeyu_comp304lab2.PaymentActivity;
import com.example.jiyeyu_comp304lab2.R;

import java.util.HashSet;
import java.util.Set;

public class DetachedHome extends AppCompatActivity {


    //
    Set<String> setDetached = new HashSet<String>();


    //preferences data variable
    SharedPreferences myPref;
    //variable to modify preference data
    SharedPreferences.Editor prefEditor;
    //
    String[] availableHouse;

//    CheckBox checkBox = (CheckBox) findViewById(R.id.checkBoxDetached1) ;
//    CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBoxDetached2) ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detached_home);
        //get available courses from string array
        availableHouse = getResources().getStringArray(R.array.available_houses);
        //retrieving from shared preferences
        myPref = getSharedPreferences("info", MODE_PRIVATE);
        //check what's in shared preferences named detached
        //
        setDetached = myPref.getStringSet("detached", new HashSet<String>());
        for (String strDetached : setDetached) {
            //Toast.makeText(this, "Selected detached home: " + strDetached, Toast.LENGTH_SHORT).show();

            // restore the state of check boxes according to shared preferences values

        }

        String myString = myPref.getString("type", "");
        Toast.makeText(this, "Retrieving from shared preferences: " + myString, Toast.LENGTH_SHORT).show();
        prefEditor = myPref.edit();

//        if (checkBox.isChecked()) {
//            Toast.makeText(this, "Please price: " + "$2,600", Toast.LENGTH_SHORT).show();
//
//        } else if (checkBox2.isChecked()) {
//            Toast.makeText(this, "Please price: " + "$2,599", Toast.LENGTH_SHORT).show();
//
//        }




    }

    //
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkBoxDetached1:

                if (checked) {

                    setDetached.add("139 Hay Avenue");
                    for (String strDetached : setDetached)
                        Toast.makeText(this, "Selected detached home: " + strDetached + "\n$2,600", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(this, Detached1.class);
                    startActivity(intent);
                } else {
                    setDetached.remove("139 Hay Avenue");
                }

                break;


            case R.id.checkBoxDetached2:

                if (checked) {
                    setDetached.add("55 Spadina Rd");

                    Intent intent = new Intent(this, Detached2.class);
                    startActivity(intent);

                    for (String strDetached : setDetached) {
                        Toast.makeText(this, "Selected detached home: " + strDetached + "\n$2,600", Toast.LENGTH_LONG).show();

                        //

                    }
                }
                else
                    setDetached .remove( "55 Spadina Rd" ) ;

                break;


            default :
                break;
        }

    }
    public void onClickNext(View view) {


        Toast.makeText(this, "The number of you chose" + setDetached.size(), Toast.LENGTH_SHORT).show();

        //using enhanced for loop to show selected courses


        for (String strDetached : setDetached) {
            Toast.makeText(this, "Selected detached home: " + strDetached, Toast.LENGTH_SHORT).show();
        }
        //add the selected courses to shared preferences variable named courses
        prefEditor.putStringSet("detached", setDetached);
        prefEditor.commit();
        //
        Intent intent = new Intent(this, PaymentActivity.class);
        startActivity(intent);


    }



}