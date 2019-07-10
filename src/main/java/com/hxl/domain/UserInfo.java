package com.hxl.domain;

import java.io.Serializable;
import java.sql.Date;

public class UserInfo implements Serializable {

    private Integer id;
    private String name;
    private Float money;
    private Date birthday;

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", birthday=" + birthday +
                '}';
    }
}
