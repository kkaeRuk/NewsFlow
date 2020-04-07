package com.example.demo.advice;

import com.example.demo.advice.exception.CEmailSigninFailedException;
import com.example.demo.advice.exception.CUserNotFoundException;
import com.example.demo.model.reponse.CommonResult;
import com.example.demo.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import static jdk.nashorn.internal.runtime.ECMAErrors.getMessage;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {

    private final ResponseService responseService;
    private final MessageSource messageSource;
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult defaultException(HttpServletRequest request, Exception e){
        //예외처리 메시지를 MessageSource에서 가져오도록 설정.
        return responseService.getFailResult(Integer.valueOf(getMessage("unKnown.code")),getMessage("unKnown.msg"));
    }


    @ExceptionHandler(CUserNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult userNotFoundException(HttpServletRequest request, CUserNotFoundException e){
        //예외처리 메시지를 MessageSour에서 가져오도록 설정
        return responseService.getFailResult(Integer.valueOf(getMessage("userNotFound.code")),getMessage("userNotFound.msg"));
  }

    @ExceptionHandler(CEmailSigninFailedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult userNotFoundException(HttpServletRequest request, CEmailSigninFailedException e){
        //예외처리 메시지를 MessageSour에서 가져오도록 설정
        return responseService.getFailResult(Integer.valueOf(getMessage("emailSigninFailed.code")),getMessage("emailSigninFailed.msg"));
    }

  //code정보에 해당하는 메시지 조회
  private String getMessage(String code){
        return getMessage(code,null);
  }

  private String getMessage(String code, Object[] args){
        return messageSource.getMessage(code,args, LocaleContextHolder.getLocale());
  }

}
