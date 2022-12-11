package com.nhom12.dao;

import com.nhom12.entity.Period;
import java.util.Date;
import java.util.List;

public interface PeriodDAO {

    List<Period> getAllPeriods();

    void addPeriod(java.sql.Date beginning, java.sql.Date end, String periodName, int creatFor, int typeID, int mainPeriod);

    List<Period> getMainPeriods();

    void updatePeriodFor(int periodID, int mainPeriod);
    
}
