package cn.aegisa.raspberry.aihomefacade.service.impl;

import cn.aegisa.raspberry.aihomefacade.service.HomeService;
import cn.aegisa.raspberry.aihomefacade.vo.InvokeResult;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Using IntelliJ IDEA.
 *
 * @author XIANYINGDA at 10/12/2018 7:35 PM
 */
@Service
@Slf4j
public class HomeServiceImpl implements HomeService {
    @Override
    public InvokeResult doSwitch(String token) throws Exception {
        final CloseableHttpClient client = HttpClients.createDefault();
        final HttpPost post = new HttpPost("http://sl.aegisa.cn:8080/app/light/switch?token=" + token);
        final CloseableHttpResponse response = client.execute(post);
        final InputStream content = response.getEntity().getContent();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(content));
        final String result = reader.readLine();
        reader.close();
        final InvokeResult invokeResult = JSON.parseObject(result, InvokeResult.class);
        log.info("执行结果：{}", JSON.toJSONString(invokeResult));
        return invokeResult;
    }

    @Override
    public InvokeResult getStatus(String token) throws Exception {
        final CloseableHttpClient client = HttpClients.createDefault();
        final HttpPost post = new HttpPost("http://sl.aegisa.cn:8080/app/light/status?token=" + token);
        final CloseableHttpResponse response = client.execute(post);
        final InputStream content = response.getEntity().getContent();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(content));
        final String result = reader.readLine();
        reader.close();
        final InvokeResult invokeResult = JSON.parseObject(result, InvokeResult.class);
        log.info("执行结果：{}", JSON.toJSONString(invokeResult));
        return invokeResult;
    }
}
