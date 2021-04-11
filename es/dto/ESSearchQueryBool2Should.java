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
public class ESSearchQueryBool2Should {
    private List<ESSearchQueryBool2ShouldMatch> should = new ArrayList<>();

    public List<ESSearchQueryBool2ShouldMatch> getShould() {
        return should;
    }

    public void setShould(List<ESSearchQueryBool2ShouldMatch> should) {
        this.should = should;
    }

    
    
    
}
