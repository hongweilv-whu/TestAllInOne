package log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Log4j测试类
 * Created by lvhw on 2016/6/12.
 */
public class TestLog4j {

    private static Logger logger = Logger.getLogger(TestLog4j.class);

    static {
        //BasicConfigurator.configure();
        //PropertyConfigurator.configure ("../log4j.properties");
    }

    public static void main(String[] args) {

        // System.out.println("This is println message.");

        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
        logger.fatal("This is fatal message");
        System.out.println("lvhongwei exit");
    }
}
