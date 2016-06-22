package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pojos.Message;

import java.util.Arrays;
import java.util.List;

/**
 * 查询服务控制器
 * Created by lvhw on 2016/6/20.
 */
@RestController
@RequestMapping(value = "/")
public class QueryServiceController {

    @RequestMapping(value = "/queryData")
    public Message queryData(String sql, Integer ei, String verifyInfo){

        Message msg = new Message("test", "this is a test message!");
        return msg;
    }

/*    @RequestMapping(value = "requestParam")
    List<String> getAllList(@RequestParam(required = false) String entName,
                            @RequestParam(required = false)int entId,
                            @RequestParam(required = false)String verify){

        System.out.println("entName:" + entName + ", entId:" + entId + ", verify:" + verify);

        return Arrays.asList("lvhongwei", "whu", "xiongzhiyan");
    }*/
}
