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
public class ESSearchQueryBoolFilter {
    
    private ESSearchQueryBoolFilterGeoPolygon geo_polygon = new ESSearchQueryBoolFilterGeoPolygon();

    public ESSearchQueryBoolFilterGeoPolygon getGeo_polygon() {
        return geo_polygon;
    }

    public void setGeo_polygon(ESSearchQueryBoolFilterGeoPolygon geo_polygon) {
        this.geo_polygon = geo_polygon;
    }
    
    
    
}
