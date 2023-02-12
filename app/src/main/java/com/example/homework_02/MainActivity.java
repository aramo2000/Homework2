package com.example.homework_02;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static String result = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText numberInput = findViewById(R.id.number_input);
        final TextView resultView = findViewById(R.id.result_view);

        Button checkButton = findViewById(R.id.check_button);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = numberInput.getText().toString();
                int number = Integer.parseInt(input);


                resultView.setText(intToString(number));
                result = "";
                numberInput.setText("");
            }
        });
    }

    public static String intToString(int intValue) {
        if(intValue==0) {
            result = "Zero";
            return result;
        }
        if(intValue>999999) {
            int millions = intValue/1000000;
            numbering(millions," Million");
            intValue = intValue%1000000;
            if(intValue>0) {
                result += " and";
            }
        }
        if(intValue>999) {
            int thousands = intValue/1000;
            numbering(thousands," Thousand");
            intValue = intValue%1000;
            if(intValue>0) {
                result += " and";
            }
        }
        if(intValue>0) {
            numbering(intValue,"");
        }
        return result;
    }

    public static void numbering(int number, String naming) {
        if(number>99) {
            result += " " + LESS_THAN_20[number/100] + " Hundred";
            number = number%100;
            if(number>0) {
                result += " and";
            }
        }
        if(number>19) {
            result += " " + TENS[number/10];
            number = number%10;
        }
        if(number>0) {
            result += " " + LESS_THAN_20[number];
        }
        result += naming;

    }
}