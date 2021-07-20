package com.streamlet.chain;

/**
 * @author Linxz
 * 创建日期：2021年07月19日 2:07 PM
 * version：
 * 描述：
 */
public class Response {

    private boolean isOk;
    private String message;
    public Object data;

    public static Response error(String message){
        Response response = new Response();
        response.setOk(false);
        response.setMessage(message);
        return response;
    }

    public static Response ok(Object data){
        Response response = new Response();
        response.setOk(false);
        response.setMessage("操作成功");
        response.setData(data);
        return response;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "isOk=" + isOk +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
