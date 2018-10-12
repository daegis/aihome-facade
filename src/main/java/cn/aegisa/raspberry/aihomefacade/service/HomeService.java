package cn.aegisa.raspberry.aihomefacade.service;

import cn.aegisa.raspberry.aihomefacade.vo.InvokeResult;

/**
 * Using IntelliJ IDEA.
 *
 * @author XIANYINGDA at 10/12/2018 7:35 PM
 */
public interface HomeService {
    InvokeResult doSwitch(String token) throws Exception;

    InvokeResult getStatus(String token) throws Exception;
}
