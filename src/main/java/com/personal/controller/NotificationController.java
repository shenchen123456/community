package com.personal.controller;

import com.github.pagehelper.PageInfo;
import com.personal.dto.NotificationDTO;
import com.personal.entity.Notification;
import com.personal.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Chen
 * @Data: 2019/9/16
 * @Description: com.personal.controller
 * @Version: 1.0.0
 */
@Controller
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @GetMapping("/user/replies")
    @ResponseBody
    public PageInfo<Notification> getUserNotification(HttpServletRequest request,
                                                      @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                                      @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");

        //TODO
        //userId可能为空
        if (userId == null || userId == 0){
            return null;
        }

        return notificationService.getUserWithAllNotification(userId,currentPage,size);
    }

    @PostMapping("/notification")
    @ResponseBody
    public String toQuestionPage(@RequestBody NotificationDTO notificationDTO,
                                 HttpServletRequest request) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");

        //TODO
        //userId可能为空
        if (userId == null || userId == 0){
            return "/";
        }

        Integer questionId = notificationService.findQuestionId(notificationDTO);

        return "/question/"+questionId;
    }

}
