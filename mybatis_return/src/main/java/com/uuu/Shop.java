package com.uuu;

import java.util.List;

public class Shop {
    private String id;
    private String shopName;

    // 多对一：引入Dept。一对多：引入List<Dept>
    private List<Clerk> clerks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Clerk> getClerks() {
        return clerks;
    }

    public void setClerks(List<Clerk> clerks) {
        this.clerks = clerks;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id='" + id + '\'' +
                ", shopName='" + shopName + '\'' +
                ", clerks=" + clerks +
                '}';
    }
}