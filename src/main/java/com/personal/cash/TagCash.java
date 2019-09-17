package com.personal.cash;

import com.github.pagehelper.util.StringUtil;
import com.personal.dto.TagDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: Chen
 * @Data: 2019/9/15
 * @Description: com.personal.cash
 * @Version: 1.0.0
 */
public class TagCash {

    public static List<TagDTO> get(){
        List<TagDTO> tagDTOS = new ArrayList<>();
        TagDTO program = new TagDTO();
        program.setCategoryName("开发语言");
        program.setTags(Arrays.asList("js","php","node.js","css","html","java","c++","c"));
        tagDTOS.add(program);

        TagDTO framework = new TagDTO();
        framework.setCategoryName("平台框架");
        framework.setTags(Arrays.asList("spring","springboot","springmvc","mybatis","dubbo","struts","flask"));
        tagDTOS.add(framework);

        TagDTO server = new TagDTO();
        server.setCategoryName("服务器");
        server.setTags(Arrays.asList("linux","nginx","docker","apache","tomcat","unix"));
        tagDTOS.add(server);

        return tagDTOS;
    }

    public static String filterInValid(String tags){
        String[] split = tags.split(",");
        List<TagDTO> tagDTOS = get();
        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        String invalid = Arrays.stream(split).filter(t -> !tagList.contains(t.toLowerCase())).collect(Collectors.joining(","));
        return invalid;
    }

    public static void main(String[] args) {
        String s = TagCash.filterInValid("spring,c++,css,html,springboot");
        System.out.println(s);
    }
}
