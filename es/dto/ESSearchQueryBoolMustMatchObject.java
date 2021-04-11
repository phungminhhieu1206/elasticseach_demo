/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tav.web.dto;

/**
 *
 * @author HieuPhung
 */
public class ESSearchQueryBoolMustMatchObject {
    
    
    // Các trường tìm kiếm
    private Long bdaid; // Kết quả
    private Long categoryid; // Loại
    private Long ord_classid; // Lớp BM
    private Long targetid; // Mục tiêu
    private Long airacrftid; // Máy bay
    private Long ordnanceid; // BM

    public Long getBdaid() {
        return bdaid;
    }

    public void setBdaid(Long bdaid) {
        this.bdaid = bdaid;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public Long getOrd_classid() {
        return ord_classid;
    }

    public void setOrd_classid(Long ord_classid) {
        this.ord_classid = ord_classid;
    }

    public Long getTargetid() {
        return targetid;
    }

    public void setTargetid(Long targetid) {
        this.targetid = targetid;
    }

    public Long getAiracrftid() {
        return airacrftid;
    }

    public void setAiracrftid(Long airacrftid) {
        this.airacrftid = airacrftid;
    }

    public Long getOrdnanceid() {
        return ordnanceid;
    }

    public void setOrdnanceid(Long ordnanceid) {
        this.ordnanceid = ordnanceid;
    }

}
