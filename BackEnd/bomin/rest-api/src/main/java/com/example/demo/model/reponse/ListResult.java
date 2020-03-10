package com.example.demo.model.reponse;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListResult<T> extends CommonResult {
    //결과가 여러건인 api를 담는 모델
    private List<T> list;
}
