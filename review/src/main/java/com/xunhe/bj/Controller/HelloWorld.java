package com.xunhe.bj.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;


//@ResponseBody
@Controller
public class HelloWorld {

//    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @RequestMapping("/test")
    public String sayHello(){
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.setViewName("sayHello");
//        return modelAndView;
        return "sayHello";
    }
}
