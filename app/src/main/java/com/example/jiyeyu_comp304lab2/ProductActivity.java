package com.example.jiyeyu_comp304lab2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.jiyeyu_comp304lab2.ProductDetails.Apartment;
import com.example.jiyeyu_comp304lab2.ProductDetails.Condominium;
import com.example.jiyeyu_comp304lab2.ProductDetails.DetachedHome;
import com.example.jiyeyu_comp304lab2.ProductDetails.SemiDetachedHome;
import com.example.jiyeyu_comp304lab2.ProductDetails.TownHouse;


public class ProductActivity extends MainActivity {

    private SharedPreferences myPreference;
    //variable to modify preference data
    SharedPreferences.Editor prefEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    //
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.apartment:
                Toast.makeText(this, "You selected Apartment", Toast.LENGTH_LONG).show();
                //instantiate the preference data variable
                myPreference = getSharedPreferences("info", 0);
                //prepare it for edit by creating and Edit object
                prefEditor = myPreference.edit();
                //store "set" in  a preference named "program"
                prefEditor.putString("houseType", "Home");
                //commit the transaction
                prefEditor.commit();

                intent = new Intent(this, Apartment.class);
                startActivity(intent);
                break;

            case R.id.detachedHome:
                Toast.makeText(this, "You selected Detached Home", Toast.LENGTH_LONG).show();
                intent = new Intent(this, DetachedHome.class);
                startActivity(intent);
                break;

            case R.id.semiDetachedHome:
                Toast.makeText(this, "You selected Semi-detached Home", Toast.LENGTH_LONG).show();
                intent = new Intent(this, SemiDetachedHome.class);
                startActivity(intent);
                break;

            case R.id.condominium:
                Toast.makeText(this, "You selected Condominium", Toast.LENGTH_LONG).show();
                intent = new Intent(this, Condominium.class);
                startActivity(intent);
                break;

            case R.id.townHouse:
                Toast.makeText(this, "You selected Town House", Toast.LENGTH_LONG).show();
                intent = new Intent(this, TownHouse.class);
                startActivity(intent);
                break;

            default:
                return super.onOptionsItemSelected(item);

        }
        return true;

    }
}