package com.msp.impulse.nb.controller;

import com.msp.impulse.entity.TestMessageReceiver;
import com.msp.impulse.nb.service.TestReceiverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@EnableAutoConfiguration
public class TestReceiverController {
    private static Logger logger = LoggerFactory.getLogger(TestReceiverController.class);

    private final String callbackurl = "/v1.0.0/testReceiver";

    @Autowired
    private TestReceiverService testReceiverService;


    public TestReceiverController() {
    }

    @RequestMapping(
        value = {"/v1.0.0/testReceiver"},
        method = {RequestMethod.POST}
    )
    @ResponseBody
    public String receive(@RequestBody String body) throws Exception {
        System.out.println("receiver ====> "+body);
        TestMessageReceiver testMessageReceiver = new TestMessageReceiver();
        testMessageReceiver.setCreateTime(new Date());
        testMessageReceiver.setValue(body);
        testReceiverService.save(testMessageReceiver);
        return "ok";
    }


}
