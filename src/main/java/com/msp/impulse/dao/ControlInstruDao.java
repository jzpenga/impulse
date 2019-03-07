package com.msp.impulse.dao;

import com.msp.impulse.entity.Controlinstru;
import com.msp.impulse.entity.PageBean;
import com.msp.impulse.query.ControlInstruQuery;
import com.msp.impulse.query.ControllnstruUpdateQuery;

import java.text.ParseException;
import java.util.List;

public interface ControlInstruDao {
    void  save(Controlinstru controlInstru);

    PageBean findControlInstru(ControlInstruQuery controlInstruQuery, String userId) throws ParseException;

    List<Controlinstru> getControlInstruList();

    void updateControlInstru(ControllnstruUpdateQuery updateQuery);

    List<Controlinstru> findByDealStatusAndReturnStatus(ControllnstruUpdateQuery controllnstruUpdateQuery);
}
