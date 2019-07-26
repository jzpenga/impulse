package com.msp.impulse.nb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(
        prefix = "nb"
)
public class NBIotConfigProperties {

    private String platformIp;
    private String platformPort;
    private String appId;
    private String secret;
    private String manufacturerId;
    private String manufacturerName;
    private String dataCallbackUrl;

    public String getPlatformIp() {
        return platformIp;
    }

    public void setPlatformIp(String platformIp) {
        this.platformIp = platformIp;
    }

    public String getPlatformPort() {
        return platformPort;
    }

    public void setPlatformPort(String platformPort) {
        this.platformPort = platformPort;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getDataCallbackUrl() {
        return dataCallbackUrl;
    }

    public void setDataCallbackUrl(String dataCallbackUrl) {
        this.dataCallbackUrl = dataCallbackUrl;
    }
}
