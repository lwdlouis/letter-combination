package com.test.lettercombination.controller;


import com.test.lettercombination.dto.ApiRespDTO;
import com.test.lettercombination.dto.LetterCombinationsReqDTO;
import com.test.lettercombination.service.LetterCombinationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequestMapping("/letters")
@RestController
public class LetterCombinationController {

    @Autowired
    private LetterCombinationService letterCombinationService;

    @PostMapping("/combinations")
    public ApiRespDTO letterCombinations(@Valid @RequestBody LetterCombinationsReqDTO reqDTO) {

        String resultStr = letterCombinationService.allLettersCombinations(reqDTO);
        return ApiRespDTO.ofSuccess(resultStr);
    }

}
