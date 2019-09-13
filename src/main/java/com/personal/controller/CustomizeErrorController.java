package com.personal.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Chen
 * @Data: 2019/9/13
 * @Description: com.personal.controller
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/error")
public class CustomizeErrorController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "error";
    }

    @RequestMapping(
            produces = {"text/html"}
    )
    public ModelAndView errorHtml(HttpServletRequest request, Model model) {
        HttpStatus status = this.getStatus(request);

        if (status.is4xxClientError()) {
            model.addAttribute("message", "请求错误，要不要换个试试");
        }
        if (status.is5xxServerError()) {
            model.addAttribute("message", "服务器冒烟了，要不稍后再试试?");
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
