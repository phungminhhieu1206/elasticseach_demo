/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tav.web.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HieuPhung
 */
public class ESSearchQueryBoolFilterGeoPolygonPinLocation {
    
    private List<List<Double>> points = new ArrayList<>();

    public List<List<Double>> getPoints() {
        return points;
    }

    public void setPoints(List<List<Double>> points) {
        this.points = points;
    }
    
    
    
}
