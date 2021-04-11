/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tav.web.dto;

import java.util.List;

/**
 *
 * @author HieuPhung
 */
public class ESReturnSecond {
    
    private List<ESReturnThird> hits;
    
    private ESReturnTotal total;

    public List<ESReturnThird> getHits() {
        return hits;
    }

    public void setHits(List<ESReturnThird> hits) {
        this.hits = hits;
    }

    public ESReturnTotal getTotal() {
        return total;
    }

    public void setTotal(ESReturnTotal total) {
        this.total = total;
    }
    
    
    
}
