package com.test.lettercombination.service.impl;


import com.test.lettercombination.beans.DigitLettersList;
import com.test.lettercombination.dto.ApiRespDTO;
import com.test.lettercombination.dto.LetterCombinationsReqDTO;
import com.test.lettercombination.service.LetterCombinationService;
import com.test.lettercombination.utils.ConvertUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class LetterCombinationServiceImpl implements LetterCombinationService {

    @Autowired
    private Map<Integer, String[]> digitLettersMap;


    @Override
    public String allLettersCombinations(LetterCombinationsReqDTO reqDTO) {

        DigitLettersList digitLettersList = ConvertUtils.convertDigit0To99(reqDTO.getInputs(), digitLettersMap);

        List<String> letterCombinations = digitLettersList.getAllLetterCombinations();

        StringBuilder stringBuilder = new StringBuilder();
        letterCombinations.stream().forEach(s -> stringBuilder.append(s + " "));

        return stringBuilder.toString();
    }
}
