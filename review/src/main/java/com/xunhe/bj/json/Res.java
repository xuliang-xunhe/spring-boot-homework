package com.xunhe.bj.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Res {

    protected String resultCode;
    protected String resultMsg;
    protected Map<String, Object> result;

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public Res(){

    }

    public Res(String res){
        this.resultCode=res;
    }

    public Res(String res,String msg){
        this.resultCode=res;
        this.resultMsg=msg;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
    public String getResultCode() {
        return resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    @Override
    public String toString() {
        return "Res{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", result=" + result +
                '}';
    }
}
