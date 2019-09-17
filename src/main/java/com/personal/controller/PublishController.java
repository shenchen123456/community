package com.personal.controller;

import com.personal.cash.TagCash;
import com.personal.entity.Question;
import com.personal.entity.User;
import com.personal.service.QuestionService;
import com.personal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Chen
 * @Data: 2019/9/6
 * @Description: com.personal.controller
 * @Version: 1.0.0
 */
@Controller
public class PublishController {

    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;

    @GetMapping("/publish")
    public String publish(Model model) {

        model.addAttribute("tags", TagCash.get());
        return "publish";
    }

    /**
     * 通过编辑按钮  编辑用户自己的问题
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/publish/{id}")
    public String publish(@PathVariable("id")Integer id,
                          Model model,
                          HttpServletRequest request) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");

        model.addAttribute("tags", TagCash.get());

        Question question = questionService.findOneById(id);

        if (question.getCreator() == userId) {
            model.addAttribute("question",question);
        }else {
            model.addAttribute("error","这不是你的问题哦!!!");
        }
        return "/publish";
    }



    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "id",required = false) Integer id,
            @RequestParam(value = "title",required = false) String title,
            @RequestParam(value = "description" ,required = false) String description,
            @RequestParam(value = "tag",required = false) String tag,
            HttpServletRequest httpServletRequest,
            Model model) {

        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);

        model.addAttribute("tags", TagCash.get());

        //后端校验标题，描述，标签不能为空
        if (null == title || "".equals(title)) {
            model.addAttribute("error","标题不能为空");
            return "publish";
        }
        if (null == description || "".equals(description)) {
            model.addAttribute("error","描述不能为空");
            return "publish";
        }if (null == tag || "".equals(tag)) {
            model.addAttribute("error","标签不能为空");
            return "publish";
        }

        String invalid = TagCash.filterInValid(tag);
        if (!StringUtils.isEmpty(invalid)){
            model.addAttribute("error","输入非法标签"+invalid);
            return "publish";
        }

        //后端校验用户是否登录
        String username = (String) httpServletRequest.getSession().getAttribute("username");
        Integer userId = (Integer) httpServletRequest.getSession().getAttribute("userId");

        if (null == username && null ==userId){
            model.addAttribute("error", "用户未登录");
        }

        User user = userService.findOneByNameAndId(username,userId);

        if (null == user) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }


        questionService.questionCreateOrUpdate(new Question()
                .setId(id)
                .setTitle(title)
                .setDescription(description)
                .setTag(tag)
                .setCreator(user.getId()));

        return "redirect:/";
    }
}
