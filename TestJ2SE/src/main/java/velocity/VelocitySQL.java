package velocity;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;

/**
 * Created by lvhw on 2016/6/11.
 */
public class VelocitySQL {
    public static void main(String[] args) {
        VelocityEngine engine = new VelocityEngine();
        engine.init();

        VelocityContext context = new VelocityContext();
        context.put("fields", "Customer.name, Contact.address");
        context.put("fromtables", "Customer, Contact");
        context.put("conditions", "Customer.ownerID");
        context.put("currentOwnerId", 111);

        String template = "SELECT ${fields} FROM ${fromtables} WHERE ${conditions}=${currentOwnerId}";

        StringWriter sw =  new StringWriter();

        engine.evaluate(context, sw, "", template);

        System.out.println(sw.toString());

    }
}
