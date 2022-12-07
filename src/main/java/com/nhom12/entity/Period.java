package com.nhom12.entity;

import java.util.Date;

public class Period {
    private int periodID;
    private Date beginning;
    private Date end;
    private String topicType;
    private int createFor;

    public Period(int periodID, Date beginning, Date end, String topicType, int createFor) {
        this.periodID = periodID;
        this.beginning = beginning;
        this.end = end;
        this.topicType = topicType;
        this.createFor = createFor;
    }

    public int getPeriodID() {
        return periodID;
    }

    public void setPeriodID(int periodID) {
        this.periodID = periodID;
    }

    public Period() {
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

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    public int getCreateFor() {
        return createFor;
    }

    public void setCreateFor(int createFor) {
        this.createFor = createFor;
    }

    
}
