package com.example.android;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(JUnit4.class)
public class CalculatorTest
{
    private Calculator calculator;

    @Before
    public void setUp()
    {
        calculator = new Calculator();
    }

    @Test
    public void addTwoNumbers()
    {
        double resultAdd = calculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }

    @Test
    public void addTwoNumbersNegative()
    {
        double resultAdd = calculator.add(-1d, 2d);
        assertThat(resultAdd, is(equalTo(1d)));
    }

    @Test
    public void subTwoNumbers()
    {
        double resultSub = calculator.sub(1d, 1d);
        assertThat(resultSub, is(equalTo(0d)));
    }

    @Test
    public void subWorksWithNegativeResult()
    {
        double resultSub = calculator.sub(1d, 17d);
        assertThat(resultSub, is(equalTo(-16d)));
    }

    @Test
    public void mulTwoNumbers()
    {
        double resultMul = calculator.mul(32d, 2d);
        assertThat(resultMul, is(equalTo(64d)));
    }

    @Test
    public void divTwoNumbers()
    {
        double resultDiv = calculator.div(32d,2d);
        assertThat(resultDiv, is(equalTo(16d)));
    }

    @Test
    public void divTwoNumbersZero()
    {
        double resultDiv = calculator.div(32d,0);
        assertThat(resultDiv, is(equalTo(Double.POSITIVE_INFINITY)));
    }
}