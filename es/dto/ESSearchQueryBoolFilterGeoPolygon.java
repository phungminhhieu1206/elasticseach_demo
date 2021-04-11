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
public class ESSearchQueryBoolFilterGeoPolygon {
    
    private ESSearchQueryBoolFilterGeoPolygonPinLocation location = new ESSearchQueryBoolFilterGeoPolygonPinLocation();

    public ESSearchQueryBoolFilterGeoPolygonPinLocation getLocation() {
        return location;
    }

    public void setLocation(ESSearchQueryBoolFilterGeoPolygonPinLocation location) {
        this.location = location;
    }
    
    
    
}
