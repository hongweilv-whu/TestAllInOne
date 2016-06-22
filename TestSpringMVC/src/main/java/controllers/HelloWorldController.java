package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试@Controller的用法
 * Created by lvhw on 2016/6/22.
 */

@Controller
@RequestMapping(value = "/common")
public class HelloWorldController {

    @RequestMapping(value = "/hello")
    public String sayHello(Model model){

        model.addAttribute("greeting", "Welcome to SpringMVC World!<br><br>");
        model.addAttribute("author", "HelloWorldController--sayHello()");
        return "sayHello";
    }
}
