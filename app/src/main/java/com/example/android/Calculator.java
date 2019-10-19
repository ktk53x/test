package com.example.android;

class Calculator
{
    public enum Operator
    {
        ADD, SUB, DIV, MUL
    }

    double add(double firstOperand, double secondOperand)
    {
        return firstOperand + secondOperand;
    }

    double sub(double firstOperand, double secondOperand)
    {
        return firstOperand - secondOperand;
    }

    double div(double firstOperand, double secondOperand)
    {
        return firstOperand / secondOperand;
    }

    double mul(double firstOperand, double secondOperand)
    {
        return firstOperand * secondOperand;
    }
}
