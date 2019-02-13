package com.example.medicalcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // Define Values

    double conversionRate = 2.2;
    double weightEntered;
    double convertedWeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This is what i'm adding. note the book on page 140 specifies to delete code that doesn't really
        // exist

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // Main activity has three new statements to display the logo named ic_launcher in the mipmap folder.

        // Define some Radio Button Controls
        final EditText weight = (EditText) findViewById(R.id.txtWeight);
        final RadioButton lbsToKilo = (RadioButton) findViewById(R.id.radLbToKilo);
        final RadioButton kiloToLbs = (RadioButton) findViewById(R.id.radKiloToLbs);
        final TextView result = (TextView) findViewById(R.id.txtResult);

        Button convert = (Button) findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightEntered = Double.parseDouble(weight.getText().toString());
                DecimalFormat tenth = new DecimalFormat("#.#");

                // Do the nested if

                if(lbsToKilo.isChecked()) {
                    if (weightEntered <= 500) {
                        convertedWeight = weightEntered / conversionRate;
                        result.setText(tenth.format(convertedWeight) + " Kilograms");

                    } else {
                        Toast.makeText(MainActivity.this, "Pounds must be less than 500", Toast.LENGTH_LONG).show();
                    }
                } else if (kiloToLbs.isChecked()){
                    if (weightEntered <= 225) {
                        convertedWeight = weightEntered * conversionRate;
                        result.setText(tenth.format(convertedWeight) + " Pounds");

                    } else {
                        Toast.makeText(MainActivity.this, "Kilosmust be less than 225", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }
}
