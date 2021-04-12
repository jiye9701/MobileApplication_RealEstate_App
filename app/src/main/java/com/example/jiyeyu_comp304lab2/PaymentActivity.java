package com.example.jiyeyu_comp304lab2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.androidwidgets.formatedittext.widgets.FormatEditText;

import java.util.Calendar;


public class PaymentActivity extends AppCompatActivity {


    private String str;

    private RadioGroup radioButton1, radioButton2, radioButton3;
    private RadioGroup radioGroup;
    private SharedPreferences myPreference;
//    TextView edit_text;

//    @BindView(R.id.editDate)
//    EditText creditExpireDate;
//    @BindView(R.id.editCVC)


    private EditText ExpiryDate;
    EditText name, email, cvc;
    Button btnpay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);

        ExpiryDate = (EditText) findViewById(R.id.editDate);
        ExpiryDate.addTextChangedListener(expiryDateWatcher);

        name = (EditText) findViewById(R.id.editname);
        email = (EditText) findViewById(R.id.editEmail);
        cvc = (EditText) findViewById(R.id.editCVC);

        btnpay = (Button) findViewById(R.id.btnpayment);


        //format
        final FormatEditText editText1 = findViewById(R.id.edittext1);
        //

        editText1.setFormat("---- ---- ---- ----");
        //Radio Group
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(radioGroupButtonChangeListener);


        //validation
        EditText name = (EditText) findViewById(R.id.editname);
        EditText etUserName = (EditText) findViewById(R.id.editname);
        String strUserName = etUserName.getText().toString();


        EditText email = (EditText) findViewById(R.id.editEmail);
        String strEmail = email.getText().toString();
        //CVC = (EditText)findViewById(R.id.editCVC);
        EditText cvc = (EditText) findViewById(R.id.editCVC);

        if (name.getText().toString().trim().equals("")) {
            etUserName.setError("Please Enter your Name");


        } else {
            Button Btn = (Button) findViewById(R.id.btnpayment);
            Btn.setEnabled(true);
        }

        if (cvc.getText().toString().trim().equals("")) {
            Button Btn = (Button) findViewById(R.id.btnpayment);
            Btn.setEnabled(false);
        } else {

        }


    }


        RadioGroup.OnCheckedChangeListener radioGroupButtonChangeListener = new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioButton1) {
                    Toast.makeText(PaymentActivity.this, "Clicked Cash Button", Toast.LENGTH_SHORT).show();

                    EditText edt1 = (EditText) findViewById(R.id.editDate);
                    EditText edt2 = (EditText) findViewById(R.id.edittext1);
                    EditText edt3 = (EditText) findViewById(R.id.editCVC);


                    edt1.setEnabled(false);
                    edt2.setEnabled(false);
                    edt3.setEnabled(false);

                    Button Btn = (Button) findViewById(R.id.btnpayment);
                    Btn.setEnabled(true);


                } else if (i == R.id.radioButton2) {
                    Toast.makeText(PaymentActivity.this, "Clicked Credit card Button", Toast.LENGTH_SHORT).show();

                    EditText edt1 = (EditText) findViewById(R.id.editDate);
                    EditText edt2 = (EditText) findViewById(R.id.edittext1);
                    EditText edt3 = (EditText) findViewById(R.id.editCVC);


                    edt1.setEnabled(true);
                    edt2.setEnabled(true);
                    edt3.setEnabled(true);
                } else if (i == R.id.radioButton3) {

                    EditText edt1 = (EditText) findViewById(R.id.editDate);
                    EditText edt2 = (EditText) findViewById(R.id.edittext1);
                    EditText edt3 = (EditText) findViewById(R.id.editCVC);


                    edt1.setEnabled(true);
                    edt2.setEnabled(true);
                    edt3.setEnabled(true);
                    Toast.makeText(PaymentActivity.this, "Clicked Debit card Button", Toast.LENGTH_SHORT).show();
                }
            }
        };













        public void onClickPayment (View view){


            Toast.makeText(this, "Thank you for your order!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }

        private TextWatcher expiryDateWatcher = new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String formatting = s.toString();
                boolean isValid = true;
                if (formatting.length() == 2 && before == 0) {
                    if (Integer.parseInt(formatting) < 1 || Integer.parseInt(formatting) > 12) {
                        isValid = false;
                    } else {
                        formatting += "/";
                        ExpiryDate.setText(formatting);
                        ExpiryDate.setSelection(formatting.length());
                    }
                }

//
                else if (formatting.length() == 7 && before == 0) {
                    String enteredYear = formatting.substring(3);
                    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                    if (Integer.parseInt(enteredYear) < currentYear) {
                        isValid = false;
                        Button Btn = (Button) findViewById(R.id.btnpayment);
                        Btn.setEnabled(false);
                    }
                } else if (formatting.length() != 5) {
                    isValid = false;
                    Button Btn = (Button) findViewById(R.id.btnpayment);
                    Btn.setEnabled(false);
                }

                if (!isValid) {
                    ExpiryDate.setError("Please Enter a valid date: MM/YY");
                    Button Btn = (Button) findViewById(R.id.btnpayment);
                    Btn.setEnabled(false);
                } else {
                    ExpiryDate.setError(null);
                    Button Btn = (Button) findViewById(R.id.btnpayment);
                    Btn.setEnabled(true);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

        };




    }




