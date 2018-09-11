package com.springmvc.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EnterCtrl {

    @RequestMapping("/hi")
    public ModelAndView sayHiPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("hi");
        mav.addObject("msg", "hello kitty");

        // List
        List<String> list = new ArrayList<String>();
        list.add("java");
        list.add("c++");
        list.add("oracle");
        mav.addObject("bookList", list);

        // Map
        Map<String, String> map = new HashMap<String, String>();
        map.put("zhangsan", "北京");
        map.put("lisi", "上海");
        map.put("wangwu", "深圳");
        mav.addObject("map", map);

        return mav;
    }


    @RequestMapping("/upload")
    public ModelAndView uploadFilePage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("upload");
        return mav;
    }

}
