package com.hust.bigdataplatform.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;

import com.hust.bigdataplatform.constant.ResultVal;

import net.sf.json.JSONObject;

public class ResultUtil {
    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(ResultUtil.class);

    public static Object success(Object result) {
        JSONObject object = new JSONObject();
        object.put("status", HttpStatus.OK);
        object.put("result", result);
        logger.info("status：{}，result：{}", HttpStatus.OK, result.toString());
        return object;
    }

    public static Object successWithoutMsg() {
        JSONObject object = new JSONObject();
        object.put("status", HttpStatus.OK);
        logger.info("status：{}，result：{}", HttpStatus.OK, StringUtils.EMPTY);
        return object;
    }

    public static Object successWithoutStatus(Object result) {
        JSONObject object = new JSONObject();
        object.put("result", result);
        logger.info("status：{}，result：{}", StringUtils.EMPTY, result);
        return object;
    }

    public static Object unknowError() {
        JSONObject object = new JSONObject();
        object.put("status", ResultVal.ERROR_CODE);
        object.put("result", ResultVal.UNKNOW_ERROR);
        logger.info("status：{}，result：{}", ResultVal.ERROR_CODE, ResultVal.UNKNOW_ERROR);
        return object;
    }

    public static Object errorWithMsg(Object msg) {
        JSONObject object = new JSONObject();
        object.put("status", ResultVal.ERROR_CODE);
        object.put("result", msg);
        logger.info("status：{}，result：{}", ResultVal.ERROR_CODE, msg);
        return object;
    }
}
