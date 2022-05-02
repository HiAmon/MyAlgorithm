package com.amon.springbootdemo.error;

public class GlobalError extends Error{
    private String log;
    private String info;

    public GlobalError(String log, String info) {
        this.log = log;
        this.info = info;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
