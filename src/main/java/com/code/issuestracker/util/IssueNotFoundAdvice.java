package com.code.issuestracker.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class IssueNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(IssueNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String issueNotFoundHandler(IssueNotFoundException ex){
        return ex.getMessage();
    }


}
