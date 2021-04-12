package com.example.jiyeyu_comp304lab2.ProductDetails;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jiyeyu_comp304lab2.CondominiumDetails.Condo1;
import com.example.jiyeyu_comp304lab2.CondominiumDetails.Condo2;
import com.example.jiyeyu_comp304lab2.CondominiumDetails.Condo3;
import com.example.jiyeyu_comp304lab2.CondominiumDetails.Condo4;
import com.example.jiyeyu_comp304lab2.PaymentActivity;
import com.example.jiyeyu_comp304lab2.R;

import java.util.HashSet;
import java.util.Set;

public class Condominium extends AppCompatActivity {

    //
    Set<String> setCondos = new HashSet<String>();
    //preferences data variable
    SharedPreferences myPref;
    //variable to modify preference data
    SharedPreferences.Editor prefEditor;
    //
    String[] availableHouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condominium);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);

        //get available courses from string array
        availableHouse = getResources().getStringArray(R.array.available_houses);
        //retrieving from shared preferences
        myPref = getSharedPreferences("info", MODE_PRIVATE);
        //check what's in shared preferences named condos
        //
        setCondos = myPref.getStringSet("condos", new HashSet<String>());
        for (String strCondo : setCondos) {
            //Toast.makeText(this, "Selected condos: " + strCondo, Toast.LENGTH_SHORT).show();

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
            case R.id.checkBoxCondo1:
                if (checked) {
                    setCondos.add("Gibson Sq South Tower");
                    for (String strCondo : setCondos)
                        Toast.makeText(this, "Selected condos: Gibson Sq South Tower" + "\n$2,500", Toast.LENGTH_LONG).show();


                    Intent intent = new Intent(this, Condo1.class);
                    startActivity(intent);
                } else {
                    setCondos.remove("Gibson Sq South Tower");
                }

                break;

            case R.id.checkBoxCondo2:
                if (checked) {
                    setCondos.add("Bay Street Corridor");
                    for (String strCondo : setCondos)
                        Toast.makeText(this, "Selected condos: Bay Street Corridor" +  "\n$2,000", Toast.LENGTH_LONG).show();

                    //
                    Intent intent = new Intent(this, Condo2.class);
                    startActivity(intent);
                } else {
                }
                setCondos.remove("Bay Street Corridor");


                break;

            case R.id.checkBoxCondo3:
                if (checked) {
                    setCondos.add("Henry Farm");
                    for (String strCondo : setCondos)
                        Toast.makeText(this, "Selected condos: Henry Farm" +  "\n$2,000", Toast.LENGTH_LONG).show();

                    //
                    Intent intent = new Intent(this, Condo3.class);
                    startActivity(intent);
                } else {
                }
                setCondos.remove("Henry Farm");


                break;



            case R.id.checkBoxCondo4:
                if (checked) {
                    setCondos.add("Waterfront Communities C1");
                    for (String strCondo : setCondos) {
                        Toast.makeText(this, "Selected condos: Waterfront Communities C1" + "\n$1,800", Toast.LENGTH_LONG).show();

                        //
                        Intent intent = new Intent(this, Condo4.class);
                        startActivity(intent);
                    }
                }
                else
                    setCondos .remove( "Waterfront Communities C1" ) ;

                break;


            default :
                break;
        }

    }
    public void onClickNext(View view)
    {

        Toast.makeText(this, "The number of you chose"+ setCondos.size(), Toast.LENGTH_SHORT).show();

        //using enhanced for loop to show selected courses
        for( String strCondos : setCondos ){
            Toast.makeText(this, "Selected condos: " + strCondos, Toast.LENGTH_SHORT).show();

        }
        //add the selected courses to shared preferences variable named courses
        prefEditor.putStringSet("condos",setCondos);
        prefEditor.commit();
        //
        Intent intent = new Intent(this, PaymentActivity.class);
        startActivity(intent);
    }
}