package com.personal.advice;

import com.personal.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Chen
 * @Data: 2019/9/13
 * @Description: com.personal.advice
 * @Version: 1.0.0
 */
@ControllerAdvice
public class CustomizeExceptionHandle {

    @ExceptionHandler(CustomizeException.class)
    ModelAndView handle(HttpServletRequest request,Throwable ex, Model model) {

        HttpStatus status = getStatus(request);

        if (ex instanceof CustomizeException){
            model.addAttribute("message",ex.getMessage());
        }else {
            model.addAttribute("message","服务器冒烟了，要不稍后再试试?");
        }

        return new ModelAndView("error");
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
