package slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * slf4j测试类
 * Created by lvhw on 2016/6/13.
 */
public class TestSlf4j {
    private static Logger logger = LoggerFactory.getLogger(TestSlf4j.class);
    public static void main(String[] args) {

        logger.info("hongwei info message.");
        logger.debug("hongwei debug message.");
        logger.error("hongwei error message.");
    }
}
