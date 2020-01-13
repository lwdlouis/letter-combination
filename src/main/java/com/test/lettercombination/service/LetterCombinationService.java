package com.test.lettercombination.service;

import com.test.lettercombination.dto.ApiRespDTO;
import com.test.lettercombination.dto.LetterCombinationsReqDTO;

public interface LetterCombinationService {

    String allLettersCombinations(LetterCombinationsReqDTO reqDTO);
}
