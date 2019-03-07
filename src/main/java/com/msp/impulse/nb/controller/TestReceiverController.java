package com.msp.impulse.nb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class TestReceiverController {
    private static Logger logger = LoggerFactory.getLogger(TestReceiverController.class);

    private final String callbackurl = "/v1.0.0/testReceiver";
    private final String callbackurl_nbcmd = "/v1.0.0/testReceiver/cmd";


    public TestReceiverController() {
    }

    @RequestMapping(
        value = {"/v1.0.0/testReceiver"},
        method = {RequestMethod.POST}
    )
    @ResponseBody
    public String receive(@RequestBody String body) throws Exception {
        System.out.println("receiver ====> "+body);
        return "ok";
    }


}
