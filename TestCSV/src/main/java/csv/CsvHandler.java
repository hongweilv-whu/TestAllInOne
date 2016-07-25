package csv;

import com.csvreader.CsvWriter;

import java.io.*;
import java.util.List;

/**
 * csv文件处理类
 * Created by lvhw on 2016/7/18.
 */
public class CsvHandler {

    public byte[] write2Bytes(List<Object> head, List<List<Object>> data){
        BufferedWriter csvWtriter = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {

            //utf8编码
            byteArrayOutputStream = new ByteArrayOutputStream();
            csvWtriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, "GB2312"), 1024);
            CsvWriter writer = new CsvWriter(csvWtriter, ',');

            //写头
            writeRow(head, writer);

            //写数据
            for (List<Object> row : data) {
                writeRow(row, writer);
            }
            csvWtriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != csvWtriter)
                    csvWtriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return byteArrayOutputStream.toByteArray();

    }

    private static void writeRow(List<Object> row, CsvWriter writer) throws IOException {
        for (Object o : row) {
            writer.write(o.toString());
        }
        writer.endRecord();
    }

    public static void main(String[] args) {

    }
}
