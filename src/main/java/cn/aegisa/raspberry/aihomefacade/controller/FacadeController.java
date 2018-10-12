package cn.aegisa.raspberry.aihomefacade.controller;

import cn.aegisa.raspberry.aihomefacade.service.HomeService;
import cn.aegisa.raspberry.aihomefacade.vo.InvokeResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Using IntelliJ IDEA.
 *
 * @author XIANYINGDA at 10/12/2018 7:37 PM
 */
@Controller
@Slf4j
public class FacadeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/light/{token}")
    @ResponseBody
    public InvokeResult doSwitch(@PathVariable String token) throws Exception {
        return homeService.doSwitch(token);
    }

    @GetMapping("/status/{token}")
    @ResponseBody
    public InvokeResult getStatus(@PathVariable String token) throws Exception {
        return homeService.getStatus(token);
    }

    @RequestMapping("/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/index.html");
    }
}
