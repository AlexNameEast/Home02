package com.example.home02.ui;

import com.example.home02.domain.Calculator;
import com.example.home02.domain.Operation;

public class CalculatorPresenter {

    private static final int BASE = 10;
    private CalculatorView view;
    private Calculator calculator;

    private double argument1;
    private double argument2;

    private boolean isRealPart;
    private double realPartMultiplier = 1.0;

    private Operation selectedOperation;

    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void onDigitPressed(int digit) {

        if (selectedOperation == null) {
            argument1 = addToArg(argument1, digit);
            view.showResult(String.valueOf(argument1));
        } else {
            argument2 = addToArg(argument2, digit);
            view.showResult(String.valueOf(argument2));
        }
    }

    public void onOperationPressed(Operation operation) {

        if (selectedOperation != null) {
            argument1 = calculator.calculator(argument1, argument2, selectedOperation);
            view.showResult(String.valueOf(argument1));
            argument2 = 0.0;
        }

        isRealPart = false;
        realPartMultiplier = 1.0;
        selectedOperation = operation;

    }

    public void onDotPressed() {
        isRealPart = true;

    }

    public void onCePressed() {
        argument2 = 0.0;
        argument1 = 0.0;
        isRealPart = false;
        realPartMultiplier = 1.0;
        view.showResult(String.valueOf(0.0));
    }

    public void onValuePressed() {

        argument1 = calculator.calculator(argument1, argument2, selectedOperation);
        view.showResult(String.valueOf(argument1));
        argument2 = 0.0;
        isRealPart = false;
        realPartMultiplier = 1.0;
    }

    private double addToArg(double inital, int digit) {

        if (isRealPart) {

            realPartMultiplier *= BASE;
            return inital + digit / realPartMultiplier;

        } else {

            return inital = argument2 * BASE + digit;
        }
    }

}
