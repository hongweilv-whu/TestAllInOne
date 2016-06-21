package jetbrick;

import jetbrick.template.JetEngine;
import jetbrick.template.JetTemplate;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lvhw on 2016/6/11.
 */
public class JetTempUser {
    public static void main(String[] args) {
        // 0. 准备一些 Model 数据作为测试
        List<User> users = Arrays.asList(
                new User("张三", "zhangsan@qq.com"),
                new User("李四", "lisi@qq.com"),
                new User("王五", "wangwu@qq.com"));

        // 1. 创建一个默认的 JetEngin
        JetEngine engine = JetEngine.create();

        // 2. 获取一个模板对象 (从默认的 classpath 下面)
        JetTemplate template = engine.getTemplate("users.jetx");

        // 3. 创建 context 对象
        Map<String, Object> context = new HashMap<String, Object>();
        context.put("users", users);

        // 4. 渲染模板到自定义的 Writer
        StringWriter writer = new StringWriter();
        template.render(context, writer);

        // 5. 打印结果
        System.out.println(writer.toString());
    }
}
