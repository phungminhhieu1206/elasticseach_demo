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
public class ESSearchQueryBool {
    private List<Object> must = new ArrayList<>();
    private ESSearchQueryBoolFilter filter; // search polygon

    public List<Object> getMust() {
        return must;
    }

    public void setMust(List<Object> must) {
        this.must = must;
    }

    public ESSearchQueryBoolFilter getFilter() {
        return filter;
    }

    public void setFilter(ESSearchQueryBoolFilter filter) {
        this.filter = filter;
    }

    
    
    
    
    
}
