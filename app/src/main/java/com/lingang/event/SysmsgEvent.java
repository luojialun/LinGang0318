package com.lingang.event;

/**
 * Created by luojialun on 2017/9/21.
 * 消息通知
 */

public class SysmsgEvent {
    private Type type;//消息类型
    private Object obj;//消息Value
    private String msg;//消息key或内容本身

    public SysmsgEvent(){
    }

    public SysmsgEvent(Type type) {
        this.type = type;
    }

    public SysmsgEvent(Type type, Object obj) {
        this.obj = obj;
        this.type = type;
    }

    public SysmsgEvent(Type type, Object obj, String msg) {
        this.obj = obj;
        this.type = type;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public static enum Type{
        SHORTCUT_UPDATE //角标更新通知
    }
}
