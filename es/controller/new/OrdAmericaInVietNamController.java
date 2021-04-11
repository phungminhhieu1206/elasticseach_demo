///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package com.tav.web.controller;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tav.common.web.form.JsonDataGrid;
import com.tav.web.bo.ServiceResult;
import com.tav.web.bo.UserSession;
import com.tav.web.bo.ValidationResult;
import com.tav.web.common.CommonConstant;
import com.tav.web.common.CommonFunction;
import com.tav.web.common.ConvertData;
import com.tav.web.common.DateUtil;
import com.tav.web.common.ErpConstants;
import com.tav.web.common.StringUtil;
import com.tav.web.data.OrdAmericaInVietNamData;
import com.tav.web.dto.ESReturnFirst;
import com.tav.web.dto.ESSearchObject;
import com.tav.web.dto.ESSearchQuery;
import com.tav.web.dto.ESSearchQueryBool2;
import com.tav.web.dto.ESSearchQueryBool2ShouldMatch;
import com.tav.web.dto.ESSearchQueryBoolFilter;
import com.tav.web.dto.ESSearchQueryBoolMustMatch;
import com.tav.web.dto.ESSearchQueryBoolMustMatchAll;
import com.tav.web.dto.OrdAmericaInVietNamDTO;
import com.tav.web.dto.ImportErrorMessage;
import com.tav.web.dto.ObjectCommonSearchDTO;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author TuTinh
 */
@Controller
public class OrdAmericaInVietNamController extends SubBaseController {

    @Autowired
    private OrdAmericaInVietNamData ordAmericaInVietNamData;

    @RequestMapping("/" + ErpConstants.RequestMapping.ORD_AMERICA)
    public ModelAndView agent(Model model, HttpServletRequest request) {
        return new ModelAndView("ordAmericaInVietNam");
    }

//    @RequestMapping(value = {"/" + ErpConstants.RequestMapping.GET_ALL_ORD_AMERICA}, method = RequestMethod.GET)
//    @ResponseBody
//    public JsonDataGrid getAll(HttpServletRequest request) {
//        try {
//            // get info paging
//            Integer currentPage = getCurrentPage();
//            Integer limit = getTotalRecordPerPage();
//            Integer offset = --currentPage * limit;
//            JsonDataGrid dataGrid = new JsonDataGrid();
//            ObjectCommonSearchDTO searchDTO = new ObjectCommonSearchDTO();
//            
//            try {
//                if (!Strings.isNullOrEmpty(request.getParameter("bdaid"))) {
//                    searchDTO.setLstFirst(ConvertData.convertStringToListLong(request.getParameter("bdaid")));
//                }
//            } catch (Exception ex) {
//            }
//            try {
//                if (!Strings.isNullOrEmpty(request.getParameter("categoryid"))) {
//                    searchDTO.setLstSec(ConvertData.convertStringToListLong(request.getParameter("categoryid")));
//                }
//            } catch (Exception ex) {
//            }
//            try {
//                if (!Strings.isNullOrEmpty(request.getParameter("ord_classid"))) {
//                    searchDTO.setLstTh(ConvertData.convertStringToListLong(request.getParameter("ord_classid")));
//                }
//            } catch (Exception ex) {
//            }
//            
//            try {
//                if (!Strings.isNullOrEmpty(request.getParameter("targetid"))) {
//                    searchDTO.setLstFor(ConvertData.convertStringToListLong(request.getParameter("targetid")));
//                }
//            } catch (Exception ex) {
//            }
//            
//            try {
//                if (!Strings.isNullOrEmpty(request.getParameter("airacrftid"))) {
//                    searchDTO.setLstFive(ConvertData.convertStringToListLong(request.getParameter("airacrftid")));
//                }
//            } catch (Exception ex) {
//            }
//            
//            try {
//                if (!Strings.isNullOrEmpty(request.getParameter("ordnanceid"))) {
//                    searchDTO.setLstSix(ConvertData.convertStringToListLong(request.getParameter("ordnanceid")));
//                }
//            } catch (Exception ex) {
//            }
//            
//            try {
//                if (!Strings.isNullOrEmpty(request.getParameter("communeid"))) {
//                    searchDTO.setLstNi(ConvertData.convertStringToListLong(request.getParameter("communeid")));
//                }
//            } catch (Exception ex) {
//            }
//            
//            try {
//                if (!Strings.isNullOrEmpty(request.getParameter("districtid"))) {
//                    searchDTO.setLstEight(ConvertData.convertStringToListLong(request.getParameter("districtid")));
//                }
//            } catch (Exception ex) {
//            }
//            try {
//                if (!Strings.isNullOrEmpty(request.getParameter("provinceid"))) {
//                    searchDTO.setLstSeven(ConvertData.convertStringToListLong(request.getParameter("provinceid")));
//                }
//            } catch (Exception ex) {
//            }
//            if (!StringUtil.isNull(request.getParameter("polygon"))) {
//                searchDTO.setCriteriaFirst(request.getParameter("polygon"));
//            }
//
////            searchDTO.setCriteriaFirst(request.getParameter("key"));
////            try {
////                if (!Strings.isNullOrEmpty(request.getParameter("country"))) {
////                    searchDTO.setLstFirst(ConvertData.convertStringToListLong(request.getParameter("country")));
////                }
////            } catch (Exception ex) {
////            }
////            try {
////                if (!Strings.isNullOrEmpty(request.getParameter("useVN"))) {
////                    searchDTO.setLstTh(ConvertData.convertStringToListLong(request.getParameter("useVN")));
////                }
////            } catch (Exception ex) {
////            }
////            try {
////                if (!Strings.isNullOrEmpty(request.getParameter("sWeight")) && !Strings.isNullOrEmpty(request.getParameter("eWeight"))) {
////                    searchDTO.setCriteriaElevent(Double.parseDouble(request.getParameter("sWeight")));
////                    searchDTO.setCriteriaTe(Double.parseDouble(request.getParameter("eWeight")));
////                }
////            } catch (Exception ex) {
////            }
////            try {
////                if (!Strings.isNullOrEmpty(request.getParameter("sFrag")) && !Strings.isNullOrEmpty(request.getParameter("eFrag"))) {
////                    searchDTO.setCriteriaThir(Double.parseDouble(request.getParameter("sFrag")));
////                    searchDTO.setCriteriaFort(Double.parseDouble(request.getParameter("eFrag")));
////                }
////            } catch (Exception ex) {
////            }
//            List<OrdAmericaInVietNamDTO> lst = new ArrayList<>();
//            Integer totalRecords = 0;
//            totalRecords = ordAmericaInVietNamData.getCount(searchDTO);
//            if (totalRecords > 0) {
//                lst = ordAmericaInVietNamData.getAll(searchDTO, offset, limit);
//            }
//            dataGrid.setCurPage(getCurrentPage());
//            dataGrid.setTotalRecords(totalRecords);
//            dataGrid.setData(lst);
//            return dataGrid;
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//            return null;
//        }
//    }
    @RequestMapping(value = {"/" + ErpConstants.RequestMapping.GET_ALL_ORD_AMERICA}, method = RequestMethod.GET)
    @ResponseBody
    public JsonDataGrid getAll(HttpServletRequest request) {
        try {
            // get info paging
            Integer currentPage = getCurrentPage();
            Integer limit = getTotalRecordPerPage();
            Integer offset = --currentPage * limit;
            JsonDataGrid dataGrid = new JsonDataGrid();
            ESSearchObject searchDTO = new ESSearchObject();

            // Làm dữ liệu cho đối tượng search
            searchDTO.setFrom(offset);
            searchDTO.setSize(limit);

            // Tiêu chí tìm kiếm
            List<Long> bdaidPrama = new ArrayList<>();
            List<Long> categoryidPrama = new ArrayList<>();
            List<Long> ordClassidPrama = new ArrayList<>();
            List<Long> targetidPrama = new ArrayList<>();
            List<Long> airacrfidPrama = new ArrayList<>();
            List<Long> ordnanceidPrama = new ArrayList<>();
            String polygonSearch = "";

            try {
                if (!Strings.isNullOrEmpty(request.getParameter("bdaid"))) {
                    bdaidPrama = ConvertData.convertStringToListLong(request.getParameter("bdaid"));
                }
            } catch (Exception ex) {
            }

            try {
                if (!Strings.isNullOrEmpty(request.getParameter("categoryid"))) {
                    categoryidPrama = ConvertData.convertStringToListLong(request.getParameter("categoryid"));
                }
            } catch (Exception ex) {
            }

            try {
                if (!Strings.isNullOrEmpty(request.getParameter("ord_classid"))) {
                    ordClassidPrama = ConvertData.convertStringToListLong(request.getParameter("ord_classid"));
                }
            } catch (Exception ex) {
            }

            try {
                if (!Strings.isNullOrEmpty(request.getParameter("targetid"))) {
                    targetidPrama = ConvertData.convertStringToListLong(request.getParameter("targetid"));
                }
            } catch (Exception ex) {
            }

            try {
                if (!Strings.isNullOrEmpty(request.getParameter("airacrftid"))) {
                    airacrfidPrama = ConvertData.convertStringToListLong(request.getParameter("airacrftid"));
                }
            } catch (Exception ex) {
            }

            try {
                if (!Strings.isNullOrEmpty(request.getParameter("ordnanceid"))) {
                    ordnanceidPrama = ConvertData.convertStringToListLong(request.getParameter("ordnanceid"));
                }
            } catch (Exception ex) {
            }

            if (!StringUtil.isNull(request.getParameter("polygon"))) {
                polygonSearch = request.getParameter("polygon");
            }

            // Khởi tạo các tiêu chí tìm kiếm
            // Tìm tất cả
            ESSearchQueryBoolMustMatchAll must_all = new ESSearchQueryBoolMustMatchAll();

//            ESSearchQueryBoolMustMatch must2 = new ESSearchQueryBoolMustMatch();
//            must2.getMatch().setAiracrft("A1");
//            
//            ESSearchQueryBoolMustMatch must3 = new ESSearchQueryBoolMustMatch();
//            must3.getMatch().setCategory("Ammunition");
            // bdaid
            ESSearchQueryBool2 must_bdaid = new ESSearchQueryBool2();
            if (bdaidPrama != null && bdaidPrama.size() > 0) {
                for (int i = 0; i < bdaidPrama.size(); i++) {
                    ESSearchQueryBool2ShouldMatch tmp = new ESSearchQueryBool2ShouldMatch();
                    tmp.getMatch().setBdaid(bdaidPrama.get(i));

                    if (tmp != null) {
                        must_bdaid.getBool().getShould().add(tmp);
                    }

                }
            }

            // categoryid
            ESSearchQueryBool2 must_categoryid = new ESSearchQueryBool2();
            if (categoryidPrama != null && categoryidPrama.size() > 0) {
                for (int i = 0; i < categoryidPrama.size(); i++) {
                    ESSearchQueryBool2ShouldMatch tmp = new ESSearchQueryBool2ShouldMatch();
                    tmp.getMatch().setCategoryid(categoryidPrama.get(i));

                    if (tmp != null) {
                        must_categoryid.getBool().getShould().add(tmp);
                    }

                }
            }

            // ord_classid
            ESSearchQueryBool2 must_ord_classid = new ESSearchQueryBool2();
            if (ordClassidPrama != null && ordClassidPrama.size() > 0) {
                for (int i = 0; i < ordClassidPrama.size(); i++) {
                    ESSearchQueryBool2ShouldMatch tmp = new ESSearchQueryBool2ShouldMatch();
                    tmp.getMatch().setOrd_classid(ordClassidPrama.get(i));

                    if (tmp != null) {
                        must_ord_classid.getBool().getShould().add(tmp);
                    }

                }
            }

            // targetid
            ESSearchQueryBool2 must_targetid = new ESSearchQueryBool2();
            if (targetidPrama != null && targetidPrama.size() > 0) {
                for (int i = 0; i < targetidPrama.size(); i++) {
                    ESSearchQueryBool2ShouldMatch tmp = new ESSearchQueryBool2ShouldMatch();
                    tmp.getMatch().setTargetid(targetidPrama.get(i));

                    if (tmp != null) {
                        must_targetid.getBool().getShould().add(tmp);
                    }

                }
            }

            // airacrfid
            ESSearchQueryBool2 must_airacrfid = new ESSearchQueryBool2();
            if (airacrfidPrama != null && airacrfidPrama.size() > 0) {
                for (int i = 0; i < airacrfidPrama.size(); i++) {
                    ESSearchQueryBool2ShouldMatch tmp = new ESSearchQueryBool2ShouldMatch();
                    tmp.getMatch().setAiracrftid(airacrfidPrama.get(i));

                    if (tmp != null) {
                        must_airacrfid.getBool().getShould().add(tmp);
                    }

                }
            }

            // ordnanceid
            ESSearchQueryBool2 must_ordnanceid = new ESSearchQueryBool2();
            if (ordnanceidPrama != null && ordnanceidPrama.size() > 0) {
                for (int i = 0; i < ordnanceidPrama.size(); i++) {
                    ESSearchQueryBool2ShouldMatch tmp = new ESSearchQueryBool2ShouldMatch();
                    tmp.getMatch().setOrdnanceid(ordnanceidPrama.get(i));

                    if (tmp != null) {
                        must_ordnanceid.getBool().getShould().add(tmp);
                    }

                }
            }

            // Gắn polygon
            List<List<Double>> points = new ArrayList<>();
//            List<Double> point1 = new ArrayList<>();
//            List<Double> point2 = new ArrayList<>();
//            List<Double> point3 = new ArrayList<>();
//            point1.add(103.18098);
//            point1.add(19.49761);
//
//            point2.add(103.59082);
//            point2.add(19.5871);
//
//            point3.add(105.71475);
//            point3.add(19.50353);
//
//            points.add(point1);
//            points.add(point2);
//            points.add(point3);

            String[] splits = null;

            if ((polygonSearch + "").length() != 0) {
                splits = polygonSearch.split(", ");
            }

            System.out.println("--------------------------start test polygon--------------------------");
            if (splits != null && splits.length > 0) {
                for (String item : splits) {
                    List<Double> pointtmp = new ArrayList<>();
                    String[] pointstr = item.split(" ");
                    pointtmp.add(Double.parseDouble(pointstr[1]));
                    pointtmp.add(Double.parseDouble(pointstr[0]));
                    if (pointtmp != null) {
                        points.add(pointtmp);
                    }
                }
            }

            System.out.println(points);
            System.out.println("--------------------------end test polygon--------------------------");

            // Gắn vào tiêu chí tìm kiếm
            searchDTO.getQuery().getBool().getMust().add(must_all);

            searchDTO.getQuery().getBool().getMust().add(must_bdaid);
            searchDTO.getQuery().getBool().getMust().add(must_categoryid);
            searchDTO.getQuery().getBool().getMust().add(must_ord_classid);
            searchDTO.getQuery().getBool().getMust().add(must_targetid);
            searchDTO.getQuery().getBool().getMust().add(must_airacrfid);
            searchDTO.getQuery().getBool().getMust().add(must_ordnanceid);

            ESSearchQueryBoolFilter filtertmp = null;
            // Gắn polygon
            if (points != null && points.size() > 0) {
                filtertmp = new ESSearchQueryBoolFilter();
                searchDTO.getQuery().getBool().setFilter(filtertmp);
                searchDTO.getQuery().getBool().getFilter().getGeo_polygon().getLocation().setPoints(points);
            }

            // Gọi phương thức lấy dữ liệu từ Elastic Search về
            System.out.println("----------------------- In doi tuong tim kiem -----------------------");
            System.out.println(searchDTO);
            ESReturnFirst temp = ordAmericaInVietNamData.getAll(searchDTO);
            System.out.println("Data return: --------------------  " + temp.getHits());

            // Lấy tổng số documents trả về
            Integer totalRecords = 0;
            System.out.println("---------------------------- total records ----------------------------");
            if (temp.getHits().getTotal() != null) {
                totalRecords = temp.getHits().getTotal().getValue();
            }

            System.out.println("pmh_totalRecords:           ------------          " + totalRecords);

            // Tạo đối tượng hứng dữ liệu -> trung tâm giao tiếp.
            List<OrdAmericaInVietNamDTO> lst;
            lst = new ArrayList<>();

            // Đổ dữ liệu lấy về vào list đã tạo
            if (temp != null && temp.getHits() != null && temp.getHits().getHits() != null && temp.getHits().getHits().size() > 0) {

                for (int i = 0; i < temp.getHits().getHits().size(); i++) {

                    OrdAmericaInVietNamDTO obj = new OrdAmericaInVietNamDTO();
                    obj.setGid(temp.getHits().getHits().get(i).getObj().getGid());
                    obj.setAiracrft(temp.getHits().getHits().get(i).getObj().getAiracrft());
                    obj.setBda(temp.getHits().getHits().get(i).getObj().getBda());
                    obj.setCategory(temp.getHits().getHits().get(i).getObj().getCategory());
                    obj.setDcode(temp.getHits().getHits().get(i).getObj().getDcode());
                    obj.setLat(temp.getHits().getHits().get(i).getObj().getLat());
                    obj.setLatlonkey(temp.getHits().getHits().get(i).getObj().getLatlonkey());
                    obj.setLoad_lbs(temp.getHits().getHits().get(i).getObj().getLoad_lbs());
                    obj.setLon(temp.getHits().getHits().get(i).getObj().getLon());
                    obj.setOrd_class(temp.getHits().getHits().get(i).getObj().getOrd_class());
                    obj.setOrdnance(temp.getHits().getHits().get(i).getObj().getOrdnance());
                    obj.setPcode(temp.getHits().getHits().get(i).getObj().getPcode());
                    obj.setShape(temp.getHits().getHits().get(i).getObj().getShape());
                    obj.setTarget(temp.getHits().getHits().get(i).getObj().getTarget());
                    obj.setCreateddateST(temp.getHits().getHits().get(i).getObj().getCreateddateST());
                    obj.setNum_acrft(temp.getHits().getHits().get(i).getObj().getNum_acrft());
                    obj.setShapeid(temp.getHits().getHits().get(i).getObj().getShapeid());
                    obj.setAiracrftid(temp.getHits().getHits().get(i).getObj().getAiracrftid());
                    obj.setOrdnanceid(temp.getHits().getHits().get(i).getObj().getOrdnanceid());
                    obj.setOrd_classid(temp.getHits().getHits().get(i).getObj().getOrd_classid());
                    obj.setCategoryid(temp.getHits().getHits().get(i).getObj().getCategoryid());
                    obj.setTargetid(temp.getHits().getHits().get(i).getObj().getTargetid());
                    obj.setBdaid(temp.getHits().getHits().get(i).getObj().getBdaid());

                    lst.add(obj);
                }
            }

            // Xử lý phần còn lại
            dataGrid.setCurPage(getCurrentPage());
            dataGrid.setTotalRecords(totalRecords);
            dataGrid.setData(lst); // List dữ liệu OrdAmericaInVietNamDTO đã hứng.
			
			ObjectCommonSearchDTO searchDTOTmp = new ObjectCommonSearchDTO();
            ordAmericaInVietNamData.getAllOld(searchDTOTmp, 0, 50000);

            System.out.println("-----------------------------xxxxxxxxxxxxxxxxxx------------------");
            return dataGrid;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    @RequestMapping(value = "/" + ErpConstants.RequestMapping.GET_ORD_AMERICA_BY_ID, method = RequestMethod.GET)
    public @ResponseBody
    OrdAmericaInVietNamDTO getOneById(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("gid"));
        importFromFile();
        return ordAmericaInVietNamData.getOneById(id);
    }

    private void importFromFile() {
//        try {
//            File file = new File("D:\\WORK\\BM\\DATA\\Khong quan My danh pha Viet Nam\\Export_Output.txt");    //creates a new file instance  
//            FileReader fr = new FileReader(file);   //reads the file  
//            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream  
//            StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters  
//            String line;
//            while ((line = br.readLine()) != null) {
//                sb.append(line);      //appends line to string buffer  
//                sb.append("\n");     //line feed   
//            }
//            fr.close();    //closes the stream and release the resources  
//            System.out.println("Contents of File: ");
//            System.out.println(sb.toString());   //returns a string that textually represents the object  
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream("D:\\WORK\\BM\\DATA\\Khong quan My danh pha Viet Nam\\Export_Output.txt");
            sc = new Scanner(inputStream, "UTF-8");
            int i = 0;
            while (sc.hasNextLine()) {

                String line = sc.nextLine();
                if (i >= 1) {
                    OrdAmericaInVietNamDTO dto = initDTO(line);
//                    System.out.println(line);
                    ordAmericaInVietNamData.addObj(dto);
                }
                i++;
            }
            inputStream.close();
        } catch (Exception e) {
        } finally {
        }
    }

    private OrdAmericaInVietNamDTO initDTO(String input) {
        OrdAmericaInVietNamDTO dto = new OrdAmericaInVietNamDTO();
        String[] xyz = (input + "").split("\"");
        if (xyz != null && xyz.length == 3) {
            input = xyz[0] + "" + (xyz[1] + "").replaceAll(",", ";@") + xyz[2];
            System.out.println("11111111111111111 input " + input);
        }

        String[] st = (input + "").split(",");
        if (st.length == 16) {
            try {
                String stDate = st[1];
                String[] arrDate = stDate.split(" ");
                dto.setCreateddate(DateUtil.formatDate3(arrDate[0]));
                dto.setLat(Double.parseDouble(st[2]));
                dto.setLon(Double.parseDouble(st[3]));
                dto.setNum_acrft(Math.round(Double.parseDouble(st[4])));
                dto.setAiracrft((st[5] + "").replaceAll(";@", ", "));
                dto.setLoad_lbs(Math.round(Double.parseDouble(st[7])));
                dto.setOrdnance((st[8] + "").replaceAll(";@", ", "));
                dto.setOrd_class((st[9] + "").replaceAll(";@", ", "));
                dto.setCategory((st[10] + "").replaceAll(";@", ", "));
                dto.setTarget((st[11] + "").replaceAll(";@", ", "));
                dto.setBda((st[12] + "").replaceAll(";@", ", "));
                dto.setDcode((int) (Double.parseDouble((st[13] + "").replaceAll(";@", ", "))) + "");
                dto.setPcode((int) Double.parseDouble((st[14] + "").replaceAll(";@", ", ")) + "");
                dto.setLatlonkey((int) Double.parseDouble((st[15] + "").replaceAll(";@", ", ")) + "");
            } catch (Exception e) {
            }
        }
        return dto;
    }

    //add
    @RequestMapping(value = {"/" + ErpConstants.RequestMapping.ADD_ORD_AMERICA}, method = RequestMethod.POST, produces = ErpConstants.LANGUAGE)
    @ResponseBody
    public String addOBJ(@ModelAttribute("ordAmericaInVietNamForm") OrdAmericaInVietNamDTO ordAmericaInVietNamDTO, MultipartHttpServletRequest multipartRequest,
            HttpServletRequest request) {

        JSONObject result;
        String error = validateForm(ordAmericaInVietNamDTO);
        ServiceResult serviceResult;
//        String doc_files = CommonFunction.uploadFileOnAdd(multipartRequest, "filestTmp");
        if (error != null) {
            return error;
        } else {
//            ordAmericaInVietNamDTO.setImage_file(doc_files);
            serviceResult = ordAmericaInVietNamData.addObj(ordAmericaInVietNamDTO);
            if (!serviceResult.isHasError()) {
                addEventLog("ADD_BOMB", "ADD_BOMB code=" + ordAmericaInVietNamDTO.getGid());
            }
            processServiceResult(serviceResult);
            result = new JSONObject(serviceResult);
        }
        return result.toString();
    }

    //update
    @RequestMapping(value = {"/" + ErpConstants.RequestMapping.UPDATE_ORD_AMERICA}, method = RequestMethod.POST, produces = ErpConstants.LANGUAGE)
    @ResponseBody
    public String updateOBJ(@ModelAttribute("ordAmericaInVietNamForm") OrdAmericaInVietNamDTO ordAmericaInVietNamDTO, MultipartHttpServletRequest multipartRequest,
            HttpServletRequest request) {

        JSONObject result;
        String error = validateForm(ordAmericaInVietNamDTO);
        ServiceResult serviceResult;
        if (error != null) {
            return error;
        } else {
//            OrdAmericaInVietNamDTO dtoTmp = ordAmericaInVietNamData.getOneById(ordAmericaInVietNamDTO.getGid());
//            String doc_files = CommonFunction.uploadFileOnUpdate(multipartRequest, "filestTmp");
//            if (!StringUtil.isEmpty(doc_files)) {
//                ordAmericaInVietNamDTO.setImage_file(doc_files);
//            } else if (dtoTmp != null) {
//                ordAmericaInVietNamDTO.setImage_file(dtoTmp.getImage_file());
//            }

            serviceResult = ordAmericaInVietNamData.updateBO(ordAmericaInVietNamDTO);
            if (!serviceResult.isHasError()) {
                addEventLog("UPDATE_BOMB", "UPDATE_BOMB code=" + ordAmericaInVietNamDTO.getGid());
            }
            processServiceResult(serviceResult);
            result = new JSONObject(serviceResult);
        }
        return result.toString();
    }

    //validate
    private String validateForm(OrdAmericaInVietNamDTO cbChaDTO) {
        List<ValidationResult> lsError = new ArrayList<>();
        if (lsError.size() > 0) {
            Gson gson = new Gson();
            return gson.toJson(lsError);
        }
        return null;
    }

//    @RequestMapping(value = "/" + ErpConstants.RequestMapping.DOWNLOAD_IMAGE_BOMB, method = RequestMethod.GET)
//    public void downloadFiles(HttpServletRequest request, HttpServletResponse response) {
//        String dataDirectory = CommonConstant.PATH_FOLDER_TOPIC_FILE;
//        Long id = null;
//        if (!Strings.isNullOrEmpty(request.getParameter("id"))) {
//            id = Long.parseLong(request.getParameter("id"));
//            OrdAmericaInVietNamDTO ordAmericaInVietNamDTOTmp = ordAmericaInVietNamData.getOneById(id);
//            if (ordAmericaInVietNamDTOTmp != null) {
//                String fileName = ordAmericaInVietNamDTOTmp.getImage_file();
//                response.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//                response.setHeader("Content-Transfer-Encoding", "binary");
//                response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
//                Path file = Paths.get(dataDirectory, fileName);
//                if (Files.exists(file)) {
//                    response.setContentType("application/vnd.ms-excel");
//                    response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
//                    try {
//                        Files.copy(file, response.getOutputStream());
//                        response.getOutputStream().flush();
//                    } catch (IOException ex) {
//                        logger.error(ex);
//                    }
//                }
//            }
//        }
//    }
    @RequestMapping(value = {"/" + ErpConstants.RequestMapping.DELETE_ORD_AMERICA}, method = RequestMethod.POST,
            produces = "text/html;charset=utf-8")
    public @ResponseBody
    String deleteObj(@ModelAttribute("objectCommonSearchDTO") ObjectCommonSearchDTO objectCommonSearchDTO,
            HttpServletRequest request) {
        HttpSession session = request.getSession();
        ServiceResult serviceResult = ordAmericaInVietNamData.deleteObj(objectCommonSearchDTO);
        if (!serviceResult.isHasError()) {
            List<Long> deptIds = objectCommonSearchDTO.getLstFirst();
            StringBuilder sDeptIds = new StringBuilder();
            for (long deptId : deptIds) {
                sDeptIds.append(deptId).append(",");
            }
            addEventLog("DELETE_BOMB", "BOMB ids=" + sDeptIds);
        }

        processServiceResult(serviceResult);
        JSONObject result = new JSONObject(serviceResult);
        return result.toString();
    }

//    @RequestMapping(value = "/" + ErpConstants.RequestMapping.BOMB_IMPORT, method = RequestMethod.POST)
//    public @ResponseBody
//    String importData(MultipartHttpServletRequest multipartRequest, HttpServletRequest request) {
//        UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
//        JsonObject jsObj = new JsonObject();
//        if (multipartRequest != null) {
//            try {
//                MultipartFile file = multipartRequest.getFile("files");
//                if (file != null && file.getOriginalFilename().endsWith("xls") || file.getOriginalFilename().endsWith("xlsx")) {
//                    String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/import/");
//                    // Create the file on server
//                    String fileName = String.valueOf(System.currentTimeMillis());
//                    if ("application/vnd.ms-excel".equals(file.getContentType())) {
//                        fileName += ".xls";
//                    } else {
//                        fileName += ".xlsx";
//                    }
//                    File serverFile = new File(dataDirectory + fileName);
//                    if (!StringUtil.isBlank(file.getOriginalFilename()) && (file.getOriginalFilename().toLowerCase().endsWith(".xls") || file.getOriginalFilename().toLowerCase().endsWith(".xlsx")) && file.getSize() <= 10240000) {
//                        try (BufferedOutputStream streamOut = new BufferedOutputStream(
//                                new FileOutputStream(serverFile))) {
//                            streamOut.write(file.getBytes());
//                            streamOut.close();
//                        }
//                    }
//                    String result = readFile(dataDirectory + fileName, file.getOriginalFilename().toLowerCase().endsWith("xls"), userSession);
//                    serverFile.delete();
//                    return result;
//                }
//                jsObj.addProperty("error", "File not support");
//                jsObj.addProperty("code", "404");
//                return jsObj.toString();
//            } catch (IOException | ParseException e) {
//                logger.error(e);
//                jsObj.addProperty("code", "error");
//                return jsObj.toString();
//            }
//        } else {
//            jsObj.addProperty("code", "500");
//            return jsObj.toString();
//        }
//    }
//    private String readFile(String inputFile, boolean isXls, UserSession userSession) throws ParseException {
//
//        try {
//            int totalSuccess = 0;
//            int totalFail = 0;
//            JsonObject jsObj = new JsonObject();
//            List<ImportErrorMessage> lstImportErrorMessages = new ArrayList<>();
//            try (FileInputStream file = new FileInputStream(new File(inputFile))) {
//                Workbook workbook;
//                Sheet sheet;
//                if (isXls) {
//                    //read xls
//                    workbook = new HSSFWorkbook(file);
//                    sheet = workbook.getSheetAt(0);
//                } else {
//                    //read xlsx
//                    workbook = new XSSFWorkbook(file);
//                    sheet = workbook.getSheetAt(0);
//                }
//                Iterator<Row> rowIterator = sheet.iterator();
//                DataFormatter formatter = new DataFormatter();
//                Pattern dateRegex = Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})");
//                int index = 0;
//                //Danh sach 
//                while (rowIterator.hasNext()) {
//                    List<ValidationResult> lstTemp = new ArrayList<>();
//                    Row row = rowIterator.next();
//                    if (row.getRowNum() >= 1) {
//                        index++;
//                        HashMap<String, String> hmError = new HashMap<>();
//                        ImportErrorMessage errorMessage = new ImportErrorMessage();
//                        //Duyet qua cac dong trong file import
//                        Iterator<Cell> cellIterator = row.cellIterator();
//                        if (cellIterator.hasNext()) {
//                            OrdAmericaInVietNamDTO ordAmericaInVietNamDTO = new OrdAmericaInVietNamDTO();
//                            Integer topicIndex = null;
//                            while (cellIterator.hasNext()) {
//                                //Duyet qua cac cot trong file import
//                                Cell cell = cellIterator.next();
//                                if (cell != null) {
//
//                                    //getColumnIndex bat dau tu 0
//                                    String valueTemp = null;
//                                    int cellIndex = cell.getColumnIndex();
//                                    if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC && org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
//                                        SimpleDateFormat dateFormat = new SimpleDateFormat(
//                                                "dd/MM/yyyy");
//                                        valueTemp = dateFormat.format(cell.getDateCellValue());
//                                    } else {
//                                        valueTemp = ConvertData.getDataFromCell(formatter, cell);
//                                    }
//                                    //<editor-fold defaultstate="collapsed" desc="set data for variables">
//                                    switch (cellIndex) {
//                                        case 0:
//                                            //Mã ordAmericaInVietNam
//                                            OrdAmericaInVietNamDTO cecmProviceDTOTmp = ordAmericaInVietNamData.getOneOrdAmericaInVietNamByCode(valueTemp);
//                                            if (cecmProviceDTOTmp != null) {
//                                                hmError.put("errCodeExist", "Mã ordAmericaInVietNam đã tồn tại");
//                                            } else {
//                                                ordAmericaInVietNamDTO.setCode(valueTemp);
//                                            }
//                                            break;
//                                        case 1:
//                                            //Tên ordAmericaInVietNam
//                                            ordAmericaInVietNamDTO.setName(valueTemp);
//                                            break;
//                                        case 2:
//                                            //Tên nước sản xuất
//                                            switch (valueTemp) {
//                                                case "US":
//                                                    ordAmericaInVietNamDTO.setCountryorigin(1L);
//                                                    break;
//                                                case "CH":
//                                                    ordAmericaInVietNamDTO.setCountryorigin(2L);
//                                                    break;
//                                                case "UR":
//                                                    ordAmericaInVietNamDTO.setCountryorigin(3L);
//                                                    break;
//                                                case "UK":
//                                                    ordAmericaInVietNamDTO.setCountryorigin(4L);
//                                                    break;
//                                                case "SP":
//                                                    ordAmericaInVietNamDTO.setCountryorigin(5L);
//                                                    break;
//                                                case "FR":
//                                                    ordAmericaInVietNamDTO.setCountryorigin(6L);
//                                                    break;
//                                                case "SW":
//                                                    ordAmericaInVietNamDTO.setCountryorigin(7L);
//                                                    break;
//                                                case "EG":
//                                                    ordAmericaInVietNamDTO.setCountryorigin(8L);
//                                                    break;
//                                                case "CZ":
//                                                    ordAmericaInVietNamDTO.setCountryorigin(9L);
//                                                    break;
//                                                case "PL":
//                                                    ordAmericaInVietNamDTO.setCountryorigin(10L);
//                                                    break;
//                                                case "BR":
//                                                    ordAmericaInVietNamDTO.setCountryorigin(11L);
//                                                    break;
//                                                case "CI":
//                                                    ordAmericaInVietNamDTO.setCountryorigin(12L);
//                                                    break;
//                                                case "IZ":
//                                                    ordAmericaInVietNamDTO.setCountryorigin(13L);
//                                                    break;
//                                                case "HU":
//                                                    ordAmericaInVietNamDTO.setCountryorigin(14L);
//                                                    break;
//                                                case "RO":
//                                                    ordAmericaInVietNamDTO.setCountryorigin(15L);
//                                                    break;
//                                                case "BU":
//                                                    ordAmericaInVietNamDTO.setCountryorigin(16L);
//                                                    break;
//                                                case "FI":
//                                                    ordAmericaInVietNamDTO.setCountryorigin(17L);
//                                                    break;
//                                                case "YO":
//                                                    ordAmericaInVietNamDTO.setCountryorigin(18L);
//                                                    break;
//                                                case "NL":
//                                                    ordAmericaInVietNamDTO.setCountryorigin(19L);
//                                                    break;
//                                                default:
//                                                    break;
//                                            }
//                                            break;
//                                        case 3:
//                                            //Chiều rộng
//                                            valueTemp = (valueTemp + "").replace(",", "").replace("...", "");
//                                            ordAmericaInVietNamDTO.setWidth(Double.parseDouble(valueTemp));
//                                            break;
//                                        case 4:
//                                            //Chiều dài
//                                            valueTemp = (valueTemp + "").replace(",", "").replace("...", "");
//                                            ordAmericaInVietNamDTO.setHeight(Double.parseDouble(valueTemp));
//                                            break;
//                                        case 5:
//                                            //Khối lượng
//                                            valueTemp = (valueTemp + "").replace(",", "").replace("...", "");
//                                            ordAmericaInVietNamDTO.setWeight(Double.parseDouble(valueTemp));
//                                            break;
//                                        case 6:
//                                            //Photo
//                                            ordAmericaInVietNamDTO.setImage_file(valueTemp);
//                                            break;
//                                        default:
//                                            //Khong phai la 1 trong so index tren... Bo qua
//                                            break;
//                                    }
////</editor-fold>
//                                }
//                            }
//
//                            if (hmError.isEmpty()) {
//
//                                ServiceResult serviceResult = ordAmericaInVietNamData.addObj(ordAmericaInVietNamDTO);
//                                if (!serviceResult.isHasError()) {
//                                    addEventLog("ADD_BOMB", "BOMB BOMBId=" + ordAmericaInVietNamDTO.getGid());
//                                }
//                                processServiceResult(serviceResult);
//                            } else {
//                                totalFail++;
//                                errorMessage.setRow(row.getRowNum() + 1);
//                                lstImportErrorMessages.add(errorMessage);
//                            }
//                            index++;
//                        }
//                    }
//                }
//            }
//            jsObj.addProperty("totalSuccess", String.valueOf(totalSuccess));
//            jsObj.addProperty("totalFail", String.valueOf(totalFail));
//            jsObj.addProperty("rdList", new Gson().toJson(lstImportErrorMessages));
//            return jsObj.toString();
//        } catch (FileNotFoundException e) {
//            logger.error("FileNotFoundException", e);
//            JsonObject jsObj = new JsonObject();
//            jsObj.addProperty("error", "FileNotFoundException");
//            jsObj.addProperty("code", "500");
//            return jsObj.toString();
//        } catch (IOException e) {
//            logger.error("IOException", e);
//            JsonObject jsObj = new JsonObject();
//            jsObj.addProperty("error", "IOException");
//            jsObj.addProperty("code", "500");
//            return jsObj.toString();
//        }
//
//    }
}
