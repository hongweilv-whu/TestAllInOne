package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

/**
 * 查询服务控制器
 * Created by lvhw on 2016/6/20.
 */
@Controller
/*@RequestMapping(value = "/queryData")*/
public class QueryServiceController {

    @RequestMapping(value = "/hello")
    public String hello(Model model){
        model.addAttribute("greeting", "fxiaoke.com");
        return "springmvctesthello";
    }

/*    @RequestMapping(value = "requestParam")
    List<String> getAllList(@RequestParam(required = false) String entName,
                            @RequestParam(required = false)int entId,
                            @RequestParam(required = false)String verify){

        System.out.println("entName:" + entName + ", entId:" + entId + ", verify:" + verify);

        return Arrays.asList("lvhongwei", "whu", "xiongzhiyan");
    }*/
}
