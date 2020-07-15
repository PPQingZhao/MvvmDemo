package com.pp.mvvm.base;


/**
 * @author qing
 */
public class ViewEvent<T> {

    private String type;
    private T data;

    private Object subData;

    public ViewEvent(String type) {
        this(type, null);
    }

    public ViewEvent(String type, T data) {
        this(type, data, null);
    }

    public ViewEvent(String type, T data, Object subData) {
        this.type = type;
        this.data = data;
        this.subData = subData;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getSubData() {
        return subData;
    }

    public void setSubData(Object subData) {
        this.subData = subData;
    }
}
