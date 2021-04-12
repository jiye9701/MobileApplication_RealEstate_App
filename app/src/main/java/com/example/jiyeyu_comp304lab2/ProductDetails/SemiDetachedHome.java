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
import com.example.jiyeyu_comp304lab2.SemiDetachedDetails.Semidetached1;
import com.example.jiyeyu_comp304lab2.SemiDetachedDetails.Semidetached2;
import com.example.jiyeyu_comp304lab2.SemiDetachedDetails.Semidetached3;

import java.util.HashSet;
import java.util.Set;

public class SemiDetachedHome extends AppCompatActivity {


    //
    Set<String> setSemidetached = new HashSet<String>();
    //preferences data variable
    SharedPreferences myPref;
    //variable to modify preference data
    SharedPreferences.Editor prefEditor;
    //
    String[] availableHouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semi_detached_home);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);

        //get available courses from string array
        availableHouse = getResources().getStringArray(R.array.available_houses);
        //retrieving from shared preferences
        myPref = getSharedPreferences("info", MODE_PRIVATE);
        //check what's in shared preferences named semidetached
        //
        setSemidetached = myPref.getStringSet("semidetached", new HashSet<String>());
        for (String strSemiDetached : setSemidetached) {
            //Toast.makeText(this, "Selected semidetached home: " + strSemiDetached, Toast.LENGTH_SHORT).show();

            // restore the state of check boxes according to shared preferences values

        }

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
            case R.id.checkBoxsemidetached1:
                if (checked) {
                    setSemidetached.add("146 Blackthorn Ave");
                    for (String strSemiDetached : setSemidetached)
                        Toast.makeText(this, "Selected semidetached home: " + strSemiDetached +  "\n$1,849", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(this, Semidetached1.class);
                    startActivity(intent);
                } else {
                    setSemidetached.remove("146 Blackthorn Ave");
                }

                break;

            case R.id.checkBoxsemidetached2:
                if (checked) {
                    setSemidetached.add("70 Grenadier Road");
                    for (String strSemiDetached : setSemidetached)
                        Toast.makeText(this, "Selected semidetached home: " + strSemiDetached +  "\n$5,000", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(this, Semidetached2.class);
                    startActivity(intent);
                } else {
                    setSemidetached.remove("70 Grenadier Road");
                }

                break;

            case R.id.checkBoxsemidetached3:
                if (checked) {
                    setSemidetached.add("783 Euclid Avenue");
                    for (String strSemiDetached : setSemidetached) {
                        Toast.makeText(this, "Selected semidetached home: "  + strSemiDetached +  "\n$3,900", Toast.LENGTH_LONG).show();

                        //
                        Intent intent = new Intent(this, Semidetached3.class);
                        startActivity(intent);
                    }
                }
                else
                    setSemidetached .remove( "783 Euclid Avenue" ) ;

                break;


            default :
                break;
        }

    }
    public void onClickNext(View view)
    {

        Toast.makeText(this, "The number of you chose"+ setSemidetached.size(), Toast.LENGTH_SHORT).show();

        //using enhanced for loop to show selected courses
        for( String strSemiDetached : setSemidetached ){
            Toast.makeText(this, "Selected semidetached home: " + strSemiDetached, Toast.LENGTH_SHORT).show();
        }
        //add the selected courses to shared preferences variable named courses
        prefEditor.putStringSet("semidetached",setSemidetached);
        prefEditor.commit();
        //
        Intent intent = new Intent(this, PaymentActivity.class);
        startActivity(intent);
    }
}