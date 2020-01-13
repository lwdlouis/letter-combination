package com.test.lettercombination.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.test.lettercombination.dto.ApiRespDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LetterCombinationControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private final String url = "/letters/combinations";

    @Test
    public void testNormalCase() throws Exception {

        Map<String, Object> jsonParam = new HashMap<>();
        jsonParam.put("inputs", new Integer[]{3});

        String jsonStr = JSON.toJSONString(jsonParam);

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonStr))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        JSONObject resultJson = JSON.parseObject(content);

        Assert.assertEquals(ApiRespDTO.SUCCESS_CODE, resultJson.get("code"));
    }


    @Test
    public void testOutOfRangeCase() throws Exception {

        Map<String, Object> jsonParam = new HashMap<>();
        jsonParam.put("inputs", new Integer[]{-1});

        String jsonStr = JSON.toJSONString(jsonParam);

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonStr))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        JSONObject resultJson = JSON.parseObject(content);

        Assert.assertEquals(ApiRespDTO.INVALID_CODE, resultJson.get("code"));
    }

}
