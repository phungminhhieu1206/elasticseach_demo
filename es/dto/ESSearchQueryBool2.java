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
public class ESSearchQueryBool2 {
    
    private ESSearchQueryBool2Should bool = new ESSearchQueryBool2Should();

    public ESSearchQueryBool2Should getBool() {
        return bool;
    }

    public void setBool(ESSearchQueryBool2Should bool) {
        this.bool = bool;
    }
    
    
}
