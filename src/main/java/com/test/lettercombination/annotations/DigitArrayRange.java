package com.test.lettercombination.annotations;


import com.test.lettercombination.validators.DigitArrayRangeValidator;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({ FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = {DigitArrayRangeValidator.class})
public @interface DigitArrayRange {

    int min() default 0;

    int max() default Integer.MAX_VALUE;

    String message() default "";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
