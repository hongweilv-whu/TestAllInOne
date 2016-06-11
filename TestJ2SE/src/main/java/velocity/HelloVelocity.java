package velocity;

import lambda.pojos.*;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by lvhw on 2016/6/10.
 */
public class HelloVelocity {
    public static void main(String[] args) {
        VelocityEngine ve = new VelocityEngine();

        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();

        Template t = ve.getTemplate("Hellovelocity.vm");
        VelocityContext vc = new VelocityContext();
        vc.put("name", "lvhongwei");
        vc.put("date", new Date().toString());

        List<Integer> list = Arrays.asList(1, 2, 3);
        vc.put("list", list);

        Person person = new Person();
        person.setId(340321);
        person.setName("lvhongwei");
        person.setAge(28);
        person.setBirthday(new Date(1989, 05, 20));

        vc.put("person", person);

        StringWriter sw = new StringWriter();
        t.merge(vc, sw);
        System.out.println(sw.toString());
    }
}
