package com.test.lettercombination.dto;


import lombok.Data;

@Data
public class ApiRespDTO {

    public static final int SUCCESS_CODE = 0;
    public static final int FAIL_CODE = -1;
    public static final int INVALID_CODE = 1;

    private int code;
    private String msg;
    private Object data;

    public ApiRespDTO(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ApiRespDTO ofSuccess(Object data) {
        return new ApiRespDTO(ApiRespDTO.SUCCESS_CODE, "Success", data);
    }

    public static ApiRespDTO ofFail(String msg) {
        return new ApiRespDTO(ApiRespDTO.FAIL_CODE, msg, null);
    }

    public static ApiRespDTO ofInvalid(String msg) {
        return new ApiRespDTO(ApiRespDTO.INVALID_CODE, msg, null);
    }


}
