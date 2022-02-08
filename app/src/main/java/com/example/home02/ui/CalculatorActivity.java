package com.example.home02.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.home02.R;
import com.example.home02.domain.CalculatorImp;
import com.example.home02.domain.Operation;
import com.example.home02.domain.Theme;
import com.example.home02.storage.ThemeStorage;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {


    private TextView textResult;
    private CalculatorPresenter calculatorPresenter;

    @Override
    public void showResult(String result) {
        textResult.setText(result);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ThemeStorage storage = new ThemeStorage(this);
        setTheme(storage.getTheme().getStyle());

        setContentView(R.layout.activity_calculator);


        calculatorPresenter = new CalculatorPresenter(this, new CalculatorImp());
        textResult = findViewById(R.id.result);


        findViewById(R.id.theme_one).setOnClickListener(view -> {
            storage.saveTheme(Theme.ONE);
            recreate();
        });

        findViewById(R.id.theme_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storage.saveTheme(Theme.TWO);
                recreate();
            }
        });

        findViewById(R.id.theme_tree).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storage.saveTheme(Theme.TREE);
                recreate();
            }
        });


        Map<Integer, Integer> digits = new HashMap<>();

        digits.put(R.id.key_0, 0);
        digits.put(R.id.key_1, 1);
        digits.put(R.id.key_2, 2);
        digits.put(R.id.key_3, 3);
        digits.put(R.id.key_4, 4);
        digits.put(R.id.key_5, 5);
        digits.put(R.id.key_6, 6);
        digits.put(R.id.key_7, 7);
        digits.put(R.id.key_8, 8);
        digits.put(R.id.key_9, 9);

        View.OnClickListener digitClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorPresenter.onDigitPressed(digits.get(view.getId()));
            }
        };

        Map<Integer, Operation> operations = new HashMap<>();

        operations.put(R.id.key_plus, Operation.ADD);
        operations.put(R.id.key_minus, Operation.SUB);
        operations.put(R.id.key_multiply, Operation.MULT);
        operations.put(R.id.key_separator, Operation.DIV);

        View.OnClickListener operationsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorPresenter.onOperationPressed(operations.get(view.getId()));
            }
        };

        findViewById(R.id.key_1).setOnClickListener(digitClickListener);

        Button button02 = findViewById(R.id.key_2);
        button02.setOnClickListener(digitClickListener);

        Button button03 = findViewById(R.id.key_3);
        button03.setOnClickListener(digitClickListener);

        Button button04 = findViewById(R.id.key_4);
        button04.setOnClickListener(digitClickListener);

        Button button05 = findViewById(R.id.key_5);
        button05.setOnClickListener(digitClickListener);

        Button button06 = findViewById(R.id.key_6);
        button06.setOnClickListener(digitClickListener);

        Button button07 = findViewById(R.id.key_7);
        button07.setOnClickListener(digitClickListener);

        Button button08 = findViewById(R.id.key_8);
        button08.setOnClickListener(digitClickListener);

        Button button09 = findViewById(R.id.key_9);
        button09.setOnClickListener(digitClickListener);

        Button button00 = findViewById(R.id.key_0);
        button00.setOnClickListener(digitClickListener);


        Button buttonDot = findViewById(R.id.key_dot);
        buttonDot.setOnClickListener(view -> calculatorPresenter.onDotPressed());


        Button buttonSeparator = findViewById(R.id.key_separator);
        buttonSeparator.setOnClickListener(operationsClickListener);

        Button buttonMultiply = findViewById(R.id.key_multiply);
        buttonMultiply.setOnClickListener(operationsClickListener);

        Button buttonPlus = findViewById(R.id.key_plus);
        buttonPlus.setOnClickListener(operationsClickListener);

        Button buttonMinus = findViewById(R.id.key_minus);
        buttonMinus.setOnClickListener(operationsClickListener);

        Button buttonValue = findViewById(R.id.key_value);
        buttonValue.setOnClickListener(view -> calculatorPresenter.onValuePressed());

        Button buttonCe = findViewById(R.id.key_ce);
        buttonCe.setOnClickListener(view -> calculatorPresenter.onCePressed());
    }
}


