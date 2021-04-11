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
public class ESSearchQueryBoolMustMatchAll {
    
    private ESSearchQueryBoolMustMatchAllObject match_all = new ESSearchQueryBoolMustMatchAllObject();

    public ESSearchQueryBoolMustMatchAllObject getMatch_all() {
        return match_all;
    }

    public void setMatch_all(ESSearchQueryBoolMustMatchAllObject match_all) {
        this.match_all = match_all;
    }

    
    

}
