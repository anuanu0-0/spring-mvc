package com.example.springmvc.ValidationAnnotations;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class Calculator {
    @Positive
    private int operand1;

    @Negative
    private int operand2;

    @PositiveOrZero
    private int operand3;

    @NegativeOrZero
    private int operand4;

    @Null
    private char operator;
}
