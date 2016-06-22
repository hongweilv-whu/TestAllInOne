package controllers;

import junit.framework.TestCase;

/**
 * Created by lvhw on 2016/6/22.
 */
public class QueryServiceControllerTest extends TestCase {

    public void testQueryData() throws Exception {

        QueryServiceController controller = new QueryServiceController();
        System.out.println(controller.queryData("", 1, ""));;
    }
}