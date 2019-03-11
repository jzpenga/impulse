package com.msp.impulse.nb.service;

import com.msp.impulse.entity.TestMessageReceiver;
import com.msp.impulse.mapper.TestMessageReceiverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestReceiverService {

    @Autowired
    private TestMessageReceiverMapper testMessageReceiverMapper;

    public void save(TestMessageReceiver testMessageReceiver){
        testMessageReceiverMapper.insert(testMessageReceiver);
    }


}
