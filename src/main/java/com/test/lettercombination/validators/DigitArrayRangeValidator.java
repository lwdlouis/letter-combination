package com.test.lettercombination.validators;

import com.test.lettercombination.annotations.DigitArrayRange;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DigitArrayRangeValidator implements ConstraintValidator<DigitArrayRange, Integer[]> {

    private DigitArrayRange digitArrayRange;

    @Override
    public void initialize(DigitArrayRange constraintAnnotation) {
        this.digitArrayRange = constraintAnnotation;
    }

    @Override
    public boolean isValid(Integer[] digits, ConstraintValidatorContext context) {

        int min = digitArrayRange.min();
        int max = digitArrayRange.max();

        for (Integer digit : digits) {
            if (digit < min || digit > max) {

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder
                        .append("Input Digit ")
                        .append(digit)
                        .append(" is out of range {min} to {max}")
//                        .append(min)
//                        .append(" to ")
//                        .append(max)
                        ;

                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(stringBuilder.toString())
                        .addConstraintViolation();

                return false;
            }
        }
        return true;
    }
}
