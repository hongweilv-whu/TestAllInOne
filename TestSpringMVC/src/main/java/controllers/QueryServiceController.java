package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Message;

import java.util.Arrays;
import java.util.List;

/**
 * 查询服务控制器
 * Created by lvhw on 2016/6/20.
 */
//@RestController
@Controller
@RequestMapping(value = "/")
public class QueryServiceController {

    @ResponseBody
    @RequestMapping(value = "/queryData")
    //方法参数不能用原生类型
    public Message queryData(String sql, Integer ei, String verifyInfo){

        Message msg = new Message("test", "this is a test message!");
        return msg;
    }

    @ResponseBody
    @RequestMapping(value = "/queryDataSet")//queryData2前面的'/'可有可无，后面的必需
    List<String> getAllList(@RequestParam(required = true) String sql,
                            @RequestParam(required = true)Integer entId,
                            @RequestParam(required = true)String verify){

        System.out.println("sql:" + sql + ", entId:" + entId + ", verify:" + verify);

        return Arrays.asList(sql, String.valueOf(entId), verify);
    }
}
