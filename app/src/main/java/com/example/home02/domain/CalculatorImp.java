package com.example.home02.domain;

public class CalculatorImp implements Calculator {
    @Override
    public double calculator(double argumentOne, double argumentTwo, Operation operation) {
        switch (operation) {
            case ADD:
                return argumentOne + argumentTwo;
            case SUB:
                return argumentOne - argumentTwo;
            case MULT:
                return argumentOne * argumentTwo;
            case DIV:
                return argumentOne / argumentTwo;
        }
        return 0;
    }
}
