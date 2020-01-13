package com.test.lettercombination.service;

import com.test.lettercombination.dto.LetterCombinationsReqDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class LetterCombinationServiceTests {

    @Autowired
    private LetterCombinationService letterCombinationService;

    @Test
    public void testNormalSingleDigit() {

        Integer[] inputs = new Integer[]{9};

        LetterCombinationsReqDTO reqDTO = new LetterCombinationsReqDTO();
        reqDTO.setInputs(inputs);

        String resultStr = letterCombinationService.allLettersCombinations(reqDTO);

        log.info("[Unit Test] [testSingleDigit] : resultStr-{}", resultStr);
        Assert.assertEquals("w x y z ", resultStr);
    }


    @Test
    public void testNormalMultiDigit() {

        Integer[] inputs = new Integer[]{2, 3};

        LetterCombinationsReqDTO reqDTO = new LetterCombinationsReqDTO();
        reqDTO.setInputs(inputs);

        String resultStr = letterCombinationService.allLettersCombinations(reqDTO);

        log.info("[Unit Test] [testNormalMultiDigit] : resultStr-{}", resultStr);
        Assert.assertEquals("ad ae af bd be bf cd ce cf ", resultStr);
    }

    @Test
    public void testNormalMultiDigitRandom() {

        Integer[] inputs = new Integer[]{5, 4, 3};

        LetterCombinationsReqDTO reqDTO = new LetterCombinationsReqDTO();
        reqDTO.setInputs(inputs);

        String resultStr = letterCombinationService.allLettersCombinations(reqDTO);

        log.info("[Unit Test] [testNormalMultiDigitRandom] : resultStr-{}", resultStr);
        Assert.assertEquals("jgd jge jgf jhd jhe jhf jid jie jif kgd kge kgf khd khe khf kid kie kif lgd lge lgf lhd lhe lhf lid lie lif ", resultStr);
    }

    @Test
    public void testNormalIncludeEmptyLetterDigit() {

        Integer[] inputs = new Integer[]{1, 7, 0, 9, 1};

        LetterCombinationsReqDTO reqDTO = new LetterCombinationsReqDTO();
        reqDTO.setInputs(inputs);

        String resultStr = letterCombinationService.allLettersCombinations(reqDTO);

        log.info("[Unit Test] [testNormalIncludeEmptyLetterDigit] : resultStr-{}", resultStr);
        Assert.assertEquals("pw px py pz qw qx qy qz rw rx ry rz sw sx sy sz ", resultStr);
    }


    @Test
    public void testNormalBetween0To99InDouble() {

        Integer[] inputs = new Integer[]{22, 33};

        LetterCombinationsReqDTO reqDTO = new LetterCombinationsReqDTO();
        reqDTO.setInputs(inputs);

        String resultStr = letterCombinationService.allLettersCombinations(reqDTO);

        log.info("[Unit Test] [testNormalBetween0To99InDouble] : resultStr-{}", resultStr);
        Assert.assertEquals("ad ae af bd be bf cd ce cf ", resultStr);
    }

    @Test
    public void testNormalBetween0To99Random() {

        Integer[] inputs = new Integer[]{43, 12};

        LetterCombinationsReqDTO reqDTO = new LetterCombinationsReqDTO();
        reqDTO.setInputs(inputs);

        String resultStr = letterCombinationService.allLettersCombinations(reqDTO);

        log.info("[Unit Test] [testNormalBetween0To99Random] : resultStr-{}", resultStr);
        Assert.assertEquals("ga gb gc ha hb hc ia ib ic da db dc ea eb ec fa fb fc ", resultStr);
    }


    @Test
    public void testOutOfRange() {

        Integer[] inputs = new Integer[]{2, 3, -1};

        LetterCombinationsReqDTO reqDTO = new LetterCombinationsReqDTO();
        reqDTO.setInputs(inputs);

        String resultStr = letterCombinationService.allLettersCombinations(reqDTO);

        log.info("[Unit Test] [testNormalDigitBetween0To99] : resultStr-{}", resultStr);
        Assert.assertEquals("ad ae af bd be bf cd ce cf ", resultStr);
    }


}
