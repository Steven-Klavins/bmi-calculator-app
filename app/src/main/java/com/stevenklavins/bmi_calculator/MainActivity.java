package com.stevenklavins.bmi_calculator;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class MainActivity extends AppCompatActivity {
    private TextInputLayout textInputHeight;
    private TextInputLayout textInputWeight;
    private double hieght;
    private double weight;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            output = (TextView) findViewById(R.id.text_output);
            output.setText("Enter your weight and height");

                Button calculateButton = (Button) findViewById(R.id.calculate_button);
                textInputHeight = findViewById(R.id.heightInputId);
                textInputWeight = findViewById(R.id.weightInputId);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String hightText = textInputHeight.getEditText().getText().toString();
               String weightText = textInputWeight.getEditText().getText().toString();

               if (validation(hightText,weightText)==true){

                   double result = weight/(hieght*hieght);
                     BigDecimal rounded = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
                        result = rounded.doubleValue();
                            setTextResult(result);

               }

            }
        });
    }

    private boolean validation (String textInputHeight, String textInputWeight){
        try {
            hieght = Double.valueOf(textInputHeight);
            weight = Double.valueOf(textInputWeight);
            return true;
        }

        catch (Exception e){
            return false;
        }
    }

    private void setTextResult (double number){

        if (number<18.5){
            output.setText("Your BMI is " + number + " this indicates your underweight");
        }
        else if (number>=18.5&&number<=24.9){
            output.setText("Your BMI is " + number + " this indicates your average weight");
        }
        else if (number>24.9&&number<30) {
            output.setText("Your BMI is " + number + " this indicates your overweight");
        }
        else {
            output.setText("Your BMI is " + number + " this indicates your obese");
        }

    }
}
