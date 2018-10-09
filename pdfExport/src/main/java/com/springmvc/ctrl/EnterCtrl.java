package com.springmvc.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EnterCtrl {

    @RequestMapping("/hi")
    public ModelAndView sayHiPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("hi");
        // List
        List<String> list = new ArrayList<String>();
        list.add("1.jpg");
        list.add("2.jpg");
        list.add("3.jpg");
        list.add("4.jpg");
        list.add("5.jpg");
        mav.addObject("picList", list);

        return mav;
    }


    @RequestMapping("/upload")
    public ModelAndView uploadFilePage(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        String pic=request.getParameter("pic");
        mav.addObject("picName",pic);
        mav.setViewName("upload");
        return mav;
    }

}
