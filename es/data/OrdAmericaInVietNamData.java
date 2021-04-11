/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tav.web.data;

import com.tav.web.bo.ServiceResult;
import com.tav.web.common.Config;
import com.tav.web.common.RestRequest;
import com.tav.web.dto.Counter;
import com.tav.web.dto.CounterThread;
import com.tav.web.dto.ESReturnFirst;
import com.tav.web.dto.ESSearchObject;
import com.tav.web.dto.OrdAmericaInVietNamDTO;
import com.tav.web.dto.ObjectCommonSearchDTO;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author TuTinh
 */
@Component
public class OrdAmericaInVietNamData {

    protected static final Logger logger = Logger.getLogger(OrdAmericaInVietNamData.class);
    private static final String subUrl = "/ordAmericaInVietNamRsServiceRest";
    private static final String subUrlGetData = "/getDataRsServiceRest";

    @Autowired
    private Config config;

    // get all  OLD
    public List<OrdAmericaInVietNamDTO> getAllOld(ObjectCommonSearchDTO searchDTO, Integer offset, Integer limit) {
        String url = config.getRestURL() + subUrl + "/getAll/" + offset + "/" + limit;
        try {
            List<OrdAmericaInVietNamDTO> jsResult = RestRequest.postAndReturnObjectArray(url, searchDTO, OrdAmericaInVietNamDTO.class);
            if (jsResult == null) {
                return null;
            } else {
                return jsResult;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }
    
    // get all  OLD
    public List<OrdAmericaInVietNamDTO> getAllByGetData(Integer offset, Integer limit) {
        String url = config.getRestURL() + subUrlGetData + "/getAll/" + offset + "/" + limit;
        try {
            List<OrdAmericaInVietNamDTO> jsResult = RestRequest.getObjectArray(url, OrdAmericaInVietNamDTO.class);
            if (jsResult == null) {
                return null;
            } else {
                return jsResult;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }
    
    
        // get all by elastic search
    public ESReturnFirst getAll(ESSearchObject searchDTO) {
        String url = "http://localhost:9200/ordamerica_map/_search?pretty&filter_path=hits.hits._source,hits.total.value";
        try {
//            ESReturnFirst jsResult = (ESReturnFirst) RestRequest.getObjectElastic(url,  ESReturnFirst.class);
            ESReturnFirst jsResult = (ESReturnFirst) RestRequest.postAndReturnObjectElasticSearch(url, searchDTO, ESReturnFirst.class);
            
            if (jsResult == null) {
                return null;
            } else {
                return jsResult;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    //get count
//    public Integer getCount(ObjectCommonSearchDTO searchDTO) {
//        String url = config.getRestURL() + subUrl + "/getCount";
//        return (Integer) RestRequest.postAndReturnObject(url, searchDTO, Integer.class);
//    }
    
        //get count new 
    public Integer getCount(ObjectCommonSearchDTO searchDTO) {
        String url = config.getRestURL() + subUrl + "/getCountTableChild";
        Counter counter = new Counter();
        ObjectCommonSearchDTO searchDTO1= convertSearch(searchDTO);
        searchDTO1.setCriteriaSec("ord_america_in_vietnam_" + 1);
        Thread thread1 = new CounterThread(counter, 1, searchDTO1, url);
        ObjectCommonSearchDTO searchDTO2= convertSearch(searchDTO);
        searchDTO2.setCriteriaSec("ord_america_in_vietnam_" + 2);
        Thread thread2 = new CounterThread(counter, 2, searchDTO2, url);
        ObjectCommonSearchDTO searchDTO3= convertSearch(searchDTO);
        searchDTO3.setCriteriaSec("ord_america_in_vietnam_" + 3);
        Thread thread3 = new CounterThread(counter, 3, searchDTO3, url);
                ObjectCommonSearchDTO searchDTO4= convertSearch(searchDTO);
        searchDTO4.setCriteriaSec("ord_america_in_vietnam_" + 4);
        Thread thread4 = new CounterThread(counter, 4, searchDTO4, url);
                        ObjectCommonSearchDTO searchDTO5= convertSearch(searchDTO);
        searchDTO5.setCriteriaSec("ord_america_in_vietnam_" + 5);
        Thread thread5 = new CounterThread(counter, 5, searchDTO5, url);
         ObjectCommonSearchDTO searchDTO6= convertSearch(searchDTO);
        searchDTO6.setCriteriaSec("ord_america_in_vietnam_" + 6);
        Thread thread6 = new CounterThread(counter, 6, searchDTO6, url);
         ObjectCommonSearchDTO searchDTO7= convertSearch(searchDTO);
        searchDTO7.setCriteriaSec("ord_america_in_vietnam_" + 7);
        Thread thread7 = new CounterThread(counter, 7, searchDTO7, url);
        ObjectCommonSearchDTO searchDTO8= convertSearch(searchDTO);
        searchDTO8.setCriteriaSec("ord_america_in_vietnam_" + 8);
        Thread thread8 = new CounterThread(counter, 8, searchDTO8, url);
                ObjectCommonSearchDTO searchDTO9= convertSearch(searchDTO);
        searchDTO9.setCriteriaSec("ord_america_in_vietnam_" + 9);
        Thread thread9 = new CounterThread(counter, 9, searchDTO9, url);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        try {
            while (!(thread1.getState() + "").equals("TERMINATED") || !(thread2.getState() + "").equals("TERMINATED")
                    || !(thread3.getState() + "").equals("TERMINATED") || !(thread4.getState() + "").equals("TERMINATED")
                    || !(thread5.getState() + "").equals("TERMINATED") || !(thread6.getState() + "").equals("TERMINATED")
                    || !(thread7.getState() + "").equals("TERMINATED") || !(thread8.getState() + "").equals("TERMINATED")
                    || !(thread9.getState() + "").equals("TERMINATED")) {
//                Thread.sleep(30000);
            }
            System.out.println("cc1_______ " + counter.count);
        } catch (Exception ex) {
        }
        return counter.count;
        
        
//        String url = config.getRestURL() + subUrl + "/getCountTableChild";
//        return (Integer) RestRequest.postAndReturnObject(url, searchDTO, Integer.class);
    }
    private ObjectCommonSearchDTO convertSearch(ObjectCommonSearchDTO ip){
        ObjectCommonSearchDTO ot=new ObjectCommonSearchDTO();
ot.setCriteriaFirst(ip.getCriteriaFirst());
ot.setCriteriaSec(ip.getCriteriaSec());
ot.setCriteriaTh(ip.getCriteriaTh());
ot.setCriteriaFor(ip.getCriteriaFor());
ot.setCriteriaFive(ip.getCriteriaFive());
ot.setCriteriaFirst(ip.getCriteriaFirst());
ot.setCriteriaSec(ip.getCriteriaSec());
ot.setCriteriaTh(ip.getCriteriaTh());
ot.setCriteriaFor(ip.getCriteriaFor());
ot.setCriteriaFive(ip.getCriteriaFive());
ot.setCriteriaSixLong(ip.getCriteriaSixLong());
ot.setCriteriaSevenLong(ip.getCriteriaSevenLong());
ot.setCriteriaEightLong(ip.getCriteriaEightLong());
ot.setCriteriaNiLong(ip.getCriteriaNiLong());
ot.setCriteriaTenLong(ip.getCriteriaTenLong());
ot.setLstFirst(ip.getLstFirst());
ot.setLstSec(ip.getLstSec());
ot.setLstTh(ip.getLstTh());
ot.setLstFor(ip.getLstFor());
ot.setLstFive(ip.getLstFive());
ot.setLstSix(ip.getLstSix());
ot.setLstSeven(ip.getLstSeven());
ot.setLstEight(ip.getLstEight());
ot.setLstNi(ip.getLstNi());
ot.setLstTen(ip.getLstTen());
ot.setCriteriaElevent(ip.getCriteriaElevent());
ot.setCriteriaTe(ip.getCriteriaTe());
ot.setCriteriaThir(ip.getCriteriaThir());
ot.setCriteriaFort(ip.getCriteriaFort());
        return ot;
    }

    public ServiceResult addObj(OrdAmericaInVietNamDTO cbChaDTO) {
        String url = config.getRestURL() + subUrl + "/addDTO/";
        ServiceResult result = (ServiceResult) RestRequest.postAndReturnObject(url, cbChaDTO, ServiceResult.class);
        return result;
    }

    public ServiceResult updateBO(OrdAmericaInVietNamDTO cbChaDTO) {
        String url = config.getRestURL() + subUrl + "/updateBO/";
        ServiceResult result = (ServiceResult) RestRequest.postAndReturnObject(url, cbChaDTO, ServiceResult.class);
        return result;
    }

    public ServiceResult deleteObj(ObjectCommonSearchDTO objectCommonSearchDTO) {
        String url = config.getRestURL() + subUrl + "/deleteList/";
        ServiceResult result = (ServiceResult) RestRequest.postAndReturnObject(url, objectCommonSearchDTO, ServiceResult.class);
        return result;
    }

    public OrdAmericaInVietNamDTO getOneById(Long id) {
        String url = config.getRestURL() + subUrl + "/getOneById/" + id;
        OrdAmericaInVietNamDTO item = (OrdAmericaInVietNamDTO) RestRequest.getObject(url, OrdAmericaInVietNamDTO.class);
        return item;
    }
    
    

    

}
