package stringutils;

import org.apache.commons.lang.StringUtils;

/**
 * Description:
 * Created by lvhw on 2016/8/3 19:19.
 */
public class StringUtilsClient {

    public static void main(String[] args) {
        System.out.println(StringUtils.substringBefore("说点好什么好呢","好"));
        //从左往右查到相等的字符开始，保留后边的，不包含等于的字符。本例：什么好呢
        System.out.println(StringUtils.substringAfter("说点什么好呢","点"));
        //这个也是截取到相等的字符，但是是从右往左.本例结果：说点什么好
        System.out.println(StringUtils.substringBeforeLast("说点什么好点呢","点"));
    }
}
