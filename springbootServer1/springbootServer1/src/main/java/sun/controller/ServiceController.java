/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package sun.controller;

import common.entity.RestfulResult;
import common.utils.CommUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.entity.ServiceInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController // 重要，如果用Controller会404
@RequestMapping(value = "service")
public class ServiceController {

    @RequestMapping(value = "hello")
    public void login(HttpServletRequest request, HttpServletResponse response,
                      ServiceInfo serviceInfo) {

        RestfulResult restfulResult = new RestfulResult();
        serviceInfo.setName("lisi");

        try {
            restfulResult.setData("Service2:Welcome " + serviceInfo.getName() + "!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        CommUtils.printDataJason(response, restfulResult);
    }

    @RequestMapping(value = "rest")
    public String rest(ServiceInfo serviceInfo){
        serviceInfo.setName("wangwu");
        return "Service2:Welcome " + serviceInfo.getName() + " !";
    }
}