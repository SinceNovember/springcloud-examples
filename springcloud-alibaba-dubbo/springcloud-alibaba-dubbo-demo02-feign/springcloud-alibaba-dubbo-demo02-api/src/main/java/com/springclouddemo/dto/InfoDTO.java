package com.springclouddemo.dto;

import java.io.Serializable;

public class InfoDTO implements Serializable {
    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 昵称
     */
    private String infoName;

    public Integer getId() {
        return id;
    }

    public InfoDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getInfoName() {
        return infoName;
    }

    public InfoDTO setInfoName(String infoName) {
        this.infoName = infoName;
        return this;
    }
}
