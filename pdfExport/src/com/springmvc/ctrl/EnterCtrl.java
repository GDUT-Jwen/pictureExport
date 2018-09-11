package com.springmvc.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EnterCtrl {

    @RequestMapping("/hi")
    public String sayHiPage() {
        return "hi";
    }

}
