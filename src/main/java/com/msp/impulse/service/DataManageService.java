package com.msp.impulse.service;

import com.github.pagehelper.PageInfo;
import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.dao.AlarmDao;
import com.msp.impulse.dao.ControlInstruDao;
import com.msp.impulse.dao.DataManageDao;
import com.msp.impulse.query.DataHistoryQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class DataManageService {
    private static Logger logger = LoggerFactory.getLogger(DataManageService.class);
    @Autowired
    private DataManageDao dataManageDao;
    @Autowired
    private AlarmDao alarmDao;
    @Autowired
    private SensorService sensorService;
    @Autowired
    private ControlInstruDao controlInstruDao;


//    public BaseResponse findHomeData() {
//        BaseResponse response=new BaseResponse();
//        HomePageDataVo homePageDataVoList= dataManageDao.findHomeData();
//        response.setData(homePageDataVoList);
//        response.setResponseMsg(ResponseCode.OK.getMessage());
//        response.setResponseCode(ResponseCode.OK.getCode());
//        return response;
//    }

//    public void extAlarmData(HttpServletResponse servletResponse) {
//        try {
//            List<Controlinstru> list = controlInstruDao.getControlInstruList();
//
//            // 存在数据可以导出
//            // 2.创建excel，创建标题
//            // 2.1创建整个excel
//            /**
//             * 整个excel：HSSFWorkbook sheet页：HSSFSheet row行：HSSFRow（写）,Row(读)
//             * cell单元格：HSSFCell（写）,Cell（读）
//             */
//            XSSFWorkbook wb = new XSSFWorkbook();
//            // 2.2在excel中创建一个sheet页
//            XSSFSheet sheet = wb.createSheet();
//            // 2.3在sheet页中创建标题行
//            XSSFRow row = sheet.createRow(0);// 创建第一行，第一行从0开始
//            // 2.4在标题行创建标题单元格
//            row.createCell(0).setCellValue("时间");
//            row.createCell(1).setCellValue("设备");
//            row.createCell(2).setCellValue("操作");
//            row.createCell(2).setCellValue("执行状态");
//
//            if (null != list && list.size() > 0) {
//                // 3.循环将数据存入excel
//                int index = 1;
//                for (Controlinstru controlInstru : list) {
//                    // 3.1循环创建行
//                    row = sheet.createRow(index++);
//                    // 3.2创建行的列,给列赋值
//                    row.createCell(0).setCellValue(controlInstru.getCreateTime());
//                    row.createCell(1).setCellValue(controlInstru.getGatewayName());
//                    row.createCell(2).setCellValue(controlInstru.getDealStatus());
//                    row.createCell(2).setCellValue(controlInstru.getReturnStatus());
//                }
//            }
//            // 4.设置response响应参数：一个流两个头
//            String filename = "警报.xlsx";
//            // 4.1一个流：response的输出流
//            ServletOutputStream os = servletResponse.getOutputStream();
//            // 4.2两个头之一：content-type，告诉前台浏览器返回数据的格式：xml,css,html,json,xls等等
//            servletResponse.setHeader("content-Type", "application/vnd.ms-excel");
//            // 4.3两个头之二：content-disposition，告诉前台浏览器数据的打开方式，附件方式打开值如下：attachment;filename=文件名
//            servletResponse.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "utf-8"));
//            // 5.将excel通过response返回到前台
//            wb.write(os);
//            wb.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error(e.getMessage(), e);
//        }
//    }
//
//    public void extControllnstruData(HttpServletResponse servletResponse) {
//        try {
//            List<Alarm> list = alarmDao.getAlarmList();
//
//            // 存在数据可以导出
//            // 2.创建excel，创建标题
//            // 2.1创建整个excel
//            /**
//             * 整个excel：HSSFWorkbook sheet页：HSSFSheet row行：HSSFRow（写）,Row(读)
//             * cell单元格：HSSFCell（写）,Cell（读）
//             */
//            XSSFWorkbook wb = new XSSFWorkbook();
//            // 2.2在excel中创建一个sheet页
//            XSSFSheet sheet = wb.createSheet();
//            // 2.3在sheet页中创建标题行
//            XSSFRow row = sheet.createRow(0);// 创建第一行，第一行从0开始
//            // 2.4在标题行创建标题单元格
//            row.createCell(0).setCellValue("时间");
//            row.createCell(1).setCellValue("设备");
//            row.createCell(2).setCellValue("警报类型");
//
//            if (null != list && list.size() > 0) {
//                // 3.循环将数据存入excel
//                int index = 1;
//                for (Alarm alarm : list) {
//                    // 3.1循环创建行
//                    row = sheet.createRow(index++);
//                    // 3.2创建行的列,给列赋值
//                    row.createCell(0).setCellValue(alarm.getCreateTime());
//                    row.createCell(1).setCellValue(alarm.getGatewayName());
//                    row.createCell(2).setCellValue(alarm.getAlarmType());
//                }
//            }
//            // 4.设置response响应参数：一个流两个头
//            String filename = "警报.xlsx";
//            // 4.1一个流：response的输出流
//            ServletOutputStream os = servletResponse.getOutputStream();
//            // 4.2两个头之一：content-type，告诉前台浏览器返回数据的格式：xml,css,html,json,xls等等
//            servletResponse.setHeader("content-Type", "application/vnd.ms-excel");
//            // 4.3两个头之二：content-disposition，告诉前台浏览器数据的打开方式，附件方式打开值如下：attachment;filename=文件名
//            servletResponse.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "utf-8"));
//            // 5.将excel通过response返回到前台
//            wb.write(os);
//            wb.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error(e.getMessage(), e);
//        }
//    }

//    /**
//     *网关传感器地理位置
//     * @return
//     */
//    public BaseResponse findMapData() {
//        BaseResponse response=new BaseResponse();
//        Map<String, Object> mapMap = dataManageDao.findGatewayMap();
//        HashMap map=new HashMap();
//        map.put("mapData",mapMap);
//        response.setData(map);
//        response.setResponseMsg(ResponseCode.OK.getMessage());
//        response.setResponseCode(ResponseCode.OK.getCode());
//        return response;
//    }

//    /**
//     *查询历史数据
//     * @param dataHistoryQuery
//     * @return
//     */
//    public BaseResponse findHistoryData(DataHistoryQuery dataHistoryQuery) throws ParseException {
//        BaseResponse response=new BaseResponse();
//        List<DataHistory> valueList = dataManageDao.findHistoryData(dataHistoryQuery);
//        response.setData(valueList);
//        response.setResponseMsg(ResponseCode.OK.getMessage());
//        response.setResponseCode(ResponseCode.OK.getCode());
//        return response;
//
//    }

    /**
     * 查询实时数据
     * @param dataHistoryQuery
     * @return
     */
    public BaseResponse findRealTimeData(DataHistoryQuery dataHistoryQuery) throws ParseException {
        BaseResponse response=new BaseResponse();
        PageInfo pageInfo = dataManageDao.findRealTimeData(dataHistoryQuery);
        /*List<DataReportEntity> list = pageInfo.getList();
        for (DataReportEntity dataReportEntity : list) {
            if (!dataReportEntity.getEventTime().contains("20190304")) {
            }else {
                dataReportEntity.setSensorName("智能压力液位变送器150240");
            }
            dataReportEntity.setUserName("环宇智谷测试");
        }*/

        response.setData(pageInfo);
        response.setResponseMsg(ResponseCode.OK.getMessage());
        response.setResponseCode(ResponseCode.OK.getCode());
        return response;
    }
}
