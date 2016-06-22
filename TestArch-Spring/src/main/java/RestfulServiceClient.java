import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by lvhw on 2016/6/22.
 */
public class RestfulServiceClient {
    public static void main(String[] args) {
        String urlStr = "http://localhost:8080/queryDataSet?sql=select%20*%20&entId=1&verify=data";

        BufferedReader in = null;
        String result = "";
        try {
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            HttpURLConnection httpConnection = (HttpURLConnection)connection;
            httpConnection.connect();

            //获取所有的响应头字段
            Map<String, List<String>> headerFields = connection.getHeaderFields();
            for (String key : headerFields.keySet()){
                System.out.println(key + ":" + headerFields.get(key));
            }

            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    httpConnection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            System.out.println(line);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
