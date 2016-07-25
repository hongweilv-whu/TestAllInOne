package csv;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * Created by lvhw on 2016/7/19.
 */
public class CsvHandlerTest {

    @org.junit.Test
    public void testWrite2Byte2() throws Exception {
        CsvHandler handler = new CsvHandler();
        List<Object> head = new ArrayList<Object>();
        head.add("字段1");
        head.add("总量");
        head.add("日期");

        List<List<Object>> data = new ArrayList<>();
        data.add(Arrays.asList(100, "=\"34032122347890\"", "Jan 1, 2000 12:00:00 AM"));
        data.add(Arrays.asList(400, 84032122347890L, "hello, csv"));
        data.add(Arrays.asList(700, 64032122347890L, "Jan 1, 2016 12:00:00 AM"));


        FileOutputStream fos = null;
        try {
            byte[] result = handler.write2Bytes(head, data);
            fos = new FileOutputStream("D:/export1.csv");

            fos.write(result);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                if (null != fos)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}