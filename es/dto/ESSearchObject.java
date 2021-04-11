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
public class ESSearchObject {
    
    private Integer from; // offset
    private Integer size; // limit
    private ESSearchQuery query = new ESSearchQuery();
    private Boolean track_total_hits = true;

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }


    public ESSearchQuery getQuery() {
        return query;
    }

    public void setQuery(ESSearchQuery query) {
        this.query = query;
    }

    public Boolean getTrack_total_hits() {
        return track_total_hits;
    }

    public void setTrack_total_hits(Boolean track_total_hits) {
        this.track_total_hits = track_total_hits;
    }

    
}
