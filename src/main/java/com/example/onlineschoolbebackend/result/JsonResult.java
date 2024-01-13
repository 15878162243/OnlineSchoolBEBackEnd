package com.example.onlineschoolbebackend.result;

public class JsonResult<T>{
    private T data;
    private int code;
    private String msg;

    /*
    * 若是没有数据返回，默认返回状态码为0，提示信息为：操作成功！
     */
    public JsonResult(){
        this.code = 200;
        this.msg = "操作成功";
    }

    /*
     * 若是没有数据返回，可自定义返回指定的状态码和提示信息
     */
    public JsonResult(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    /*
     * 有数据返回时，状态码为0，默认提示信息为：操作成功！
     * @param data
     */
    public JsonResult(T data){
        if(data == null){
            this.data = null;
            this.code = 400;
            this.msg = "操作失败";
        }else {
            this.data = data;
            this.code = 200;
            this.msg = "操作成功";
        }
    }

    /*
     * 有数据返回时，状态码为0，自定义返回提示信息
     * @param data
     * @param msg
     */
    public JsonResult(T data, String msg){
        if(data == null){
            this.data = null;
            this.code = 404;
            this.msg = msg;
        }else {
            this.data = data;
            this.code = 200;
            this.msg = msg;
        }
    }

    public T getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
