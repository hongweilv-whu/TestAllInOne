package jio;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 如何正确的关闭输入输出流，以FileInputStream,FileOutputStream为例
 * 由文件输入输出流的正确关闭，想到JDBC连接的正确关闭问题
 * Created by lvhw on 2016/6/6.
 */
public class HowToCloseIOStream {

    public static void main(String[] args) {

        FileInputStream fin = null;
        FileOutputStream fout = null;
        try {
            fin = new FileInputStream("C:/my.txt");
            fout = new FileOutputStream("C:/mycopy.txt");

            //各种操作


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                //close时，要先判断是否为空，因为在创建时，可能就出现了异常，此时fin==null，直接调用会抛出空指针问题
                if (null != fin) {
                    fin.close();
                }
                //并没有把fout的关闭放在fin的关闭之后，因为若fin.close异常时，将会导致fout未能关闭
                /*if (null != fout){
                    fout.close();
                }*/
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (null != fout) {
                    fout.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
