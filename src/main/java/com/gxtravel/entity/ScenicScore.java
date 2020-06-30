package com.gxtravel.entity;

import java.util.Date;

public class ScenicScore {
    private Integer userid;
    private Integer scenicid;
    private Double score;
    private Date time;

    public ScenicScore() {
    }

    public ScenicScore(Integer userid, Integer scenicid, Double score, Date time) {
        this.userid = userid;
        this.scenicid = scenicid;
        this.score = score;
        this.time = time;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getScenicid() {
        return scenicid;
    }

    public void setScenicid(Integer scenicid) {
        this.scenicid = scenicid;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
