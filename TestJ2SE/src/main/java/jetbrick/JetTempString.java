package jetbrick;

import jetbrick.template.JetEngine;
import jetbrick.template.JetTemplate;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lvhw on 2016/6/11.
 */
public class JetTempString {

    public static void main(String[] args) {
        JetEngine engine = JetEngine.create();
        String templatestr = "SELECT ${fields} FROM ${fromtables} WHERE ${conditions}=${currentOwnerId}";
        JetTemplate template = engine.createTemplate(templatestr);

        Map<String, Object> context = new HashMap<>();
        context.put("fields", "Customer.name, Contact.address");
        context.put("fromtables", "Customer, Contact");
        context.put("conditions", "Customer.ownerID");
        context.put("currentOwnerId", 111);

        StringWriter sw = new StringWriter();

        template.render(context, sw);

        System.out.println(sw.toString());


    }
}
