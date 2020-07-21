package com.hangyu.platform.global;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

public class MiscUtil {

     public static Result getValidateError(BindingResult bindingResult) {

        if(bindingResult.hasErrors() == false)
            return null;

        Map<String,String> fieldErrors = new HashMap<String, String>();
        for(FieldError error : bindingResult.getFieldErrors()){
//            fieldErrors.put(error.getField(), error.getCode() + "|" + error.getDefaultMessage());
            fieldErrors.put(error.getField(),  error.getDefaultMessage());
        }

        Result ret = new Result(422, "输入错误"); //rfc4918 - 11.2. 422: Unprocessable Entity
        ret.putData("fieldErrors", fieldErrors);

        return ret;
    }
}
