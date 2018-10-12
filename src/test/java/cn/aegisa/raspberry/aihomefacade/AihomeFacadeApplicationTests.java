package cn.aegisa.raspberry.aihomefacade;

import cn.aegisa.raspberry.aihomefacade.service.HomeService;
import cn.aegisa.raspberry.aihomefacade.vo.InvokeResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AihomeFacadeApplicationTests {

    @Autowired
    private HomeService homeService;

    @Test
    public void contextLoads() throws Exception {
        final InvokeResult invokeResult = homeService.doSwitch("941203shuang");
    }

}
