package com.msp.impulse.nb.utils;

import com.iotplatform.client.NorthApiClient;
import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.ClientInfo;
import com.msp.impulse.nb.config.NBIotConfigProperties;

public class AuthUtil {

	private static NorthApiClient northApiClient = null;
	
	public static NorthApiClient initApiClient(NBIotConfigProperties nbIotConfigProperties) {
		if (northApiClient != null) {
			return northApiClient;
		}
		northApiClient = new NorthApiClient();
        //PropertyUtil.init("classpath*: nb-iot-config.properties");
        //PropertyUtil.init(System.class.getClass().getResource("/").getPath()+"./main/resources/nb-iot-config.properties");

		ClientInfo clientInfo = new ClientInfo();
        clientInfo.setPlatformIp(nbIotConfigProperties.getPlatformIp());
        clientInfo.setPlatformPort(nbIotConfigProperties.getPlatformPort());
        clientInfo.setAppId(nbIotConfigProperties.getAppId());
        clientInfo.setSecret(nbIotConfigProperties.getSecret());
//        clientInfo.setSecret(getAesPropertyValue("secret"));
        
        try {
			northApiClient.setClientInfo(clientInfo);
			northApiClient.initSSLConfig();
		} catch (NorthApiException e) {
			System.out.println(e.toString());
		}        
        
        return northApiClient;
    }
	

}
