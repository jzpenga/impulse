package com.msp.impulse;

import com.iotplatform.client.dto.DeviceInfo;
import com.msp.impulse.entity.Company;
import com.msp.impulse.nb.utils.NBDXManager;
import com.msp.impulse.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    @Autowired
    private UserService userService;

    @Test
    public void testAddUser() {
        Company company = new Company();
        company.setLoginName("tom");
        company.setPassword("123456");
        userService.addUser(company);
    }


}
