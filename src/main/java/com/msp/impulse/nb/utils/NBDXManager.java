package com.msp.impulse.nb.utils;

import com.iotplatform.client.NorthApiClient;
import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.*;
import com.iotplatform.client.invokeapi.Authentication;
import com.iotplatform.client.invokeapi.DeviceManagement;
import com.msp.impulse.nb.config.NBIotConfigProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 电信运营商
 */

public class NBDXManager {

    private static Logger logger = LoggerFactory.getLogger(NBDXManager.class);

    private static final String MANUFACTURER_ID_New = "b706451dbc604aaba9d2f9398eaeaf5d";

    public static  RegDirectDeviceOutDTO registerDevice(DeviceInfo infoEntity) {

        try {
            /**---------------------initialize northApiClient------------------------*/
            NorthApiClient northApiClient = AuthUtil.initApiClient(SpringContextHolder.getBean(NBIotConfigProperties.class));
            DeviceManagement deviceManagement = new DeviceManagement(northApiClient);

            /**---------------------get accessToken at first------------------------*/
            Authentication authentication = new Authentication(northApiClient);
            AuthOutDTO authOutDTO = authentication.getAuthToken();
            String accessToken = authOutDTO.getAccessToken();

            //fill input parameters
            RegDirectDeviceInDTO2 rddid = new RegDirectDeviceInDTO2();
            rddid.setNodeId(infoEntity.getNodeId());
            rddid.setVerifyCode(infoEntity.getNodeId());
            rddid.setTimeout(0);

            RegDirectDeviceOutDTO rddod = deviceManagement.regDirectDevice(rddid, null, accessToken);
            logger.info("register success=====> "+rddod.toString());

            boolean modifyInfoFlag = false;
            for (int i = 0; i < 3; i++) {
                modifyInfoFlag = modifyDeviceInfo(deviceManagement,accessToken,rddod.getDeviceId(),infoEntity);
               if (modifyInfoFlag) break;
            }
            if (!modifyInfoFlag){
                logger.info("modify fail =====> "+rddod.getDeviceId() +" delete Device ");
                deleteDevice(rddod.getDeviceId());
                return null;
            }
            return rddod;
        } catch (Exception e) {
           // System.out.println(e.toString());
            logger.error(e.toString());
        }
        return null;
    }


    private static  boolean modifyDeviceInfo(DeviceManagement deviceManagement, String accessToken,String deviceId, DeviceInfo deviceInfo) {
        NBIotConfigProperties nbIotConfigProperties = SpringContextHolder.getBean(NBIotConfigProperties.class);
        ModifyDeviceInforInDTO mdiInDTO = new ModifyDeviceInforInDTO();
        mdiInDTO.setName(deviceInfo.getName());
        mdiInDTO.setDeviceType(deviceInfo.getDeviceType());
        mdiInDTO.setManufacturerId("HY600".equals(deviceInfo.getModel())?nbIotConfigProperties.getManufacturerId():MANUFACTURER_ID_New);
        mdiInDTO.setManufacturerName(nbIotConfigProperties.getManufacturerName());
        mdiInDTO.setModel(deviceInfo.getModel());
        mdiInDTO.setProtocolType("CoAP");
        try {
            deviceManagement.modifyDeviceInfo(mdiInDTO, deviceId, null, accessToken);
            logger.info("modify device info succeeded =====>"+deviceId);
            return true;
        } catch (NorthApiException e) {
            logger.error("modify device info succeeded =====>"+deviceId);
        }
        return  false;
    }

    public static boolean deleteDevice(String deviceId){
        try {
            /**---------------------initialize northApiClient------------------------*/
            NorthApiClient northApiClient = AuthUtil.initApiClient(SpringContextHolder.getBean(NBIotConfigProperties.class));
            DeviceManagement deviceManagement = new DeviceManagement(northApiClient);

            /**---------------------get accessToken at first------------------------*/
            Authentication authentication = new Authentication(northApiClient);
            AuthOutDTO authOutDTO = authentication.getAuthToken();
            String accessToken = authOutDTO.getAccessToken();

            deviceManagement.deleteDirectDevice(deviceId, true, null, accessToken);
            logger.info("delete device  succeeded =====>"+deviceId);

            return true;
        } catch (NorthApiException e) {
            System.out.println(e.toString());
        }
        return false;
    }

}
