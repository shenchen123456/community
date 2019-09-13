package com.personal.advice;

import com.alibaba.fastjson.JSON;
import com.personal.dto.MessageDTO;
import com.personal.exception.CustomizeErrorEnum;
import com.personal.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: Chen
 * @Data: 2019/9/13
 * @Description: com.personal.advice
 * @Version: 1.0.0
 */
@ControllerAdvice
public class CustomizeExceptionHandle {

    @ExceptionHandler(CustomizeException.class)
    ModelAndView handle(HttpServletRequest request,
                        HttpServletResponse response,
                        Throwable ex, Model model) {
        String contentType = request.getContentType();


        if ("application/json".equals(contentType)){
            MessageDTO result ;
            //返回JSON
            if (ex instanceof CustomizeException){
                result = MessageDTO.errorOf((CustomizeException) ex);
            }else {
                result =  MessageDTO.errorOf(CustomizeErrorEnum.SYSTEM_ERROR);
            }

            try {
                response.setContentType("application/json");
                response.setStatus(200);
                response.setCharacterEncoding("utf-8");

                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(result));
                writer.close();
            }catch (IOException e){
                e.printStackTrace();
            }

            return null;

        }else {
            //页面跳转
            if (ex instanceof CustomizeException){
                model.addAttribute("message",ex.getMessage());
            }else {
                model.addAttribute("message",CustomizeErrorEnum.SYSTEM_ERROR.getMessage());
            }

            return new ModelAndView("error");

        }

    }

}
