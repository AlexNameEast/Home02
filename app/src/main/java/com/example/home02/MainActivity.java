package com.example.home02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private TextView textResult;
    private String intermediateValue = "";
    private String intermediateValue02 = "";
    private boolean flag = true;
    private String sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textResult = findViewById(R.id.result);

        Button button01 = findViewById(R.id.key_1);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intermediateValue += getResources().getString(R.string.key_one);
                textResult.setText(String.format(Locale.getDefault(), "%s", intermediateValue));
            }
        });

        Button button02 = findViewById(R.id.key_2);
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intermediateValue += getResources().getString(R.string.key_two);
                textResult.setText(String.format(Locale.getDefault(), "%s", intermediateValue));
            }
        });

        Button button03 = findViewById(R.id.key_3);
        button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intermediateValue += getResources().getString(R.string.key_three);
                textResult.setText(String.format(Locale.getDefault(), "%s", intermediateValue));
            }
        });

        Button button04 = findViewById(R.id.key_4);
        button04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intermediateValue += getResources().getString(R.string.key_four);
                textResult.setText(String.format(Locale.getDefault(), "%s", intermediateValue));
            }
        });

        Button button05 = findViewById(R.id.key_5);
        button05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intermediateValue += getResources().getString(R.string.key_five);
                textResult.setText(String.format(Locale.getDefault(), "%s", intermediateValue));
            }
        });

        Button button06 = findViewById(R.id.key_6);
        button06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intermediateValue += getResources().getString(R.string.key_six);
                textResult.setText(String.format(Locale.getDefault(), "%s", intermediateValue));
            }
        });

        Button button07 = findViewById(R.id.key_7);
        button07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intermediateValue += getResources().getString(R.string.key_seven);
                textResult.setText(String.format(Locale.getDefault(), "%s", intermediateValue));
            }
        });

        Button button08 = findViewById(R.id.key_8);
        button08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intermediateValue += getResources().getString(R.string.key_eight);
                textResult.setText(String.format(Locale.getDefault(), "%s", intermediateValue));
            }
        });

        Button button09 = findViewById(R.id.key_9);
        button09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intermediateValue += getResources().getString(R.string.key_nine);
                textResult.setText(String.format(Locale.getDefault(), "%s", intermediateValue));
            }
        });

        Button button00 = findViewById(R.id.key_0);
        button00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intermediateValue += getResources().getString(R.string.key_zero);
                textResult.setText(String.format(Locale.getDefault(), "%s", intermediateValue));
            }
        });

        Button buttonDot = findViewById(R.id.key_dot);
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intermediateValue += getResources().getString(R.string.key_point);
                textResult.setText(String.format(Locale.getDefault(), "%s", intermediateValue));
            }
        });

        Button buttonSeparator = findViewById(R.id.key_separator);
        buttonSeparator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    intermediateValue02 = intermediateValue;
                    intermediateValue = "";
                    textResult.setText(String.format(Locale.getDefault(), "%s", intermediateValue));
                    flag = false;
                    sign = "/";
                }
            }
        });

        Button buttonMultip = findViewById(R.id.key_multip);
        buttonMultip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    intermediateValue02 = intermediateValue;
                    intermediateValue = "";
                    textResult.setText(String.format(Locale.getDefault(), "%s", intermediateValue));
                    flag = false;
                    sign = "*";
                }
            }
        });

        Button buttonPlus = findViewById(R.id.key_plus);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    intermediateValue02 = intermediateValue;
                    intermediateValue = "";
                    textResult.setText(String.format(Locale.getDefault(), "%s", intermediateValue));
                    flag = false;
                    sign = "+";
                }
            }
        });

        Button buttonMinus = findViewById(R.id.key_minus);
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    intermediateValue02 = intermediateValue;
                    intermediateValue = "";
                    textResult.setText(String.format(Locale.getDefault(), "%s", intermediateValue));
                    flag = false;
                    sign = "-";
                }
            }
        });

        Button buttonValue = findViewById(R.id.key_value);
        buttonValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!flag) {
                    Float x;
                    if (sign.equals("+")){
                        x = Float.parseFloat(intermediateValue02) + Float.parseFloat(intermediateValue);
                    }
                    else if (sign.equals("-")){
                        x = Float.parseFloat(intermediateValue02) - Float.parseFloat(intermediateValue);
                    }
                    else if (sign.equals("*")){
                        x = Float.parseFloat(intermediateValue02) * Float.parseFloat(intermediateValue);
                    }
                    else if (sign.equals("/")){
                        x = Float.parseFloat(intermediateValue02) / Float.parseFloat(intermediateValue);
                    }
                    else x=0.0f;


                    
                    intermediateValue = x.toString();
                    textResult.setText(String.format(Locale.getDefault(), "%s", intermediateValue));
                    flag = true;
                }
            }
        });

        Button buttonCE = findViewById(R.id.key_ce);
        buttonCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intermediateValue = "";
                textResult.setText(String.format(Locale.getDefault(), "%s", "0.0"));
            }
        });
    }
}


