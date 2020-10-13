package com.alex.gulimall.product.exception;

import com.alex.gulimall.common.exception.BigCodeEnum;
import com.alex.gulimall.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice(basePackages = "com.alex.gulimall.product.controller")
@Slf4j
public class GulimallExceptionAdvice {

    @ExceptionHandler
    public R exceptionHandle(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        Map map = bindingResult.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
        log.error("数据校验出现问题:{},异常类型{}",e.getMessage(),e.getClass());
        return R.error(Integer.parseInt(BigCodeEnum.VAILD_EXCEPTION.getCode()), BigCodeEnum.VAILD_EXCEPTION.getMsg()).put("data", map);
    }
}
