package com.example.demo.model.reponse;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResult {
    //api의 처리 상태 및 메시지를 내려주는 데이터로 구성
    //success는 api의 성공 실패 여부를 나타내고 code, msg는 해당 상황에서의 응답 코드와 응답 메시지를 나타낸다.
    @ApiModelProperty(value = "응답 성공여부 : true/false")
    private boolean success;

    @ApiModelProperty(value = "응답 코드 번호 : >= 0 정상, < 0 비정상 ")
    private int code;

    @ApiModelProperty(value="응답 메시지")
    private String msg;
}
