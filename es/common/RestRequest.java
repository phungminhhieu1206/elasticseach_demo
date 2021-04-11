/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tav.web.common;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author v3-os02
 */
public class RestRequest {

    protected static final Logger logger = Logger.getLogger(RestRequest.class);

    public static JSONObject getJSONObject(String sUrl) {
        JSONObject jsResult = null;

        try {
            URL url = new URL(sUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
//                logger.error(String.format("An error happen when calling getJSONObject with url=%s (HTTP error code=%d)", sUrl, conn.getResponseCode()));
                logger.error("An error happen when calling getJSONObject");

                return null;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder result = new StringBuilder();
            String output;

            while ((output = br.readLine()) != null) {
                result.append(ConvertData.stripXSS(output));
            }
            br.close();
            conn.disconnect();

            jsResult = new JSONObject(ConvertData.stripXSS(result.toString()));

        } catch (MalformedURLException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException | JSONException e) {
            logger.error(e.getMessage(), e);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return jsResult;
    }

    public static Object getObject(String sUrl, Class clazz) {
        Object obj = null;

        try {
            URL url = new URL(sUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
//                logger.error(String.format("An error happen when calling getObject with url=%s (HTTP error code=%d)", sUrl, conn.getResponseCode()));
                logger.error("An error happen when calling getObject");

                return null;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder result = new StringBuilder();
            String output;

            while ((output = br.readLine()) != null) {
                System.out.println("11111111111111 "+output);
                result.append(ConvertData.stripXSS(output));
            }
            br.close();
            conn.disconnect();

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            obj = mapper.readValue(ConvertData.stripXSS(result.toString()), clazz);

        } catch (MalformedURLException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return obj;
    }
    public static Object getObjectElastic(String sUrl, Class clazz) {
        Object obj = null;

        try {
            URL url = new URL(sUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
//                logger.error(String.format("An error happen when calling getObject with url=%s (HTTP error code=%d)", sUrl, conn.getResponseCode()));
                logger.error("An error happen when calling getObject");

                return null;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder result = new StringBuilder();
            String output;

            while ((output = br.readLine()) != null) {
//                System.out.println("11111111111111 "+output);
                output=(output+"").replaceAll("_source", "obj");
                result.append(ConvertData.stripXSS(output));
            }
            br.close();
            conn.disconnect();

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            obj = mapper.readValue(ConvertData.stripXSS(result.toString()), clazz);

        } catch (MalformedURLException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return obj;
    }

    public static List getObjectArray(String sUrl, Class clazz) {
        List objs = null;

        try {
            URL url = new URL(sUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
//                logger.error(String.format("An error happen when calling getObjectArray with url=%s (HTTP error code=%d)", sUrl, conn.getResponseCode()));
                logger.error("An error happen when calling getObjectArray");

                return null;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder result = new StringBuilder();
            String output;

            while ((output = br.readLine()) != null) {
                result.append(ConvertData.stripXSS(output));
            }
            br.close();
            conn.disconnect();

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            //objs = mapper.readValue(result.toString(), new TypeReference<List<clazz>>(){});
            objs = mapper.readValue(ConvertData.stripXSS(result.toString()), mapper.getTypeFactory().constructCollectionType(List.class, clazz));

        } catch (MalformedURLException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return objs;
    }

    public static String postAndReturnString(String sUrl, Object obj) {

        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL(sUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);

            try (OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream())) {
                JSONObject jsObj = new JSONObject(obj);
                out.write(jsObj.toString());
                System.out.println(jsObj.toString());
            }

            BufferedReader reader;
            if (conn.getResponseCode() != 200) {
                logger.error("An error happen when calling postAndReturnString");

//                logger.error(String.format("An error happen when calling postAndReturnString with url=%s (HTTP error code=%d)", sUrl, conn.getResponseCode()));
//                return null;
                reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            }

            String output;

            while ((output = reader.readLine()) != null) {
                result.append(ConvertData.stripXSS(output));
            }
            reader.close();
            conn.disconnect();
        } catch (MalformedURLException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return ConvertData.stripXSS(result.toString());
    }
    
    public static String postAndReturnStringElasticSearch(String sUrl, Object obj) {

        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL(sUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);

            try (OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream())) {
                JSONObject jsObj = new JSONObject(obj);
                out.write(jsObj.toString().replaceAll("location", "pin.location"));
            }

            BufferedReader reader;
            if (conn.getResponseCode() != 200) {
                logger.error("An error happen when calling postAndReturnString");

//                logger.error(String.format("An error happen when calling postAndReturnString with url=%s (HTTP error code=%d)", sUrl, conn.getResponseCode()));
//                return null;
                reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            }

            String output;

            while ((output = reader.readLine()) != null) {
                output=(output+"").replaceAll("_source", "obj");
                result.append(ConvertData.stripXSS(output));
            }
            reader.close();
            conn.disconnect();
        } catch (MalformedURLException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return ConvertData.stripXSS(result.toString());
    }

    public static Object postAndReturnObject(String sUrl, Object paramObject, Class resultClass) {
        String result = postAndReturnString(sUrl, paramObject);
        if (result == null) {
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Object resultObject = new Object();
        try {
            resultObject = mapper.readValue(ConvertData.stripXSS(result), resultClass);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return resultObject;
    }
    
    public static Object postAndReturnObjectElasticSearch(String sUrl, Object paramObject, Class resultClass) {
        String result = postAndReturnStringElasticSearch(sUrl, paramObject);
        if (result == null) {
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Object resultObject = new Object();
        try {
            resultObject = mapper.readValue(ConvertData.stripXSS(result), resultClass);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return resultObject;
    }

    public static List postAndReturnObjectArray(String sUrl, Object obj, Class clazz) {
        String result = postAndReturnString(sUrl, obj);

        if (result == null) {
            return null;
        }

        List objs = null;

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            objs = mapper.readValue(ConvertData.stripXSS(result), mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return objs;
    }

}
