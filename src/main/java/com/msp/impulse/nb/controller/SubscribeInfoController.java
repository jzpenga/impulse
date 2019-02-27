package com.msp.impulse.nb.controller;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.entity.Company;
import com.msp.impulse.nb.entity.SubscribeInfoEntity;
import com.msp.impulse.nb.service.SubscribeInfoService;
import com.msp.impulse.service.UserService;
import com.msp.impulse.util.HttpClientUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1.0.0/subscribeData")
public class SubscribeInfoController {

    @Autowired
    private SubscribeInfoService subscribeInfoService;

    @Autowired
    private UserService userService;
    /**
     * 200成功
     *
     * 400 callbackUrl 为空
     * 403 用户名密码认证失败
     *
     * 503调用callbaseUrl接口失败，注册接口失败
     */
    @PostMapping
    public BaseResponse<Object> subscribeData(@RequestBody SubscribeInfoEntity subscribeInfoEntity){
        BaseResponse<Object> baseResponse = new BaseResponse<>();
        if (StringUtils.isEmpty(subscribeInfoEntity.getCallbackUrl())){
            baseResponse.setResponseCode(400);
            baseResponse.setResponseMsg("接口调用失败！");
            return baseResponse;
        }

        Company company = userService.findByNameAndPwd(subscribeInfoEntity.getLoginName(), subscribeInfoEntity.getPassword()).getData();
        if (company!=null){
            //验证成功
            String TEST_JSON = "www";
            String response = HttpClientUtil.doPostJson(subscribeInfoEntity.getCallbackUrl(), TEST_JSON);
            if (StringUtils.isEmpty(response) || "{".equals(response)){
                //调用接口失败
                baseResponse.setResponseCode(503);
                baseResponse.setResponseMsg("接口调用失败！");
            }else {
                //入库
                subscribeInfoEntity.setPassword("");
                SubscribeInfoEntity entity = subscribeInfoService.saveSubscribeInfo(subscribeInfoEntity);
                if (entity!=null){
                    baseResponse.setResponseCode(200);
                    baseResponse.setResponseMsg("success !");
                }else {
                    baseResponse.setResponseCode(500);
                    baseResponse.setResponseMsg("fail !");
                }
            }
        }else {
            baseResponse.setResponseCode(403);
            baseResponse.setResponseMsg("用户名密码认证失败");
        }
        return baseResponse;
    }

}
