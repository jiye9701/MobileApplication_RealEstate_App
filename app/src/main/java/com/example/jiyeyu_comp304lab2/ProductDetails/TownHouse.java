package com.example.jiyeyu_comp304lab2.ProductDetails;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jiyeyu_comp304lab2.PaymentActivity;
import com.example.jiyeyu_comp304lab2.R;
import com.example.jiyeyu_comp304lab2.TownDetails.Town1;
import com.example.jiyeyu_comp304lab2.TownDetails.Town2;

import java.util.HashSet;
import java.util.Set;

public class TownHouse extends AppCompatActivity {



    //
    Set<String> setTown = new HashSet<String>();
    //preferences data variable
    SharedPreferences myPref;
    //variable to modify preference data
    SharedPreferences.Editor prefEditor;
    //
    String[] availableHouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_town_house);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);

        availableHouse = getResources().getStringArray(R.array.available_houses);
        //retrieving from shared preferences
        myPref = getSharedPreferences("info", MODE_PRIVATE);
        //check what's in shared preferences named townhouse
        //
        setTown = myPref.getStringSet("townhouse", new HashSet<String>());
        for (String strTown : setTown) {
            //Toast.makeText(this, "Selected Town house: " + strTown, Toast.LENGTH_SHORT).show();

            // restore the state of check boxes according to shared preferences values

        }

        String myString = myPref.getString("type", "");
        Toast.makeText(this, "Retrieving from shared preferences: " +  myString, Toast.LENGTH_SHORT).show();
        prefEditor = myPref.edit();

    }

    //
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkBoxtownhouse1:
                if (checked) {
                    setTown.add("950 Dundas Street East #30003");
                    for (String strTown : setTown)
                        Toast.makeText(this, "Selected Town house: " + strTown+ "\n$4,250", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(this, Town1.class);
                    startActivity(intent);
                } else {
                    setTown.remove("950 Dundas Street East #30003");
                }

                break;

            case R.id.checkBoxtownhouse2:
                if (checked) {
                    setTown.add("306 Bleecker Street");
                    for (String strTown : setTown)
                        Toast.makeText(this, "Selected Town house: " + strTown+  "\n$3,050", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(this, Town2.class);
                    startActivity(intent);
                } else {
                    setTown.remove("06 Bleecker Street");
                }

                break;

            default :
                break;
        }

    }
    public void onClickNext(View view)
    {

        Toast.makeText(this, "The number of you chose"+ setTown.size(), Toast.LENGTH_SHORT).show();


        for( String strTown : setTown ){
            Toast.makeText(this, "Selected Town house: " + strTown, Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, "The price: " + strTown, Toast.LENGTH_SHORT).show();
        }

        prefEditor.putStringSet("townhouse",setTown);
        prefEditor.commit();
        //
        Intent intent = new Intent(this, PaymentActivity.class);
        startActivity(intent);
    }

}