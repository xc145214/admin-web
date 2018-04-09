/*************************************************************************
 *                  HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
 *
 *                COPYRIGHT (C) HONGLING CAPITAL CORPORATION 2012
 *    ALL RIGHTS RESERVED BY HONGLING CAPITAL CORPORATION. THIS PROGRAM
 * MUST BE USED  SOLELY FOR THE PURPOSE FOR WHICH IT WAS FURNISHED BY
 * HONGLING CAPITAL CORPORATION. NO PART OF THIS PROGRAM MAY BE REPRODUCED
 * OR DISCLOSED TO OTHERS,IN ANY FORM, WITHOUT THE PRIOR WRITTEN
 * PERMISSION OF HONGLING CAPITAL CORPORATION. USE OF COPYRIGHT NOTICE
 * DOES NOT EVIDENCE PUBLICATION OF THE PROGRAM.
 *                  HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
 *************************************************************************/
package com.github.xc145214.common.bean;

import com.github.xc145214.common.constant.Result;

import java.io.Serializable;

/**
 *
 *
 * @author xiachuan at 2017/12/6 15:32。
 */

public class JsonResult<T> implements Serializable {
    /**
     * code
     */
    private int code;
    /**
     * message
     */
    private String message;

    /**
     *
     */
    private T data;


    public static <T> JsonResult<T> successForData(T data){
        JsonResult<T> jsonResult = new JsonResult<T>();
        jsonResult.setCode(Result.SUCCESS.getCode());
        jsonResult.setMessage(Result.SUCCESS.getMessage());
        jsonResult.setData(data);
        return jsonResult;
    }
    public static <T> JsonResult<T> success(){
        JsonResult<T> jsonResult = new JsonResult<T>();
        jsonResult.setCode(Result.SUCCESS.getCode());
        jsonResult.setMessage(Result.SUCCESS.getMessage());
        return jsonResult;
    }

    public static <T> JsonResult<T> failed(String message){
        JsonResult<T> jsonResult = new JsonResult<T>();
        jsonResult.setCode(Result.FAIL.getCode());
        jsonResult.setMessage(message);
        return jsonResult;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

