package com.nhom12.entity;

import java.util.Date;

public class Period {
    private int periodID;
    private Date beginning;
    private Date end;
    private String periodName;
    private int createFor;
    private int typeID; // của periodName
    private int mainPeriod; // đợt đăng ký chính -> ví dụ đợt của sinh viên đăng ký từ đề tài của đợt cho giáo viên

    public Period() {
    }

    public Period(int periodID, Date beginning, Date end, String periodName, int createFor, int typeID, int mainPeriod) {
        this.periodID = periodID;
        this.beginning = beginning;
        this.end = end;
        this.periodName = periodName;
        this.createFor = createFor;
        this.typeID = typeID;
        this.mainPeriod = mainPeriod;
    }

    public int getPeriodID() {
        return periodID;
    }

    public void setPeriodID(int periodID) {
        this.periodID = periodID;
    }

    public Date getBeginning() {
        return beginning;
    }

    public void setBeginning(Date beginning) {
        this.beginning = beginning;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public int getCreateFor() {
        return createFor;
    }

    public void setCreateFor(int createFor) {
        this.createFor = createFor;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public int getMainPeriod() {
        return mainPeriod;
    }

    public void setMainPeriod(int mainPeriod) {
        this.mainPeriod = mainPeriod;
    }

    
}
