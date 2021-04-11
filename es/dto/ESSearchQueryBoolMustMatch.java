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
public class ESSearchQueryBoolMustMatch {
    private ESSearchQueryBoolMustMatchObject match = new ESSearchQueryBoolMustMatchObject();

    public ESSearchQueryBoolMustMatchObject getMatch() {
        return match;
    }

    public void setMatch(ESSearchQueryBoolMustMatchObject match) {
        this.match = match;
    }
    
    
    
}
