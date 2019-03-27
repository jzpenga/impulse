package com.msp.impulse.nb.handler;

import com.iotplatform.client.dto.NotifyDeviceDataChangedDTO;
import com.msp.impulse.nb.handler.task.DataReportTask;
import com.msp.impulse.service.DataReportService;
import com.msp.impulse.vo.DataReportVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class DeviceDataChangeHandler implements IDataHandler<NotifyDeviceDataChangedDTO>{

    private Logger logger = LoggerFactory.getLogger(DeviceDataChangeHandler.class);
    private ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(5000));

    @Autowired
    private DataReportService dataReportService;

    @Override
    public void handler(NotifyDeviceDataChangedDTO dto) {

        try {
            long start = System.currentTimeMillis();
            DataReportVo dataReport = dataReportService.getDataReport(dto.getDeviceId());
            logger.info("数据获取信息时间===>"+(System.currentTimeMillis()-start)/1000f+"秒");

            DataReportTask dataReportTask = new DataReportTask(dataReport, dto, dataReportService);
            executor.execute(dataReportTask);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

}
