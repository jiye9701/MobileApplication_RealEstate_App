package com.example.jiyeyu_comp304lab2.ProductDetails;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jiyeyu_comp304lab2.ApartmentDetails.Apart1;
import com.example.jiyeyu_comp304lab2.ApartmentDetails.Apart2;
import com.example.jiyeyu_comp304lab2.ApartmentDetails.Apart3;
import com.example.jiyeyu_comp304lab2.PaymentActivity;
import com.example.jiyeyu_comp304lab2.R;

import java.util.HashSet;
import java.util.Set;

public class Apartment<setAparts> extends AppCompatActivity {

    Set<String> setAparts = new HashSet<String>();
    //preferences data variable
    SharedPreferences myPref;
    //variable to modify preference data
    SharedPreferences.Editor prefEditor;
    //
    String[] availableHouse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);


        //get available courses from string array
        availableHouse = getResources().getStringArray(R.array.available_houses);
        //retrieving from shared preferences
        myPref = getSharedPreferences("info", MODE_PRIVATE);
        //check what's in shared preferences named aparts
        //
        setAparts = myPref.getStringSet("aparts", new HashSet<String>());


        String myString = myPref.getString("type", "");
        Toast.makeText(this, "Retrieving from shared preferences: " + myString, Toast.LENGTH_SHORT).show();
        prefEditor = myPref.edit();

    }

    //
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkBoxApart1:
                if (checked) {
                    setAparts.add("1 Newholm Road");
                    for (String strApart : setAparts)
                    Toast.makeText(this, "Selected apartments: " +  strApart+"\n$1,750", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(this, Apart1.class);
                    startActivity(intent);
                    }
                else {
                    setAparts.remove("1 Newholm Road");
                }


                break;

            case R.id.checkBoxApart2:
                if (checked) {
                    setAparts.add("63, 73 \u0026 120 Widdicombe Hill Blvd");
                    for (String strApart : setAparts)
                        Toast.makeText(this, "Selected apartments: "  +  strApart+ "\n$1,800", Toast.LENGTH_LONG).show();
                    //
                    Intent intent = new Intent(this, Apart2.class);
                    startActivity(intent);
                    }
                else
                    {
            setAparts.remove("63, 73 \u0026 120 Widdicombe Hill Blvd");
                    }

                break;

            case R.id.checkBoxApart3:
                if (checked) {
                    setAparts.add("110 Jameson Ave");
                    for (String strApart : setAparts)
                        Toast.makeText(this, "Selected apartments: "  +  strApart+  "\n$1,295", Toast.LENGTH_LONG).show();
                    //
                    Intent intent = new Intent(this, Apart3.class);
                    startActivity(intent);
                    }
                else
                    setAparts .remove( "110 Jameson Ave" ) ;

                break;


            default :
                break;
        }

    }

    public void onClickNext(View view)
    {

        Toast.makeText(this, "The number of you chose"+ setAparts.size(), Toast.LENGTH_SHORT).show();

        //using enhanced for loop to show selected courses
        for( String strAparts : setAparts ){
            Toast.makeText(this, "Selected apartments: " + strAparts, Toast.LENGTH_SHORT).show();
        }

        //
        Intent intent = new Intent(this, PaymentActivity.class);
        startActivity(intent);
    }

}