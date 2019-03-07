package com.msp.impulse.query;

import com.msp.impulse.entity.Gateway;
import com.msp.impulse.entity.Pass;
import com.msp.impulse.entity.Relay;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("新增网关")
public class GatewayAddQuery {
    @ApiModelProperty(name = "passList", value = "通道list", example = "")
    private List<Pass> passList;
    @ApiModelProperty(name = "gateway", value = "网关", example = "")
    private Gateway gateway;
    @ApiModelProperty(name = "relayList", value = "继电器list", example = "")
    private List<Relay> relayList;

    public List<Pass> getPassList() {
        return passList;
    }

    public void setPassList(List<Pass> passList) {
        this.passList = passList;
    }

    public Gateway getGateway() {
        return gateway;
    }

    public void setGateway(Gateway gateway) {
        this.gateway = gateway;
    }

    public List<Relay> getRelayList() {
        return relayList;
    }

    public void setRelayList(List<Relay> relayList) {
        this.relayList = relayList;
    }
}
