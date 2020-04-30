package com.example.demo.model.reponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SingleResult<T> extends CommonResult {
    //결과가 단일건인 api를 담는 모델
    private T data;
}
