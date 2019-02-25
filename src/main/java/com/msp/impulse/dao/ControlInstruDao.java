package com.msp.impulse.dao;

import com.msp.impulse.entity.ControlInstru;
import com.msp.impulse.query.ControlInstruQuery;
import com.msp.impulse.query.ControllnstruUpdateQuery;

import java.text.ParseException;
import java.util.List;

public interface ControlInstruDao {
    void  save(ControlInstru controlInstru);

    List<ControlInstru> findControlInstru(ControlInstruQuery controlInstruQuery,String userId) throws ParseException;

    List<ControlInstru> getControlInstruList();

    void updateControlInstru(ControllnstruUpdateQuery updateQuery);

    List<ControlInstru> findByDealStatusAndReturnStatus(ControllnstruUpdateQuery controllnstruUpdateQuery);
}
