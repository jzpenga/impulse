package com.msp.impulse.base;

public enum ResponseCode {
    OK(200, "成功"),
    SERVER_FAILED(500, "失败"),
    PARAMETER_VALIDATION_FAILED(2001, "参数不合法"),
    PARAMETER_ISNULL(2002, "参数为空"),
    USERNAME_OR_PWD_WRONG(3001,"用户名或者密码错误"),
    OPWD_WRONG(3002,"原密码输入不正确!"),
    NOT_LOGIN(3003,"未登录，请先登录"),
    USERNAME_NULL(3004,"请输入用户名"),
    PASSWORD_NULL(3005,"请输入密码"),
    SESSION_TIME_OUT(3006,"请重新登录！！！"),
    GATEWAYNAME_REPEAT(3007,"网关名称重复！"),
    GATEWAYNAME_NULL(3008,"网关名称为空！"),
    SENSOR_REPEAT(3009,"传感器名称重复！"),
    SENSOR_NULL(3010,"传感器名称为空！"),
    CONTRO_NOT_DONE(3011,"操作为完成，请稍后提交！"),
    RELAY_NOT_EXSIST(3012,"网关对应的继电器不存在！"),
    LOGINNAME_EXSIST(3013,"登录名已存在！"),
    INPUT_COMPAY(3014,"请输入公司相关信息！"),
    ADMINNAME_NULL(3015,"请输入管理员登录名"),
    SENSOR_NO_MUST_INPUT(3016,"请输入传感器序列号!"),
    LINKMAN_MUST_INPUT(3017,"请输入联系人信息!"),
    GATEWAY_NOT_HAVE(3018,"网关不存在!"),
    FILE_NOT_HAVE(3019,"文件不存在!"),
    PHONE_NO_MUST_HAVE(3020,"联系人电话必输!"),
    TOKEN_TIME_OUT(4000,"token失效"),
    TOKEN_CREATE_WRONG(4001,"token生成失败！！！"),
    NOT_HAVE_TOKEN(4002,"无token，请重新登录"),
    ;



    private int code;
    private String message;
    private ResponseCode(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
