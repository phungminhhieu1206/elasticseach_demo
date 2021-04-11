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
public class ESObject {
    
    private Long gid;
    private String shape;
    private String createddate;
    private Double lat;
    private Double lon;
    private Long num_acrft;
    private String airacrft;
    private Long load_lbs;
    private String ordnance;
    private String ord_class;
    private String category;
    private String target;
    private String bda;
    private String dcode;
    private String pcode;
    private String latlonkey;
    private Long shapeid;
    private Long airacrftid;
    private Long ordnanceid;
    private Long ord_classid;
    private Long categoryid;
    private Long targetid;
    private Long bdaid;
    private String createddateST;
    private ESLocation pin;

    public ESLocation getPin() {
        return pin;
    }

    public void setPin(ESLocation pin) {
        this.pin = pin;
    }
    
    

    public String getCreateddateST() {
        return createddateST;
    }

    public void setCreateddateST(String createddateST) {
        this.createddateST = createddateST;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Long getNum_acrft() {
        return num_acrft;
    }

    public void setNum_acrft(Long num_acrft) {
        this.num_acrft = num_acrft;
    }

    public String getAiracrft() {
        return airacrft;
    }

    public void setAiracrft(String airacrft) {
        this.airacrft = airacrft;
    }

    public Long getLoad_lbs() {
        return load_lbs;
    }

    public void setLoad_lbs(Long load_lbs) {
        this.load_lbs = load_lbs;
    }

    public String getOrdnance() {
        return ordnance;
    }

    public void setOrdnance(String ordnance) {
        this.ordnance = ordnance;
    }

    public String getOrd_class() {
        return ord_class;
    }

    public void setOrd_class(String ord_class) {
        this.ord_class = ord_class;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getBda() {
        return bda;
    }

    public void setBda(String bda) {
        this.bda = bda;
    }

    public String getDcode() {
        return dcode;
    }

    public void setDcode(String dcode) {
        this.dcode = dcode;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getLatlonkey() {
        return latlonkey;
    }

    public void setLatlonkey(String latlonkey) {
        this.latlonkey = latlonkey;
    }

    public Long getShapeid() {
        return shapeid;
    }

    public void setShapeid(Long shapeid) {
        this.shapeid = shapeid;
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

    public Long getOrd_classid() {
        return ord_classid;
    }

    public void setOrd_classid(Long ord_classid) {
        this.ord_classid = ord_classid;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public Long getTargetid() {
        return targetid;
    }

    public void setTargetid(Long targetid) {
        this.targetid = targetid;
    }

    public Long getBdaid() {
        return bdaid;
    }

    public void setBdaid(Long bdaid) {
        this.bdaid = bdaid;
    }

    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    
}
