package com.test.lettercombination.dto;

import com.test.lettercombination.annotations.DigitArrayRange;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class LetterCombinationsReqDTO {

    @DigitArrayRange(min = 0, max = 99)
    private Integer[] inputs;
}
