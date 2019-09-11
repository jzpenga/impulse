package com.msp.impulse.nb.listener;

import com.iotplatform.client.NorthApiClient;
import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.*;
import com.iotplatform.client.invokeapi.Authentication;
import com.iotplatform.client.invokeapi.SubscriptionManagement;
import com.iotplatform.utils.PropertyUtil;
import com.msp.impulse.nb.utils.AuthUtil;
import com.msp.impulse.nb.config.NBIotConfigProperties;
import com.msp.impulse.nb.utils.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationMessageReceiver implements ApplicationListener<ApplicationReadyEvent> {

    private Logger logger = LoggerFactory.getLogger(ApplicationMessageReceiver.class);


    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        //应用启动成功，注册回调
        try {
            /**---------------------initialize northApiClient------------------------*/
            NBIotConfigProperties iotConfigProperties = SpringContextHolder.getBean(NBIotConfigProperties.class);
            NorthApiClient northApiClient = AuthUtil.initApiClient(iotConfigProperties);
            SubscriptionManagement subscriptionManagement = new SubscriptionManagement(northApiClient);

            /**---------------------get accessToken at first------------------------*/
            Authentication authentication = new Authentication(northApiClient);
            AuthOutDTO authOutDTO = authentication.getAuthToken();
            String accessToken = authOutDTO.getAccessToken();


            /**---------------------query batch subscriptions------------------------*/
            System.out.println("\n======query batch subscriptions======");
            QueryBatchSubInDTO qbsInDTO = new QueryBatchSubInDTO();
            qbsInDTO.setAppId(PropertyUtil.getProperty("appId"));
            QueryBatchSubOutDTO qbsOutDTO = subscriptionManagement.queryBatchSubscriptions(qbsInDTO, accessToken);
            System.out.println(qbsOutDTO.toString());


            if (qbsOutDTO.getTotalCount()<=0){
                /**---------------------sub deviceAdded notification------------------------*/
                //note: 10.X.X.X is a LAN IP, not a public IP, so subscription callbackUrl's IP cannot be 10.X.X.X
                System.out.println("======subscribe to device business data notification======");
                String callbackUrl = iotConfigProperties.getDataCallbackUrl();//this is a test callbackUrl
                //subDeviceData(subscriptionManagement, "deviceAdded", callbackUrl, accessToken);
                subDeviceData(subscriptionManagement, "deviceDataChanged", callbackUrl, accessToken);
            }

        }catch (Exception e){
            logger.error("订阅出错"+e.getMessage());
            e.printStackTrace();
        }
    }


    private static SubscriptionDTO subDeviceData(SubscriptionManagement subscriptionManagement,
                                                 String notifyType, String callbackUrl, String accessToken) {
        SubDeviceDataInDTO sddInDTO = new SubDeviceDataInDTO();
        sddInDTO.setNotifyType(notifyType);
        sddInDTO.setCallbackUrl(callbackUrl);
        try {
            SubscriptionDTO subDTO = subscriptionManagement.subDeviceData(sddInDTO, null, accessToken);
            System.out.println(subDTO.toString());
            return subDTO;
        } catch (NorthApiException e) {
            System.out.println(e.toString());
        }
        return null;
    }


    private static void subDeviceManagementData(SubscriptionManagement subscriptionManagement,
                                                String notifyType, String callbackUrl, String accessToken) {
        SubDeviceManagementDataInDTO sddInDTO = new SubDeviceManagementDataInDTO();
        sddInDTO.setNotifyType(notifyType);
        sddInDTO.setCallbackurl(callbackUrl);
        try {
            subscriptionManagement.subDeviceData(sddInDTO, accessToken);
            System.out.println("subscribe to device management data succeeds");
        } catch (NorthApiException e) {
            System.out.println(e.toString());
        }
        return;
    }
}
