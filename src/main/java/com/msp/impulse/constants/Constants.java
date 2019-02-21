package com.msp.impulse.constants;

public interface Constants {
    //监测类别
    enum  MonitorType{
        TYPE_ONE("类别1", 0),
        TYPE_TWO("类别2", 1);

        private MonitorType(String name, int value){
            this.name = name;
            this.value = value;
        }
        String name;
        int value;

        public int getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
    }
    //监测类别
    enum  SwitchStatus{
        ON("开", "0"),
        OFF("关", "1");

        private SwitchStatus(String name, String value){
            this.name = name;
            this.value = value;
        }
        String name;
        String value;

        public String getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
    }
    //控制指令返回状态
    enum  ReturnStatus{
        SUCCESS("成功", "0"),
        FAIL("失败", "1");

        private ReturnStatus(String name, String value){
            this.name = name;
            this.value = value;
        }
        String name;
        String value;

        public String getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
    }



}
