package io.jio;


import java.io.*;

/**
 * Created by lvhw on 2016/6/6.
 */
public class CopyTxtFile {
    public static void main(String[] args) {

        BufferedInputStream bin = null;
        BufferedOutputStream bout = null;
        try {
            bin = new BufferedInputStream(new FileInputStream("my.txt"));
            bout = new BufferedOutputStream(new FileOutputStream("mycopy.txt"));

            //按照多个字节的方式读写,1024
            int readLen = 0;
            byte[] bytes = new byte[1024];
            while ((readLen = bin.read(bytes)) != -1) {
                bout.write(bytes, 0, readLen);
                //注意此处写法：读了多少就从缓存bytes中取出多少，而不是把bytes中的全部写出
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                if (null != bin){
                    bin.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (null != bout){
                    bout.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
